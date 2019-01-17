<%--
  Created by IntelliJ IDEA.
  User: josu
  Date: 13/01/2019
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 m-auto">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Transférer de l'argent: </h4>
                    <c:if test="${ param.err eq 0 }">
                        <div class="alert alert-success alert-dismissible fade show">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            Solde transféré avec succès.
                        </div>
                    </c:if>
                    <c:if test="${ param.err eq 1 }">
                        <div class="alert alert-danger alert-dismissible fade show">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            ${ param.msg }
                        </div>
                    </c:if>
                    <form action="/Banque/transfert" method="post">
                        <div class="form-group">
                            <div class="select2">
                                <select name="bsend" class="form-control">
                                    <option>Séléctionnez une de vos banques</option>
                                    <c:forEach var="item" items="${ banques }">
                                        <option value="${ item.idbanque }">${ item.nombanque }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <h6 class="card-subtitle">Veuillez choisir le destinataire et sa banque, puis indiquez le
                                montant à
                                transférer:</h6>
                        </div>
                        <div class="form-group">
                            <div class="select2">
                                <select name="dest" id="dest" class="form-control" onchange="loadBq()">
                                    <option>Séléctionnez le destinataire:</option>
                                    <c:forEach var="item" items="${ clients }">
                                        <option value="${ item.id }">${ item.nom } ${ item.prenom }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="select2">
                                <select name="bdest" id="bdest" class="form-control">
                                    <option>Séléctionnez d'abord un destinataire</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" name="montant" class="form-control" placeholder="Montant">
                            <i class="form-group__bar"></i>
                        </div>
                        <button class="btn">Transférer</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

