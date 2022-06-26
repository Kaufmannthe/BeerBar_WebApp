package com.example.beerbar_webapp.repository.impl;

import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.model.User;
import com.example.beerbar_webapp.repository.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDAOImpl implements UserDAO {
    private static final String CREATE_USER = "INSERT INTO users (name,login,password,age,email,phone_number,gender,surname,address) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String USER_UPDATE = "UPDATE users SET login = ?, password = ?, age = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ? ";
    private static final String FIND_ALL_USERS = "SELECT * FROM users";
    private static final String FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String FIND_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String GET_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
    private JDBConnection connector;

    public UserDAOImpl(JDBConnection connector) {
        this.connector = connector;
    }

    @Override
    public List<User> findAll() {
        List<User> personList = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS);

            while (resultSet.next()) {
                User person = new User();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setLogin(resultSet.getString("login"));
                person.setAge(resultSet.getInt("age"));
                personList.add(person);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Optional<User> findByID(int id) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setAge(resultSet.getInt("age"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.of(user);
    }

    @Override
    public boolean create(User entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getPassword());
            statement.setInt(4, entity.getAge());
            statement.setString(5, entity.getEmail());
            statement.setString(6, entity.getPhoneNumber());
            statement.setString(7, entity.getGender());
            statement.setString(8,entity.getSurname());
            statement.setString(9,entity.getAddress());


            return statement.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(USER_UPDATE)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setInt(4, entity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.print("Результат удаления пользователя: ");
            return preparedStatement.executeUpdate() == 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findByLogin(String name) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setAge(resultSet.getInt("age"));

            }
            return user;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean findUser(String login, String password) {
        try (Connection connection = connector.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(String login, String password) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setAddress(resultSet.getString("address"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
