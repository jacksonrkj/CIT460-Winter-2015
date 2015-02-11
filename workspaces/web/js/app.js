/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function init() {


var app = angular.module('workspaces', ['ngRoute']);

app.controller('personController', ['$scope', '$http', '$sce', function ($scope, $http, $sce) {

        $scope.mustHide = true;
        $scope.chatHide = true; 

        $scope.fullName = function () {
            return $scope.firstName + " " + $scope.lastName;
        };



        $scope.angularJsAjax = function (index) {
            var url;
            console.log("Log");
            switch (index) {
                case 0: 
                    console.log("case 0");
                    url = "../html/chat.html";
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

  app.directive('close', function(){
    return {
      restrict: 'A',
      link: function(scope, element, attrs){
        element.click(function(){
          alert('hi');
          console.log('Hi');
          
        });
      }
    }
  });

// Test
}init();