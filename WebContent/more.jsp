<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

<title>News | AKNEWS</title>

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
            <div class="container" style="margin-top:22px">
                
                <!--left sidebar-->
                <div class="column-one-fourth">
                    <div class="sidebar">
                        
                        <h5 class="user-profile"><span>គ្រប់ប្រភេទ</span></h5>
                        <div>
                            <ul class="all-category" id="category">
                            </ul>
                        </div>

                    </div>    
                </div>
                <!--/left sidebar-->
                
                <!--main-content-->
                <div class="main-content">
                    <div class="column-three-fourth" id="display-user">
                    </div>
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
	$("#other").toggleClass("current");
	$.post("getmoduletype",function(data){
		var str="";
		for(var i=0;i<data.length;i++){
			str+="<li id="+data[i].module_type_code+" onclick='getnews(\""+data[i].module_type_code+"\")'>"
				+"<a>"+data[i].module_type+"</a>"
				+"</li>";
		}	
		$("#category").html(str);
	});
	getnews("B000202");
	function active(id){
		$("#category li").each(function(index,li) {
		    $(li).css("background","#fff");
		});
		$("#"+id).css("background","#ccc");
	}
	function getnews(module_type_code){
		$.post("getnewsmore",{
			module_type_code:module_type_code
		},function(data){
			var str="<h5 class='user-profile'><span>"+data[0].module_type+"</span></h5>"
			+"<div class='wrap-news user'>";
			for(var i=0;i<data.length;i++){
				str+="<div class='news-row'>"
            	+"<div class='items'>"
            	+"<img src='"+data[i].news_img+"' style='height:170px;width:285px'/>"
            	+"<a href='news?id="+data[i].news_id+"'><h5>"+data[i].news_title+"</h5></a>"
            	+"<p class='publish-date'>"+data[i].news_date+"</p>"
            	+"<p style='min-height:100px;max-height:100px;overflow:hidden'>"+data[i].news_desc+"</p>"
            	+"</div>"      
            	+"</div>";      
			}
				var p="<div class='pager' style='float:right'><ul>";
       				p+="<li><a href='#' class='first-page'></a></li>";
        			for(var i=0;i<10;i++){
        				p+="<li><a href='#' class='pagelist'>"+(i+1)+"</a></li>";
        			}
        			p+="<li><a href='#' class='last-page'></a></li>";
        		p+="</ul></div>";
			str+=p+"</div>";
			$("#display-user").html(str);
			active(module_type_code);
		});
	}
</script>
</body>
</html>
