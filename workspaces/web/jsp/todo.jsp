<%-- 
    Document   : todo
    Created on : Feb 13, 2015, 9:13:45 AM
    Author     : Preston
--%>

<div class="todo-panel panel panel-primary" ng-controller="groupsController">
    <div class="panel-heading row margin-remove">
        <h3 class="panel-title col-xs-11">ToDo List</h3>
        <span  class="removePanel glyphicon glyphicon-remove col-xs-1" aria-hidden="true"></span>
    </div>
    <div class="panel-body">
        <form>

            <div class="checkbox">
                <label>
                    <span><input type="checkbox"> Assignment 2.3 Presentation <br></span>
                    <span><input type="checkbox"> Assignment 2.3 Presentation <br></span>
                    <span><input type="checkbox"> Assignment 2.3 Presentation <br></span>
                    <span><input type="checkbox"> Assignment 2.3 Presentation <br></span>
                    <span><input type="checkbox"> Assignment 2.3 Presentation <br></span>
                </label>
            </div>

        </form>

        <button class="btn add-group-btn" type="button"  data-toggle="modal" data-target="#todoModal">
            Add ToDo
        </button>

    </div>
</div>


<div class="modal fade" id="todoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add ToDo Item</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="todoModal"></label>
                        <input type="text" class="form-control" id="todoModal" placeholder="Enter Todo">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>