$(document).ready(function () {
	getModules();
});

function getModules(){
		var settings = {
	  "url": "http://localhost:8080/api/module",
	  "method": "GET",
	  "timeout": 0,
	};

	$.ajax(settings).done(function (response) {
		
		
		for(i=0; i < response.length ; i++){
			$("#module").append(new Option(response[0].modCode, response[0].modId));
			
		}
		
		//$("#module").html
		
	  console.log(response);
	});
	
}


// var clicks = 3;
// function clickCounter() {
	// clicks--;
	// clicks = clicks--;
	// if(clicks < 1){
		// if(sessionStorage != null){
			// sessionStorage.clear();
		// }
		// window.location = "index.html";		
		// clicks = 3;
		// return true;
	// }
	// if (typeof(Storage) !== "undefined") {
		// var un = document.getElementById("username").value;
		// var pw = document.getElementById("password").value;
		// $('#loginbutton').prop("disabled", true);
		
		// if (un != "" & pw != "" & un != null & pw != null) {
			// if(!loginWithUsernameAndPassword(un,pw)){
				// $("#result").html(clicks+" Attempt remaining <br /> Username Or Password not matched !");
			// }
		// }else{
			// $("#result").html(clicks+" Attempt remaining <br /> Username Or Password not filled !");
		// }
	// }
// };

// function jtogel(ele){
		
		// var settings = {
			// async: false,
	  // "url": "http://localhost:8080/api/test/",
	  // "method": "POST",
	  // "timeout": 0,
	  // "headers": {
		// "Authorization": "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJyb2hpdCIsImlhdCI6MTU5MzkzMTA2OSwiZXhwIjoxNTk0MDIxMDY5fQ.HgY3J0LgzCB_BQAsVwLWszkY-rMhZzkyy-zGXrIhMhjyk_KK0Z2JP7nMWCKq4H9wFPZwYrrqGagDgWqaaAgn_y1CznbwLudCYCRqU7T-m_6Qfka-95adi_bNfy5zu5_ip0T02dLZD9PWHRrg-G3ugJLTRtgVIGYKWqTRrXet-DE5HaEuG4PYPjZekZim-eTy2LnGr0CYt3jBQCwobInZ1hwn94XlSjqmMBGululfqlIWh7WQd5kbP30UOrq4FVDrR7g_qK1KNII3LJQgjADeHuMcJ6arxdm8q2VUf2cHlvCPBpTgG9S8laG40-XLApvHpLkNJIU4nHW_uOkz8APp5A",
		// "Content-Type": "application/json",
		// "Cookie": "JSESSIONID=50771CE1259BE6D7428E5D88EE5DE899"
	  // },
	  // "data": JSON.stringify({"ctrModCode":"PAS"}),
	// };

// $.ajax(settings).done(function (response) {
	// var contect = '';
	// sessionStorage.question = JSON.stringify(response);
	// for(i = 0; i < response.questionDtos.length; i++){
		// var icount = i+1;
	  // contect = contect +' <div class="modal fade" id="myModal'+icount+'" role="dialog">'+
	 // ' <div class="modal-dialog modal-lg">'+
    // '  <div class="modal-content">'+
     // '   <div class="modal-body">      '+   
		// ' <form id = "form'+icount+'">'+
		// '	 <ol>'+
		// '		 <li>'+	
		// '			 <h5><b>'+response.questionDtos[i].queText+'</b></h5>';
		// for(j = 0; j<response.questionDtos[i].questionOptionDtos.length; j++ ){
			// var jcount = j +1;
			// contect = contect + '<input type = "radio" name = "question1" value = "'+response.questionDtos[i].questionOptionDtos[j].optId+'"> '+jcount+') '+response.questionDtos[i].questionOptionDtos[j].optText+' <br>';	
		// }
		// var nexti = icount + 1
		// contect = contect + '		 </li>'+
		// '	 </ol> '+
		 // '</form>  '+
		 // '<center>';
		 // if(icount == response.questionDtos.length){
			// contect = contect +  ' <button type="button" id="subid"  class="btn btn-sm btn-primary" data-dismiss="modal" onclick = "javascript: getScore2()" >'+
			// '		SUBMIT'+
			 // '</button>';
		 // }else{
			// contect = contect + ' <button type="button" id="subid"  class="btn btn-sm btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#myModal'+nexti+'" >'+
			// '		Next'+
			 // '</button>';
		 // } 
			 
		// contect = contect + ' </center>     '+                      
        // '</div>'+
     // ' </div>'+
	 // ' </div>'+
    // '</div>';	
	
	// }
	
	
	// $("#myModal1").parent().html(contect);
// });
	// console.log("rohit")
	
	// $(ele).attr("data-toggle", "modal");
	// $(ele).attr("data-target", "#myModal1");
	
// }

