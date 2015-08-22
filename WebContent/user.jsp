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

<title> ${requestScope.user.user_name } | AKNnews</title>

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
        margin-top: 20px;
    }
    .wrap-news p{
        margin-bottom: 6px;
    }
</style>
</head>

<body>
<c:set value="${requestScope.user }" var="user"></c:set>
<c:if test="${user==null }">
	<c:redirect url="home"></c:redirect>
</c:if>
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
                    <div class="sidebar" style="font-family:'Khmer OS Content';font-size:14px">
                        
                        <h5 class="user-profile"><span>User Profile</span></h5>
                        <div id="accordion">
                            <h3 id="user-general" style="margin-top:15px">General</h3>
                            <div>
                            </div>
                            
                            <h3 id="save-news">Saved News</h3>
                            <div>
                                <ul class="all-category" id="save-news-li">
                                    <c:set value="${requestScope.savedlist }" var="savedlist"></c:set>
	                            	<c:forEach items="${savedlist }" var="i">
	                            		<li><a onclick="myfun(${i.news_id}})">${i.news_title }</a></li>
	                            	</c:forEach>
                                </ul>
                            </div>
                        
                            <h3 id="subscribe-list">Subscribe List</h3>
                            <div>
                            	<ul class="all-category" id="subscribe-li">
                            	<c:set value="${requestScope.subscribelist }" var="subscribelist"></c:set>
                            	<c:forEach items="${subscribelist }" var="i">
                            		<li><a onclick="unsubscribe(${i.module_id}})">${i.module_name }</a></li>
                            	</c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>    
                </div>
                <!--/left sidebar-->
                
                <!--main-content-->
                <div class="main-content">
                    <div class="column-three-fourth" id="display-user">
                        <h5 class="user-profile"><span>General User Setting</span>
                        	<button style="float:right;margin-top:2px;background-color:#e8484c" id="update-user-info">Update Info</button>
                        </h5>
                        <table class="table">
                            <tr>
                                <td>Username</td>
                                <td id="username">${user.user_name }</td>
                                
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td id="password">********</td>
                                
                            </tr>
                            <tr>
                                <td>Email Address</td>
                                <td id="user-email">${user.user_email }</td>
                                
                            </tr>
                            <tr>
                                <td>Gender</td>
                                <td id="user-gender">
                                	<c:choose>
                                		<c:when test="${user.user_gender==1}">
                                			Male
                                		</c:when>
                                		<c:otherwise>
                                			Female
                                		</c:otherwise>
                                	</c:choose>
                                </td>
                                
                            </tr>
                            <tr>
                                <td colspan='3'><a onclick="deactivate()" style="color:#f00">Deactivate</a></td>
                            </tr>
                        </table>
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
	$("#update-user-info").click(function(){
		if($("#update-user-info").text()!='Save'){
			$("#update-user-info").text("Save");
			var tmp=$("#username").text();
			$("#username").html("<input id='input-username' type='text' value='"+tmp+"' style='border:1px solid #000'/>");
			$("#password").html("<input id='input-password' type='password' value='********' style='border:1px solid #000'/>");
			$("#user-gender").html("<select id='input-gender'><option value='1'>Male</option><option value='2'>Female</option></select>");
		}else{
			var n=$("#input-username").val();
			var p=$("#input-password").val();
			var g=$("#input-gender").val();
			$.post("updateuserinfo",{
				username:n,
				password:p,
				gender:g
			},function(data){
				if(data=='success'){
					$("#username").html(n);
					$("#password").html("********");
					var tmp="Male";
					if(g==2){
						tmp="Female";
					}
					$("#user-gender").html(tmp);
					swal("Done!", "Your information updated!", "success")
				}else{
					swal("Error!", "Error updating your infomation!", "error")
				}
				$("#update-user-info").text("Update Info");
			});
		}
	});
	function deactivate(){
		swal({  
			title: "Are you sure?",  
					text: "You're about to delete your account!", 
					type: "warning", 
					showCancelButton: true, 
					confirmButtonColor: "#DD6B55", 
					confirmButtonText: "Yes", 
					cancelButtonText: "No",  
					closeOnConfirm: false, 
					closeOnCancel: false 
			},
					function(isConfirm){   
						if (isConfirm) {
								$.post("deleteaccount",function(data){
									if(data=='success'){
										swal({title:"Success!", text:"Your account has been deleted.", type:"success"},function(isConfirm){
											window.location.href="home";
										});
									}else{
										swal("Error!", "Cannot delete", "error");
									}
								});
							} else {  
								swal("Phew!");  
							} 
					}
			);
	}
</script>
</body>
</html>
