<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 26/06/2022
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <style type="text/css">
        body {
            background: #f7f7ff;
            margin-top: 20px;
        }

        /* The alert message box */
        .alert {
            padding: 20px;
            background-color: #90ff65; /* Red */
            color: white;
            margin-bottom: 15px;
            text-align: center;
        }

        /* The close button */
        .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }

        /* When moving the mouse over the close button */
        .closebtn:hover {
            color: black;
        }
    </style>
</head>
<body>
<div class="alert">
    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    Data changed successfully
</div>
<%@include file="profile.jsp"%>
</body>
</html>

