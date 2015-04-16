# bedobedobedo
bedobedobedo

# For front-end
go to webapps/resources and run in terminal 'sh run.sh'


# Magic
1) create virtual host in apatch + php
2) copy __host to created host

list of 'index.php'
<?php
header('Location: http://xn--b1acc2ao6a.xn--p1ai:8090/?' . $_SERVER['QUERY_STRING']);
?>

list of '.htaccess'
RewriteEngine On
RewriteCond %{REQUEST_FILENAME} !-f
RewriteCond %{REQUEST_FILENAME} !-d
RewriteRule ^(.*)$ /index.php [L]