// function loginToCellma(ele, url, un, pw) {
	
	// var targetLoginForm = '_blank';
	// if($('#cellmaPagesIframe') != null && $('#cellmaPagesIframe').length){
		// targetLoginForm = "";
		// url = url + '&accessMode=trainingPortal';
	// }
	// var loginToCellmaForm = "loginToCellmaForm";
	// if(url.indexOf("MNM")>=0){
		// loginToCellmaForm = loginToCellmaForm + "1";
	// }
	// var dynamicForm = 			'<div style="display:none">';
	// dynamicForm = dynamicForm + '	<form id="'+loginToCellmaForm+'"  name="'+loginToCellmaForm+'" action="'+url+'" method="POST" target="'+targetLoginForm+'">';
	// dynamicForm = dynamicForm + '		<input type="text" value="'+un+'" name="useUsername" id="useUsername"/>';
	// dynamicForm = dynamicForm + '		<input type="password" value="'+pw+'" name="usePassword" id="usePassword"/>';
	// dynamicForm = dynamicForm + '	</form>';
	// dynamicForm = dynamicForm + '</div>';

	// if($('#cellmaPagesIframe') != null && $('#cellmaPagesIframe').length){
		// $("#cellmaPagesIframe").contents().find("body").html(dynamicForm);
		// alert($('#cellmaPagesIframe').contents().find('#'+loginToCellmaForm).length);
		// $('#cellmaPagesIframe').contents().find('#'+loginToCellmaForm).submit();
	// }
	// else{
		// $(ele).after(dynamicForm);
		// $("#"+loginToCellmaForm).submit();
	// }
// }



// function serverCheck(){	
// var status = true;
	// $.ajax({url:  trainingSiteDomain + 'cellmaWEB/TrainingPortalLogin.do?',
		// timeout:500,
		// statusCode: {
			// 400: function (response) {
				// status = false;
			// }             
		// }
	// });
	// return status;
// }

// function ConfigCheck(){	
	// if (typeof trainingSiteDomain === 'undefined' || trainingSiteDomain === null) {
		// $("#configCheckModal").modal();
		// $("#mainBodyPage").css("pointer-events", "none");
		// $("#configCheckModal .login-form").css("pointer-events", "all");
		
	// }			
// }


// function loginWithUsernameAndPassword(un,pw){
	// if(sessionStorage != null){
		// sessionStorage.clear();
	// }
	// $.support.cors = true;
	// var status = false;
	// var settings = {
		// async: false,
		// data: 'userData={"useUsername":"' + encodeURIComponent(un) + '", "usePassword":"' + encodeURIComponent(pw) + '"}',
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/TrainingPortalLogin.do?',
		// method: "POST",
	// }
	// $.ajax(settings).done(function (data) {
		// if (data != null & data.useUsername != null) {
			
			// sessionStorage.un = data.useUsername;
			// sessionStorage.pw = data.usePassword;					
			// sessionStorage.surname = data.useSurname;
			// sessionStorage.firstname = data.useFirstname;
			// sessionStorage.email = data.useEmail;
			// sessionStorage.mobile = data.useMobile;
			// sessionStorage.estId = data.useEstId;
			// sessionStorage.cliId = data.useCliId;
			// sessionStorage.assignedModules = data.useTrainingAssignedModules;
			// sessionStorage.useReferenceId = data.useReferenceId;
			// var uggList = data.uggNames;
			// sessionStorage.uggNames = uggList;
			// var  moduleList = "";
								
			// if (sessionStorage.un != "" & sessionStorage.pw != "" & sessionStorage.un != null & sessionStorage.pw != null) {

				// if (sessionStorage.un == "super" & sessionStorage.pw == "s0uthampton3") {
					// uggList = "Administrator,Appointment Admin,Appointment Wizard,ARV Prescriber,ARV Prescriber Plus,Blood Bank,Cashier,Communication,Consultant,Deceased_Editor,Default,Dietetics,Dietician,Dispensing,ECA,Employee Hr User,Finance,Finance Admin,HCP,HP Default Appt,HumanResource,Imaging,Infusions Specialist,Kitchen Staff,Lab,Lab Reports,Letter Authoriser,Letter CC,LetterApproveSend,MaintenanceCreated,MDT,Medical Notes,Medical Notes Admin,OrderComms,Overview Editor,Patient Portal,Pharmacist,PointOfSale,PortersTaskDueRep,PortersTaskDueRep,Prescriber,Prescriber,PROMS,Radiologist,Read-Only,Registration,Reports,Results Management,SACT Consultant,SACT Pharmacist,SACT Prescriber,Sample Collection,Service Finance,Service Maintenance,Service Mews,Service Theatre,ServiceAdmin,ServiceUser,Standard,Stock,StockAdmin,Super Admin,Super-User,Surgeon,Task Clerical,Task Dietician,Task Doctor,Task Imaging,Task Lab,Task Nurse,Task Nurse,Task Pharmacist,Task Physio,Theatre Booking,Theatre Emergency,Triage";
					// moduleList = "ePharmacy, Pathology, Imaging, Electronic Patient Record, Ward and Bed management, Theatre and Surgery, Supplies and Inventory Management, Document Management, Maintenance, Porters, Finance billing and insurance, Dietetics and Kitchen, Business intelligence and reporting, Communication";
				// }
				

				// sessionStorage.firstLogin = "";
				// sessionStorage.Patient_Administration_and_Scheduling = "";
				
				// window.location = "index.html";
			// } else {
				// $("#result").html("Invalid");
			// }
		// } else {
			// document.getElementById("result").innerHTML = "Sorry, your browser does not support web storage...";
		// }
		// status =  true;
	// }).fail(function (jqXHR, textStatus, errorThrown) {	
		// status = false; 									
	// });
	// return status; 
