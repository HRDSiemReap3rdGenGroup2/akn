<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="News - Clean HTML5 and CSS3 responsive template">
<meta name="author" content="MyPassion">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>TOP NEWS | AKNEWS</title>

<link rel="shortcut icon" href="img/sms-4.ico" />

<!-- STYLES -->
<link rel="stylesheet" type="text/css" href="css/superfish.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/fontello/fontello.css" />
<link rel="stylesheet" type="text/css" href="css/flexslider.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/ui.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />    
<link rel="stylesheet" type="text/css" href="css/960.css" />
<link rel="stylesheet" type="text/css" href="css/devices/1000.css" media="only screen and (min-width: 768px) and (max-width: 1000px)" />
<link rel="stylesheet" type="text/css" href="css/devices/767.css" media="only screen and (min-width: 480px) and (max-width: 767px)" />
<link rel="stylesheet" type="text/css" href="css/devices/479.css" media="only screen and (min-width: 200px) and (max-width: 479px)" />
<link href='http://fonts.googleapis.com/css?family=Merriweather+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

<!--[if lt IE 9]> <script type="text/javascript" src="js/customM.js"></script> <![endif]-->

<style>
    .user-profile{
        background-color: #4F9D51;
        padding:8px;
        color: white;
    }
    .user-info li:hover{
        background-color: darkseagreen;
    }
    .wrap-news{
        margin-top: 20px;
    }
    .wrap-news p{
        margin-bottom: 6px;
    }
    body{
    	min-height: 1000px;
    }
</style>
</head>

<body>
<!-- Body Wrapper -->
<div class="body-wrapper">
	<div class="controller">
    <div class="controller2">

        <!-- Header -->
        <jsp:include page="includes/header.jsp"></jsp:include>
        <!-- /Header -->
        
        <!-- Content -->
        <section id="content">
            <div class="container" style="">
                
                
                <!--main-content-->
                
                    <div class="column" id="display-job">
                        
                        <!--category-header-->
                        <h5 class="user-profile"><span>ស្ថិតិ</span></h5>
                        <!--/category-header-->
                        
                        
                        <!-- job list -->
                        <div style="margin-top:10px;">
                        	<h3 style="display:inline;margin-right:20px">Top News</h3>
                        	<select id="number" style="border:1px solid #DBDBDB;padding:3px">
                        		<option>5</option>
                        		<option>10</option>
                        		<option>25</option>
                        	</select>
                        </div><!-- /.div -->
                        <div style="position:relative;right:-15px;">
                        <select id="media" style="border:1px solid #DBDBDB; margin-left:0; margin-right:0;margin-top:10px; margin-bottom:10px; width:32%; font-family: 'Khmer OS Siemreap'">
                            <option value="0">All Media</option>
                        </select>
                        <select id="category" style="border:1px solid #DBDBDB; margin-left:0; margin-right:0;margin-top:10px; margin-bottom:10px; width:32%; font-family: 'Khmer OS Siemreap'">
                            <option value="0">All Category</option>
                        </select>
                        <select id="time" style="border:1px solid #DBDBDB; margin-left:0; margin-right:0;margin-top:10px; margin-bottom:10px; width:32%; font-family: 'Khmer OS Siemreap'">
                            <option value="1">Today</option>
                            <option value="7">Weekly</option>
                            <option value="30">Monthly</option>
                        </select>
                        </div>
                        <table class="table" id="tbl">
                        </table>
                        <!--/job list-->
                    </div>
                <!--/main content-->
            </div>    
        </section>
        <!-- / Content -->
        
        <!-- Footer -->
       <jsp:include page="includes/footer.jsp"></jsp:include>
        <!-- / Footer -->
    
    </div>
	</div>
</div>
<!-- / Body Wrapper -->


<!-- SCRIPTS -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/myscript.js"></script>
<script type="text/javascript" src="js/easing.min.js"></script>
<script type="text/javascript" src="js/1.8.2.min.js"></script>
<script type="text/javascript" src="js/ui.js"></script>
<script type="text/javascript" src="js/carouFredSel.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/customM.js"></script>
<script type="text/javascript" src="js/flexslider-min.js"></script>
<script type="text/javascript" src="js/tweetable.js"></script>
<script type="text/javascript" src="js/timeago.js"></script>
<script type="text/javascript" src="js/jflickrfeed.min.js"></script>
<script type="text/javascript" src="js/mobilemenu.js"></script>

<!--[if lt IE 9]> <script type="text/javascript" src="js/html5.js"></script> <![endif]-->
<script type="text/javascript" src="js/mypassion.js"></script>
<script>
	$("#statistic").addClass("current");
	list();
	listpopnews();
	$("#media").change(function(){
		listpopnews();
	});
	$("#number").change(function(){
		listpopnews();
	});
	$("#category").change(function(){
		listpopnews();
	});
	$("#time").change(function(){
		listpopnews();
	});
	function listpopnews(){
		$.post("gettopnews",{
			n:$('#number :selected').text(),
			source:$('#media :selected').val(),
			category:$('#category :selected').val(),
			time:$('#time :selected').val()
		},function(data){
			var str="<tr>"
                	+"<th>Rank</th>"
                	+"<th>Title</th>"
                	+"<th>Category</th>"
                	+"<th>Source</th>"
                	+"<th>Views</th>"
                	+"</tr>";
			for(var i=0;i<data.length;i++){
				str+="<tr>"
	            	+"<td>"+(i+1)+"</td>"
	            	+"<td><a href='news?id="+data[i].news_id+"' target='_blank'>"+data[i].news_title+"</a></td>"
	            	+"<td>"+$('#category :selected').text()+"</td>"
	            	+"<td>"+$('#media :selected').text()+"</td>"
	            	+"<td>"+data[i].hit_count+"</td>"
	        		+"</tr>";
			}
			$("#tbl").html(str);
		}); 
	}
	
	function list(){
		$.post("getcategory",function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				str+="<option value='"+data[i].category_id+"'>"
					+data[i].category_name
					+"</option>";
			}	
			$("#category").append(str);
		});
		$.post("getsource",function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				str+="<option value='"+data[i].source_id+"'>"
					+data[i].source_name
					+"</option>";
			}	
			$("#media").append(str);
		});
	};
</script>
</body>
</html>
