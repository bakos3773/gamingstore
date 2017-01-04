var app = angular.module('myApp', []);
app.controller('mainCtrl', function($scope, $http) {

    $scope.games = [];

    $scope.allGames = function(){
        $http.get("/getAllUsersGame").then(function(reposnse){
            console.log(reposnse.data);
            $scope.games = reposnse.data;
        });
    }
});
