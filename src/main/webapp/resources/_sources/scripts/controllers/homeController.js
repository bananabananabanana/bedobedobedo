homeController.$inject = ['$scope', 'homeService'];
function homeController(scope, homeService) {
    scope.getUser = function () {
        homeService.getUser(function (data) {
            scope.users = data;
        });
    };
}