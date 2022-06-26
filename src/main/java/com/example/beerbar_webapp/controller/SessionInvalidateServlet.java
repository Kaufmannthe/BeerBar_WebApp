package com.example.beerbar_webapp.controller;

import com.example.beerbar_webapp.connection.JDBConnection;
import com.example.beerbar_webapp.repository.impl.UserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SessionInvalidateServlet", value = "/SessionInvalidate")
public class SessionInvalidateServlet extends HttpServlet {
    JDBConnection jdbConnection = new JDBConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        try {
            jdbConnection.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/landingPage.jsp");
    }

}