// }

// $(document).ready(function () {
// $("#version").val(version);
	// ConfigCheck();
	
	// var url = window.location.href;
	// if(url.indexOf("autologin=true") !== -1) {
		// autoLoginFromCellma(url);
	// }
	
	// $('#signUpBtn').click(function(e){
        // e.preventDefault();

        // $('#loginModal')
            // .modal('hide')
            // .on('hidden.bs.modal', function (e) {
                // $('#registerModal').modal('show');

                // $(this).off('hidden.bs.modal'); // Remove the 'on' event binding
            // });

   // });


	
	// if(sessionStorage != null){
		// $("#contactName").val(sessionStorage.firstname);
		// $("#contactEmail").val(sessionStorage.email);

		// if(checkModuleAccess("1")){
			// var	assignedModules = sessionStorage.assignedModules;	
			// var uggList = sessionStorage.uggNames;	
			// if (uggList.indexOf("Pharmacist")>=0 & uggList.indexOf("Prescriber")>=0 & uggList.indexOf("Dispensing")>=0 & assignedModules.indexOf("ePharmacy")>=0 ){
				// sessionStorage.ePharmacy = "";
			// }
			
			// if (uggList.indexOf("Lab")>=0 & uggList.indexOf("Lab Admin")>=0 & uggList.indexOf("Lab Reports")>=0 & assignedModules.indexOf("Pathology")>=0 ){
				// sessionStorage.Pathology = "";		
			// }
			
			// if (uggList.indexOf("Radiologist")>=0 & uggList.indexOf("OrderComms")>=0 & uggList.indexOf("Imaging")>=0 & assignedModules.indexOf("Imaging")>=0 ){
				// sessionStorage.Imaging = "";		
			// }
			
			// if(assignedModules.indexOf("Electronic Patient Record")>=0 ){
				// sessionStorage.Electronic_Patient_Record = "";	
			// }
			
			// if(assignedModules.indexOf("Ward and Bed management")>=0 ){
				// sessionStorage.Ward_and_Bed_management = "";
			// }
			
			// if (uggList.indexOf("Service Theatre")>=0 /*  & uggList.indexOf("Theatre Surgeon")>=0 */ & uggList.indexOf("Theatre Viewer")>=0 & assignedModules.indexOf("Theatre and Surgery")>=0 ){
				// sessionStorage.Theatre_and_Surgery = "";		
			// }
			
			// if (uggList.indexOf("Communication")>=0 & assignedModules.indexOf("Communication")>=0 ){
				// sessionStorage.Communication = "";		
			// }
			
			// if (uggList.indexOf("Stock")>=0  & uggList.indexOf("StockAdmin")>=0 & assignedModules.indexOf("Supplies and Inventory Management")>=0 ){
				// sessionStorage.Supplies_and_Inventory_Management = "";		
			// }
			
			// if (uggList.indexOf("Finance")>=0 & uggList.indexOf("Finance Admin")>=0 & uggList.indexOf("Cashier")>=0 & uggList.indexOf("Service Finance")>=0 & uggList.indexOf("PointOfSale")>=0 & uggList.indexOf("FinanceCreateInvoice")>=0 & assignedModules.indexOf("Finance billing and insurance")>=0 ){
				// sessionStorage.Finance_billing_and_insurance = "";		
			// }

			// if (uggList.indexOf("Medical Notes")>=0 & uggList.indexOf("Medical Notes Admin")>=0 & assignedModules.indexOf("Document Management")>=0 ){
				// sessionStorage.Document_Management = "";		
			// }
			// if(assignedModules.indexOf("Patient Online Access")>=0 ){
				// sessionStorage.Patient_Online_Access = "";
			// }
			
			// if (uggList.indexOf("Report")>=0 & assignedModules.indexOf("Business intelligence and reporting")>=0 ){
				// sessionStorage.Business_intelligence_and_reporting = "";		
			// }

			// if (uggList.indexOf("Porter")>=0 & uggList.indexOf("PortersTaskCreated")>=0 & uggList.indexOf("PortersTaskDueRep")>=0 & uggList.indexOf("Service Porter")>=0 & assignedModules.indexOf("Porters")>=0 ){
				// sessionStorage.Porters = "";		
			// }

			// if (uggList.indexOf("Maintenance")>=0 & uggList.indexOf("MaintenanceCreated")>=0 & uggList.indexOf("MaintenanceDueRep")>=0 & uggList.indexOf("Service Maintenance")>=0 & assignedModules.indexOf("Maintenance")>=0 ){
				// sessionStorage.Maintenance = "";		
			// }	

			// if (uggList.indexOf("Dietetics")>=0 & uggList.indexOf("Kitchen Staff")>=0 & uggList.indexOf("Dietician")>=0 & uggList.indexOf("Nurse")>=0 & assignedModules.indexOf("Dietetics and Kitchen")>=0 ){
				// sessionStorage.Dietetics_and_Kitchen = "";		
			// }		
		// }else{
			// if(sessionStorage.firstLogin == "" && sessionStorage.firstLogin != "1"){
				// $("#firstLoginModal").modal();
				// sessionStorage.firstLogin = "1";
			// }				
		// }
	// }

	// ==============================
	// if ( sessionStorage == null || sessionStorage.Patient_Administration_and_Scheduling == null) {
		// $("div[name~=Patient_Administration_and_Scheduling]").addClass('disableModule');
		// $("#Patient_Administration_and_Scheduling").addClass('disable');
	// }
	// else if(checkModuleAccess(1)){
		// $("div[name~=Patient_Administration_and_Scheduling]").find("img[src$='tick.png']").css("display", "");
	// }

	// if (sessionStorage == null || sessionStorage.ePharmacy == null) {
		// $("div[title~=ePharmacy]").addClass('disableModule');
		// $("#ePharmacy").addClass('disable');
	// }	else if(checkModuleAccess(2)){
		// $("div[title~=ePharmacy]").find("img[src$='tick.png']").css("display", "");
	// }
	
	
	// if (sessionStorage == null || sessionStorage.Pathology == null) {
		// $("div[title~=Pathology]").addClass('disableModule');
		// $("#Pathology").addClass('disable');
	// }	else if(checkModuleAccess(5)){
		// $("div[title~=Pathology]").find("img[src$='tick.png']").css("display", "");
	// }
	
	// if (sessionStorage == null || sessionStorage.Imaging == null) {
		// $("div[title~=Imaging]").addClass('disableModule');
		// $("#Imaging").addClass('disable');
	// }	else if(checkModuleAccess(4)){
		// $("div[title~=Imaging]").find("img[src$='tick.png']").css("display", "");
	// }
	

	// ==============================
	// if (sessionStorage == null || sessionStorage.Electronic_Patient_Record == null) {
		// $("div[name~=Electronic_Patient_Record]").addClass('disableModule');
		// $("#Electronic_Patient_Record").addClass('disable');
	// }	else if(checkModuleAccess(6)){
		// $("div[name~=Electronic_Patient_Record]").find("img[src$='tick.png']").css("display", "");
	// }
	
	
	// if (sessionStorage == null || sessionStorage.Ward_and_Bed_management == null) {
		// $("div[name~=Ward_and_Bed_management]").addClass('disableModule');
		// $("#Ward_and_Bed_management").addClass('disable');
	// }	else if(checkModuleAccess(7)){
		// $("div[name~=Ward_and_Bed_management]").find("img[src$='tick.png']").css("display", "");
	// }
	
	// if (sessionStorage == null || sessionStorage.Theatre_and_Surgery == null) {
		// $("div[name~=Theatre_and_Surgery]").addClass('disableModule');
		// $("#Theatre_and_Surgery").addClass('disable');
	// }	else if(checkModuleAccess(3)){
		// $("div[name~=Theatre_and_Surgery]").find("img[src$='tick.png']").css("display", "");
	// }
	
	
	// if (sessionStorage == null || sessionStorage.Communication == null) {
		// $("div[title~=Communication]").addClass('disableModule');
		// $("#Communication").addClass('disable');
	// }	else if(checkModuleAccess(8)){
		// $("div[title~=Communication]").find("img[src$='tick.png']").css("display", "");
	// }

	// ==============================
	// if (sessionStorage == null || sessionStorage.Supplies_and_Inventory_Management == null) {
		// $("div[name~=Supplies_and_Inventory_Management]").addClass('disableModule');
		// $("#Supplies_and_Inventory_Management").addClass('disable');
	// }	else if(checkModuleAccess(9)){
		// $("div[name~=Supplies_and_Inventory_Management]").find("img[src$='tick.png']").css("display", "");
	// }
	
	// if (sessionStorage == null || sessionStorage.Finance_billing_and_insurance == null) {
		// $("div[name~=Finance_billing_and_insurance]").addClass('disableModule');
		// $("#Finance_billing_and_insurance").addClass('disable');
	// }	else if(checkModuleAccess(10)){
		// $("div[name~=Finance_billing_and_insurance]").find("img[src$='tick.png']").css("display", "");
	// }
	
	// if (sessionStorage == null || sessionStorage.Document_Management == null) {
		// $("div[name~=Document_Management]").addClass('disableModule');
		// $("#Document_Management").addClass('disable');
	// }	else if(checkModuleAccess(11)){
		// $("div[name~=Document_Management]").find("img[src$='tick.png']").css("display", "");
	// }
	
	// if (sessionStorage == null || sessionStorage.Patient_Online_Access == null) {
		// $("div[name~=Patient_Online_Access]").addClass('disableModule');
		// $("#Patient_Online_Access").addClass('disable');
	// }	else if(checkModuleAccess(13)){
		// $("div[name~=Patient_Online_Access]").find("img[src$='tick.png']").css("display", "");
	// }

	// ==============================
	// if (sessionStorage == null || sessionStorage.Business_intelligence_and_reporting == null) {
		// $("div[name~=Business_intelligence_and_reporting]").addClass('disableModule');
		// $("#Business_intelligence_and_reporting").addClass('disable');
	// }	else if(checkModuleAccess(16)){
		// $("div[name~=Patient_Online_Access]").find("img[src$='tick.png']").css("display", "");
	// }

	// if (sessionStorage == null || sessionStorage.Porters == null) {
		// $("div[title~=Porters]").addClass('disableModule');
		// $("#Porters").addClass('disable');
	// }	else if(checkModuleAccess(14)){
		// $("div[title~=Patient_Online_Access]").find("img[src$='tick.png']").css("display", "");
	// }

	// if (sessionStorage == null || sessionStorage.Maintenance == null) {
		// $("div[title~=Maintenance]").addClass('disableModule');
		// $("#Maintenance").addClass('disable');
	// }	else if(checkModuleAccess(15)){
		// $("div[title~=Patient_Online_Access]").find("img[src$='tick.png']").css("display", "");
	// }

	// if (sessionStorage == null || sessionStorage.Dietetics_and_Kitchen == null) {
		// $("div[name~=Dietetics_and_Kitchen]").addClass('disableModule');
		// $("#Dietetics_and_Kitchen").addClass('disable');
	// }


	
	// if(sessionStorage != null){
		// if (sessionStorage.un != "" && sessionStorage.pw != "" && sessionStorage.un != null && sessionStorage.pw != null) {

			// var urlWithUnAndPwAndisParentAndcode = trainingSiteDomain + 'cellmaWEB/login.do?isparent=true&code=' ;
			
			// $("#loginFun").html("<img src='images/profile_1x.png' alt='user pic' style='width: 36px;height: 30px;padding-right: 6px;'><label><b>" + sessionStorage.un + "</b></label>");

			// $("#Patient_Administration_and_SchedulingLink").click(function(){loginToCellma("#Patient_Administration_and_SchedulingLink", urlWithUnAndPwAndisParentAndcode + 'PAS',sessionStorage.un,sessionStorage.pw);});
			// $("#Patient_Administration_and_SchedulingGoToLink").click(function(){loginToCellma("#Patient_Administration_and_SchedulingGoToLink", urlWithUnAndPwAndisParentAndcode + 'PAS',sessionStorage.un,sessionStorage.pw);});
			
			// $("#ePharmacyLink").click(function(){loginToCellma("#ePharmacyLink", urlWithUnAndPwAndisParentAndcode + 'EPH',sessionStorage.un,sessionStorage.pw);});
			// $("#ePharmacyGoToLink").click(function(){ loginToCellma("#ePharmacyGoToLink",urlWithUnAndPwAndisParentAndcode + 'EPH',sessionStorage.un,sessionStorage.pw);});
			
			// $("#PathologyLink").click(function(){loginToCellma("#PathologyLink", urlWithUnAndPwAndisParentAndcode + 'PTH ',sessionStorage.un,sessionStorage.pw);});
			// $("#PathologyGoToLink").click(function(){ loginToCellma(urlWithUnAndPwAndisParentAndcode + 'PTH',sessionStorage.un,sessionStorage.pw);});
			
			// $("#ImagingLink").click(function(){loginToCellma("#ImagingLink", urlWithUnAndPwAndisParentAndcode + 'IMG ',sessionStorage.un,sessionStorage.pw);});
			// $("#ImagingGoToLink").click(function(){ loginToCellma("#ImagingGoToLink",urlWithUnAndPwAndisParentAndcode + 'IMG',sessionStorage.un,sessionStorage.pw);});

			// ==============================
			// $("#Electronic_Patient_RecordLink").click(function(){loginToCellma("#Electronic_Patient_RecordLink", urlWithUnAndPwAndisParentAndcode + 'EPR ', sessionStorage.un,sessionStorage.pw);});
			// $("#Electronic_Patient_RecordGoToLink").click(function(){ loginToCellma("#Electronic_Patient_RecordGoToLink",urlWithUnAndPwAndisParentAndcode + 'EPR', sessionStorage.un,sessionStorage.pw);});
			
			// $("#Ward_and_Bed_managementLink").click(function(){loginToCellma("#Ward_and_Bed_managementLink", urlWithUnAndPwAndisParentAndcode + 'WBM', sessionStorage.un,sessionStorage.pw);});
			// $("#Ward_and_Bed_managementGoToLink").click(function(){ loginToCellma("#Ward_and_Bed_managementGoToLink",urlWithUnAndPwAndisParentAndcode + 'WBM', sessionStorage.un,sessionStorage.pw);});
			
			// $("#Theatre_and_SurgeryLink").click(function(){loginToCellma("#Theatre_and_SurgeryLink", urlWithUnAndPwAndisParentAndcode + 'THS', sessionStorage.un,sessionStorage.pw);});
			// $("#Theatre_and_SurgeryGoToLink").click(function(){ loginToCellma("#Theatre_and_SurgeryGoToLink",urlWithUnAndPwAndisParentAndcode + 'THS', sessionStorage.un,sessionStorage.pw);});
			
			// $("#CommunicationLink").click(function(){loginToCellma("#CommunicationLink", urlWithUnAndPwAndisParentAndcode + 'COM', sessionStorage.un,sessionStorage.pw);});
			// $("#CommunicationGoToLink").click(function(){ loginToCellma("#CommunicationGoToLink",urlWithUnAndPwAndisParentAndcode + 'COM', sessionStorage.un,sessionStorage.pw);});
			
			// ==============================
			// $("#Supplies_and_Inventory_ManagementLink").click(function(){loginToCellma("#Supplies_and_Inventory_ManagementLink", urlWithUnAndPwAndisParentAndcode + 'SIM', sessionStorage.un,sessionStorage.pw);});
			// $("#Supplies_and_Inventory_ManagementGoToLink").click(function(){ loginToCellma("#Supplies_and_Inventory_ManagementGoToLink",urlWithUnAndPwAndisParentAndcode + 'SIM', sessionStorage.un,sessionStorage.pw);});
			
			// $("#Finance_billing_and_insuranceLink").click(function(){loginToCellma("#Finance_billing_and_insuranceLink", urlWithUnAndPwAndisParentAndcode + 'FBI', sessionStorage.un,sessionStorage.pw);});
			// $("#Finance_billing_and_insuranceGoToLink").click(function(){ loginToCellma("#Finance_billing_and_insuranceGoToLink",urlWithUnAndPwAndisParentAndcode + 'FBI', sessionStorage.un,sessionStorage.pw);});
			
			// $("#Document_ManagementLink").click(function(){loginToCellma("#Document_ManagementLink", urlWithUnAndPwAndisParentAndcode + 'DMA', sessionStorage.un,sessionStorage.pw);});
			// $("#Document_ManagementGoToLink").click(function(){ loginToCellma("#Document_ManagementGoToLink",urlWithUnAndPwAndisParentAndcode + 'DMA', sessionStorage.un,sessionStorage.pw);});
			// $("#Medical_Notes_ManagementLink").click(function(){loginToCellma("#Medical_Notes_ManagementLink", urlWithUnAndPwAndisParentAndcode + 'MNM', sessionStorage.un,sessionStorage.pw);});
			// $("#Medical_Notes_ManagementGoToLink").click(function(){ loginToCellma("#Medical_Notes_ManagementGoToLink",urlWithUnAndPwAndisParentAndcode + 'MNM', sessionStorage.un,sessionStorage.pw);});
			
			// $("#Patient_Online_AccessLink").click(function(){loginToCellma("#Patient_Online_AccessLink", trainingSiteDomain + 'cellmaWEB/PatientWeb.do?isparent=true&code=' + 'POA', sessionStorage.un,sessionStorage.pw);});//PatientWeb
			// $("#Patient_Online_AccessGoToLink").click(function(){ loginToCellma("#Patient_Online_AccessGoToLink",trainingSiteDomain + 'cellmaWEB/PatientWeb.do?isparent=true&code=' + 'POA', sessionStorage.un,sessionStorage.pw);});

			// ==============================
			// $("#Business_intelligence_and_reportingLink").click(function(){loginToCellma("#Business_intelligence_and_reportingLink", urlWithUnAndPwAndisParentAndcode + 'BIR', sessionStorage.un,sessionStorage.pw);});
			// $("#Business_intelligence_and_reportingGoToLink").click(function(){ loginToCellma("#Business_intelligence_and_reportingGoToLink",urlWithUnAndPwAndisParentAndcode + 'BIR', sessionStorage.un,sessionStorage.pw);});
			
			// $("#PortersLink").click(function(){loginToCellma("#PortersLink", urlWithUnAndPwAndisParentAndcode + 'POR', sessionStorage.un,sessionStorage.pw);});
			// $("#PortersGoToLink").click(function(){ loginToCellma("#PortersGoToLink",urlWithUnAndPwAndisParentAndcode + 'POR', sessionStorage.un,sessionStorage.pw);}); 
			
			// $("#MaintenanceLink").click(function(){loginToCellma("#MaintenanceLink", urlWithUnAndPwAndisParentAndcode + 'MAI', sessionStorage.un,sessionStorage.pw);});
			// $("#MaintenanceGoToLink").click(function(){ loginToCellma("#MaintenanceGoToLink",urlWithUnAndPwAndisParentAndcode + 'MAI', sessionStorage.un,sessionStorage.pw);}); 

			// $("#Dietetics_and_KitchenLink").click(function(){loginToCellma("#Dietetics_and_KitchenLink", urlWithUnAndPwAndisParentAndcode + 'DAK', sessionStorage.un,sessionStorage.pw);});
			// $("#Dietetics_and_KitchenGoToLink").click(function(){ loginToCellma("#Dietetics_and_KitchenGoToLink",urlWithUnAndPwAndisParentAndcode + 'DAK', sessionStorage.un,sessionStorage.pw);}); 

			// $("#LogoutFun").html("<button type='Login' class='btn btn-primary btn-sm' onClick='logout()' ><span class='glyphicon glyphicon-log-in'></span>&nbsp;&nbsp;Logout</button>");
		// }
	// }

