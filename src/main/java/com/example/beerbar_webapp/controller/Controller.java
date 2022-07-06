package com.example.beerbar_webapp.controller;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandFactory;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.connection.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontController", value = "/controller")
public class Controller extends HttpServlet {
    private ConnectionPool connectionPool;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.processRequest(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.processRequest(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String commandName = req.getParameter("command");
        Command command = CommandFactory.defineCommand(commandName);
        CommandResult result = command.execute(req);

        switch (result.getType()){
            case FORWARD -> getServletContext().getRequestDispatcher(result.getPage()).forward(req,resp);
            case REDIRECT -> resp.sendRedirect(result.getPage());
            default -> throw new RuntimeException();
        }

    }

    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.getInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
