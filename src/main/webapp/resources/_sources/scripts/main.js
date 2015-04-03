angular
    .module('app', ['ngRoute'])
    .config(config)
    .controller({
        'indexController': indexController,
        'homeController': homeController,
        'userController': userController
    })
    .directive('page', pageDirective)
    .service('homeService', homeService);