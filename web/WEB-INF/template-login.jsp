<%--
  Created by IntelliJ IDEA.
  User: josu
  Date: 05/01/2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from byrushan.com/projects/super-admin/app/2.1.2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Jan 2019 18:07:32 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Vendor styles -->
    <link rel="stylesheet"
          href="vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="vendors/bower_components/animate.css/animate.min.css">

    <!-- App styles -->
    <link rel="stylesheet" href="css/app.min.css">
</head>

<body data-sa-theme="1">
<div class="login">

    <!-- Login -->
    <div class="login__block active" id="l-login">
        <div class="login__block__header">
            <i class="zmdi zmdi-account-circle"></i>
            Hi there! Please Sign in

            <div class="actions actions--inverse login__block__actions">
                <div class="dropdown">
                    <i data-toggle="dropdown" class="zmdi zmdi-more-vert actions__item"></i>

                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-register" href="#">Create
                            an account</a>
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-forget-password"
                           href="#">Forgot password?</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="login__block__body">
            <form action="/Banque/login" method="post">

                <div class="form-group">
                    <input type="text" name="email" class="form-control text-center" placeholder="Email Address">
                </div>

                <div class="form-group">
                    <input type="password" name="password" class="form-control text-center" placeholder="Password">
                </div>

                <button class="btn btn--icon login__block__btn"><i
                        class="zmdi zmdi-long-arrow-right"></i></button>
            </form>
        </div>
    </div>

    <!-- Register -->
    <div class="login__block" id="l-register">
        <div class="login__block__header">
            <i class="zmdi zmdi-account-circle"></i>
            Create an account

            <div class="actions actions--inverse login__block__actions">
                <div class="dropdown">
                    <i data-toggle="dropdown" class="zmdi zmdi-more-vert actions__item"></i>

                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-login" href="#">Already
                            have an account?</a>
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-forget-password"
                           href="#">Forgot password?</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="login__block__body">
            <div class="form-group">
                <input type="text" class="form-control text-center" placeholder="Name">
            </div>

            <div class="form-group form-group--centered">
                <input type="text" class="form-control text-center" placeholder="Email Address">
            </div>

            <div class="form-group form-group--centered">
                <input type="password" class="form-control text-center" placeholder="Password">
            </div>

            <div class="form-group">
                <label class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input">
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-description">Accept the license agreement</span>
                </label>
            </div>

            <a href="index-2.html" class="btn btn--icon login__block__btn"><i class="zmdi zmdi-plus"></i></a>
        </div>
    </div>

    <!-- Forgot Password -->
    <div class="login__block" id="l-forget-password">
        <div class="login__block__header">
            <i class="zmdi zmdi-account-circle"></i>
            Forgot Password?

            <div class="actions actions--inverse login__block__actions">
                <div class="dropdown">
                    <i data-toggle="dropdown" class="zmdi zmdi-more-vert actions__item"></i>

                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-login" href="#">Already
                            have an account?</a>
                        <a class="dropdown-item" data-sa-action="login-switch" data-sa-target="#l-register" href="#">Create
                            an account</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="login__block__body">
            <p class="mb-5">Lorem ipsum dolor fringilla enim feugiat commodo sed ac lacus.</p>

            <div class="form-group">
                <input type="text" class="form-control text-center" placeholder="Email Address">
            </div>

            <a href="index-2.html" class="btn btn--icon login__block__btn"><i class="zmdi zmdi-check"></i></a>
        </div>
    </div>
</div>

<!-- Older IE warning message -->
<!--[if IE]>
<div class="ie-warning">
    <h1>Warning!!</h1>
    <p>You are using an outdated version of Internet Explorer, please upgrade to any of the following web browsers to
        access this website.</p>

    <div class="ie-warning__downloads">
        <a href="http://www.google.com/chrome">
            <img src="img/browsers/chrome.png" alt="">
        </a>

        <a href="https://www.mozilla.org/en-US/firefox/new">
            <img src="img/browsers/firefox.png" alt="">
        </a>

        <a href="http://www.opera.com">
            <img src="img/browsers/opera.png" alt="">
        </a>

        <a href="https://support.apple.com/downloads/safari">
            <img src="img/browsers/safari.png" alt="">
        </a>

        <a href="https://www.microsoft.com/en-us/windows/microsoft-edge">
            <img src="img/browsers/edge.png" alt="">
        </a>

        <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
            <img src="img/browsers/ie.png" alt="">
        </a>
    </div>
    <p>Sorry for the inconvenience!</p>
</div>
<![endif]-->

<!-- Javascript -->
<!-- Vendors -->
<script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="vendors/bower_components/popper.js/dist/umd/popper.min.js"></script>
<script src="vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- App functions and actions -->
<script src="js/app.min.js"></script>
</body>

<!-- Mirrored from byrushan.com/projects/super-admin/app/2.1.2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Jan 2019 18:07:32 GMT -->
</html>
