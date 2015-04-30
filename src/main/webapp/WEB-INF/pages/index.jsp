<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ru" ng-app="app">
<head>
    <meta charset="UTF-8">
    <meta name="fragment" content="!">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="/libraries/lib.min.css" rel="stylesheet">
    <link href="/application/app.min.css" rel="stylesheet">
    <base href="/">

</head>
<body>

    <ion-nav-view></ion-nav-view>

    <script src="/libraries/lib.min.js"></script>
    <script src="/application/app.min.js"></script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="<c:url value="/logout" />" > Logout</a>
    </c:if>

</body>
</html>