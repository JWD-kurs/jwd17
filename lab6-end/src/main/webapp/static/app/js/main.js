var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('myCtrl', function($scope){
	$scope.text = "hello world!";
	$scope.sayHello = function () {
		console.log('uneta poruka je: ',$scope.poruka);
	}
});

wafepaApp.controller('myCtrl1', function($scope){
	$scope.text="asdfasdfasd asdf asdf";
});

wafepaApp.controller('innerCtrl', function($scope){
	$scope.text = "Nova vrednost";
});

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partials/home.html'
        })
        .when('/activities', {
             templateUrl : '/static/app/html/partials/activities.html'
        })
        .otherwise({
             redirectTo: '/'
        });
}]);