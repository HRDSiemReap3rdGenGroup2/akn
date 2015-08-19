<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Add Module's Information</title>

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
			<input id="module_id" type="hidden" value="${param.id }">
			<!-- BEGIN OFFCANVAS LEFT -->
			<div class="offcanvas">
			
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">
				
				<!-- BEGIN BLANK SECTION -->
				<section class="style-default-bright">
					
					<c:set value="${requestScope.module }" var="module"></c:set>
					<c:set value="${requestScope.source }" var="source"></c:set>
					
					<div class="section-body">
						<!-- BEGIN INTRO -->
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form">
									<div class="card">
										<div class="card-head style-primary">
											<c:choose>
												<c:when test="${module.status==1 }">
													<header>Update Category</header>
												</c:when>
												<c:otherwise>
													<header>Create Category</header>
												</c:otherwise>
											</c:choose>
											
										</div>
										<div class="card-body floating-label">
											
											<div class="form-group floating-label">
												<select id="select2" name="select2" class="form-control">
													<c:choose>
														<c:when test="${module.status==1 }">
															<option value="70">ពត៌មាន</option>
														</c:when>
														<c:otherwise>
															<option value="">&nbsp;</option>
															<option value="70">ពត៌មាន</option>
														</c:otherwise>
													</c:choose>
												</select>
												<label for="select2">Type</label>
											</div>
                                            <div class="form-group floating-label">
												<select id="module_name" name="select2" class="form-control">
													<c:choose>
														<c:when test="${module.status==1 }">
															<option value="${module.module_name }">${module.module_name }</option>
														</c:when>
														<c:otherwise>
															<option value="">&nbsp;</option>
														</c:otherwise>
													</c:choose>
													<c:forEach var="item" items="${source }">
														<option value='${item.module_name }'>${item.module_name}</option>
													</c:forEach>
												</select>
												<label for="Username2">Media</label>
											</div>
                                            
											<div class="form-group">
												<c:choose>
														<c:when test="${module.status==1 }">
															<input required="required" class="form-control" id="module_type" type="text" value="${module.module_type }">
														</c:when>
														<c:otherwise>
															<input class="form-control" id="module_type" type="text">
														</c:otherwise>
													</c:choose>
												<label for="Username2">Category</label>
											</div>
											
										</div><!--end .card-body -->
										<div class="card-actionbar">
											<div class="card-actionbar-row">
												<c:choose>
													<c:when test="${module.status==1 }">
														<button id="btnupdate" type="button" class="btn btn-flat btn-primary ink-reaction">Update Category</button>
													</c:when>
													<c:otherwise>
														<button id="btncreate"  class="btn btn-flat btn-primary ink-reaction">Create Category</button>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div><!--end .card -->
								</div>
							</div>
						</div><!--end .row -->
						<!-- END INTRO -->

					</div>
					
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
		<!-- END JAVASCRIPT -->

		<script>
			$(document).ready(function(){
				
				$('#categorymenu').addClass('active');
				
				$('#btncreate').click(function(){
					
					$.post('addmodule',{
						module_name:$('#module_name option:selected').val(),module_type:$('#module_type').val()
						},
						function(data){
							swal("Done!","Added Successfully!","success");
							location.href="formmodule";
						}
					);
				});
				
				$('#btnupdate').click(function(){
					$.post('actionupdatemodule',{
						module_id:$('#module_id').val(),module_name:$('#module_name option:selected').val(),module_type:$('#module_type').val()
						},
						function(data){
							swal("Done!","Updated Successfully!","success");
							location.href="listmodule";
						}
					); 
				});
			});
		
		</script>

	</body>
</html>
