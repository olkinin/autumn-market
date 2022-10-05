angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/allProduct')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changeScore = function (id, delta){
        $http({
            url: contextPath + '/product/change_score',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };


    $scope.loadProducts();



});
