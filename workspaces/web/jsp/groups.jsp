<%-- 
    Document   : groups Template
    Created on : Feb 10, 2015, 7:39:26 PM
    Author     : Preston Blaylock 
--%>
<div class="panel panel-primary" ng-controller="groupsController">
    <div class="panel-heading row margin-remove">
        <h3 class="panel-title col-xs-11">Group</h3>
        <span  class="removePanel glyphicon glyphicon-remove col-xs-1" aria-hidden="true"></span>
    </div>
    <div class="panel-body">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default panel-show-groups">
                <div class="panel-heading row" role="tab" id="headingOne">
                    <h4 class="panel-title col-xs-11">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Group 1 
                        </a>
                    </h4>
                    <span class="col-xs-1"><a data-toggle="modal" data-target="#myModal">edit</a></span>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                        <p><strong>Description: </strong><br>This group meets ever tuesday at 6pm to review for the upcoming biology test  </p>
                        <h4>Group Members</h4>
                        <div class="group-members row">
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Mario Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>mario@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Lugi Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>lugi@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Toad Bro</strong> <br>
                                        <strong>Role: </strong> Member <br>
                                        <strong>Email: </strong>toad@education.edu
                                    </div> 
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default panel-show-groups">
                <div class="panel-heading row" role="tab" id="headingTwo">
                    <h4 class="panel-title col-xs-11">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Group 2 
                        </a>
                    </h4>
                    <span class="col-xs-1"><a data-toggle="modal" data-target="#myModal">edit</a></span>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body">
                        <div class="panel-body">
                        <p><strong>Description: </strong><br>This is the group that meets for our group project. ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum ipsum plurum </p>
                        <h4>Group Members</h4>
                        <div class="group-members row">
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Mario Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>mario@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Lugi Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>lugi@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Toad Bro</strong> <br>
                                        <strong>Role: </strong> Member <br>
                                        <strong>Email: </strong>toad@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Bowser Bro</strong> <br>
                                        <strong>Role: </strong> Member <br>
                                        <strong>Email: </strong>bowser@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Princess Peach</strong> <br>
                                        <strong>Role: </strong> Member <br>
                                        <strong>Email: </strong>peach@education.edu
                                    </div> 
                                </div>

                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default panel-show-groups">
                <div class="panel-heading row" role="tab" id="headingThree">
                    <h4 class="panel-title col-xs-11">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            WorkSpace Warriors Group
                        </a>
                    </h4>
                     <span class="col-xs-1"><a data-toggle="modal" data-target="#myModal">edit</a></span>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                    <div class="panel-body">
                           <p><strong>Description: </strong><br>This group meets to build the workspace warrior app.</p>
                        <h4>Group Members</h4>
                        <div class="group-members row">
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Mario Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>mario@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Lugi Bro</strong> <br>
                                        <strong>Role: </strong> Manager <br>
                                        <strong>Email: </strong>lugi@education.edu
                                    </div> 
                                </div>

                            </div>
                            <div style="clear:both"></div>
                            <hr>
                            <div class="member">
                                <div class="col-md-2 col-xs-2 avatar">
                                    <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                </div>
                                <div class="col-xs-10">
                                    <div><strong>Toad Bro</strong> <br>
                                        <strong>Role: </strong> Member <br>
                                        <strong>Email: </strong>toad@education.edu
                                    </div> 
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>       
    </div>
    
    <button class="btn add-group-btn" type="button"  data-toggle="modal" data-target="#myModal">
  Add Group
</button>
    
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Add Group</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" >Group Name:</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="Group-Name" placeholder="Group Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="pwd"> Description: </label>
                                        <div class="col-sm-10"> 
                                            <textarea class="form-control" ></textarea>
                                        </div>
                                    </div>

                                    <div class="group-members row">
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Mario Bro</strong> <br>
                                                    <strong>Role: </strong> 
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>mario@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Lugi Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>lugi@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        <div style="clear:both"></div>
                                        <hr>
                                        <div class="member">
                                            <div class="col-md-2 col-xs-2 avatar">
                                                <img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">     
                                            </div>
                                            <div class="col-xs-10">
                                                <div><strong>Toad Bro</strong> <br>
                                                    <strong>Role: </strong>
                                                    <select>
                                                        <option>Manager</option>
                                                        <option>Member</option>
                                                    </select><br>
                                                    <strong>Email: </strong>toad@education.edu
                                                </div> 
                                            </div>

                                        </div>
                                        
                                        
                                        
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
