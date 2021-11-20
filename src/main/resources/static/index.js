angular.module('app', []).controller('indexController', function ($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function(){
        $http.get(contextPath + '/products')
            .then(function(response){
                $scope.ProductList=response.data;
        });
    };

//    $scope.changeScore = function (studentId, delta) {
//        $http({
//            url: contextPath + '/students/change_score',
//            method: 'GET',
//            params: {
//                studentId: studentId,
//                delta: delta
//            }
//        }).then(function(response){
//            $scope.loadStudents();
//        });
//    }
//
    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                //alert('DELETED');
                $scope.loadProducts();
            });
    }

    $scope.loadProducts();
});