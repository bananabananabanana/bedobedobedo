Profile.$inject = ['$http'];
function Profile(http) {
    this.getProfile = function (callback) {
        var data = {
            'id': Math.round(Math.random() * (1000 - 1) + 1),
            'creditors': [
                {
                    'id': Math.round(Math.random() * (1000 - 1) + 1),
                    'fullname': 'Друг ' + Math.round(Math.random() * (100 - 1) + 1),
                    'image': 'http://placehold.it/400x400'
                },
                {
                    'id': Math.round(Math.random() * (1000 - 1) + 1),
                    'fullname': 'Друг ' + Math.round(Math.random() * (100 - 1) + 1),
                    'image': 'http://placehold.it/400x400'
                }
            ],
            'debtors': [
                {
                    'id': Math.round(Math.random() * (1000 - 1) + 1),
                    'fullname': 'Друг ' + Math.round(Math.random() * (100 - 1) + 1),
                    'image': 'http://placehold.it/400x400'
                },
                {
                    'id': Math.round(Math.random() * (1000 - 1) + 1),
                    'fullname': 'Друг ' + Math.round(Math.random() * (100 - 1) + 1),
                    'image': 'http://placehold.it/400x400'
                }
            ],
            'image': 'http://placehold.it/400x400',
            'fullname': 'Василий Пупкин',
            'rating': Math.round(Math.random() * (100 - 1) + 1)
        };
        callback(data);
    };
}