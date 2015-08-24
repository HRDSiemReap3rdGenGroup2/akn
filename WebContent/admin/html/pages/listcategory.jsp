<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List Category</title>

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
		
		
		<link rel="stylesheet" type="text/css" href="../../../dist/sweetalert.css">
        <script src="../../../dist/sweetalert.min.js"></script>
        
		<!-- END STYLESHEETS -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../../assets/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../../assets/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
		<style>
			body{
				font-family: 'Khmer OS Siemreap';
			}
			button.ColVis_Button {
				display: none;
			}
			thead{
				background-color:#0AA89E;
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
			<div class="offcanvas">
			
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">

				<!-- BEGIN BLANK SECTION -->
				<section class="style-default-bright">
					<div class="section-header">
						<div class="col-lg-12" style="padding-left:0px">
							<a href="formcategory"><button type="button" class="btn ink-reaction btn-raised btn-primary">Add Category</button></a>
						</div>
					</div>
					
					<div class="section-body">
						
						<!-- BEGIN DATATABLE 1 -->
						
						<div class="row">
							<div class="col-lg-12">
								
								<div class="table-responsive">
									<table id="datatable1" class="table table-striped table-hover">
										<thead>
											<tr>
												<th>Category ID</th>
												<th>Category Name</th>
												<th>Category Description</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:set value="${requestScope.allCategory }" var="sources"></c:set>
											<c:forEach items="${sources }" var="item">
												<tr class="gradeX">
													<td>${item.category_id }</td>
													<td>${item.category_name }</td>
													<td>${item.category_description }</td>
													<td class="text-right">
														<a href="updatecategory?id=${item.category_id }" class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Edit row"><i class="fa fa-pencil"></i></a>
														<button onclick="deletecategory('${item.category_id }')" class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Delete row"><i class="fa fa-trash-o"></i></button>
														<%-- <a href="actiondeletecategory?id=${item.category_id }" class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Delete row"><i class="fa fa-trash-o"></i></a> --%>
													</td>
												</tr>
											</c:forEach>
											
										</tbody>
									</table>
								</div><!--end .table-responsive -->
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END DATATABLE 1 -->
					</div><!--end .section-body -->
				</section>
				<!-- BEGIN BLANK SECTION -->
			
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
		<script src="../../assets/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		<script src="../../assets/js/core/source/App.js"></script>
		<script src="../../assets/js/core/source/AppNavigation.js"></script>
		<script src="../../assets/js/core/source/AppOffcanvas.js"></script>
		<script src="../../assets/js/core/source/AppCard.js"></script>
		<script src="../../assets/js/core/source/AppForm.js"></script>
		<script src="../../assets/js/core/source/AppNavSearch.js"></script>
		<script src="../../assets/js/core/source/AppVendor.js"></script>
		<script src="../../assets/js/core/demo/Demo.js"></script>
		<script src="../../assets/js/core/demo/DemoTableDynamic.js"></script>
		
		<script src="../../assets/js/libs/DataTables/jquery.dataTables.min.js"></script>
		<script src="../../assets/js/libs/DataTables/extensions/ColVis/js/dataTables.colVis.js"></script>
		<script src="../../assets/js/libs/DataTables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
		
		<!-- END JAVASCRIPT -->
		
		<script>
			$(document).ready(function(){
				$('#categorymenu').addClass('active');
			});
			
			function deletecategory(category_id){
				swal({   title: "Are you sure?",   
						 text: "You will not be able to recover this category!",   
						 type: "warning",   showCancelButton: true,   
						 confirmButtonColor: "#DD6B55",   
						 confirmButtonText: "Yes, delete it!",   
						 closeOnConfirm: false 
				    }, function(){   
				    	$.get("actiondeletecategory",{
							id : category_id
						},function(data){
					    	swal("Deleted!", "Category has been deleted..!.", "success"); 
							location.href="listcategory";
						});
				    });
			
			}
			
		</script>
		
		<jsp:include page="../../include/setting.jsp"></jsp:include>
	</body>
</html>
 