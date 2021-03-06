<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List User's Information</title>

		<!-- BEGIN META -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="your,keywords">
		<meta name="description" content="Short explanation about this website">
		<!-- END META -->

		<!-- BEGIN STYLESHEETS -->
		<link href='http://fonts.googleapis.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/bootstrap.css?1422792965" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/materialadmin.css?1425466319" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/font-awesome.min.css?1422529194" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/material-design-iconic-font.min.css?1421434286" />
        
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/DataTables/jquery.dataTables.css?1423553989" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/DataTables/extensions/dataTables.colVis.css?1423553990" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/DataTables/extensions/dataTables.tableTools.css?1423553990" />
		<!-- END STYLESHEETS -->
		
		<link rel="stylesheet" type="text/css" href="../../../dist/sweetalert.css">
        <script src="../../../dist/sweetalert.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../../assets/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../../assets/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
		<style>
			body{
				font-family: 'Khmer OS Siemreap';
			}
		</style>
	</head>
	<body class="menubar-hoverable header-fixed menubar-first full-content ">

		<!-- BEGIN HEADER-->
		<jsp:include page="../../include/header.jsp"></jsp:include>
		<!-- END HEADER-->
		

		<!-- BEGIN BASE-->
		<div id="base">

			<!-- BEGIN OFFCANVAS LEFT -->
			
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">
				<section class="style-default-bright">
					<div class="section-header">
						<div class="col-lg-12" style="padding-left:0px">
							<a href="adduser.jsp"><button type="button" class="btn ink-reaction btn-raised btn-primary">New User</button></a>
						</div>
					</div>
					<div class="section-header">	
						<h2 class="text-primary">List User</h2>
					</div>
					<div class="section-body">

						<!-- BEGIN DATATABLE 1 -->
						
						<div class="row">
							<div class="col-lg-12">
								
								<div class="table-responsive">
									<table id="datatable1" class="table table-striped table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Username</th>
												<th>Email</th>
												<th>Type</th>
												<th>Password</th>
												<th>Gender</th>
											</tr>
										</thead>
										
									</table>
								</div><!--end .table-responsive -->
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END DATATABLE 1 -->

						<hr class="ruler-xxl"/>

					</div><!--end .section-body -->
				</section>
			</div><!--end #content-->
			<!-- END CONTENT -->

			<!-- BEGIN MENUBAR-->
			<jsp:include page="../../include/menubar.jsp"></jsp:include>
			<!-- END MENUBAR -->

		</div><!--end #base-->
		<!-- END BASE -->

		<!-- BEGIN JAVASCRIPT -->
		<script src="../../assets/js/libs/jquery/jquery-1.11.2.min.js"></script>
		<script src="../../assets/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
		<script src="../../assets/js/libs/bootstrap/bootstrap.js"></script>
		<script src="../../assets/js/libs/spin.js/spin.min.js"></script>
		<script src="../../assets/js/libs/autosize/jquery.autosize.min.js"></script>
		<script src="../../assets/js/libs/DataTables/jquery.dataTables.min.js"></script>
		<script src="../../assets/js/libs/DataTables/extensions/ColVis/js/dataTables.colVis.js"></script>
		<script src="../../assets/js/libs/DataTables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
		<script src="../../assets/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		<script src="../../assets/js/core/source/App.js"></script>
		<script src="../../assets/js/core/source/AppNavigation.js"></script>
		<script src="../../assets/js/core/source/AppOffcanvas.js"></script>
		<script src="../../assets/js/core/source/AppCard.js"></script>
		<script src="../../assets/js/core/source/AppForm.js"></script>
		<script src="../../assets/js/core/source/AppNavSearch.js"></script>
		<script src="../../assets/js/core/source/AppVendor.js"></script>
		<script src="../../assets/js/core/demo/Demo.js"></script><!-- 
		<script src="../../assets/js/core/demo/DemoTableDynamic.js"></script> -->
		<!-- END JAVASCRIPT -->
		<script>
			$(document).ready(function(){
				$('#usermenu').addClass('active');
				
				$('#datatable1').DataTable({
					"ajax": "getjsonuser",
			        "columns": [
			            { "data": "user_id" },
			            { "data": "user_name" },
			            { "data": "user_email" },
			            { "data": "user_type_name" },
			            { "data": "user_pass" },
			            { "data": "user_gender" }
			        ],
			        "order": [ 0, 'desc' ],
			        "fnCreatedRow": function( nRow, data, iDataIndex ) {
				           $('td:eq(5)', nRow).append(
				        		"<a href='updateuser?id="+data.user_id+"' class='btn btn-icon-toggle' data-toggle='tooltip' data-placement='op' data-original-title='Edit Row'><i class='fa fa-pencil'></i></a>"+
				        		"<button onclick=deleteuser('"+data.user_id+"') class='btn btn-icon-toggle' data-toggle='tooltip' data-placement='op' data-original-title='Delete Row'><i class='fa fa-trash-o'></i></button>"
				           );
				       }
				});
				
			});
			
			function deleteuser(user_id){
				swal({   title: "Are you sure?",   
						 text: "You will not be able to recover this user!",   
						 type: "warning",   showCancelButton: true,   
						 confirmButtonColor: "#DD6B55",   
						 confirmButtonText: "Yes, delete it!",   
						 closeOnConfirm: false 
				    }, function(){   
				    	$.get("actiondeleteuser",{
							id : user_id
						},function(data){
					    	swal("Deleted!", "User has been deleted..!.", "success"); 
							location.href="listuser";
						});
				    });
			}
			
		</script>
		<jsp:include page="../../include/setting.jsp"></jsp:include>
	</body>
</html>

