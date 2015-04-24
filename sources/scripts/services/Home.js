function Home(http) {
    this.getUser = function (callback) {
        //var data = [];
        //for (var i = 0; i < 10; i++) {
        //    data.push({
        //        id: i,
        //        name: 'User ' + i
        //    });
        //}
        //callback(data);
        http
            .get('/home/getData')
            .success(callback);
    };
}
Home.$inject = ['$http'];