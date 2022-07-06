<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 21/06/2022
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>

        /* form */
        body {
            background: #e2e8f0;
        }

        .form-body {
            background: #fff;
            padding: 20px;
        }

        .innter-form {
            padding-top: 20px;
        }

        .final-login li {
            width: 50%;
        }

        .nav-tabs {
            border-bottom: none !important;
        }

        .nav-tabs > li {
            color: #222 !important;
        }

        .nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
            color: #fff;
            background-color: #d14d42;
            border: none !important;
            border-bottom-color: transparent;
            border-radius: unset !important;
        }

        .nav-tabs > li > a {
            margin-right: 2px;
            line-height: 1.428571429;
            border: none !important;
            border-radius: unset !important;
            text-transform: uppercase;
            font-size: 16px;
        }

        .social-login {
            text-align: center;
            font-size: 12px;
        }

        .social-login p {
            margin: 15px 0;
        }

        .social-login ul {
            margin: 0;
            padding: 0;
            list-style-type: none;
        }

        .social-login ul li {
            width: 33%;
            float: left;
            clear: unset;
        }

        .social-login ul li a {
            font-size: 13px;
            color: #fff;
            text-decoration: none;
            padding: 10px 0;
            display: block;
        }

        .social-login ul li:nth-child(1) a {
            background: #3b5998;
        }

        .social-login ul li:nth-child(2) a {
            background: #e74c3d;
        }

        .social-login ul li:nth-child(3) a {
            background: #3698d9;
        }

        .sa-innate-form input[type=text], input[type=password], input[type=file], textarea, select, email {
            font-size: 13px;
            padding: 10px;
            border: 1px solid #ccc;
            outline: none;
            width: 100%;
            margin: 8px 0;

        }

        .sa-innate-form input[type=submit] {
            border: 1px solid #e64b3b;
            background: #e64b3b;
            color: #fff;
            padding: 10px 25px;
            font-size: 14px;
            margin-top: 5px;
        }

        .sa-innate-form input[type=submit]:hover {
            border: 1px solid #db3b2b;
            background: #db3b2b;
            color: #fff;
        }

        .sa-innate-form button {
            border: 1px solid #e64b3b;
            background: #e64b3b;
            color: #fff;
            padding: 10px 25px;
            font-size: 14px;
            margin-top: 5px;
        }

        .sa-innate-form button:hover {
            border: 1px solid #db3b2b;
            background: #db3b2b;
            color: #fff;
        }

        .sa-innate-form p {
            font-size: 13px;
            padding-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
    </div>
</div>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="form-body">
                <ul class="nav nav-tabs final-login">
                    <li><a data-toggle="tab" href="index.jsp">Sign In</a></li>
                    <li class="active"><a data-toggle="tab">Join us!</a></li>
                </ul>
                <div class="tab-content">
                    <div class="innter-form">
                        <form action="controller" class="sa-innate-form"
                              method="post">
                            <input type="hidden" name="command" value="registration">
                            <label>Name</label>
                            <input type="text" name="name" id="name">
                            <label>Surname</label>
                            <input type="text" name="surname" id="surname">
                            <label>Login</label>
                            <input type="text" name="login" id="login">
                            <label>Email Address</label>
                            <input type="text" name="email" id="email">
                            <label>Address</label>
                            <input type="text" name="address" id="address">
                            <label>Age</label>
                            <input type="text" name="age" id="age">
                            <label>Mobile</label>
                            <input type="text" name="phone_number" id="phone_number">
                            <p>Gender</p>
                            <input class="form-check-input" type="radio" name="gender"
                                   id="female_gender"
                                   value="Female" checked/>
                            <label class="form-check-label" for="female_gender">Female</label>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender"
                                       id="male_gender"
                                       value="Male"/>
                                <label class="form-check-label" for="male_gender">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender"
                                       id="other_gender"
                                       value="Other"/>
                                <label class="form-check-label" for="other_gender">Other</label>
                                <br>
                                <label>Password</label>
                                <input type="text" name="password">
                                <label>Password Confirm</label>
                                <input type="text" name="password_confirm">
                            </div>

                            <button type="submit">Join Us</button>
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="social-login">
                    <p>- - - - - - - - - - - - - Register With - - - - - - - - - - - - - </p>
                    <ul>
                        <li><a href=""><i class="fa fa-facebook"></i> Facebook</a></li>
                        <li><a href=""><i class="fa fa-google-plus"></i> Google+</a></li>
                        <li><a href=""><i class="fa fa-twitter"></i> Twitter</a></li>
                    </ul>
                    <br>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
