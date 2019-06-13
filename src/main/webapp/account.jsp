<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 26.05.2019
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<c:set scope="page" var="user" value="${requestScope.get('user')}"/>
<c:set scope="page" var="account" value="${user.accounts}"/>
<div class="row">
    <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
<%--        <A href="edit.html">Edit Profile</A>--%>
<%--        <br>--%>
        <A href="/logoutServlet">Logout</A>
        <br>
        <p class=" text-info"><% out.println(java.time.LocalDateTime.now().toString());%></p>
    </div>
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">${user.firstname} 's account</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class=" col-md-9 col-lg-9 ">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>First name:</td>
                                <td>${user.firstname}</td>
                            </tr>
                            <tr>
                                <td>Last name:</td>
                                <td>${user.lastname}</td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><a href="mailto:${user.email}">${user.email}</a></td>
                            </tr>
                            <tr>
                                <td>Account details</td>
                                <td></td>
                            </tr>
                            <c:forEach var="accountItem" items="${account}">
                                <tr>
                                    <td>Account number</td>
                                    <td><c:out value="${accountItem.accountNumber}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Balance</td>
                                    <td><c:out value="${accountItem.balance}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Free funds</td>
                                    <td><c:out value="${accountItem.freeFunds}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Currency</td>
                                    <td><c:out value="${accountItem.currency}"/>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
