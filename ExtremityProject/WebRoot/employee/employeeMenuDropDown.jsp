<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<header id="main-header">

<div class="header-top">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a class="logo" href="index.html"> <img
						src="img/logo-invert.png" alt="Image Alternative text"
						title="Image Title" /> </a>
			</div>
			<div class="col-md-3 col-md-offset-2">
				<form class="main-header-search">
					<div class="form-group form-group-icon-left">
						<i class="fa fa-search input-icon"></i>
						<input type="text" class="form-control">
					</div>
				</form>
			</div>
			<div class="col-md-4">
				<div class="top-user-area clearfix">
					<ul class="top-user-area-list list list-horizontal list-border">
						<li class="top-user-area-avatar">
							<a href="#"> Welcome, <%--<s:property
									value="%{#session.UserName}" /> --%> Employee</a>
						</li>
						<li>
							<a href="logout">Sign Out</a>
						</li>


					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="nav">
		<ul class="slimmenu" id="slimmenu">
		
			<li>
				<a href="busoperatorhome">Home</a>
			</li>
		
		
			<li>
				<a href="viewSchedule">View Schedule</a>
			</li>

			<li>
				<a href="addSchedule">Add Schedule</a>
			</li>


			<li>
				<a href="myprofile">My Profile</a>
			</li>
			<li>
				<a href="busoperatorhome#">Inbox</a>
			</li>

			
			<li>
				<a href="busoperatorhome#">Report</a>
				<ul>
                                        <li><a href="reportDatewiseForOperator">BusSchedule By Date</a>
                                        </li>
                                        <li><a href="reportDatewiseForOperator">BusSchedule By Month</a>
                                        </li>
                                       
                                     
                                       
                 </ul>
			</li>
			
			<li>
				<a href="busoperatorhome#">Account Setting</a>
				<ul>
                                        <li><a href="myprofileUpd">Update Profile</a>
                                        </li>
                                        <li><a href="myprofile">Personal Information</a>
                                        </li>
                                        <li><a href="changepassbusoperator">change Password</a>
                                        </li>
                                       
                                     
                                       
                 </ul>
			</li>



		</ul>


	</div>

</div>

</header>







<%--<div id=container>
	<UL class=nav id=nav>

		<LI>
			<A href="viewSchedule" class="ImgtxtUp">View Schedule</A>
			
		</LI>
		<LI>
			<A href="addSchedule" class="ImgtxtUp">Add Schedule</A>			
		</LI>
		<LI>
			<A href="myprofile" class="ImgtxtUp">My Profile</A>
			
		</LI>
		<LI>
			<A href="inbox" class="ImgtxtUp">Inbox</A>
			
		</LI>
		<LI>
			 Pradip	 <A href="report" class="ImgtxtUp">Report</A>
			
			<A class="ImgtxtUp">Report</A>
			<UL>
				<li>
					<s:a href="reportDatewiseForOperator">BusSchedule By Date </s:a>
				</li>
				
				<li>
					<s:a href="reportDatewiseForOperator">BusSchedule By Month</s:a>
				</li>
			</UL>
		</LI>
	</UL>
	<UL class=nav id=nav style="float: right;">

		<li><s:a href="#">Welcome<s:property value="%{#session.UserName}" /></s:a>
		
		</li>
	
		<li>
			<s:a href="logout">LogOut</s:a>
		</li>
	</UL>
</div>
--%>