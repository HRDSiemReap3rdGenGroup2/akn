<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List Source</title>

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
							<a href="formsource"><button type="button" class="btn ink-reaction btn-raised btn-primary">Add Source</button></a>
						</div>
					</div>
					<div class="section-header">	
						<h2 class="text-primary">List Sources</h2>
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
												<th>Name</th>
												<th>Code</th>
												<th class="sort-alpha">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:set value="${requestScope.allSource }" var="sources"></c:set>
											<c:forEach items="${sources }" var="item">
												<tr class="gradeX">
													<td>${item.source_id }</td>
													<td>${item.source_name }</td>
													<td>${item.source_code }</td>
													<td class="text-right">
														<a href="updatesource?id=${item.source_id }" class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Edit row"><i class="fa fa-pencil"></i></a>
														<a href="deletesource?id=${item.source_id }" class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Delete row"><i class="fa fa-trash-o"></i></a>
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
				$('#dashboard').addClass('active');
			});
			
			function myedit(source_id, source_code, source_name){
				$('#source_id').val(source_id);
				$('#source_name').val(source_name); 
				$('#source_code').val(source_code);				
			}
			
			
			$('#btncreate').click(function(){
				if($('#btncreate').attr("value") == "Save")
					$.post('addsource',{
						source_name : $("#source_name").val(),
						source_code : $("#source_code").val()
					},function(data){
						list();
					});	
			});
			
		  	//list();
			function list(){
				$.post('sourcelist',function(data){
					$("#table").html(listDetail(data));
				});
			}
			function listDetail(data){
				var str="";
				str ="<table class='table'>"+
					   "<tr>"+
							"<th>ID</th>"+
							"<th>Name</th>"+
							"<th>Code</th>"+
							"<th>Action"+
						"</tr>";
					for(var i=0;i<data.length;i++){
						str += "<tr>"+
									"<td>"+ data[i].source_id+"</td>"+
									"<td>"+ data[i].source_name +"</td>"+
									"<td>"+ data[i].source_code +"</td>"+
									"<td><button type='button' class='btn btn-warning' onclick=editrecord('"+ data[i].source_id +"')>Edit</button>"+
									"&nbsp;&nbsp;<button type='button' class='btn btn-danger' onclick=deleterecord('"+ data[i].source_id +"')>Delete</button>"+
									"</td>"+
								"</tr>";
					}
				str += "</table>";
				return str;
			}
			
			function updatesource(source_id){
				$.post("getsource",{
					source_id: source_id
				},function(data){
					$("#id").val(data.source_id);
					$("#source_name").val(data.source_name);
					$("#source_code").val(data.source_code);
					
					$("#btncreate").attr("value", "Update");
					$("#btncreate").attr("onclick", "edit('"+ data.source_id +"')");
				});
			}
			function edit(id){
				if($("#btncreate").attr("value")=="Update"){
					$.post("editsource",{
						source_id : id,
						source_name : $("#source_name").val(),
						source_code : $("#source_code").val()
					},function(data){
						list();
						$("#btncreate").attr("value","Save");
					});
				}
			}
			
			function deletesource(source_id){
				$.post("deletesource",{
					source_id : source_id
				},function(){
					list();
				});
			}
		</script>
		
	</body>
</html>
 