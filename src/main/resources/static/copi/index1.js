angular.module('app', []).controller('indexController', function ($scope, $http) {
       //let currentPageIndex=1;
       const contextPath = 'http://localhost:8189/app';
       $scope.loadProducts = function () {
           $http.get(contextPath + '/api/v1/products')
               .then(function (response) {
                   $scope.products = response.data;
               });
       };


    $scope.deleteProduct = function (id) {
           $http.get(contextPath + '/api/v1/products/delete/'+ id)
               .then(function (response) {
                   $scope.products = response.data;
                     $scope.loadProducts();
               });
       };

       $scope.createNewProduct = function () {
               $http.post(contextPath + '/api/v1/products', $scope.new_product)
                   .then(function successCallback (response) {
                       $scope.loadProducts();
                       $scope.new_product = null;
                   }, function failureCallback (response) {
                       alert(response.data.message);
                   })};

       $scope.updateProduct = function (id) {
               $http.put(contextPath + '/api/v1/products/update/'+id, $scope.update_product)
                  .then(function (response) {
                  $scope.loadProducts();
                  $scope.new_product = null;
                   $scope.products = response.data;
                  })};


           $scope.loadProducts();

});
