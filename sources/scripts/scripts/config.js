config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];
function config(stateProvider, urlRouterProvider, locationProvider) {
    stateProvider
        .state('login', {
            url: '/login',
            templateUrl: '/templates/login.html'
        })
        .state('main', {
            url: '/main',
            abstract: true,
            templateUrl: '/templates/main.html',
            controller: 'MainController'
        })
        .state('main.profile', {
            url: '/profile',
            views: {
                main: {
                    templateUrl: '/templates/main.profile.html',
                    controller: 'ProfileController'
                }
            }
        })
        .state('main.friends', {
            url: '/friend',
            abstract: false,
            views: {
                main: {
                    templateUrl: '/templates/main.friend.html',
                    controller: 'FriendController'
                }
            }
        });

    urlRouterProvider.otherwise('/main/friend');
    locationProvider.html5Mode(true).hashPrefix('!');
}