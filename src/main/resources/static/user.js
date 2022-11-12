angular.module('app', []).controller('userController', function ($scope, $http) {
       //let currentPageIndex=1;
       const contextPath = 'http://localhost:8189/app/';
       $scope.loadProducts = function () {
           $http.get(contextPath + 'api/v1/users')
               .then(function (response) {
                   $scope.products = response.data;
               });
       };



           $scope.loadProducts();

});
