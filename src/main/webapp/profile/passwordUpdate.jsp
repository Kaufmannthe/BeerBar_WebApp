<%@ page import="com.example.beerbar_webapp.connection.JDBConnection" %>
<%@ page import="com.example.beerbar_webapp.repository.impl.UserDAOImpl" %>
<%@ page import="com.example.beerbar_webapp.model.User" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 27/06/2022
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%
    JDBConnection connection = new JDBConnection();
    UserDAOImpl userDAO = new UserDAOImpl(connection);

    String password = request.getParameter("password");
    String login = request.getParameter("login");
    String passwordConf = request.getParameter("password-conf");
    User user = new User(login, password);


    if (userDAO.update(user) && Objects.equals(password, passwordConf) && password != null && password.length() > 6) {
        try {
            response.sendRedirect(request.getContextPath() + "/profile/results/success.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } else {
        response.sendRedirect(request.getContextPath() + "/profile/results/passwordError.jsp");
    }
%>
</body>
</html>
