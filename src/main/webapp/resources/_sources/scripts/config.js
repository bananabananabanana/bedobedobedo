config.$inject = ['$routeProvider', '$locationProvider'];
function config(routeProvider, locationProvider) {
    routeProvider
        .when('/', {
            templateUrl: '/resources/templates/index.html',
            controller: 'indexController'
        })
        .when('/home', {
            templateUrl: '/resources/templates/home.html',
            controller: 'homeController'
        })
        .when('/home/:user', {
            templateUrl: '/resources/templates/user.html',
            controller: 'userController'
        })
        .otherwise({
            redirectTo: '/'
        });

    locationProvider.html5Mode(true).hashPrefix('!');
}