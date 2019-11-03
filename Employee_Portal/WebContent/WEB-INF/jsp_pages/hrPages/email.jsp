<%@include file="../header/hrHeader.jsp" %>
			<noscript>
				<div class="alert alert-block col-md-12">
					<h4 class="alert-heading">Warning!</h4>

					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">Tables</a></li>
					</ul>
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i>Todays leave Requests
									
								</h2>

								<!-- <div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div> -->
							</div>
							<div class="box-content">
								
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th>Username</th>
										<!-- 	<th>Date registered</th> -->
											<th>Role</th>
											<th>Leave requests</th>
											<th>Actions</th>
										</tr>
										<tr>
											<th>Username</th>
										<!-- 	<th>Date registered</th> -->
											<th>Role</th>
											<th>Leave requests</th>
											<th><a class="btn btn-info" href="#"> <i
													class="glyphicon glyphicon-edit icon-white"></i> Send mail
											</a></th>
										
										</tr>
									</thead>
									<tbody>
										
										
										
										<!-- write contents here for leave requests  -->

									</tbody>
								</table>
								<ul class="pagination pagination-centered">
									<li><a href="#">Prev</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">Next</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!--/span-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i>Todays Attendents
									status
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th>Username</th>
											<th>Date registered</th>
											<th>Role</th>
											<th>Todays status</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>David R</td>
											<td class="center">2012/01/01</td>
											<td class="center">Member</td>
											<td class="center"><span
												class="label-success label label-default">Absent</span></td>
											<td class="center"><a class="btn btn-success" href="#">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>
													approve
											</a> <a class="btn btn-info" href="#"> <i
													class="glyphicon glyphicon-edit icon-white"></i> Edit
											</a> <a class="btn btn-danger" href="#"> <i
													class="glyphicon glyphicon-trash icon-white"></i> Delete
											</a></td>
										</tr>

									</tbody>
								</table>
								<ul class="pagination pagination-centered">
									<li><a href="#">Prev</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">Next</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!--/span-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->

			<!-- Ad, you can remove it -->
			<div class="row">
				<div class="col-md-9 col-lg-9 col-xs-9  hidden-xs">
					<script async
						src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- Charisma Demo 2 -->
					<ins class="adsbygoogle"
						style="display: inline-block; width: 728px; height: 90px"
						data-ad-client="ca-pub-5108790028230107" data-ad-slot="3193373905"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
				</div>
			
			</div>
			<!-- Ad ends -->

			<hr>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h3>Settings</h3>
						</div>
						<div class="modal-body">
							<p>Here settings can be configured...</p>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
							<a href="#" class="btn btn-primary" data-dismiss="modal">Save
								changes</a>
						</div>
					</div>
				</div>
			</div>

<div style="clear: both"></div>
<%@ include file="../footer/footer.jsp"%>