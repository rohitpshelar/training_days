	







12



	
TRAINING PORTAL COMPETENCY TEST WORKFLOW AND CONFIGURATION







      




DOCUMENT CONTROL			
DOCUMENT LOCATION	

The source of the document will be found in Drive 
Subsequent versions of this document will be found in the same folder.
REVISION HISTORY


Revision dateVersionSummary of ChangesAuthor15/07/2020-Customer ReadyRohit ShelarAPPROVALS
Version 1.0 and above of document requires the following approvals:
NameSignatureTitleDate of IssueVersionApproval records are held electronically by the PMO.
DISTRIBUTION
This version of this document has been distributed to:
NameTitle / Job ResponsibilityIssue Date

	


TABLE OF CONTENTS
chapter 1: Introduction	3
1.1 Create user Group as same name mentioned below and add their roles.	3
1.2 AiM of creating Competency test backend	5
chapter 2: Training Portal Web service Message	6
2.1	Medium of communication	6
2.1.1	JSON	6
2.2 Training Portal Web service message format	6
chapter 3: Configuration Page	7
3.1	Module	7
3.1.1	Add module	7
3.1.2	Updated Module	8
3.2	Question	9
3.2.1	Add Question	9
3.2.2	Updated Question	10
3.3	Question Option	11
3.3.1	Add Option	11
3.3.2	Update Option	12
chapter 4: UI effect to understand Configuration made	13
4.1	Question are displayed in below format:	13
4.2	Option are displayed in below format:	13
chapter 5: Contact us	14
we are here to HELP:	14


NOTE: DOUBLE CLICK ON LINK(APPENDIX.docx) WILL GET YOU IN THE LINKED DOCUMENT.

CHAPTER 1: INTRODUCTION

1.1 CREATE USER GROUP AS SAME NAME MENTIONED BELOW AND ADD THEIR ROLES.
NOTE: “default” and “standard” roles are required for each module
1. Patient Administration and Scheduling (Patient)  
2. Electronic Patient Record
3. Ward and Bed management

4. ePharmacy
a. Pharmacist
b. Prescriber
c. Dispensing

5. Theatres and Surgery
a. Service Theatre
b. Theatre Viewer

6. Communication
a. Communication

7. Pathology
a. Lab
b. Lab Admin
c. Lab Reports

8. Imaging
a. Radiologist
b. Imaging
c. OrderComms

9. Finance billing and insurance 
a. Finance
b. Finance Admin
c. Cashier
d. Service Finance
e. PointOfSale



10. Document Management
a. Medical Notes
b. Medical Notes Admin

11. Supplies and Inventory Management (Stock)
a. Stock
b. StockAdmin

12. Patient Online Access
13. Business intelligence and reporting
a. Report

14. Porters
a. Porter
b. PortersTaskCreated
c. PortersTaskDueRep
d. Service Porter

15. Maintenance
a. Maintenance
b. MaintenanceCreated
c. MaintenanceDueRep
d. ServiceMaintenance

16. Dietetics and Kitchen
a. Dietetics
b. Kitchen Staff
c. Dietician
d. Nurse

17. AME
a. AME
b. ID Verification
c. Assessment Approver
d. LetterApproveSend
e. Communication
f. ID Verification

18. External Cardiology
a. LetterApproveSend
b. MedCert ViewPrint

19. Ophthalmologist/Optometrist
a. AME
b. Assessment Approver
c. Communication
d. ID Verification
e. LetterApproveSend
f. MedCert ViewPrint



20. Support Staff
a. MedCert ViewPrint
b. ID Verification


* Find x-config.js file in training portal folder and update following details 
E.g.:
// ## Config to connect CAA Internal server ##
var portalBackendUrl = "http://www.cellmatesting3.com/CellmaTrainingPortal"

var trainingSiteDomain	=	'http://www.cellmatesting3.com/';
var trainingSiteEstId	=	'3';
var trainingSiteCliId	=	'4';
var liveSiteDomain	=	'http://www.caacellma.com/';
var liveSiteEstId		=	'3';
var liveSiteCliId		=	'1';
var enquiryEmail 	=	'enquiry@riomed.com,cellmatraining.support@riomed.com';
var feedbackEmail	=	'enquiry@riomed.com,cellmatraining.support@riomed.com';


* Cellma Configuration Checklist
o Check Portal server is able to connect trainingSiteDomain and liveSiteDomain mentioned in x-config.js file as mentioned above
o Check if Cellma server (Where user will be trained ) has “cellma_training_portal_url” parameter added in cellma preferences and check if is able to ping that portal if portal is on other server

o Check if “Make Establishment visible in Training Portal” setting is enabled  in edit Establishment setting.


