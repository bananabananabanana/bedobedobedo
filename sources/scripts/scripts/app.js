angular.module('app', ['ionic'])
    .config(config)
    .controller({
        'LoginController': LoginController,
        'MainController': MainController,
        'ProfileController': ProfileController,
        'FriendController': FriendController
    })
    .service({
        'Friend': Friend,
        'Profile': Profile
    });