function HomeController(scope, Home) {
    scope.getUser = function () {
        Home.getUser(function (users) {
            scope.users = users;
        });
    };
}
HomeController.$inject = ["$scope", "Home"];