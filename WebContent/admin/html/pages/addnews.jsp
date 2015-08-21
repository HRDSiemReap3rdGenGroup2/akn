<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<c:set value="${requestScope.news }" var="news"></c:set>
		
		<c:choose>
			<c:when test="${news.status==1 }">
				<title>Update News's Information'</title>
			</c:when>
			<c:otherwise>
				<title>Add News's Information'</title>
			</c:otherwise>
		</c:choose>

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
		
        <link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/bootstrap-datepicker/datepicker3.css?1424887858">
        
    	<!-- include summernote css/js-->
		<link href="../../assets/js/summernote/summernote.css" rel="stylesheet">
		
		<link rel="stylesheet" type="text/css" href="../../../dist/sweetalert.css">
        <script src="../../../dist/sweetalert.min.js"></script>
		
		<!-- END STYLESHEETS -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../../assets/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../../assets/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
		
		<style>
			/*.form-control{
				height:61px;
			}*/
			.note-editor{
				border:none;
			}
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
			
			<c:set value="${requestScope.category }" var="item"></c:set>
			<c:set value="${requestScope.source }" var="source"></c:set>
			
			<input type="hidden" id="news_id" value="${param.id }">
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
								<div class="form">
									<div class="card">
										<div class="card-head style-primary">
											<c:choose>
												<c:when test="${news.status==1 }">
													<header>Update News</header>
												</c:when>
												<c:otherwise>
													<header>Add News</header>
												</c:otherwise>
											</c:choose>
										</div>
										<div class="card-body floating-label">
											<div class="form-group">
												<c:choose>
													<c:when test="${news.status==1 }">
														<input class="form-control" id="khmertitle" type="text" value="${news.news_title }">
													</c:when>
													<c:otherwise>
														<input class="form-control" id="khmertitle" type="text">
													</c:otherwise>
												</c:choose>
												<label for="khmertitle">Khmer Title</label>
											</div>
											
                                            <div class="form-group floating-label">
                                            	<label for="thumnail">Thumnail (285x170)</label>
												<div class="input-group">
													<div class="input-group-btn" style="margin-right:0px">
														<c:choose>
															<c:when test="${news.status==1 }">
																<input type="hidden" value="${news.news_img }" id="updateimage"/>
																<input type="file" value="${news.news_img }" accept="image/*" id="fileUpload" class="filestyle" data-classButton="btn btn-primary" data-input="false" data-classIcon="icon-plus" data-buttonText="Choose Thumnail ">
															</c:when>
															<c:otherwise>
																<input type="file" accept="image/*" id="fileUpload" class="filestyle" data-classButton="btn btn-primary" data-input="false" data-classIcon="icon-plus" data-buttonText="Choose Thumnail ">
															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</div>
                                            
                                            <div class="form-group floating-label">
												<select id="source" name="source" class="form-control">
													<c:choose>
														<c:when test="${news.status==1 }">
															<option value="${news.source_id }">${news.source_name }</option>
														</c:when>
														<c:otherwise>
															<option value="">&nbsp;</option>
															<option value="AKN News">AKN News</option>
														</c:otherwise>
													</c:choose>
												</select>
												<label for="select2">Source</label>
											</div>
                                            
                                            <div class="form-group floating-label">
												<select id="category" name="category" class="form-control">
													<c:choose>
														<c:when test="${news.status==1 }">
															<option value="${news.category_id }">${news.category_name }</option>
															<c:forEach var="v" items="${item }">
																<option value="${v.category_id }">${v.category_name }</option>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<option value="">&nbsp;</option>
															<c:forEach var="v" items="${item }">
																<option value="${v.category_id }">${v.category_name }</option>
															</c:forEach>
														</c:otherwise>
													</c:choose>
												</select>
												<label for="select2">Category</label>
											</div>
											
                                            <div class="form-group">
												<div class="input-group date" id="demo-date">
													<div class="input-group-content">
														<c:choose>
															<c:when test="${news.status==1 }">
																<input class="form-control" name="publishdate" id="publishdate" type="text" value="${news.news_date_timestamp }">
															</c:when>
															<c:otherwise>
																<input class="form-control" name="publishdate" id="publishdate" type="text">
															</c:otherwise>
														</c:choose>
														<label>Publish Date</label>
													</div>
													<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
                                            
                                            <!--begin language-->
                                            <div class="form-group">
                                            	<div class="tab-pane active" id="first5">
                                                           <!--BEGIN SUMMERNOTE  -->
                                                           <div class="card">
                                                               <div class="card-body no-padding">
                                                                   <div id="summernote" class="summernote">
																	<c:choose>
																		<c:when test="${news.status==1 }">
																			${news.news_desc }												
																		</c:when>
																		<c:otherwise>
																			<p>Khmer</p>
																		</c:otherwise>
																	</c:choose>
                                                                   </div>
                                                               </div><!--end .card-body -->
                                                           </div><!--end .card -->
                                                           <!-- END SUMMERNOTE -->
                                                 </div>
                                            </div><!--/end language-->
                                            
										</div><!--end .card-body -->
                                        
										<div class="card-actionbar">
											<div class="card-actionbar-row">
												<c:choose>
													<c:when test="${news.status==1 }">
														<button id="btnupdate" class="btn btn-flat btn-primary ink-reaction">Update News</button>
													</c:when>
													<c:otherwise>
														<button id="btnsave1" class="btn btn-flat btn-primary ink-reaction">Save News</button>
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
        <script src="../../assets/js/libs/bootstrap-datepicker/bootstrap-datepicker.js"></script>
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
		<script src="../../assets/js/core/demo/DemoFormComponents.js"></script>
		<script src="../../assets/js/summernote/summernote.min.js"></script>
		<!-- END JAVASCRIPT -->
		
		<script type="text/javascript" src="../../assets/js/bootstrap-filestyle.min.js"> </script>
		
		<script>
			$(document).ready(function() {
	  			$('#summernote').summernote();
	  			
	  			$('#news').addClass('active');
	  			
	  			$('#btnsave1').click(function(){
	  				var data1;
				    data1 = new FormData();
				    data1.append('file', $('#fileUpload')[0].files[0]);
				    $.ajax({
						url : "addnews",
						type : "POST",
						cache: false,
						contentType: false,
						processData: false,
						data: data1,
						success:function(data){
							var path=data;
							var c = $('#summernote').code();
							$.post('addnews1',
									{ path:path,
								      khmer:$('#khmertitle').val(),
									  category:$('#category option:selected').val(),
									  source:$('#source option:selected').val(),
									  mydate:$("#publishdate").val(),
									  khmercontent:c
									},
									function(data){
										swal("Done!","Added Successfully!","success");
										location.href="formnews";
							});
						}
					});   
	  			});
	  			
				$('#btnupdate').click(function(){
					var data2;
				    data2 = new FormData();
				    data2.append('file', $('#fileUpload')[0].files[0]);
				    $.ajax({
						url : "addnews",
						type : "POST",
						cache: false,
						contentType: false,
						processData: false,
						data: data2,
						success:function(data){
							if(data==""){
								path=$('#updateimage').val();
							}else{
								path=data;
							}
							var c = $('#summernote').code();
							$.post('actionupdatenews',
									{ path:path,
									  id:$('#news_id').val(),
								      khmer:$('#khmertitle').val(),
									  category:$('#category option:selected').val(),
									  source:$('#source option:selected').val(),
									  mydate:$("#publishdate").val(),
									  khmercontent:c
									},
									function(data){
										swal("Done!","Updated Successfully!","success");
										location.href="formnews";
							});
						}
					});   
				});
	    
			});
			
		</script>
		<!-- END JAVASCRIPT -->
	</body>
</html>
