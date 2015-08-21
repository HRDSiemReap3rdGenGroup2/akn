<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Form Source</title>
	
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
			
		</style>
	</head>
	<body class="menubar-hoverable header-fixed menubar-first full-content ">

		<!-- BEGIN HEADER-->
		<jsp:include page="../../include/header.jsp"></jsp:include>
		<!-- END HEADER-->

		<!-- BEGIN BASE-->
		<div id="base">
		<c:set value="${requestScope.updatesource }" var="update"></c:set>
			<!-- BEGIN OFFCANVAS LEFT -->
			<div class="offcanvas">
			
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">

				<!-- BEGIN BLANK SECTION -->
				<section class="style-default-bright">
					<div class="section-header">
						<ol class="breadcrumb">
							<li class="active">Form Source</li>
						</ol>
					</div><!--end .section-header -->
					<div class="section-body">
						<div class="row">
							<c:choose>
								<c:when test="${update.source_status==1 }">
									<form method="post" action="editsource" class="form form-validate floating-label" novalidate="novalidate">
								</c:when>
								<c:otherwise>
									<form method="post" action="addsource" class="form form-validate floating-label" novalidate="novalidate">
								</c:otherwise>
							</c:choose>
									<div class="card">
										
										<div class="card-head style-primary">
											<c:choose>
												<c:when test="${update.source_status==1 }">
													<header>Update Source</header>
												</c:when>
												<c:otherwise>
													<header>Create Source</header>
												</c:otherwise>
											</c:choose>
										</div><!-- end .card-head -->
										
										<div class="card-body floating-label">
											<input type="text" id="source_id" name="source_id" hidden="hidden" value="${update.source_id }">
											<div class="form-group floating-label">
												<input type="text" class="form-control" value="${update.source_name }" id="source_name" name="source_name" required>
												<label for="regular2">Source Name</label>
												<p class="help-block">This is for the source name of the pages!</p>
											</div>
										    <div class="form-group floating-label">
												<input type="text" class="form-control" value="${update.source_code }"  id="source_code" name="source_code" required>
												<label for="regular2">Source Code</label>
												<p class="help-block">This is for the source code you set!</p>
											</div>
											<div class="card-actionbar-row">
												<c:choose>
													<c:when test="${update.source_status==1 }">
														<button type="submit" class="btn btn-flat btn-primary ink-reaction">Update Source</button>
													</c:when>
													<c:otherwise>
														<button type="submit" class="btn btn-flat btn-primary ink-reaction">Create Source</button>
													</c:otherwise>
												</c:choose>
											</div>
										</div><!-- end .card-body -->
									</div><!--end .card -->
								</form><!-- end form -->
						</div>
						
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
		
		<script src="../../assets/js/libs/validation/jquery.validate.min.js"></script>
		<!-- END JAVASCRIPT -->
		
		<script>

			$(document).ready(function(){
				$('#sourcemenu').addClass('active');
			});
			
		</script>
		
	</body>
</html>
 