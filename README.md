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


-------------------VK--------------------

https://api.vk.com/method/users.get?user_ids=1639840&fields=photo_50
_
{"response":[{"uid":1639840,"first_name":"Николай","last_name":"Цыганков","photo_50":"http:\/\/cs616722.vk.me\/v616722840\/8dca\/lDk70ovh3nI.jpg","hidden":1}]}


https://api.vk.com/method/friends.get?user_id=1639840&fields=photo_50
_
{"response":[{"uid":53321,"first_name":"Kukri","last_name":"Nikson","photo_50":"http:\/\/cs621219.vk.me\/v621219321\/c04a\/dL9EDgwA1e4.jpg","user_id":53321},{"uid":58801,"first_name":"Андрей","last_name":"Зленко","photo_50":"http:\/\/cs622825.vk.me\/v622825801\/45cb\/qIMbNRTBYYQ.jpg","user_id":58801,"lists":[25]},
...
{"uid":210259969,"first_name":"Саша","last_name":"Наторов","photo_50":"http:\/\/cs407216.vk.me\/v407216969\/f1b2\/G7RgqSGmawU.jpg","user_id":210259969}]}


---
https://api.vk.com/method/users.get?user_ids=1639840..,photo_200_orig,sex - Профиль с ID, ФИО, фото 2 и пол
https://api.vk.com/method/friends.get?user_id=1639840..,photo_200_orig,sex - Друзья с ID, ФИО, фото 2 и пол
https://api.vk.com/method/friends.getOnline?user_id=1..$token - Друзья онлайн (с телефона/без)
https://api.vk.com/method/friends.search?user_id=1639..$string&access_token=$token - Поиск друзей

https://vk.com/login.php?op=logout