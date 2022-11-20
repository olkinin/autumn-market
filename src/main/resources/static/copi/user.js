angular.module('app').controller('userController', function ($scope, $http) {
       const contextPath = 'http://localhost:8189/app/';
       $scope.loadUsers = function () {
           $http.get(contextPath + 'api/v1/users')
               .then(function (response) {
                   $scope.users = response.data;
               });
       };

           $scope.loadUsers();

});
