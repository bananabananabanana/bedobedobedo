require.config({
    paths: {
        'angular': '/resources/_vendors/bower_components/angular/angular',
        'angular-route': '/resources/_vendors/bower_components/angular-route/angular-route',
        'app': '/resources/scripts/app.min'
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