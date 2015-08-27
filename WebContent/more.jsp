<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<link rel="shortcut icon" href="img/logo/aknlogo.png" />

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
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
        <script src="dist/sweetalert.min.js"></script>
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
        margin-top: 0px;
    }
    .wrap-news p{
        margin-bottom: 6px;
    }
</style>
</head>

<body>
<c:set var="user" value="${sessionScope.user }"></c:set>
<c:set var="savedlist" value="${requestScope.user_savedlist}"></c:set>
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
                 <div class="column-one-third">
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
                	<div class="column-two-third">
                		<div class="wrap-news" id="display-user">
	                        
                   		</div>
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
	var source="";
	var category_id_choice=1;
	
	$.post("getcategory",function(data){
		var str="";
		for(var i=0;i<data.length;i++){
			str+="<li id='cate"+data[i].category_id+"' onclick='getnews(\""+data[i].category_id+"\",0)'>"
				+"<a>"+data[i].category_name+"</a>"
				+"</li>";
		}	
		$("#category").html(str);
	});
	getnews(1,0,0);
	function active(id){
		$("#category li").each(function(index,li) {
		    $(li).css("background","#fff");
		});
		$("#"+id).css("background","#ccc");
	}
	function getnews(category_id,page,source_id){
		category_id_choice=category_id;
		$.post("getallsource",function(data){
			source="<option value='0'> All Source </option>";
			for(var i=0;i<data.length;i++){
				source+="<option value='"+data[i].source_id+"'>"
					+data[i].source_name
					+"</option>";
			}	
		});
		var totalpage=0;
		$.post("gettotalpage",{
			category_id:category_id
		},function(data){
			totalpage=data;
		});
		$.post("getnewsmore",{
			category_id:category_id,
			page:page,
			source_id:source_id
		},function(data){
			var str="<h5 class='user-profile'><span>"+data[0].category_name+"</span>"
				+"<select style='float:right;margin-top:4px;' id='source_choice' onchange='changeSource("+category_id+",0)'>"+source+"</select>"
				+"</h5>"
			+"<div class='wrap-news user'>";
			for(var i=0;i<data.length;i++){
				
				str+="<div class='news-row column-two-third' style='margin-left:0'>"
                +"<div class='items'>"
                   +"<img src='"+data[i].news_img+"' style='height:170px'>"
                    +"<a href='news?id="+data[i].news_id+"' target='_blank'><h5>"+data[i].news_title+"</h5></a>"
                    +"<p class='publish-date'>"+data[i].news_date+"</p>"    
                    +"<p>"+data[i].news_desc.substring(0,100)+"...</p>"
                    +"<div>"
                    +"<img src='img/logo/"+data[i].source_id+".png' style='width:20px;'>"
                    +"<span style='color:#999'>Viewed:"+data[i].hit_count+"</span>";
					var have=0;
					if('${user}'!=null||'${user}'!=''){
						var j=[];
						<c:forEach items='${requestScope.user_savedlist }' var='i'>
						    j.push(${i.news_id});
						</c:forEach>
						for(l=0;l<j.length;l++){
							if(j[l]==data[i].news_id){
								have=1;
								str+="<button style='float:right;background:#ccc' onclick='save(815)' id='"+data[i].news_id+"' disabled>Saved</button>";
							}
						}
						if(have!=1){
							str+="<button style='float:right' onclick='save("+data[i].news_id+")' id='"+data[i].news_id+"'>Save</button>";
						}
					}else{
						str+="<button style='float:right' onclick='save("+data[i].news_id+")' id='"+data[i].news_id+"'>Save</button>";
					}
					str+="</div>"
                	+"</div>"  
            		+"</div>";
				}
			source="";
			var p="";		
			p="<div class='pager' style='float:right'><ul>";
			if(page>0){
				p+="<li><a onclick='getnews("+category_id+","+0+")'>First</a></li>";
				p+="<li><a onclick='getnews("+category_id+","+0+")'>Prev</a></li>";
			}
			var begin=1;
			var end=5;
			if(page-4<0)
				begin=0;
			else
				begin=page-4;
			if(totalpage-page<4){
				end=totalpage;
			}else{
				end=page+4;
			}
			for(var k=begin;k<end+1;k++){
				p+="<li><a id='page_"+(k)+"' onclick='getnews("+category_id+","+(k)+")' class='pagelist'>"+(k+1)+"</a></li>";
			}
			if(page<totalpage){
				p+="<li><a onclick='getnews("+category_id+","+(page+1)+")'>Next</a></li>";
				p+="<li><a onclick='getnews("+category_id+","+totalpage+")'>Last</a></li>";
			}
				p+="</ul></div>";		
			str+=p+"</div>";
			$("#display-user").html(str);
			active("cate"+category_id);
			$("#page_"+page).addClass("active");
		});
	}
	
	function changeSource(category_id,page){
		var source_id=$("#source_choice :selected").val();
		var totalpage=0;
		$.post("gettotalpage",{
			category_id:category_id,
			source_id:source_id
		},function(data){
			totalpage=data;
		});
		$.post("getnewsmore",{
			category_id:category_id,
			page:page,
			source_id:source_id
		},function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				str+="<div class='news-row column-two-third' style='margin-left:0'>"
                +"<div class='items'>"
                   +"<img src='"+data[i].news_img+"' style='height:170px'>"
                    +"<a href='news?id="+data[i].news_id+"' target='_blank'><h5>"+data[i].news_title+"</h5></a>"
                    +"<p class='publish-date'>"+data[i].news_date+"</p>"    
                    +"<p>"+data[i].news_desc.substring(0,100)+"...</p>"
                    +"<div>"
                    +"<img src='img/logo/"+data[i].source_id+".png' style='width:20px;'>"
                    +"<span style='color:#999'>Viewed:"+data[i].hit_count+"</span>";
					var have=0;
					if('${user}'!=null||'${user}'!=''){
						var j=[];
						<c:forEach items='${requestScope.user_savedlist }' var='i'>
						    j.push(${i.news_id});
						</c:forEach>
						for(l=0;l<j.length;l++){
							if(j[l]==data[i].news_id){
								have=1;
								str+="<button style='float:right;background:#ccc' onclick='save(815)' id='"+data[i].news_id+"' disabled>Saved</button>";
							}
						}
						if(have!=1){
							str+="<button style='float:right' onclick='save("+data[i].news_id+")' id='"+data[i].news_id+"'>Save</button>";
						}
					}else{
						str+="<button style='float:right' onclick='save("+data[i].news_id+")' id='"+data[i].news_id+"'>Save</button>";
					}
					str+="</div>"
                	+"</div>"  
            		+"</div>";
				}
			source="";
			var p="";		
			p="<div class='pager' style='float:right'><ul>";
			if(page>0){
				p+="<li><a onclick='changeSource("+category_id+","+0+")'>First</a></li>";
				p+="<li><a onclick='changeSource("+category_id+","+0+")'>Prev</a></li>";
			}
			var begin=1;
			var end=5;
			if(page-4<0)
				begin=0;
			else
				begin=page-4;
			if(totalpage-page<4){
				end=totalpage;
			}else{
				end=page+4;
			}
			for(var k=begin;k<end+1;k++){
				p+="<li><a id='page_"+(k)+"' onclick='changeSource("+category_id+","+(k)+")' class='pagelist'>"+(k+1)+"</a></li>";
			}
			if(page<totalpage){
				p+="<li><a onclick='changeSource("+category_id+","+(page+1)+")'>Next</a></li>";
				p+="<li><a onclick='changeSource("+category_id+","+totalpage+")'>Last</a></li>";
			}
				p+="</ul></div>";		
			str+=p+"";
			$(".wrap-news .user").html(str);
			active("cate"+category_id);
			$("#page_"+page).addClass("active");
		});
	}
	
	function save(news_id){
		if('${user.user_id}'==''){
			swal({   
				title: "Login first!",   
						text: "You need to login to save news to your list.",   
						type: "warning",   
						showCancelButton: true,   
						confirmButtonColor: "#DD6B55",   
						confirmButtonText: "Login!",   
						closeOnConfirm: false }, 
						function(){   
							window.location.href="login";
						}
			);
		}else{
			$.post("savenews",{
				news_id:news_id
			},function(data){
				if(data=='success'){
					$("#"+news_id).css("background","#ccc");
					$("#"+news_id).text("Saved");
					swal("Done!", "News already saved to your save list!", "success")
				}
			});	
		}
	}
</script>
</body>
</html>
