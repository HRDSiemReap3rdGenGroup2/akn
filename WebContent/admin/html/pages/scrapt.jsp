<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Scrapt News</title>

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
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/select2/select2.css?1424887856" />
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/libs/multi-select/multi-select.css?1424887857" />
		
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
			li button:hover{
				background-color:gray;
			}
			.table-container {
			    height: 500px;
			}
			table {
			    display: flex;
			    flex-flow: column;
			    height: 100%;
			    width: 100%;
			}
			table thead {
			    /* head takes the height it requires, 
			    and it's not scaled when table is resized */
			    flex: 0 0 auto;
			    width: calc(100% - 0.9em);
			}
			table tbody {
			    /* body takes all the remaining available space */
			    flex: 1 1 auto;
			    display: block;
			    overflow-y: scroll;
			}
			table tbody tr {
			    width: 100%;
			}
			table thead, table tbody tr {
			    display: table;
			    table-layout: fixed;
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
				<c:set value="${requestScope.allsource }" var="source"></c:set>
				<c:set value="${requestScope.allcategory }" var="category"></c:set>
				<!-- BEGIN BLANK SECTION -->
				<section class="style-default-bright">
					<div class="section-header">
						<ol class="breadcrumb">
							<li class="active">SCAN NEWS</li>
						</ol>
					</div><!--end .section-header -->
					<div class="section-body">
						<div class="row">
							<div class="form" role="form">
								<div class="form-group floating-label">
									<select id="source" class="form-control select2-list" multiple>
										<option value="">&nbsp;</option>
										<c:forEach items="${source }" var="item">
											<option value="${item.source_code }">${item.source_name }</option>
										</c:forEach>
									</select>
									<label>Source</label>
								</div>
								<div class="card-actionbar-row" >
									<center>
										<button style="font-size:20px" id="scannews" class="btn btn-flat btn-primary ink-reaction">SCAN NEWS</button>
										<button style="font-size:20px" id="auto-scannews" class="btn btn-flat btn-primary ink-reaction">Auto Scan</button>
									</center>
								</div>
							</div>
						</div>
						<div class="row">
							<table class="table no-margin">
								<thead>
									<tr>
										<th width="10%">Code</th>
										<th width="35%">Title</th>
										<th>Date</th>
										<th>Source</th>
										<th>Category</th>
									</tr>
								</thead>
								<tbody id="mybody" class="table-container">
								</tbody>
							</table>
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
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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
		<script src="../../assets/js/libs/multi-select/jquery.multi-select.js"></script>
		<script src="../../assets/js/libs/select2/select2.min.js"></script>
		<!-- END JAVASCRIPT -->
		
		<script>
			$(document).ready(function(){
				$('#dashboard').addClass('active');
			});
		   function chooseFile() {
			   $("#fileInput").click();
		   }
		   $('select').select2();
		   
		   $('#scannews').click(function(){
			   
			   var items = [];
			   $('#source option:selected').each(function(){ items.push($(this).val()); });
			   var result = items.join(',');
			   $.post('scannews',{source:result},function(data){
				  listdata(data);
			   });
			  
		   });
		   function listdata(data){
			   var str="";
			   for(var i=0; i<data.length; i++){
				   str+='<tr>'
						+	'<td width="10%">'+data[i].news_id+'</td>'
						+	'<td width="35%">'+data[i].news_title+'</td>'
						+	'<td>'+data[i].news_date+'</td>'
						+	'<td>'+data[i].news_source+'</td>'
						+	'<td>'+data[i].news_category+'</td>'
					+	'</tr>';
			   }
			   $('#mybody').html(str);
		   }
		   $("#auto-scannews").click(function(){
			   
		   });
		</script>
		
	</body>
</html>
