homeService.$inject = ['$http'];
function homeService(http) {
    this.getUser = function (callback) {
        http
            .get('/home/getData')
            .success(callback)
            .error(error);
    };

    function error(data) {
        console.log(data);
    }
}