// });

// function logout() {
	// sessionStorage.clear();
	// window.location = "index.html";
// }

// function clearWarning(){
	// $("#result").html("");
	// $('#loginbutton').prop("disabled", false);	
// }

// function onClickLogin(){
	// $("#username").val("");
	// $("#password").val("");
	// $("#result").html("");
	// $('#loginbutton').prop("disabled", true);	
// }

// function checkTestAccessDMA(){
	// if(checkTestAccess("DMA", 11) & checkTestAccess("MNM", 12)){
		// $("#warning_DMA" ).html('');
	// }else{
		// if(checkModuleAccess(11) & checkModuleAccess(11)){
			// $("#warning_DMA" ).css("color", "#339900");
			// $("#warning_DMA" ).html('You have successfully Completed your Competency Test');
		
		// }else{
			// $("#warning_DMA" ).html('Please complete both the practice of Document Management workflow');		
		// }
		 // $("#test_DMA" ).addClass('disableModule');
	// }
	
// }

// function checkTestAccess(code, wotId){
	// var un = sessionStorage.un;
	// var pw = sessionStorage.pw;
	// var returnValue = false;
		
	// if (un != "" & pw != "" & un != null & pw != null ) {
		// var settings = {
			// async: false,
			// data: 'userData={ "useUsername":"' + un + '", "usePassword":"' + pw + '", "useWorkflowCode":"' + code + '"}',
			// crossDomain: true,
			// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortalTestAccess.do?',
			// method: "POST",
		// }
		// $.ajax(settings).done(function (data) {
			// if (data != null & data <= "0") {
				// if(checkModuleAccess(wotId)){
					// $("#warning_" + code).css("color", "#339900");
					// $("#warning_" + code).html('You have successfully Completed your Competency Test');
					
				// }else{
					// $("#warning_" + code).html('');
					// $("#test_" + code).removeClass('disableModule');
					// returnValue =  true;
				// }
			// }else{
				// $("#warning_" + code).html('Please Complete your Practice session '+ data+' more time');

				// returnValue = false;
			// }
		// });		
	// }
	// return returnValue;
