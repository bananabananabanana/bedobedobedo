function Home(http) {
    this.getUser = function (callback) {
        http.get('/home/getData')
            .success(callback);
    };
}
Home.$inject = ["$http"];