<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 27/06/2022
  Time: 03:09
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
            background-color: rgba(188,38,0,0.99); /* Red */
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
    Unable to save changes. Check the correctness of the entered data.
</div>
<%@include file="profileEdit.jsp"%>
</body>
</html>
