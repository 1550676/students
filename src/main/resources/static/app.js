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
                        controller: 'AddOrEditStudentController'
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

    $scope.deleteStudent = function (id) {
            $http.delete(contextPath + '/'+ id)
                .then(function () {
                    fillTable();
                });
        };
});

app.controller('AddOrEditStudentController', function ($scope, $http, $routeParams) {

    if ($routeParams.id != null) {
        $http.get(contextPath + '/' + $routeParams.id).then(function (response) {
            $scope.studentForm = response.data;
            console.log($scope.studentForm);
        });
    }

    $scope.createOrUpdateStudent = function() {
        if($scope.studentForm.id == null) {
            $http.post(contextPath, $scope.studentForm).then(function (response) {
                console.log(response);
                window.location.href = 'http://localhost:8087/index.html#!/students';
                window.location.reload(true);
            });
        } else {
            $http.put(contextPath, $scope.studentForm).then(function (response) {
                console.log(response);
                window.location.href = 'http://localhost:8087/index.html#!/students';
                window.location.reload(true);
            });
        }
    };
});