o Check if while making an appointment default HP is available
o All the services have necessary configuration made to complete practice

1.2 AIM OF CREATING COMPETENCY TEST BACKEND


o Client has requested a change to the Questionnaire - they would like to have a larger question bank. Originally RioMed proposed 10 questions, and the client is now proposing a database of a minimum of 30 questions, from which 10 questions can be pulled.
o Questions need to be 'randomized' so no 2 AMEs receive the same combination and order of questions in a test and also to ensure that an AME who requires more than one attempt to pass the test is not presented with the same 10 questions for each attempt.
o The videos on the training portal need to be annotated and have a voice over.
o Questions need to be displayed one at a time rather than all together on the same page.
o Ideally, they want it so an AME can only see their set of data rather than all data. They want to avoid AMEs interfering with another AME's data or workflow. As it currently stands, an AME can see and edit all applicant’s data.
o They would like to ensure that when RioMed sets up test data for the AMEs that there are a variation of patients and have varied illnesses and case history/fit status & class/limitations/test results/medical conditions etc. so that not every test is a 'happy path'. Each user should have one healthy test patient in order to get used to the system, and the others with some complexities.





CHAPTER 2: TRAINING PORTAL WEB SERVICE MESSAGE
2.1 MEDIUM OF COMMUNICATION

        Training portal front end communicate with backend via JSON format to exchange the information.


2.1.1 JSON

o JSON (JavaScript Object Notation) is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate. It is based on a subset of the JavaScript Programming Language
o Data is represented in name/value pairs.
o Curly braces hold objects and each name is followed by ':'(colon), the name/value pairs are separated by ‘,’ (comma).
o Square brackets hold arrays and values are separated by ‘,’(comma).



* Example:
{
    "username": "Rohit.Shelar",
    "email": "rohit.shelar@riomed.com",
    "password": "password"
}
 2.2 TRAINING PORTAL WEB SERVICE MESSAGE FORMAT

When a Front end and backend communicate, they exchange JSON messages. 
1. A request message is sent from the Front end to Backend via web service 
2. The Backend responds with a response message. 
This is just like in ordinary HTTP, where a web browser sends an HTTP request to a web server, and the web server replies with an HTTP response.





CHAPTER 3: CONFIGURATION PAGE

 This will represent detailed Information of Training portal configuration page.
Configuration page has 3 Category, where user have 2 option Add or Update.
3 
3.1 MODULE

3.1.1 ADD MODULE
Click on Add New Module button.

Below popup will be opened where you can register new module. 



3.1.2 UPDATED MODULE
Click on Module Dropdown to View module list



ONCE MODULE IS SELECTED, MODULES DETAILS ARE DISPLAYED WHERE USER can edit this below field.

3.1.3 

3.2 QUESTION
3.2.1 ADD QUESTION
Click on Add New Question button to add new Question.

Below popup will be opened where you can register new module. 




3.2.2 UPDATED QUESTION
Click on any Question to open the edit question modal popup.
Modal popup of edit question is displayed as below



3.3 QUESTION OPTION
3.3.1 ADD OPTION
To add an option first you need to select the question as mentioned above, once user clicks on Question below popup is where user can add Question-Option and also update question.

      Once user click on Add new Option, modal popup will be displayed as below
       


      
3.3.2 UPDATE OPTION

To update an option first you need to select the question as mentioned above, then user need to select the option by clicking on it, as shown below.

once user clicks on Option below popup is where user can update Question-Option.


      


CHAPTER 4: UI EFFECT TO UNDERSTAND CONFIGURATION MADE

4 
4.1 QUESTION ARE DISPLAYED IN BELOW FORMAT:

Example:

4.2 OPTION ARE DISPLAYED IN BELOW FORMAT:


Example:




CHAPTER 5: CONTACT US

WE ARE HERE TO HELP:

Do not hesitate to contact us if you have any queries, we are always here and eager to help in whatever way we can.


UK OFFICE


TRINIDAD OFFICE
INDIA OFFICE
RIOMED LIMITED
18 EASTLINKS
Tollgate Business Park
SO53 3TG
Eastleigh UK
Tel: +02380 277-040
RIOMED LIMITED
26 Kitchener Street
Woodbrook
Port of Spain
Trinidad & Tobago
Tel: +1 (868) 222-9410RIOMED LIMITED
409, 4th Floor
Tower 1, World Trade Centre,
Zone Kharadi, Pune – 411014.
Maharashtra, India
Tel: 020-2066329520






                                                                                                                         


Page | 14                                                     Training Portal Competency Test Workflow and Configuration	                                                               



                                                                                                                         


Page | 59                                                                                                                Cellma Training Portal Competency Test Workflow and Configuration	


