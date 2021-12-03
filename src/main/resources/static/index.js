angular.module('app', []).controller('indexController', function ($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function(){
        $http.get(contextPath + '/products')
            .then(function(response){
                $scope.ProductList=response.data;
        });
    };

    $scope.changeCost = function (productID, delta) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productID: productID,
                delta: delta
            }
        }).then(function(response){
            $scope.loadProducts();
        });
    }

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                //alert('DELETED');
                $scope.loadProducts();
            });
    }
    $scope.loadProducts();
});