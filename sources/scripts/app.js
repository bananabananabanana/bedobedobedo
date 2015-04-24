angular.module('app', ['ngRoute'])
    .config(config)
    .controller({
        'HomeController': HomeController,
        'MainController': MainController,
        'UserController': UserController
    })
    .service({
        'Home': Home
    });