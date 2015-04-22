function config(routeProvider, locationProvider) {
    routeProvider
        .when("/", {
            templateUrl: "/www/templates/main.html",
            controller: "MainController"
        })
        .when("/home", {
            templateUrl: "/www/templates/home.html",
            controller: "HomeController"
        })
        .when("/home/:user", {
            templateUrl: "/www/templates/user.html",
            controller: "UserController"
        })
        .otherwise({redirectTo: "/"});

    locationProvider.html5Mode(true).hashPrefix("!");
}
config.$inject = ["$routeProvider", "$locationProvider"];