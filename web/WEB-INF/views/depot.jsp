<%--
  Created by IntelliJ IDEA.
  User: josu
  Date: 08/01/2019
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 m-auto">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Déposer de l'argent: </h4>
                    <h6 class="card-subtitle">Veuillez choisir la banque où déposer l'argent puis indiquer le montant à
                        déposer:</h6>
                    <form action="/Banque/depot" method="post">
                        <div class="form-group">
                            <div class="select2">
                                <select name="banque" class="form-control">
                                    <option>Séléctionnez une de vos banques</option>
                                    <c:forEach var="item" items="${ banques }">
                                        <option value="${ item.idbanque }">${ item.nombanque }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" name="montant" class="form-control" placeholder="Montant">
                            <i class="form-group__bar"></i>
                        </div>
                        <button class="btn">Déposer</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
