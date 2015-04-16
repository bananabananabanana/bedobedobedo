config.$inject = ['$routeProvider', '$locationProvider'];
function config(routeProvider, locationProvider) {
    routeProvider
        .when(BASE_PATH + '/', {
            templateUrl: BASE_PATH + '/resources/templates/index.html',
            controller: 'indexController'
        })
        .when(BASE_PATH + '/home', {
            templateUrl: BASE_PATH + '/resources/templates/home.html',
            controller: 'homeController'
        })
        .when(BASE_PATH + '/home/:user', {
            templateUrl: BASE_PATH + '/resources/templates/user.html',
            controller: 'userController'
        })
        .otherwise({
            redirectTo: BASE_PATH + '/'
        });

    locationProvider.html5Mode(true).hashPrefix('!');
}