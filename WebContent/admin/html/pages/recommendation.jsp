<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Recommendation Page</title>

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

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../../assets/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../../assets/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
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
				<section class="has-actions style-default-bright">

					<!-- BEGIN INBOX -->
					<div class="section-body">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="text-divider visible-xs"><span>Email list</span></div>
								<div class="row">

									<!-- BEGIN INBOX EMAIL LIST -->
									<div class="col-md-5 col-lg-4 height-6 scroll-sm">
										<div class="list-group list-email list-gray">
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<h5>Jonathan Smith</h5>
												<h4>I am on my way</h4>
												<p class="hidden-xs hidden-sm">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit...</p>
												<div class="stick-top-right small-padding text-default-light text-sm">12:46 am</div>
												<div class="stick-bottom-right small-padding"><span class="glyphicon glyphicon-paperclip"></span></div>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item focus">
												<div class="stick-top-left small-padding"><i class="fa fa-dot-circle-o text-info"></i></div>
												<h5>Alicia Spinnet</h5>
												<h4>Reaching the top</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">08:12 am</div>
												<p class="hidden-xs hidden-sm">We are already halfway there. There are still some obstacles that we must take, but I do not expect any problems...</p>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<h5>Peter Pitt</h5>
												<h4>Seeing the top</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">Yesterday</div>
												<p class="hidden-xs hidden-sm">Please check the new headlines of the magazine. They are quite insignificant compared with...</p>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<div class="stick-top-left small-padding"><i class="fa fa-dot-circle-o text-info"></i></div>
												<h5>Alicia Spinnet</h5>
												<h4>Meeting next monday</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">Jul 12</div>
												<p class="hidden-xs hidden-sm">Proin nonummy, lacus eget pulvinar lacinia, pede felis dignissim leo, vitae tristique magna lacus...</p>
												<div class="stick-bottom-right small-padding"><span class="glyphicon glyphicon-paperclip"></span></div>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<h5>Dennis Riker</h5>
												<h4>I'm on my way</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">Jul 07</div>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<h5>John West</h5>
												<h4>The great escape</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">Jun 24</div>
												<p class="hidden-xs hidden-sm">Proin nonummy, lacus eget pulvinar lacinia, pede felis dignissim leo, vitae tristique magna lacus...</p>
											</a>
											<a href="../../html/mail/inbox.html" class="list-group-item">
												<div class="stick-top-left small-padding"><i class="fa fa-dot-circle-o text-info"></i></div>
												<h5>George Williams</h5>
												<h4>I'm at the gym at 9 pm</h4>
												<div class="stick-top-right small-padding text-default-light text-sm">Jun 22</div>
											</a>
										</div><!--end .list-group -->
									</div><!--end .col -->
									<!-- END INBOX EMAIL LIST -->

									<!-- BEGIN EMAIL CONTENT -->
									<div class="col-md-7 col-lg-8">
										<div class="text-divider hidden-md hidden-lg"><span>Email</span></div>
										<h1 class="no-margin">Reaching the top</h1>
										<div class="btn-group stick-top-right">
											<a href="../../html/mail/reply.html" class="btn btn-icon-toggle btn-default"><i class="md md-delete"></i></a>
											<a href="../../html/mail/reply.html" class="btn btn-icon-toggle btn-default"><i class="md md-reply"></i></a>
											<a href="../../html/mail/reply.html" class="btn btn-icon-toggle btn-default"><i class="md md-reply-all"></i></a>
											<a href="../../html/mail/reply.html" class="btn btn-icon-toggle btn-default"><i class="md md-forward"></i></a>
										</div>
										<span class="pull-right text-default-light">Today, 08:12 am</span>
										<strong>Alicia Spinnet</strong>
										<hr/>
										<p class="lead">We are already halfway there. There are still some obstacles that we must take, but I do not expect any problems. Dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
										<p><img class="img-responsive" src="../../assets/img/img14.jpg?1404589160" alt="" /></p>
										<p>Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst.</p>
										<p>Fusce convallis, mauris imperdiet gravida bibendum, nisl turpis suscipit mauris, sed placerat ipsum urna sed risus. In convallis tellus a mauris. Curabitur non elit ut libero tristique sodales. Mauris a lacus. Donec mattis semper leo. In hac habitasse platea dictumst. Vivamus facilisis diam at odio. Mauris dictum, nisi eget consequat elementum, lacus ligula molestie metus, non feugiat orci magna ac sem. Donec turpis. Donec vitae metus. Morbi tristique neque eu mauris. Quisque gravida ipsum non sapien. Proin turpis lacus, scelerisque vitae, elementum at, lobortis ac, quam. Aliquam dictum eleifend risus. In hac habitasse platea dictumst. Etiam sit amet diam. Suspendisse odio. Suspendisse nunc. In semper bibendum libero.</p>
										<p>Proin nonummy, lacus eget pulvinar lacinia, pede felis dignissim leo, vitae tristique magna lacus sit amet eros. Nullam ornare. Praesent odio ligula, dapibus sed, tincidunt eget, dictum ac, nibh. Nam quis lacus. Nunc eleifend molestie velit. Morbi lobortis quam eu velit. Donec euismod vestibulum massa. Donec non lectus. Aliquam commodo lacus sit amet nulla. Cras dignissim elit et augue. Nullam non diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In hac habitasse platea dictumst. Aenean vestibulum. Sed lobortis elit quis lectus. Nunc sed lacus at augue bibendum dapibus.</p>
										<p>Aliquam vehicula sem ut pede. Cras purus lectus, egestas eu, vehicula at, imperdiet sed, nibh. Morbi consectetuer luctus felis. Donec vitae nisi. Aliquam tincidunt feugiat elit. Duis sed elit ut turpis ullamcorper feugiat. Praesent pretium, mauris sed fermentum hendrerit, nulla lorem iaculis magna, pulvinar scelerisque urna tellus a justo. Suspendisse pulvinar massa in metus. Duis quis quam. Proin justo. Curabitur ac sapien. Nam erat. Praesent ut quam.</p>
									</div><!--end .col -->
									<!-- END EMAIL CONTENT -->

								</div><!--end .row -->
							</div><!--end .col -->
						</div><!--end .row -->
					</div><!--end .section-body -->
					<!-- END INBOX -->

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
				$('#mailmenu').addClass('active');
			});
		</script>
	</body>
</html>
