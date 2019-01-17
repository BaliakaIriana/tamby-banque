<%--
  Created by IntelliJ IDEA.
  User: josu
  Date: 04/01/2019
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from byrushan.com/projects/super-admin/app/2.1.2/ by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Jan 2019 17:59:33 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Super Admin 2.0</title>

    <!-- Vendor styles -->
    <link rel="stylesheet"
          href="vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="vendors/bower_components/animate.css/animate.min.css">
    <link rel="stylesheet" href="vendors/bower_components/jquery.scrollbar/jquery.scrollbar.css">
    <link rel="stylesheet" href="vendors/bower_components/fullcalendar/dist/fullcalendar.min.css">

    <!-- App styles -->
    <link rel="stylesheet" href="css/app.min.css">
</head>

<body data-sa-theme="1">
<main class="main">
    <div class="page-loader">
        <div class="page-loader__spinner">
            <svg viewBox="25 25 50 50">
                <circle cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
            </svg>
        </div>
    </div>

    <jsp:include page="views/partials/header.jsp"/>

    <jsp:include page="views/partials/left-sidebar.jsp"/>

    <jsp:include page="views/partials/theme-sidebar.jsp"/>

    <section class="content">
        <jsp:include page="views/${ page }.jsp"/>

        <footer class="footer hidden-xs-down">
            <p>© Super Admin Responsive. All rights reserved.</p>

            <ul class="nav footer__nav">
                <a class="nav-link" href="#">Homepage</a>

                <a class="nav-link" href="#">Company</a>

                <a class="nav-link" href="#">Support</a>

                <a class="nav-link" href="#">News</a>

                <a class="nav-link" href="#">Contacts</a>
            </ul>
        </footer>
    </section>
</main>

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
<script src="vendors/bower_components/jquery.scrollbar/jquery.scrollbar.min.js"></script>
<script src="vendors/bower_components/jquery-scrollLock/jquery-scrollLock.min.js"></script>

<script src="vendors/bower_components/salvattore/dist/salvattore.min.js"></script>
<script src="vendors/bower_components/flot/jquery.flot.js"></script>
<script src="vendors/bower_components/flot/jquery.flot.resize.js"></script>
<script src="vendors/bower_components/flot.curvedlines/curvedLines.js"></script>
<script src="vendors/bower_components/jqvmap/dist/jquery.vmap.min.js"></script>
<script src="vendors/bower_components/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="vendors/bower_components/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
<script src="vendors/bower_components/peity/jquery.peity.min.js"></script>
<script src="vendors/bower_components/moment/min/moment.min.js"></script>
<script src="vendors/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>

<!-- Charts and maps-->
<script src="demo/js/flot-charts/curved-line.js"></script>
<script src="demo/js/flot-charts/line.js"></script>
<script src="demo/js/flot-charts/dynamic.js"></script>
<script src="demo/js/flot-charts/chart-tooltips.js"></script>
<script src="demo/js/other-charts.js"></script>
<script src="demo/js/jqvmap.js"></script>

<!-- App functions and actions -->
<script src="js/app.min.js"></script>
</body>

<script>
    function loadBq() {
        var id = $('#dest').val();
        $.get('/Banque/api/clients?id=' + id).then(function(response){
           console.log(response);
           response = JSON.parse(response);
           var $select = $('#bdest');
           $select.html('');
           for(var i=0; i<response.length;i++){
               var option = $('<option>');
               option.val(response[i].idbanque);
               option.text(response[i].nombanque);
               $select.append(option);
           }
        });
    }
</script>
<!-- Mirrored from byrushan.com/projects/super-admin/app/2.1.2/ by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Jan 2019 18:01:17 GMT -->
</html>
