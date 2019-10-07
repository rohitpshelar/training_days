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
									value="%{#session.UserName}" /> --%> Customer</a>
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
				<a href="customerHome">Home</a>
			</li>
		
			<li>
				<a href="showBusesLogin">Book Ticket</a>
			</li>
			
			<li>
				<a href="customerHome#">Print Ticket</a>
			</li>

			<li>
				<a href="customerHome#">Cancel Ticket</a>
			</li>
			
			<li>
				<a href="customerInbox">Inbox</a>
			</li>


			<li>
				<a href="profile">Profile</a>
			</li>
			

			
			<li>
				<a href="customerHome#">Account Setting</a>
				<ul>
                                        <li><a href="updateCustomerProfile">Update Profile</a>
                                        </li>
                                        <li><a href="profile">Personal Information</a>
                                        </li>
                                        <li><a href="changepassCustomer">change Password</a>
                                        </li>
                                       
                                     
                                       
                 </ul>
			</li>

		</ul>


	</div>

</div>

</header>





<%--<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="javascript">
javascript: window.history.forward(1);
</script>

<style>
#nav {
BORDER-RIGHT: #6B2807 1px solid;
PADDING-RIGHT: 198.5px;
BORDER-TOP: #6b2809 1px solid;
PADDING-LEFT: 42px;
FONT-WEIGHT: normal;
font-size: 1.4em;
BACKGROUND: #6b2809;
FLOAT: left;
PADDING-BOTTOM: 36px;
MARGIN: 66px -2px 47px;
BORDER-LEFT: #6b2809 1px solid;
LINE-HEIGHT: 1;
PADDING-TOP: 33px;
BORDER-BOTTOM: #6b2809 1px solid;
LIST-STYLE-TYPE: none;
}
</style>

<div id=container>
	<UL class=nav id=nav>

		<LI>
			<A class="ImgtxtUp">Ticket Management</A>
			<UL>
				<li>
					<s:a href="showBusesLogin.action">Book Ticket</s:a>
					<s:a href="printticket">Print Ticket</s:a>
					<s:a href="cancelticket">Cancel Ticket</s:a>
				</li>
			</UL>
		</LI>
		<LI>
			<A href="customerInbox" class="ImgtxtUp">Inbox</A>
			
		</LI>
		<LI>
			<A href="profile" class="ImgtxtUp">Profile</A>
			
		</LI>
		<LI>
			<A href="reportForCustomer" class="ImgtxtUp">Report</A>
			
		</LI>
	</UL>
	<UL class=nav id=nav style="float: right;">

		<li><s:a href="#">Welcome	<s:property value="%{#session.UserName}" /></s:a>
		
		</li>
	
		<li>
			<s:a href="logout">LogOut</s:a>
		</li>
	</UL>
</div>
--%>