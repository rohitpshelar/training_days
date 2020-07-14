//var token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJyb2hpdCIsImlhdCI6MTU5NDY1ODk3MywiZXhwIjoxNjM0NjU4OTc0fQ.byu9nisLHcwICv70rpgggQl0MSYeIDoAj-meCsOCjuFc0mIDufSQcD5eQL8kLhBf6aJLrG0alxG1JUYLqmWnZyk4jI4cdiCcec0Lbp0V0RooeT-UpRsfr4btRh-Dgwc5R-NH7sm81aa9jCEkUbBl-j84oQRkdWXaYFhHysemkEUYS6QDDxC3_2M--YO5lvke3U5HMtb_rr8r25QsNdRrHRZVWcDtdZ_PcZOGEwxOScndgLJon9aBtMGeCw8kcqRe2qltihV83R26v0aPmVCLBWHiOPdjt0qFHv9QHvBfDqjCETy_gVnEtJQ0W3NMuDCE6FUpIA549DrPM7VNSzVcQQq";


$(document).ready(function () {
	getModules();
	
});

function getModules(){
	
	var settings = {
			async: false,
	  "url": "http://localhost:8080/api/module",
	  "method": "GET",
	  "timeout": 0,
	};

	$.ajax(settings).done(function (response) {
		for(i=0; i < response.length ; i++){
			$("#module").append(new Option(response[i].modCode, response[i].modId));
		}
	});
}
$.fn.getFormObject = function() {
    var object = $(this).serializeArray().reduce(function(obj, item) {
        var name = item.name.replace("[]", "");
        if ( typeof obj[name] !== "undefined" ) {
            if ( !Array.isArray(obj[name]) ) {
                obj[name] = [ obj[name], item.value ];
            } else {
               obj[name].push(item.value);
            }
        } else {
            obj[name] = item.value;
        }
        return obj;
    }, {});
    return object;
}

function addModule(){
	var ele = $('#addmoduleForm').getFormObject();
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/module?user=rohitpshelar",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			  //  "Authorization": "Bearer "+token,
			    "Content-Type": "application/json"
			  },
		  "data": JSON.stringify({"modCode":ele.addmodCode,"modName":ele.addmodName,"modQuestionLimit":0,"modRandomQuestions":ele.addmodRandomQuestions,"modStatus":ele.addmodStatus,"modWeightingPassPercent":ele.addmodWeightingPassPercent}),
		};

		$.ajax(settings).done(function (response) {
			showModel("Module added");
			
		});
}

function addQuestion(){
	var ele = $('#addQuestionForm').getFormObject();
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/question?user=rohitpshelar",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			//    "Authorization": "Bearer "+token,
			    "Content-Type": "application/json"
			  },
			  "data": 	JSON.stringify({"queMandatory":ele.addqueMandatory,"queModId":sessionStorage.modId,"queStatus":ele.addqueStatus,"queText":ele.addqueText,"queType":"text"}),
		};

		$.ajax(settings).done(function (response) {
			showModel("Question added");
			$("#addqueText").val("");
		});
}

function addOption(){
	var ele = $('#addOptionForm').getFormObject();
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/option?user=rohitpshelar",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			//    "Authorization": "Bearer "+token,
			    "Content-Type": "application/json"
			  },
			  "data": JSON.stringify({"optQueId":sessionStorage.queId,"optStatus":"Approved","optText":ele.addoptText,"optWeighting":ele.addoptWeighting}),
		};

		$.ajax(settings).done(function (response) {
			showModel("Option added");
			$("#addoptText").val("");
		});
}

function showModel(msg){
	
	 $("#modelMessage").html(msg);
	 $("#showCustormModel").modal();
	 $("#showCustormModel").css("pointer-events", "all");
	
}

function getModuleById(id){
	if(id.value != null && id.value != "Please select"){
		var settings = {
				async: false,
		  "url": "http://localhost:8080/api/module/id/"+id.value,
		  "method": "GET",
		  "timeout": 0,
		};
	
		$.ajax(settings).done(function (response) {
			$("#updatemodId").val(response[0].modId);
			$("#updatemodName").val(response[0].modName);
			$("#updatemodStatus").val(response[0].modStatus);
			$("#updatemodCode").val(response[0].modCode);
			$("#updatemodQuestionLimit").val(response[0].modQuestionLimit);
			$("#updatemodWeightingPassPercent").val(response[0].modWeightingPassPercent);
			$("#updatemodRandomQuestions").val(response[0].modRandomQuestions.toString());
			$("#updateModuleForm").show();

			getQuestionByModule(response[0].modId,response[0].modQuestionLimit );
			$("#queContainer").show();
			
			sessionStorage.modId = response[0].modId;
		});
	}else{
		$("#modId").val("");
		$("#moduleForm").hide();
		$("#modName").val("");
		$("#modStatus").val("");
		$("#modQuestionLimit").val("");
		$("#modWeightingPassPercent").val("");
		$("#modRandomQuestions").val("");
		$("#modName").val("");
	}
}

function submitForm(ele){
	consol.log(ele);
}

