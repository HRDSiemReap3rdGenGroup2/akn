<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link rel="stylesheet" type="text/css" href="css/960.css" />
<link rel="stylesheet" type="text/css" href="css/devices/1000.css" media="only screen and (min-width: 768px) and (max-width: 1000px)" />
<link rel="stylesheet" type="text/css" href="css/devices/767.css" media="only screen and (min-width: 480px) and (max-width: 767px)" />
<link rel="stylesheet" type="text/css" href="css/devices/479.css" media="only screen and (min-width: 200px) and (max-width: 479px)" />
<link href='http://fonts.googleapis.com/css?family=Merriweather+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]> <script type="text/javascript" src="js/customM.js"></script> <![endif]-->
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
        <script src="dist/sweetalert.min.js"></script>
        <!-- Place this tag in your head or just before your close body tag. -->
							<script src="https://apis.google.com/js/platform.js" async defer></script>
<style type="text/css">
	*{
		font-family: "Khmer OS Siemreap";
	}
</style>
</head>

<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<c:set value="${requestScope.news }" var="news"></c:set>
<!-- Body Wrapper -->
<div class="body-wrapper">
	<div class="controller">
    <div class="controller2">

        <!-- Header -->
        <jsp:include page="includes/header.jsp"></jsp:include>
        <!-- /Header -->
        
        <!-- Content -->
        <section id="content">
            <div class="container">
            	
                <div class="breadcrumbs column">
                	<h3>${news.news_title }</h3>
                	<div style="color:#222">
                	<span>${news.news_date } &nbsp;</span>
                	<span>View:${news.hit_count }</span>
                	</div>
                </div>
            
            	<!-- Main Content -->
                <div class="main-content">
                    
                    <!-- Single -->
                    <div class="column-two-third single">
                    	${news.news_desc }
                    </div>
                    <!-- /Single -->
                        
                    <!--comment-->
                    <div class="column-two-third comments">
                        <h5 class="line"><span>មតិយោបល់</span>
                        <c:set var="req" value="${pageContext.request}" />
						<c:set var="baseURL" value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 1, fn:length(req.requestURI)), req.contextPath)}" />
						<c:url var="myUrl" value="${baseURL}/${MyID}"/>
						<div style="float:right">
							<div style="display:inline;position:relative;right:5px;top:-7px;"><div class="fb-share-button" data-href="${myUrl }news?id=${param.id}" data-layout="button_count"></div></div>
							<!-- Place this tag where you want the share button to render. -->
							<div class="g-plus" data-action="share" data-annotation="bubble"></div>
						</div>
                        	
                        </h5>
                        <div class="form">
                            <textarea style="color:black" name="comment" rows="10" cols="30" placeholder="Your comment here..." id="comment"></textarea>
                            <button style="margin-top:5px; padding:10px 15px;" id="btn-comment">Comment</button>
                        </div>    
                        
                        <ul>
                            <li id="box-comment">
                                <div>
                                    <div class="comment-avatar"><img src="img/avatar.png" alt="MyPassion" /></div>
                                    <div class="commment-text-wrap">
                                        <div class="comment-data">
                                            <p><a href="#" class="url">MyPassion</a> <br /> <span>January 12, 2013 - <a href="#" class="comment-reply-link">reply</a></span></p>
                                        </div>
                                        <div class="comment-text">Curabitur nunc mauris, <a href="#">link test</a> id dictum quis, aliquet vel diam. Aliquam gravida, augue et dictum hendrerit, nisl erat congue elit, et molestie magna sapien cursus tortor.</div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!--/end comment-->
                
                </div>
                <!-- /Main Content -->
                
                <!-- Left Sidebar -->
                <div class="column-one-third">
                    <div class="sidebar">
                    	<!-- List News by category -->
                        <div class="sidebar">
                            <h5 class="line"><span>ពត៌មានពេញនិយម</span></h5>
                            <div class="outertight">
                                <ul class="block">
		                            <c:set var="list" value="${requestScope.popularnews }"></c:set>
		                            <c:forEach items="${list }" var="row">
		                        		<li>
		                        			<a href="news?id=${row.news_id}" target="_blank"><img src="${row.news_img}" alt="${row.news_title}" class="alignleft" width="140" height="86"/></a>
		                                    <p>
		                                        <span title="${row.news_date }">${fn:substring(row.news_date,0,20)}</span>
		                                        <a href="news?id=${row.news_id}" target="_blank">${fn:substring(row.news_title,0,60)}..</a>
			                                	<div>
			                                		<span style="color:#aaa;display:inline;">Viewed:${row.hit_count}</span>
			                                		<c:set value="${0}" var="have"></c:set>
	                                		<c:choose>
		                                			<c:when test="${user!=null || user!=''}">
			                                				<c:forEach items="${requestScope.user_savedlist }" var="i">
		                                						<c:if test="${i.news_id==row.news_id }">
						                                			<c:set value="${1}" var="have"></c:set>
						                                			<button style="float:right;background:#ccc" id="${row.news_id}" disabled>Saved</button>
		                                						</c:if>
		                                				</c:forEach>
	                                					<c:if test="${have!=1}">
			                                				<button style="float:right" onclick="save(${row.news_id})" id="${row.news_id}">Save</button>
			                                				<c:set value="${0}" var="have"></c:set>
	                                					</c:if>
		                                			</c:when>
		                                			<c:otherwise>
															<button style="float:right" onclick="save(${row.news_id})" id="${row.news_id}">Save</button>
		                                			</c:otherwise>
		                                		</c:choose>
			                                	</div>	
		                                    </p>
		                        		</li>
		                        	</c:forEach>
                                </ul>
                            </div>
                        </div>
                        <!-- /List news by category -->
                    </div>
                    
                </div>
                <!-- /Left Sidebar -->
                
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
list_comment();
	function list_comment(){
		$.post("getallcomment",{
			news_id:"${param.id}"
		},function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				str+="<div>"
                    +"<div class='comment-avatar'><img src='img/avatar.png' alt='"+data[i].user_name+"' /></div>"
                    +"<div class='commment-text-wrap'>"
                        +"<div class='comment-data'>"
                            +"<p><a href='#' class='url'>"+data[i].user_name+"</a> <br /> <span>"+data[i].date+"</span></p>"
                        +"</div>"
                        +"<div class='comment-text'>"+data[i].comment_detail+"</div>"
                    +"</div>"
                +"</div>";
			}
			$("#box-comment").html(str);
		});
	}
	$("#btn-comment").click(function(){
			if('${sessionScope.user}'!=''){
				$.post("comment",{
					news_id:'${param.id}',
					comment_detail:$("#comment").val()
				},function(data){
					if(data=='success'){
						list_comment();
						:$("#comment").val("");
					}
				});	
			}else{
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
		}
	});
	function save(news_id){
		if('${sessionScope.user}'!=''){
			$.post("savenews",{
				news_id:news_id
			},function(data){
				if(data=='success'){
					$("#"+news_id).css("background","#ccc");
					$("#"+news_id).text("Saved");
					swal("Done!", "News already saved to your save list!", "success")
				}
			});
		}else{
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
		}
	}
</script>
</body>
</html>
