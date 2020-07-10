var token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJyb2hpdCIsImlhdCI6MTU5NDI3NTM3MSwiZXhwIjoxNTk0MzY1MzcxfQ.VcttOzD6Oq3ji-Q_BmWxbMqIUra-4JcAaHwCYFJMUFJSuQt6V_iB9rmvtaWQRMomrXNzEDbr8bcA5FQp6NZPkXghCnkZpV6QompPD_REGQK_noAFZEIQ7vqiU9_zGdAEQUWo9HmggqJ9lQU4GsWx9CVVNaUdNjxtemoI2fXNTEbILGGYdATIlIePP-cLR2ejPBiS_piBfOgosfVhi2bXx3P0UEe9imdWl1pkYX2ZKftXIeOGBdqLlcqFZULwMBjOdLRIch5ekfkL5HZeBnYV08F5kOUD4JTPYWDVwXX7qXAvHDYQ8AIdha5tiwXeHpR10MkfpwkX7xeltZgIszcJ2A";


$(document).ready(function () {
	getModules();
	
	
//	if($("#module").val() != null && $("#module").val() != "Please select"){
//	$("#module").change(getModules($("#module").val()));
//	}
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
		  "url": "http://localhost:8080/api/module",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			    "Authorization": "Bearer "+token,
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
		  "url": "http://localhost:8080/api/question",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			    "Authorization": "Bearer "+token,
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
		  "url": "http://localhost:8080/api/option",
		  "method": "POST",
		  "timeout": 0,
		  "headers": {
			    "Authorization": "Bearer "+token,
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
			$("#modId").val(response[0].modId);
			$("#modName").val(response[0].modName);
			$("#modStatus").val(response[0].modStatus);
			$("#modQuestionLimit").val(response[0].modQuestionLimit);
			$("#modWeightingPassPercent").val(response[0].modWeightingPassPercent);
			$("#modRandomQuestions").val(response[0].modRandomQuestions.toString());
			$("#modName").val(response[0].modName);
			$("#moduleForm").show();

			getQuestionByModule(response[0].modId);
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

function getQuestionByModule(id){
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
		          '<h4 class="modal-title">Questions</h4>'+
		          '<textarea rows="9" cols="25" class="form-control" name="updatequeText" id="updatequeText" value="'+response[i].queText +'">'+response[i].queText +'</textarea>'+
		        '  <label for="modStatus"> Is Mandatory</label> <Select id="modStatus"'+
					'	class="form-control" name="modStatus"'+
					'	onchange="getModuleById(this)">'+
					'<option selected value="Enable">Enable</option>'+
			       '   <option value="Disable">Disable</option>'+
				'	</select>'+
				'  <label for="addqueMandatory">Is Question Mandatory</label> '+
			      '   <Select id="addqueMandatory" class="form-control" name="addqueMandatory">'+
			      '    <option value="true">Yes</option>'+
			       '   <option selected value="false">No</option>'+
			      '  </select>'+
		          '<button type="submit" class="btn btn-primary" >Update Question</button>'+
		        '</div>'+
				
				 '   <div class="modal-body">      '+   
					'<button type="submit" class="btn btn-primary pull-right" data-dismiss="modal" data-toggle="modal" data-target="#addOption">Add new Option</button>'+
					' <form id = "form'+icount+'">'+
					'			 <h5><b>OPTIONS :</b></h5>';
				for(j = 0; j<response[i].questionOptionDtos.length; j++ ){
					var jcount = j +1;
					modalDiv = modalDiv + '<h5 name = "question1" value = "'+response[i].questionOptionDtos[j].optId+'"> '+jcount+') '+response[i].questionOptionDtos[j].optText+' </h5>';	
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
			  $("#modQuestionLimit").append(new Option(i, i));
		  }
		  
		  queList = queList +	'<button type="submit" class="btn btn-primary pull-right" data-toggle="modal" data-target="#addQuestion" >Add new Question</button>';
		  $("#myModal1").parent().html(modalDiv);
		  $("#queList").html(queList);
		
	});
}


function openQuestion(id){
	sessionStorage.queId = id;
}




