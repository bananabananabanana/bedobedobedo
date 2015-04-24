<!doctype html>
<html lang="ru" ng-app="app">
<head>
    <meta charset="UTF-8">
    <meta name="fragment" content="!">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/application/app.min.css" rel="stylesheet">
    <base href="/">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <ul class="nav navbar-nav">
            <li><a ng-href="/">Index</a></li>
            <li><a ng-href="/home">Home</a></li>
            <li><a ng-href="/home/john">Home John</a></li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 50px;">
    <section ng-view=""></section>
</div>

<script src="/libraries/lib.min.js"></script>
<script src="/application/app.min.js"></script>
</body>
</html>