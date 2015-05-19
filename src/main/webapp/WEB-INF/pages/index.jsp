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

    <link href="/bower_components/ionic/release/css/ionic.css" rel="stylesheet">
    <link href="/styles/app.css" rel="stylesheet">
    <base href="/">

</head>
<body>

    <ion-nav-view></ion-nav-view>

    <script src="/bower_components/angular/angular.js"></script>
    <script src="/bower_components/angular-animate/angular-animate.js"></script>
    <script src="/bower_components/angular-sanitize/angular-sanitize.js"></script>
    <script src="/bower_components/angular-ui-router/release/angular-ui-router.js"></script>
    <script src="/bower_components/ionic/release/js/ionic.js"></script>
    <script src="/bower_components/ionic/release/js/ionic-angular.js"></script>

    <script src="/scripts/controllers/FriendController.js"></script>
    <script src="/scripts/controllers/LoginController.js"></script>
    <script src="/scripts/controllers/MainController.js"></script>
    <script src="/scripts/controllers/ProfileController.js"></script>
    <script src="/scripts/services/Friend.js"></script>
    <script src="/scripts/services/Profile.js"></script>
    <script src="/scripts/config.js"></script>
    <script src="/scripts/app.js"></script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="<c:url value="/logout" />" > Logout</a>
    </c:if>

</body>
</html>