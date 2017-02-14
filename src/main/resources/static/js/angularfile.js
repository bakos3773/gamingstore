var app = angular.module('myApp', []);
app.controller('mainCtrl', function($scope, $http) {

    $scope.games = [];

    $scope.allGames = function(){
        $http.get("/user/getAllUsersGame").then(function(reposnse){
            console.log((reposnse.data));
            $scope.games = reposnse.data;
        });
    }

    $scope.showCommunicatorPanel = false;
    $scope.idCommunicator = "0";
    $scope.showCommunicator = false;
    $scope.allMyFriends = [];

    $scope.setCommunicatorPanel = function(){
        $scope.showCommunicatorPanel = !$scope.showCommunicatorPanel;
        if($scope.showCommunicatorPanel==true){
            connect();
        }else{
            disconnect();
        }
    }

    $scope.showTalkCommunicator =  function (name) {
        $scope.idCommunicator = name;
        $scope.showCommunicator = true;
    }

    $scope.getAllFriends = function(){
        $http.get("/user/getAllFriends").then(function(reposnse){
            $scope.allMyFriends  = reposnse.data;
        });
    }

    $scope.getInfoProfile = function(){
        $http.get("/user/getInfoProfile").then(function(response){
            $scope.infoProfile = response.data;
        });
    }
});

app.directive('communicatorTalking', function($document){
    return{
        restrict: 'E',
        template: "<form id='second-form'>"+
        "<input type='text' id='friendId' value='{{idCommunicator}}' />"+
        "<div class='col-md-2' style='height: 200px; width: 20%; background-color: coral; border: double;'>"+
            "<div style='height: 80%; background-color: #55acee; overflow: scroll'>"+
                "<ul id='contentCommunicator-{{idCommunicator}}'></ul>"+
             "</div>"+
             "<div style='height: 20%;'>"+
                "<input type='text' id='contentInput' class='form-control' /><button id='send' class='btn btn-default' type='submit'>Send</button> <button id='connect' class='btn btn-default' type='submit'>O</button>"+
            "</div>"+
        "</div>"+
        "</form>"
    }
});

app.directive('communicator', function(){
    return{
        restrict: 'E',
        template: "<form>" +
        "<div class='col-md-2' style='height: 200px; width: 20%; background-color: coral; border: double;'>" +
            "<div style='background-color: chocolate; overflow: scroll'>" +
                "<ul><span th:each='friend : ${friends}'><li><p th:text='${friend.username}'>Text</p></li></span></ul>" +
            "</div>" +
        "</div>" +
        "</form>"
    }
});

