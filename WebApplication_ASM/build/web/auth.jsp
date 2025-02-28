<%-- 
    Document   : auth
    Created on : Feb 28, 2025, 11:19:24 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auth</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <header class="navbar navbar-expand-lg navbar-light bg-primary py-3 border-bottom">
            <div class="container">
                <a class="navbar-brand text-white fs-4 fw-bold" href="home.jsp">MyComicSite</a>
            </div>
        </header>

        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-6 text-center text-lg-start mb-4 mb-lg-0">
                    <div class="web-icon d-inline-block"></div>
                    <h2 class="fw-bold">Welcome to MyComicSite</h2>
                    <p>Register or login to access your favorite comics!</p>
                </div>

                <div class="col-lg-6">
                    <ul class="nav nav-tabs mb-4" id="authTab" role="tablist">
                        <li class="nav-item">
                            <button class="nav-link" id="register-tab" data-bs-toggle="tab" data-bs-target="#register" type="button" role="tab">
                                Register
                            </button>
                        </li>
                        <li class="nav-item">
                            <button class="nav-link" id="login-tab" data-bs-toggle="tab" data-bs-target="#login" type="button" role="tab">
                                Login
                            </button>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title mb-3">Create Your Account</h4>
                                    <form>
                                        <div class="mb-3">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control" placeholder="e.g. John Doe">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Email</label>
                                            <input type="email" class="form-control" placeholder="john@example.com">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Password</label>
                                            <input type="password" class="form-control" placeholder="********">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Confirm Password</label>
                                            <input type="password" class="form-control" placeholder="********">
                                        </div>
                                        <button type="submit" class="btn btn-primary w-100">SIGN UP</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="login" role="tabpanel" aria-labelledby="login-tab">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title mb-3">Login</h4>
                                    <form>
                                        <div class="mb-3">
                                            <label class="form-label">Username or Email</label>
                                            <input type="text" class="form-control" placeholder="Your username or email">
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Password</label>
                                            <input type="password" class="form-control" placeholder="********">
                                        </div>
                                        <button type="submit" class="btn btn-primary w-100">LOGIN</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const urlParams = new URLSearchParams(window.location.search);
                const tab = urlParams.get("action");

                if (tab === "login") {
                    document.getElementById("login-tab").classList.add("active");
                    document.getElementById("register-tab").classList.remove("active");

                    document.getElementById("login").classList.add("show", "active");
                    document.getElementById("register").classList.remove("show", "active");
                } else {
                    document.getElementById("register-tab").classList.add("active");
                    document.getElementById("login-tab").classList.remove("active");

                    document.getElementById("register").classList.add("show", "active");
                    document.getElementById("login").classList.remove("show", "active");
                }
            });
        </script>

    </body>
    <%@include file="footer.jsp" %>
</html>
