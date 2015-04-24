Friend.$inject = ['$http'];
function Friend(http) {
    this.getFriendsOnline = function (callback) {
        var data = [];

        for (var i = 0; i < 5; i++) {
            data[i] = {
                'id': i,
                'image': 'http://placehold.it/40x40',
                'fullname': 'Друг ' + i,
                'rating': Math.round(Math.random() * (100 - 1) + 1),
                'quantity': Math.round(Math.random() * 4),
                'vkid': 1639840
            };
        }

        callback(data);
    };

    this.getFriends = function (callback) {
        var data = [];

        for (var i = 0; i < 15; i++) {
            data[i] = {
                'id': i,
                'image': 'http://placehold.it/40x40',
                'fullname': 'Друг ' + i,
                'rating': Math.round(Math.random() * (100 - 1) + 1)
            };
        }

        callback(data);
    };

    this.getFriendById = function (friendId, callback) {
        // creditor - это тот кто дал текущему пользователю
        var friend = {
            'id': friendId,
            'fullname': 'Друг ' + friendId,
            'image': 'http://placehold.it/100x100',
            'rating': Math.round(Math.random() * (100 - 1) + 1),
            'vkid': 1639840,
            'creditor': [
                {
                    "quantity": 300,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": false,
                    "close": false,
                    "cancel": false
                },
                {
                    "quantity": 600,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": true,
                    "close": true,
                    "cancel": false
                }
            ],
            'debtor': [
                {
                    "quantity": 300,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": false,
                    "close": false,
                    "cancel": false
                },
                {
                    "quantity": 600,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": true,
                    "close": true,
                    "cancel": false
                },
                {
                    "quantity": 600,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": true,
                    "closed": false,
                    "cancel": false
                },
                {
                    "quantity": 600,
                    "date": '2011-01-01',
                    "endDate": '2011-01-01',
                    "confirm": true,
                    "close": true,
                    "cancel": false
                }
            ]
        };

        var close = {
            'creditor': [],
            'debtor': []
        };
        var cancel = {
            'creditor': [],
            'debtor': []
        };
        angular.forEach(friend.creditor, function (creditor, index) {
            if (creditor.close) {
                close.creditor.push(creditor);
                friend.creditor.splice(index, 1);
            }

            if (creditor.cancel) {
                cancel.creditor.push(creditor);
                friend.creditor.splice(index, 1);
            }
        });
        angular.forEach(friend.debtor, function (debtor, index) {
            if (debtor.close) {
                close.debtor.push(debtor);
                friend.debtor.splice(index, 1);
            }

            if (debtor.cancel) {
                cancel.debtor.push(debtor);
                friend.debtor.splice(index, 1);
            }
        });

        friend.close = close;
        friend.cancel = cancel;
        callback(friend);
    };

    this.giveMoney = function (userId, quantity, date, callback) {
        console.log(userId, quantity, date);
        callback(true);
    };
}