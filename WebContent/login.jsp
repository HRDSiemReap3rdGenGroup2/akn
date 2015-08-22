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
<meta name="author" content="KhmerAcademy">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>All Khmer News</title>

<link rel="shortcut icon" href="img/sms-4.ico" />

<!-- STYLES -->
<link rel="stylesheet" type="text/css" href="css/superfish.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/fontello/fontello.css" />
<link rel="stylesheet" type="text/css" href="css/flexslider.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/ui.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />
<link rel="stylesheet" type="text/css" href="css/960.css" />
<link rel="stylesheet" type="text/css" href="css/devices/1000.css" media="only screen and (min-width: 768px) and (max-width: 1000px)" />
<link rel="stylesheet" type="text/css" href="css/devices/767.css" media="only screen and (min-width: 480px) and (max-width: 767px)" />
<link rel="stylesheet" type="text/css" href="css/devices/479.css" media="only screen and (min-width: 200px) and (max-width: 479px)" />
<link href='http://fonts.googleapis.com/css?family=Merriweather+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
        <script src="dist/sweetalert.min.js"></script>
<!--[if lt IE 9]> <script type="text/javascript" src="js/customM.js"></script> <![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

</head>

<body>
<c:if test="${sessionScope.user!=null }">
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
            <div class="container">
            	<!-- Main Content -->
                <div class="main-content">
                    <div class="column">
                    	<h5 class="line"><span>ចូលប្រើប្រាស់</span></h5>
                        <!--form login+sign up-->
                        <div class="form-area">
                        <div class="form" style="float:none">
                              <ul class="tab-group">
                                <li class="tab active"><a href="#login">Log In</a></li>
                                <li class="tab"><a href="#signup">Sign Up</a></li>
                              </ul>

                              <div class="tab-content">
	                              <div id="login">   
	                                  <h1>Login</h1>
	                                  <div>
	                                      <div class="field-wrap">
	                                          <label>Email Address<span class="req">*</span></label>
	                                          <input type="email"required autocomplete="off" id="email"/>
	                                      </div>
	                                      <div class="field-wrap">
	                                         <label>Password<span class="req">*</span></label>
	                                         <input type="password"required autocomplete="off" id="password"/>
	                                      </div>
	                                      <p class="forgot"><a href="#">Forgot Password?</a></p>
	                                      <button onclick="login()" class="button button-block">Log In</button>
	                                  </div>
	                                </div>
                                <div id="signup">   
                                  <h1>Sign Up for Free</h1>
                                   <div ng-app="app">
								  	<div ng-controller="homeCtrl">
	                                  <div name="signupForm">
										  <div class="field-wrap">
											<label>Username<span class="req">*</span></label> 
											<input type="text" required autocomplete="off" id="username"/>
										  </div>
										  <div class="field-wrap">
	                                        <label>Email Address<span class="req">*</span></label>
	                                        <input type="email"required autocomplete="off" id="Semail"/>
	                                      </div>
	                                      <div class="field-wrap" ng-class="{'has-error':formData.password.$invalid && !formData.password.$pristine}">
	                                       <label>Password<span class="req">*</span></label> 
	                                        <input type="password" id="Spassword" ng-model="formData.password" ng-minlength="8" ng-maxlength="20" ng-pattern="/(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z])/" required />
										        <p ng-show="signupForm.password.$error.minlength" class="error">
										          Passwords must be between 8 and 20 characters.</p>
										        <p ng-show="signupForm.password.$error.pattern" class="error">
										          Must contain one lower &amp; uppercase letter, and one non-alpha character (a number or a symbol.)</p>
	                                      </div>
	                                      <div class="field-wrap" ng-class="{'has-error':formData.password_c.$invalid && !formData.password_c.$pristine}">
	                                        <label>Confirm Password<span class="req">*</span></label>
	                                        <input type="password" id="Spassword_c" ng-model="formData.password_c" valid-password-c="formData.password" required />
	                                        <p ng-show="signupForm.password_c.$error.noMatch" class="error">Passwords do not match.</span>
	                                      </div>
	                                      <div class="field-wrap">
											    <select id="gender">
											        <option selected value="" disabled> Select Gender </option>
											        <option value="1">Male</option>
											        <option value="2">Female</option>
											    </select>
	                                      </div>
	                                      <button onclick="signup()" class="button button-block">Sign Up</button>
	                                  </div><!-- /form signup-->
	                                </div>
                              </div>
                        </div>
                        </div>
                        <!--/form login+sign up--> 
                    </div>    
                </div>
                <!-- /Main Content -->
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
<!-- <script type="text/javascript" src="js/mypassion.js"></script> -->
<script>
var app = angular.module('app', []);
app.directive('validPasswordC', function() {
  return {
    require: 'ngModel',
    scope: {
      reference: '=validPasswordC'
    },
    link: function(scope, elm, attrs, ctrl) {
      ctrl.$parsers.unshift(function(viewValue, $scope) {
        var noMatch = viewValue != scope.reference
        ctrl.$setValidity('noMatch', !noMatch)
      });
      scope.$watch("reference", function(value) {;
        ctrl.$setValidity('noMatch', value === ctrl.$viewValue);
      });
    }
  }
});

app.controller('homeCtrl', function($scope) {});
$("#password").keypress(function(e) {
    if(e.which == 13) {
       login();
    }
});
function login(){
$.post("user/login",{
	email:$("#email").val(),
	password:$("#password").val()
},function(data){
	if(data=="failed"){
		swal("Invalid", "Either email or password invalid", "error");   
	}else{
		window.location.href = "home";
	}
});
}
function signup(){
	$.post("user/signup",{
		username:$("#username").val(),
		email:$("#Semail").val(),
		password:$("#Spassword").val(),
		password_c:$("#Spassword_c").val(),
		gender:$("#gender :selected").val()
	},function(data){
		if(data=="e1"){
			swal("Error!", "","error");
		}else if(data=="e2"){
			swal("Invalid information!", "","error");
		}else if(data=="e3"){
			swal("Password and confirm password is not the same!","","error");
		}else if(data=="e4"){
			swal("Please select gender!", "","error");
		}else if(data=="e5"){
			swal("Email address either invalid or already existed!","","error");
		}else if(data=="success"){
			swal({title:"",text:"Your account is created successfully!",type:"success"},function(isConfirm){
				window.location.href="home";
			});
		}
	});
}
</script>
</body>
</html>
