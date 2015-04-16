<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="fragment" content="!">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <ul class="nav navbar-nav">
            <li><a href="/">Index</a></li>
            <li><a href="/home">Home</a></li>
            <li><a href="/home/john">Home John</a></li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 50px;">
    <section ng-view=""></section>
</div>

<script>
var BASE_PATH = '',
    script = document.createElement('script'),
    link = document.createElement('link'),
    base = document.createElement('base');

script.setAttribute('src', BASE_PATH + '/_vendors/bower_components/requirejs/require.js');
script.setAttribute('data-main', BASE_PATH + '/scripts/main');
document.getElementsByTagName('head')[0].appendChild(script);

base.setAttribute('href', BASE_PATH + '/');
document.getElementsByTagName('head')[0].appendChild(base);

var styles = [
    BASE_PATH + '/styles/app.min.css'
];

link.setAttribute('rel', 'stylesheet');
for (var i = 0; i < styles.length; i++) {
    link.setAttribute('href', styles[i]);
    document.getElementsByTagName('head')[0].appendChild(link);
}
</script>

</body>
</html>