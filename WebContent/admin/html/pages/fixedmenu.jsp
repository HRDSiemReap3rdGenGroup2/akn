<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Update Menu</title>

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
			*{
				font-family:'Khmer OS Siemreap';
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
					
					<div class="section-body">
						<!-- BEGIN INTRO -->
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<form class="form" action="updatemenu" method="post">
									<div class="card">
										<div class="card-head style-primary">
											<header>Dynamic Menu</header>
										</div>
										<div class="card-body floating-label">
										
											<c:set var="menu" value="${requestScope.menu }"></c:set>
											<c:set var="category" value="${requestScope.category }"></c:set>
											
											<div class="form-group">
												<select id="index0" name="index0" class="form-control">
													<option value="${menu[0].category_id }">${menu[0].name }</option>
													<c:forEach var="item" items="${category }">
														<option value="${item.category_id}">${item.category_name }</option>
													</c:forEach>
											    </select>
												<label for="Password2">1st Menu</label>
											</div>
											<div class="form-group">
												<select id="index1" name="index1" class="form-control">
													<option value="${menu[1].category_id }">${menu[1].name }</option>
													<c:forEach var="item" items="${category }">
														<option value="${item.category_id}">${item.category_name }</option>
													</c:forEach>
											    </select>
												<label for="Password2">2nd Menu</label>
											</div>
											<div class="form-group">
												<select id="index2" name="index2" class="form-control">
												    <option value="${menu[2].category_id }">${menu[2].name }</option>
												    <c:forEach var="item" items="${category }">
														<option value="${item.category_id}">${item.category_name }</option>
													</c:forEach>
											    </select>
												<label for="Password2">3rd Menu</label>
											</div>
											<div class="form-group">
												<select id="index3" name="index3" class="form-control">
												    <option value="${menu[3].category_id }">${menu[3].name }</option>
												    <c:forEach var="item" items="${category }">
														<option value="${item.category_id}">${item.category_name }</option>
													</c:forEach>
											    </select>
												<label for="Password2">4rd Menu</label>
											</div>
											<div class="form-group">
												<select id="index4" name="index4" class="form-control">
												    <option value="${menu[4].category_id }">${menu[4].name }</option>
												    <c:forEach var="item" items="${category }">
														<option value="${item.category_id}">${item.category_name }</option>
													</c:forEach>
											    </select>
												<label for="Password2">5rd Menu</label>
											</div>
							
										</div><!--end .card-body -->
										<div class="card-actionbar">
											<div class="card-actionbar-row">
                                                <button type="button" class="btn btn-flat btn-primary ink-reaction">CANCEL</button>
												<button type="submit" class="btn btn-flat btn-primary ink-reaction">SAVE</button>
											</div>
										</div>
									</div><!--end .card -->
								</form>
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
				
				$('#menu').addClass('active');
		
			});
		</script>
		
		<jsp:include page="../../include/setting.jsp"></jsp:include>
		
	</body>
</html>
