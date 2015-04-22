function UserController(scope, routeParams) {
    scope.user = routeParams.user.toUpperCase();
}
UserController.$inject = ["$scope", "$routeParams"];