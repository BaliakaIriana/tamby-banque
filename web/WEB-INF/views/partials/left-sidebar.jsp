<%--
  Created by IntelliJ IDEA.
  User: josu
  Date: 05/01/2019
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="sidebar">
    <div class="scrollbar-inner">

        <div class="user">
            <div class="user__info" data-toggle="dropdown">
                <img class="user__img" src="demo/img/profile-pics/8.jpg" alt="">
                <div>
                    <div class="user__name">${ user ne null ? user.nom : (admin ne null ? admin.login : '') } ${ user ne null ? user.prenom : '' }</div>
                    <%--<div class="user__email">malinda-h@gmail.com</div>--%>
                </div>
            </div>

            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">View Profile</a>
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="/Banque/logout">Logout</a>
            </div>
        </div>
        <c:if test="${ user ne null }">
            <ul class="navigation">
                <li><a href="/Banque/home"><i class="zmdi zmdi-home"></i>Situation actuel</a></li>
                <li><a href="#">Inscription à une banque</a></li>
                <li><a href="/Banque/transfert">Transfert d'argent</a></li>
                <li><a href="/Banque/depot">Dépôt d'argent</a></li>
                <li><a href="/Banque/etat">Etat</a></li>
            </ul>
        </c:if>
        <c:if test="${ admin ne null }">
            <ul class="navigation">
                <li><a href="#"><i class="zmdi zmdi-home"></i>Situation actuel</a></li>
                <li><a href="#">Inscription à une banque</a></li>
                <li><a href="#">Transfert d'argent</a></li>
            </ul>
        </c:if>
    </div>
</aside>