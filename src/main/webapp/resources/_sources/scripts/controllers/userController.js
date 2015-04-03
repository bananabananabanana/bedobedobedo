userController.$inject = ['$scope', '$routeParams'];
function userController(scope, routeParams) {
    scope.user = routeParams.user.toUpperCase();
}