// }

// function checkModuleAccess(wotId){
	// var returnValue = false;
	// if(wotId != null && wotId != "" && sessionStorage.un != null && sessionStorage.un != ""){
		// var un = sessionStorage.un;
			// un = un.replace("training",'').replace("Training",'');
		// var pw = sessionStorage.pw;
		// var estId = trainingSiteEstId;
		// if(sessionStorage.estId != ""){
			// estId = sessionStorage.estId;
		// }
	
		// if (un != "" & pw != "" & un != null & pw != null ) {
			// var settings = {
				// async: false,
				// data: 'mode=test&wotId='+wotId+'&userData={ "useUsername":"' + un + '", "usePassword":"' + pw + '","useEstId":"'+estId+'"}',
				// crossDomain: true,
				// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortalTestAccess.do?',
				// method: "POST",
			// }
			// $.ajax(settings).done(function (data) {
				// if (data != null & data >= "8") {
					// returnValue =  true;
				// }
			// });		
		// }
	// }
	// return returnValue;
// }


// function sendEmail(username,domain){
	// var settings = {
		// async: true,
		// data: 'type=userMessage&useUserName='+username+'&domain='+domain,
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do?',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (data) {
		// alert('Please Check your Email for Live site details.')
	// });
// }

// function createLiveUser(status, rolesList, wotId, testScore){
	
	// var username = sessionStorage.un;
	// username = username.replace("training",'').replace("Training",'');
	
	// var estId = liveSiteEstId;	
	// var cliId = liveSiteCliId;		
	// var userGroupNamesList = '';
	// var userGroupNamesList = rolesList.split(',').join("\",\"");
	
	
	
	// var settings = {
		// async: true,
		// data: 'mode=training&wotId='+wotId+'&testScore='+testScore+'&status='+status+'&userData={"useFirstname":"'+sessionStorage.firstname+'","useSurname":"'+sessionStorage.surname+'","useUsername":"'+username+'","usePassword":"'+sessionStorage.pw+'","confirmPassword":"'+sessionStorage.pw+'","useEmail":"'+sessionStorage.email+'","useEstId":"'+sessionStorage.estId+'","useCliId":"'+sessionStorage.cliId+'","useMobile":"'+sessionStorage.mobile+'","useReferenceId":"'+sessionStorage.useReferenceId+'","uggNames":["'+userGroupNamesList+'"]}',
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/TrainingProtalUserRegistration.do?',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (responseCode) {
		// if(responseCode != null && responseCode == 'RC100'){
			// var settings = {
				// async: true,
				// data: 'mode=live&wotId='+wotId+'&testScore='+testScore+'&status='+status+'&userData={"useFirstname":"'+sessionStorage.firstname+'","useSurname":"'+sessionStorage.surname+'","useUsername":"'+username+'","usePassword":"'+sessionStorage.pw+'","confirmPassword":"'+sessionStorage.pw+'","useEmail":"'+sessionStorage.email+'","useEstId":"'+liveSiteEstId+'","useCliId":"'+liveSiteCliId+'","useMobile":"'+sessionStorage.mobile+'","uggNames":["'+userGroupNamesList+'"]}',
				// crossDomain: true,
				// url: liveSiteDomain + 'cellmaWEB/TrainingProtalUserRegistration.do?',
				// method: "POST"
			// }
			// $.ajax(settings).done(function (responseCode) {
				// if(responseCode != null && responseCode == 'RC100'){
					// sendEmail(username,liveSiteDomain);
				// }
				// else{
					// alert("Error Code : "+responseCode);
				// }
			// });	
		// }
		// else{
			// alert("Something went wrong : Unable to Save Score on Training Server");
		// }
	// });	
	
	
