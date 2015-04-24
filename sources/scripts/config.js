function config(routeProvider, locationProvider) {
    routeProvider
        .when('/', {
            templateUrl: 'templates/main.html',
            controller: 'MainController'
        })
        .when('/home', {
            templateUrl: 'templates/home.html',
            controller: 'HomeController'
        })
        .when('/home/:user', {
            templateUrl: 'templates/user.html',
            controller: 'UserController'
        })
        .otherwise({
            redirectTo: '/'
        });

    locationProvider.html5Mode(true).hashPrefix('!');
}
config.$inject = ['$routeProvider', '$locationProvider'];