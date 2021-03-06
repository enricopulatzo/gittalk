//var gittalkApp = angular.module('gittalkApp', ['gittalkApp.controllers']);
//var controllerRegister = angular.module('gittalkApp.controllers', []);
angular.module('gittalkApp', []).config(function($routeProvider, $locationProvider) {
    //$locationProvider.html5Mode(true);
    $routeProvider.when('/404', {
        templateUrl: '/404.html',
        controller: 'mainController'
    });
    $routeProvider.when('/1', {
        templateUrl: '/1.html',
        controller: 'mainController'
    });
    $routeProvider.when('/', {
        redirectTo: '/1'
    });
    $routeProvider.otherwise({
        redirectTo: '/404'
    });
}).run(function($rootScope) {
    // initilization routines
}).controller('mainController', function($rootScope, $scope) {
    // main controller
});

