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
									value="%{#session.UserName}" /> --%>admin </a>
						</li>
						<li>
							<a href="#">Sign Out</a>
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
				<a href="#">Home</a>
			</li>
		
			<li>
				<a href="register">Register</a>
			</li>

			<li>
				<a href="newRegister">New Register</a>
			</li>


			<li>
				<a href="bootsnipp">bootsnipp</a>
			</li>
			<li>
				<a href="jmessa">Jmessa</a>
			</li>

			<li>
				<a href="customer.action">Customer</a>
			</li>
			
			<li>
				<a href="adminHome#">Report</a>
				<ul>
                                        <li><a href="adminReportByDate">BusSchedule by Date</a>
                                        </li>
                                        <li><a href="reportByMonth">BusSchedule by Month</a>
                                        </li>
                                        <li><a href="adminReportByRoute">Route wise Report</a>
                                        </li>
                                        <li><a href="adminHome#">Customer Booked Ticket by Month</a>
                                        </li>
                                        <li><a href="adminHome#">Customer Booked TicketBetween Two date</a>
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
			<A href="busmanagement" class="ImgtxtUp">Bus Management</A>
			
		</LI>
		<LI>
			<A href="routemanagemnt" class="ImgtxtUp">Route Management</A>
			
		</LI>
		<LI>
			<A href="citymanagemnt" class="ImgtxtUp">City Management</A>
			
		</LI>
		
		<LI>
			<A href="manageemp" class="ImgtxtUp">Manage Employee</A>
			
		</LI>
		<LI>
			<A href="designation" class="ImgtxtUp">Designation</A>
			
		</LI>
		<LI>
			<A href="#" class="ImgtxtUp">Report</A>
			<UL>
				<li>
					<s:a href="adminReportByDate.action">BusSchedule by Date</s:a>
					<s:a href="reportByMonth.action">BusSchedule  by Month</s:a>
					<s:a href="adminReportByRoute.action"> Route wise Report</s:a>
					<s:a href="adminReportByRoute.action">Customer Booked Ticket by Month</s:a>
			<s:a href="adminReportByRoute.action">Customer Booked TicketBetween Two date</s:a>
				</li>
			</UL>
			
		</LI>
	</UL>
	<UL class=nav id=nav ">

		<li ><s:a href="#">Welcome	</s:a>
		
		</li>
	
		<li>
			<s:a href="logout">LogOut</s:a>
		</li>
	</UL>
</div>
--%>