function getQuestionByModule(id, modQuestionLimit){
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/question/bymodule/"+id,
		  "method": "GET",
		  "timeout": 0,
		  "headers": {
		    "Cookie": "JSESSIONID=EF84B41FA490EC901FB378133B80E343"
		  },
		};
//	({"queMandatory":ele.addqueMandatory,"queModId":sessionStorage.modId,"queStatus":ele.addqueStatus,"queText":ele.addqueText,"queType":"text"}),
	
		$.ajax(settings).done(function (response) {
		  var queList = "";
		  var modalDiv = ""
		  var optModalDiv = "";
		var qlimitstart =1;
		  var qlimitend =response.length;
		  for(i=0; i < response.length ; i++){
			  var icount = i+1;
			  
			  if(response[i].queStatus == "Disable"){
				  queList = queList + "<h4 data-toggle='modal' data-target='#myModal"+icount+"' onClick='openQuestion("+response[i].queId+")'><pre style='text-decoration: line-through; color: gray; font-weight: 100;'>"+icount+")  "+response[i].queText +"</pre><h4>";
				  qlimitend = qlimitend - 1;
			  }else if (response[i].queMandatory == false){
				  queList = queList + "<h4 data-toggle='modal' data-target='#myModal"+icount+"' onClick='openQuestion("+response[i].queId+")'><pre style='color: gray; font-weight: 100;'>"+icount+")  "+response[i].queText +"</pre><h4>";
			  }else {
					  queList = queList + "<h4 data-toggle='modal' data-target='#myModal"+icount+"' onClick='openQuestion("+response[i].queId+")'><pre>"+icount+")  "+response[i].queText +"</pre><h4>";
					  qlimitstart = qlimitstart +1;
			  }
			  
			  
			  modalDiv = modalDiv +' <div class="modal fade" id="myModal'+icount+'" role="dialog">'+
				 ' <div class="modal-dialog modal-lg">'+
				'  <div class="modal-content">'+
				
				' <div class="modal-header">'+
		         ' <button type="button" class="close" data-dismiss="modal">&times;</button>'+
		         '<form id="updateQuestionForm'+response[i].queId +'" onsubmit="updateQuestion(this)">'+
		       '  <div hidden="true">'+
		      '   <label for="addqueId">Question Id</label> '+
		      '   <input type="text" class="form-control" name="updatequeId" id="updatequeId" placeholder="Enter modName" value="'+response[i].queId +'">'+
		      '  </div>'+
		          '<h4 class="modal-title">Questions</h4>'+
		          '<textarea rows="9" cols="25" class="form-control" name="updatequeText" id="updatequeText" value="'+response[i].queText +'">'+response[i].queText +'</textarea>'+
		        '  <label for="updatequeStatus">Status</label> <Select id="updatequeStatus"'+
					'	class="form-control" name="updatequeStatus">';
			  if(response[i].queStatus== "Enable"){
				  modalDiv = modalDiv +	'<option selected value="Enable">Enable</option>'+
			       '   <option value="Disable">Disable</option>';
			  }else{
				  modalDiv = modalDiv +		'<option  value="Enable">Enable</option>'+
				       '   <option selected value="Disable">Disable</option>';
			  }
			  modalDiv = modalDiv +'	</select>'+
				'  <label for="updatequeMandatory">Is Mandatory</label> '+
			      '   <Select id="updatequeMandatory" class="form-control" name="updatequeMandatory">';
			  if(response[i].queMandatory== true){
				  modalDiv = modalDiv +  '    <option selected value="true">Yes</option>'+
			       '   <option  value="false">No</option>';
			  }else{
				  modalDiv = modalDiv +   '    <option value="true">Yes</option>'+
			       '   <option selected value="false">No</option>';
			  }
			  modalDiv = modalDiv +   '  </select>'+
		          '<button type="submit" class="btn btn-primary" >Update Question</button>'+
		        '</div>'+
		        '<button type="submit" class="btn btn-primary pull-right" data-dismiss="modal" data-toggle="modal" data-target="#addOption">Add new Option</button>'+
				 '   <div class="modal-body">      '+   
					
					' <form id = "form'+icount+'">'+
					'			 <h5><b>OPTIONS :</b>'+
					'<div style="border: 1px solid #f60b0b;background-color: #f2dede;">'+
			   ' Note :<br>'+
			 '   1) <b style="color: green;">GREEN</b> Option are Corrent Option<br>'+
			  '  2) <span style="text-decoration: line-through;">Line-through </span>Option are Disabled Option<br>'+
			  '  3) Click on Option to edit Option'+
			  '  </div> </h5>';
				for(j = 0; j<response[i].questionOptionDtos.length; j++ ){
					var jcount = j +1;
					
					 if(response[i].questionOptionDtos[j].optWeighting == "0"){
						 modalDiv = modalDiv + '<h5 data-dismiss="modal" data-toggle="modal" data-target="#myOptModal'+response[i].questionOptionDtos[j].optId+'" name = "question1" value = "'+response[i].questionOptionDtos[j].optId+'"><pre> '+jcount+') '+response[i].questionOptionDtos[j].optText+' </pre></h5>';	
					  }else{
						  modalDiv = modalDiv + '<h5 data-dismiss="modal" data-toggle="modal" data-target="#myOptModal'+response[i].questionOptionDtos[j].optId+'" name = "question1" value = "'+response[i].questionOptionDtos[j].optId+'"><pre style="color: green;"> '+jcount+') '+response[i].questionOptionDtos[j].optText+' </pre></h5>';	
					  }
					  
					optModalDiv = optModalDiv +' <div class="modal fade" id="myOptModal'+response[i].questionOptionDtos[j].optId+'" role="dialog">'+
						 ' <div class="modal-dialog modal-lg">'+
						'  <div class="modal-content">'+
						
						' <div class="modal-header">'+
				         ' <button type="button" class="close" data-dismiss="modal">&times;</button>'+
				         '<form id="updateOptForm'+response[i].queId +'" onsubmit="updateOpt(this)">'+
				       '  <div hidden="true">'+
				      '   <label for="updateoptId">Opt Id</label> '+
				      '   <input type="text" class="form-control" name="updateoptId" id="updateoptId" value="'+response[i].questionOptionDtos[j].optId +'">'+
				      '  </div>'+
				          '<h4 class="modal-title">Option</h4>'+
				          '<textarea rows="9" cols="25" class="form-control" name="updateoptText" id="updateoptText" value="'+response[i].questionOptionDtos[j].optText +'">'+response[i].questionOptionDtos[j].optText +'</textarea>'+
					
					' <label for="updateoptStatus"> Status</label> <Select id="updateoptStatus" class="form-control" name="updateoptStatus">';
					 if(response[i].questionOptionDtos[j].optStatus== "Enable"){
						 optModalDiv = optModalDiv +	'<option selected value="Enable">Enable</option>'+
					       '   <option value="Disable">Disable</option>';
					  }else{
						  optModalDiv = optModalDiv +		'<option  value="Enable">Enable</option>'+
						       '   <option selected value="Disable">Disable</option>';
					  }
					 optModalDiv = optModalDiv +'   </select>'+
			        ' <label for="addoptWeighting">Is Correct</label> <Select id="addoptWeighting" class="form-control" name="addoptWeighting"> ';
					 if(response[i].questionOptionDtos[j].optWeighting == "0"){
						 optModalDiv = optModalDiv +	'<option selected value="0">No</option>'+
					       '   <option value="1">Yes</option>';
					  }else{
						  optModalDiv = optModalDiv +	'<option  value="0">No</option>'+
					       '   <option selected value="1">Yes</option>';
					  }
					 optModalDiv = optModalDiv + '  </select>'+
					 '<button type="submit" class="btn btn-primary" >Update Option</button>'+
					 ' </div>'+
					    '</div>'+
					 ' </div>'+
					'</div>';	
					
				}
				modalDiv = modalDiv +  '</form>  '+
				 '<center>'+
				 ' </center>     '+                      
			    '</div>'+
			 ' </div>'+
			 ' </div>'+
			'</div>';	
			  
		  }
		  
		  //to set Question Limit
		  for(i = qlimitstart; i <= qlimitend; i++){
			  $("#updatemodQuestionLimit").append(new Option(i, i));
		  }
		  $("#updatemodQuestionLimit").val(modQuestionLimit);
		  
		//  queList = queList +	'<button type="submit" class="btn btn-primary pull-right" data-toggle="modal" data-target="#addQuestion" >Add new Question</button>';
		  $("#myModal1").parent().html(modalDiv);
		  $("#queList").html(queList);
		  $("#myOptModal").parent().html(optModalDiv);
		
	});
}

