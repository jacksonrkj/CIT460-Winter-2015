/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function init() {


var app = angular.module('workspaces', ['ngRoute']);

app.controller('personController', ['$scope', '$http', '$sce', function ($scope, $http, $sce) {

        $scope.mustHide = true;

        $scope.fullName = function () {
            return $scope.firstName + " " + $scope.lastName;
        };



        $scope.angularJsAjax = function (index) {
            var url;

            switch (index) {
                case 5:
                    url = "../jsp/groups.jsp";
                    break;
                default :
                    url = "../jsp/angularAjax.jsp";
                    break;
            }


            $http.get(url)
                    .success(function (response) {
                        $scope.angularOutput = response;
                        $scope.angularOutput = $sce.trustAsHtml($scope.angularOutput);
                    });
            $scope.mustHide = false;
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