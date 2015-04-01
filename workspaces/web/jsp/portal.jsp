<%-- 
    Document   : portal.jsp
    Created on : Mar 27, 2015, 2:50:59 PM
    Author     : jacksonrkj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Welcome {{firstName}} {{lastName}}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/fullcalendar.min.css" rel="stylesheet">
        <link href="css/fullcalendar.print.css" rel="stylesheet">
        <link href="css/chat.css" rel="stylesheet">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/fileinput.js" type="text/javascript"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-route.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.2.7/fullcalendar.min.js"></script>
        <script src="js/app.js"></script>
        <script src="js/chat.js"></script>

        <script > 
            <%! String documents; %>
            <% String documents = (String) request.getAttribute("documents"); %>
        </script>



        <!--<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.3/angular-sanitize.js"></script>-->
        
    </head>
    <body >
        
       

        
        



        <div class="panel-heading no-radius main-heading">
            <h1 class="panel-title">Workspace Warrior</h1>
        </div>
        
        <div class="panel panel-primary no-radius full-screen">
            
           <div class=" icon-bar">
                <ul>
                    <li class="icon chat-icon" ng-click="angularJsAjax(0)"><a>Chat</a></li>
                    <li class="icon calendar-icon" ng-click="angularJsAjax(1)"><a>Calendar</a></li>
                    <li class="icon todo-icon" ng-click="angularJsAjax(2)"><a>To Do List</a></li>
                    <li class="icon document-icon" ng-click="angularJsAjax(3)"><a>Document</a></li>
                    <li class="icon assignment-icon" ng-click="angularJsAjax(4)"><a>Assignment</a></li>
                    <li class="icon group-icon" ng-click="angularJsAjax(5)"><a>Groups</a></li>
                </ul>
            </div>
            
            <div ng-app="myApp" ng-controller="personCtrl" ng-model="mustHide">
                <div class="panel panel-primary">
                    <br>
                    <h4>Courses</h4>
                    <ul>
                        <li ng-repeat="x in courses">
                          {{ x.document.shortDescription }}
                        </li>
                    </ul>
                </div>
                
                <div class="panel panel-primary">
                    <h4>Grades</h4>

                    <ul>
                        <li ng-repeat="x in finalGrades">
                          {{ x.document.shortDescription }}
                        </li>
                    </ul>
                </div>
                
                <div class="panel panel-primary">
                    <h4>Events</h4>
                    <ul>
                        <li ng-repeat="x in events">
                          {{ x.document.text.endTime }}: {{ x.document.shortDescription }}
                        </li>
                    </ul>
                </div>
            
            <!--{{ editEndingTimes() }}-->

            </div>

            <div class="row workspaceWindow">
                <div ng-hide="mustHide"  class="col-sm-6 " ng-bind-html="angularOutput"></div>
                <div ng-hide="groupsHide"  class="col-sm-6 " ng-bind-html="groupOutput"></div>
                <div ng-hide="chatHide"  class="" ng-bind-html="chatOutput"></div>
                <div ng-hide="todoHide"  class="col-sm-6 " ng-bind-html="todoOutput"></div>
                <div ng-hide="assignmentHide"  class="col-sm-6 " ng-bind-html="assignmentOutput"></div>
                <div  id='calendar' ng-hide="calendarHide" class="col-xs-12 col-sm-6 "></div>

            </div>
        </div>
        

    <script>

        var app = angular.module('myApp', []);

        app.controller('personCtrl', function($scope) {
            $scope.mustHide = true;
            $scope.json = '<%= documents %>';
            var documentList = JSON.parse($scope.json);
            $scope.events = documentList.documents.CTEV;
            $scope.courses = documentList.documents.CTSC;
            $scope.finalGrades = documentList.documents.CTFG;

            $scope.editEndingTimes = function() {
                alert("started"); 

                var noEvents = $scope.events.length;
                for (var i=0; i < noEvents; i++) {
                    var time = $scope.events[i].document.text.endTime;
                }           
                return "ended";
            };

                
        });

            

        $(document).ready(function () {

            // page is now ready, initialize the calendar...

            $('#calendar').fullCalendar({
            });

            $(document).on('click', '.removePanel', function () {
                $(this).closest(".panel").hide();
            });


            $(document).on('click', '#myModal .member', function () {
               $(this).toggleClass( "bg-success" );
            });

            $(document).on('click', '.todo-panel input', function () {
               $(this).closest("span").hide();
            });

        });

    </script>


        
        
    </body>
</html>
