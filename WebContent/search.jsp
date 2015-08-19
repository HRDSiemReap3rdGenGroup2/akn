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

<title>Result | AKNEWS</title>

<link rel="shortcut icon" href="img/sms-4.ico" />

<!-- STYLES -->
<link rel="stylesheet" type="text/css" href="css/superfish.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/fontello/fontello.css" />
<link rel="stylesheet" type="text/css" href="css/flexslider.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/ui.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/960.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
    
    
<link rel="stylesheet" type="text/css" href="css/devices/1000.css" media="only screen and (min-width: 768px) and (max-width: 1000px)" />
<link rel="stylesheet" type="text/css" href="css/devices/767.css" media="only screen and (min-width: 480px) and (max-width: 767px)" />
<link rel="stylesheet" type="text/css" href="css/devices/479.css" media="only screen and (min-width: 200px) and (max-width: 479px)" />
<link href='http://fonts.googleapis.com/css?family=Merriweather+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]> <script type="text/javascript" src="js/customM.js"></script> <![endif]-->
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
        <script src="dist/sweetalert.min.js"></script>

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
            <div class="container">
            	<!-- Main Content -->
                
                <div class="breadcrumbs column">
                	<h2>ស្វែងរកពត៌មាន...  <span>"${requestScope.s_query}"</span>
                		<c:if test="${requestScope.filter.size()>0 }">
	                		<c:set value="${requestScope.filter.size() }" var="n"></c:set>
                			ប្រភេទ:
                			<c:forEach items="${requestScope.filter }" var="i">
								${i.module_type } 
								<c:if test="${n>1 }">,
									<c:set value="${n-1 }" var="n"></c:set>
								</c:if>
								&nbsp;	
                			</c:forEach>
                		</c:if>
                	</h2>
                </div>
                
                <div class="main-content">
                   
                    
                    <!--list news-->
                    <div class="wrap-news" id="news">
												<c:set var="result" value="${requestScope.result }"></c:set>
								<c:forEach items="${result}" var="row">
									<div class="news-row column-two-third">
			                            <div class="items">
			                               <img src="${row.news_img }" />
			                                <a href="news?id=${row.news_id }" target="_blank">
			                                	<h5>${row.news_title }</h5>
			                                </a>
			                                <p>${fn:substring(row.news_desc,0,100) }</p>
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
			                            </div>  
			                        </div>
								</c:forEach>
                    </div>
                    
                     <!--pager-->
                    <div id="pager" class="pager" style="float:right">
                    	<ul>
                    		<c:if test="${requestScope.current_page>1 }">
	                    		<li><a href="${fn:substring(requestScope.title_id, 0 , requestScope.title_id.length()-1) }?page=">First</a></li>
                    		</c:if>
                    		<c:if test="${requestScope.current_page>1 }">
	                    		<li><a href="${fn:substring(requestScope.title_id, 0 , requestScope.title_id.length()-1)}?page=${requestScope.current_page-1}">Prev</a></li>
                    		</c:if>
							<c:set value="${requestScope.page_number }" var="total_page"></c:set>
							<c:choose>
								<c:when test="${total_page-requestScope.current_page<4 }">
									<c:set value="${total_page }" var="end"></c:set>
								</c:when>
								<c:otherwise>
									<c:set value="${requestScope.current_page+4 }" var="end"></c:set>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.current_page-4<=0 }">
									<c:set value="${1}" var="begin"></c:set>
								</c:when>
								<c:otherwise>
									<c:set value="${requestScope.current_page-4 }" var="begin"></c:set>
								</c:otherwise>
							</c:choose>
                        	<c:forEach begin="${begin }" end="${end}" var="i">
                        		<li><a id="${i }" href="${fn:substring(requestScope.title_id, 0 , requestScope.title_id.length()-1)}?page=${i}">${i }</a></li>
                        	</c:forEach>  
                        	<c:if test="${requestScope.current_page<total_page }">
	                    		<li><a href="${fn:substring(requestScope.title_id, 0 , requestScope.title_id.length()-1)}?page=${requestScope.current_page+1}">Next</a></li>
                    		</c:if>
                    		<c:if test="${total_page!=requestScope.current_page }">
	                    		<li><a href="${fn:substring(requestScope.title_id, 0 , requestScope.title_id.length()-1) }?page=${total_page}">Last</a></li>                  	
                    		</c:if>
                    	</ul>
                    </div>
                    <!--/pager-->
                    <!--/list news-->
                </div>
                <!-- /Main Content -->
                
                <!-- Left Sidebar -->
                <div class="column-one-third">
                    <div class="sidebar">
                    	<!-- List News by category -->
                        <div class="column-one-third">
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
	$("#${requestScope.current_page}").addClass("active");
	function save(news_id){
		if('${sessionScope.user_id}'==''){
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