function updateModule(ele){
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/module?user=rohitpshelar",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			  //  "Authorization": "Bearer "+token,
			    "Content-Type": "application/json"
			  },
		  "data": JSON.stringify({"modId":ele.updatemodId.value,"modCode":ele.updatemodCode.value,"modName":ele.updatemodName.value,"modQuestionLimit":ele.updatemodQuestionLimit.value,"modRandomQuestions":ele.updatemodRandomQuestions.value,"modStatus":ele.updatemodStatus.value,"modWeightingPassPercent":ele.updatemodWeightingPassPercent.value}),
		};

		$.ajax(settings).done(function (response) {
			showModel("Module Updated");
			
		});
	
}

function updateQuestion(ele){
	var settings = {
			async: false,
		  "url": "http://localhost:8080/api/question?user=rohitpshelar",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			//    "Authorization": "Bearer "+token,
			    "Content-Type": "application/json"
			  },
			  "data": 	JSON.stringify({"queId":ele.updatequeId.value,"queMandatory":ele.updatequeMandatory.value,"queModId":sessionStorage.modId,"queStatus":ele.updatequeStatus.value,"queText":ele.updatequeText.value,"queType":"text"}),
		};

		$.ajax(settings).done(function (response) {
			showModel("Question Updated");
		});
}


function openQuestion(id){
	sessionStorage.queId = id;
}