// }

// function duplicateCheckUsername(userName){
	// var booleanUserExist = false;
	// var settings = {
		// async: false,
		// data: 'type=validateUser&useUserName=' + userName,
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (responseCode) {
		// if (responseCode == 0) {
			// booleanUserExist = true;
		// }else{
			// var settings = {
				// async: false,
				// data: 'type=validateUser&useUserName=' + userName,
				// crossDomain: true,
				// url: liveSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do',
				// method: "POST"
			// }
			// $.ajax(settings).done(function (responseCode) {
				// if (responseCode == 0) {
					// booleanUserExist = true;
				// }
			// });
		// }
	// });
	// return booleanUserExist;
// }

// function isEmailRejected(email){
	// var booleanEmailApproved = false;
	
	
	// var settings = {
		// async: false,
		// data: 'type=validateEmail&useEmail=' + email+ '&useEstId='+ trainingSiteEstId,
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (responseCode) {
		// if (responseCode == 0) {
			// booleanEmailApproved = true;
		// }
	// });
	// return booleanEmailApproved;
// }

// function autoLoginFromCellma(url) {
	// var unpw = url.substring(url.indexOf("&")+1);
	// var useUsername = "";
	// var usePassword = "";
	// var plainText = atob(unpw);
	// var params = plainText.split("&");
	// for(var i = 0; i < params.length; i++) {
		// var paramNameValue = params[i].split("=");
		// if(paramNameValue[0] == "un"){
			// useUsername = paramNameValue[1];
		// }
		// if(paramNameValue[0] == "pw") {
			// usePassword = paramNameValue[1];
		// }		
	// }
	// autologin from cellma
	// if(useUsername != "" && usePassword != ""){
		// loginWithUsernameAndPassword(useUsername, usePassword);
	// }else{
		// alert("Invalid Username and password");
	// }	
// }

// function getFeedback(form2,data) {
	// var userInput = [];
	// var emailSent = false;
	// userInput[0] = form2.question0.value; 
	// userInput[1] = form2.question1.value;  
	// userInput[2] = form2.question2.value;
	// userInput[3] = form2.question3.value;
	// userInput[4] = form2.question4.value;
	// userInput[5] = form2.question5.value;
	// userInput[6] = form2.question6.value;
	// userInput[7] = data;

	// var settings = {
		// async: false,
		// data: 'type=feedbackForm&useUserName=' + sessionStorage.un+'&feedback='+JSON.stringify(userInput)+'&feedbackEmail='+feedbackEmail,
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (responseCode) {
		// if (responseCode == 0) {
			// emailSent = true;
		// }
	// });
	// return emailSent;
// } 

// function getContactForm(form2) {
	// var userInput = [];
	// var emailSent = false;
	// userInput[0] = form2.UserName.value; 
	// userInput[1] = form2.Subject.value;  
	// userInput[2] = form2.email.value;
	// userInput[3] = form2.message.value;

	// var settings = {
		// async: false,
		// data: 'type=contactForm&contact='+JSON.stringify(userInput)+'&contactEmail='+enquiryEmail+'&estId='+trainingSiteEstId,
		// crossDomain: true,
		// url: trainingSiteDomain + 'cellmaWEB/AjaxTrainingPortal.do',
		// method: "POST"
	// }
	// $.ajax(settings).done(function (responseCode) {
		// if (responseCode == 0) {
			// emailSent = true;
		// }
	// });
	// return emailSent;
// }

// function forgetPassword(){
// window.open(trainingSiteDomain + "cellmaWEB/DisplayPasswordRecovery.do?isFromTrainingPortal=true");
// }



