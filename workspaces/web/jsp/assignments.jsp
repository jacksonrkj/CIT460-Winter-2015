<%-- 
    Document   : assignments
    Created on : Feb 13, 2015, 9:34:18 AM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="panel panel-primary" ng-controller="assignmentsController">
    <div class="panel-heading row margin-remove">
        <h3 class="panel-title col-xs-11">Assignments</h3>
        <span ng-click="remove()" close class="glyphicon glyphicon-remove col-xs-1" aria-hidden="true"></span>
    </div>
    <div class="panel-body">
        <div class="kv-main">
            <h1>Bootstrap File Input Example <small><a href="https://github.com/kartik-v/bootstrap-fileinput-samples"><i class="glyphicon glyphicon-download"></i> Download Sample Files</a></small></h1>
            <form enctype="multipart/form-data">
                <input id="file-0" class="file" type="file" multiple=true>
                <br>
                 <div class="form-group">
                    <input id="file-0a" class="file" type="file">
                </div>
                <div class="form-group">
                    <input id="file-1" type="file" multiple=true class="file" data-show-upload="false" data-preview-file-type="any" data-initial-caption="Kartik" data-overwrite-initial="false">
                </div>
                <div class="form-group">
                    <input id="file-2" type="file" class="file" readonly=true data-show-upload="false">
                </div> 
                <div class="form-group">
                    <input id="file-3" type="file" multiple=true>
                </div>
                <div class="form-group">
                    <input id="file-4" type="file" class="file" data-upload-url="#">
                </div>
                <div class="form-group">
                    <button class="btn btn-warning" type="button">Disable Test</button>
                    <button class="btn btn-info" type="reset">Refresh Test</button>
                    <button class="btn btn-primary">Submit</button>
                    <button class="btn btn-default" type="reset">Reset</button>
                </div>
                <div class="form-group">
                    <input type="file" class="file" id="test-upload" multiple>
                    <div id="errorBlock" class="help-block"></div>
                </div>
                <div class="form-group">
                    <input id="file-5" class="file" type="file" multiple=true data-preview-file-type="any" data-upload-url="#">
                </div>
            </form>
        </div>
	<script>
    $("#file-0").fileinput({
        'allowedFileExtensions' : ['jpg', 'png','gif'],
    });
    $("#file-1").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
	});
    /*
    $(".file").on('fileselect', function(event, n, l) {
        alert('File Selected. Name: ' + l + ', Num: ' + n);
    });
    */
	$("#file-3").fileinput({
		showUpload: false,
		showCaption: false,
		browseClass: "btn btn-primary btn-lg",
		fileType: "any"
	});
	$("#file-4").fileinput({
		uploadExtraData: [
            {kvId: '10'}
        ],
	});
    $(".btn-warning").on('click', function() {
        if ($('#file-4').attr('disabled')) {
            $('#file-4').fileinput('enable');
        } else {
            $('#file-4').fileinput('disable');
        }
    });    
    $(".btn-info").on('click', function() {
        $('#file-4').fileinput('refresh', {previewClass:'bg-info'});
    });
    /*
    $('#file-4').on('fileselectnone', function() {
        alert('Huh! You selected no files.');
    });
    $('#file-4').on('filebrowse', function() {
        alert('File browse clicked for #file-4');
    });
    */
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
        /*
        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
        });
        */
    });
	</script>
</html>
    </div>
</div>
