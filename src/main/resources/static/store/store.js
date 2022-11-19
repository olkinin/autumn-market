angular.module('app').controller('storeController', function ($scope, $http, $location) {

   const contextPath = 'http://localhost:8189/app';
       $scope.loadProducts = function () {
           $http.get(contextPath + '/api/v1/products')
               .then(function (response) {
                   $scope.products = response.data;
               });
       };
$scope.loadProducts();
});