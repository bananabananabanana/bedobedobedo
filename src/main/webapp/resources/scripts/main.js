require.config({
    paths: {
        'angular': BASE_PATH + '/resources/_vendors/bower_components/angular/angular',
        'angular-route': BASE_PATH + '/resources/_vendors/bower_components/angular-route/angular-route',
        'app': BASE_PATH + '/resources/scripts/app.min'
    },
    shim: {
        'angular-route': ['angular'],
        'app': [
            'angular',
            'angular-route'
        ]
    }
});

require(['app'], function() {
    angular.bootstrap(document, ['app']);
});