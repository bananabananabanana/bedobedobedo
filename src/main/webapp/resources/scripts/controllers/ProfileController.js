ProfileController.$inject = [
    '$scope',
    '$ionicModal',
    '$ionicPopup',
    'Profile',
    'Friend'
];
function ProfileController(scope, modal, popup, Profile, Friend) {
    scope.swap = {};
    scope.swap.quantity = 0;
    scope.swap.date = new Date();
    scope.swap.current = new Date();
    scope.swap.current.setDate(scope.swap.current.getDate() + 1);

    scope.disabledButton = function () {
        return scope.swap.quantity < 1 || scope.swap.date == undefined || scope.swap.date < scope.swap.current;
    };

    scope.getProfile = function () {
        Profile.getProfile(function (profile) {
            scope.profile = profile;
            console.log(scope.profile);
        });
    };

    scope.getFriend = function (friendId) {
        Friend.getFriendById(friendId, function (friend) {
            scope.friend = friend;
        });
    };

    scope.showModal = function (friendId) {
        scope.getFriend(friendId);

        modal.fromTemplateUrl('/templates/main.friend.modal.html', {
            scope: scope
        }).then(function (friendModal) {
            scope.modal = friendModal;
            scope.modal.show();
        });
    };

    scope.hideModal = function () {
        scope.modal.hide().then(function () {
            scope.friend = {};
            scope.swap.quantity = 0;
            scope.swap.date = new Date();
        });
    };

    scope.refreshFriend = function (friendId) {
        scope.getFriend(friendId);
        scope.$broadcast('scroll.refreshComplete');
    };

    scope.giveConfirm = function () {
        var date = scope.swap.date.toISOString().substr(0, 10);

        popup.confirm({
            title: 'Одолжить ' + scope.swap.quantity + ' до ' + date + '?',
            subTitle: 'Будет отправлен запрос',
            buttons: [
                {
                    text: 'Отмена'
                },
                {
                    text: 'ОК',
                    type: 'button-positive',
                    onTap: function () {
                        return true;
                    }
                }
            ]
        }).then(function (result) {
            if (result) {
                Friend.giveMoney(scope.friend.id, scope.swap.quantity, date, function (result) {
                    if (result) {
                        scope.friend.debtor.push({
                            'id': 1,
                            'quantity': scope.swap.quantity,
                            'endDate': date,
                            'confirm': false,
                            'close': false,
                            'cancel': false
                        });

                        scope.swap.quantity = 0;
                        scope.swap.date = new Date();
                    }
                });
            }
        });
    };

    scope.creditorConfirm = function (creditor) {
        popup.confirm({
            title: 'Подтвердить?',
            buttons: [
                {
                    text: 'Нет',
                    onTap: function () {
                        // отменяем
                        creditor.cancel = true;
                        // добавляем в массив отмененных
                        scope.friend.cancel.creditor.push(creditor);
                        // удаляем из обычного массива
                        scope.friend.creditor.splice(scope.friend.creditor.indexOf(creditor), 1);
                    }
                },
                {
                    text: 'X',
                    type: 'button-clear'
                },
                {
                    text: 'Да',
                    type: 'button-positive',
                    onTap: function () {
                        creditor.confirm = true;
                    }
                }
            ]
        });
    };

    scope.debtorConfirm = function (debtor) {
        // есть подтверждение того, что вам должны
        popup.confirm({
            title: 'Подтвердите получение',
            buttons: [
                {
                    text: 'Отмена'
                },
                {
                    text: 'Получено',
                    type: 'button-positive',
                    onTap: function () {
                        // закрываем
                        debtor.close = true;
                        // добавляем в массив закрытых
                        scope.friend.close.debtor.push(debtor);
                        // удаляем из обычного массива
                        scope.friend.debtor.splice(scope.friend.debtor.indexOf(debtor), 1);
                    }
                }
            ]
        });
    };
}