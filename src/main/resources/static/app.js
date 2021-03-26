var app = angular.module("app", ['ngRoute']);
var contextPath = 'http://localhost:8087/students'

app.config(function($routeProvider) {
	$routeProvider
                    .when('/students', {
                        templateUrl: 'students.html',
                        controller: 'StudentsController'
                    })
                    .when('/add_or_edit_student', {
                        templateUrl: 'add_or_edit_student.html',
                        controller: 'AddOrEditProductController'
                    })
});

app.controller('StudentsController', function ($scope, $http) {
    fillTable = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.studentsList = response.data;
                            console.log($scope.studentsList);
            });
    };
    fillTable();


});

//app.controller('AddOrEditProductController', function ($scope, $http, $routeParams) {
//
//    if ($routeParams.id != null) {
//        $http.get(contextPath + '/' + $routeParams.id).then(function (response) {
//            $scope.studentForm = response.data;
//            console.log($scope.studentForm);
//        });
//    }
//
//    $scope.createOrUpdateProduct = function() {
//
//        if($scope.productFromForm.id == null) {
//            $http.post(contextPath + '/api/v1/products', $scope.productFromForm).then(function (response) {
//                console.log(response);
//                window.location.href = contextPath + '/index.html#/shop';
//                window.location.reload(true);
//            });
//        } else {
//            $http.put(contextPath + '/api/v1/products', $scope.productFromForm).then(function (response) {
//                console.log(response);
//                window.location.href = contextPath + '/index.html#/shop';
//                window.location.reload(true);
//            });
//        }
//    };
//});