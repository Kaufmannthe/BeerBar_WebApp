package com.example.beerbar_webapp.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private BlockingQueue<Connection> connections;
    private static AtomicBoolean isPoolCreated = new AtomicBoolean(false);
    private static Lock lock = new ReentrantLock();
    private static final Integer POOL_SIZE = 10;
    private static ConnectionPool instance;

    private ConnectionPool() throws ClassNotFoundException {
        this.connections = new LinkedBlockingDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            connections.offer(new JDBConnection().getConnection());
        }
    }

    public static ConnectionPool getInstance() throws ClassNotFoundException {
        if (!isPoolCreated.get()) {
            try {
                lock.lock();

                if (instance == null) {
                    instance = new ConnectionPool();
                    isPoolCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }

    public void closePool() throws SQLException {
        while (!connections.isEmpty()){
            Connection connection = connections.poll();
            connection.close();
        }
    }

}
