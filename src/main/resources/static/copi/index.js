angular.module('app').controller('indexController', function ($scope, $http) {

       const contextPath = 'http://localhost:8189/app';
       $scope.loadProducts = function () {
           $http.get(contextPath + '/api/v1/products')
               .then(function (response) {
                   $scope.products = response.data;
               });
       };


    $scope.deleteProduct = function (id) {
           $http.delete(contextPath + '/api/v1/products/'+ id)
               .then(function (response) {
                   $scope.products = response.data;
                     $scope.loadProducts();
               });
       };
  $scope.addCart = function (id) {
           $http.get(contextPath + '/api/v1/products/addCart/'+ id)
               .then(function (response) {
                   $scope.products = response.data;
                   alert("Товар успешно добавлен в корзину");
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

  $scope.tryToAuth = function () {
        $http.post(contextPath + '/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.webMarketUser = {name: $scope.user.name, token: response.data.token};

                    $scope.user.name = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.name) {
            $scope.user.name = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.webMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.webMarketUser) {
            return true;
        } else {
            return false;
        }
    };
           $scope.loadProducts();

});
