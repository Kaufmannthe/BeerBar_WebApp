<%--
  Created by IntelliJ IDEA.
  User: Kaufmannthe
  Date: 26/06/2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Craft Beer Club</title>
    <style>
    </style>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="landingPage_assets/img/logo.png"/>
    <!-- Bootstrap Icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic"
          rel="stylesheet" type="text/css"/>
    <!-- SimpleLightbox plugin CSS-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="landingPage_assets/css/styles.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#page-top">Craft Beer Club</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link" href="#about">Social</a></li>
                <li class="nav-item"><a class="nav-link" href="#services">Shop</a></li>
                <li class="nav-item"><a class="nav-link" href="#contact">Feed</a></li>
                <c:if test="${login == null}">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Login</a>
                    </li>
                </c:if>
                <c:if test="${login != null}">
                    <li class="nav-item"><a class="nav-link" href="profile.jsp">Profile</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/SessionInvalidate">Logout</a>
                    </li>

                </c:if>


            </ul>
        </div>
    </div>
</nav>
<!-- Masthead-->
<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
        <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
            <div class="col-lg-8 align-self-end">
                <h1 class="text-white font-weight-bold">Your favorite pastime Your favorite beer</h1>
                <hr class="divider"/>
            </div>
            <div class="col-lg-8 align-self-baseline">
                <p class="text-white-75 mb-5">Perfection is priceless</p>
                <a class="btn btn-primary btn-xl" href="#about">Find Out More</a>
            </div>
        </div>
    </div>
</header>
<!-- About-->
<section class="page-section bg-primary" id="about">
    <div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-lg-8 text-center">
                <h2 class="text-white mt-0">We've got what you need!</h2>
                <hr class="divider divider-light"/>
                <p class="text-white-75 mb-4">Our range includes selected craft beers brewed with selected hop
                    varieties. You can also get acquainted with the range of strong alcohol.</p>
                <a class="btn btn-light btn-xl" href="#services">Get Started!</a>
            </div>
        </div>
    </div>
</section>
<!-- Portfolio-->
<div id="portfolio">
    <div class="container-fluid p-0">
        <div class="row g-0">
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/1.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/1.jpg" alt="..."/>
                    <div class="portfolio-box-caption">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Craft Beer</div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/2.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/2.jpg" alt="..."/>
                    <div class="portfolio-box-caption">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Wine</div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/3.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/3.jpg" alt="..."/>
                    <div class="portfolio-box-caption">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Vodka</div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/4.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/4.jpg" alt="..."/>
                    <div class="portfolio-box-caption">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Whiskey</div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/5.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/5.jpg" alt="..."/>
                    <div class="portfolio-box-caption">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Cognac</div>
                    </div>
                </a>
            </div>
            <div class="col-lg-4 col-sm-6">
                <a class="portfolio-box" href="landingPage_assets/img/portfolio/fullsize/6.jpg" title="Project Name">
                    <img class="img-fluid" src="landingPage_assets/img/portfolio/thumbnails/6.jpg" alt="..."/>
                    <div class="portfolio-box-caption p-3">
                        <div class="project-category text-white-50">Category</div>
                        <div class="project-name">Snacks</div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Call to action-->

<!-- Footer-->
<footer class="bg-light py-5">
    <div class="container px-4 px-lg-5">
        <div class="small text-center text-muted">Copyright &copy; 2022 - <a href="">LLC "CBC"</a></div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- SimpleLightbox plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
<!-- Core theme JS-->
<script src="landingPage_assets/js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
