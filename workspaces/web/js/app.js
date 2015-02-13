/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function init() {


var app = angular.module('workspaces', ['ngRoute']);

app.controller('personController', ['$scope', '$http', '$sce', '$compile', function ($scope, $http, $sce, $compile) {

        $scope.mustHide = true;
        $scope.chatHide = true; 
        $scope.calendarHide = false;
        $scope.todoHide = true; 
        $scope.assignmentHide = true;

        $scope.fullName = function () {
            return $scope.firstName + " " + $scope.lastName;
        };



        $scope.angularJsAjax = function (index) {
            var url;
            var attribute; 
            
            switch (index) {
                case 0: 
                    url = "../html/chat.html";
                    break;
                case 1:
                    $scope.calendarHide = true;
                    url = "../html/chat.html";
                    break; 
                case 2: 
                    url = "../jsp/todo.jsp";
                    break;
                case 4:
                    url = "../jsp/assignments.jsp";
                    break;
                case 5:
                    url = "../jsp/groups.jsp";
                    break;
                default :
                    url = "../jsp/angularAjax.jsp";
                    break;
            }


            $http.get(url)
                    .success(function (response) {
                        switch (index){
                            case 0:
                                $scope.chatOutput = response; 
                                $scope.chatOutput = $sce.trustAsHtml($scope.chatOutput);
                                $scope.chatHide = false; 
                                break; 
                            case 1: 
                                $scope.calendarHide = false;
                                break; 
                            case 2:
                                $scope.todoOutput = response; 
                                $scope.todoOutput = $sce.trustAsHtml($scope.todoOutput);
                                $scope.todoHide = false; 
                                break; 
                            case 4:
                                $scope.assignmentOutput = response; 
                                $scope.assignmentOutput = $sce.trustAsHtml($scope.assignmentOutput);
                                $scope.assignmentHide = false; 
                                break;
                            case 5: 
                                $scope.groupOutput = response; 
                                $scope.groupOutput = $sce.trustAsHtml($scope.groupOutput);
                                $scope.groupHide = false; 
                                break; 
                            default:                        
                                $scope.angularOutput = response;
                                $scope.angularOutput = $sce.trustAsHtml($scope.angularOutput);
                                $scope.mustHide = false;
                        }
                        


                    });
                

        };

    }]);


app.controller('groupsController', ['$scope', '$http', '$sce', function ($scope, $http, $sce) {
        $scope.remove = function(){
            console.log("hide");
        }; 
        
}]);


$('.removePanel').click(function() {
  alert( "Handler for .click() called." );
});


// Test
}init();