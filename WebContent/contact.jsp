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

<title>Contact Us | AKNEWS</title>

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
            	
                <div class="breadcrumbs column">
                </div>
            
            	<!-- Main Content -->
                    
                    <!-- Single -->
                    <div class="column single">
                    	<div> <!-- id="map" -->
                    		<iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d3908.6955292162224!2d104.88844254841001!3d11.573670846684433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1shrd!5e0!3m2!1sen!2skh!4v1438855069228" width="100%" height="500px" frameborder="0" style="border:0" allowfullscreen></iframe>
                    	</div>
                    </div><!-- /Single -->
                    <div class="column-two-third">
                        	<h5 class="line"><span>ទីតាំងរបស់យើង</span></h5>
                            <p></p>
                            
                            <div class="contact-info">
                            	<p class="man"><i class="icon-location"></i>Creative Laboratory <br />77 New York Avenue, New York city, <br />USA 10000.</p>
                                <p class="phone"><i class="icon-phone"></i> Phone:  73 443 11 23. <br />Fax:  73 443 11 23.</p>
                                <p class="envelop"><i class="icon-mail"></i>Email: <a href="#">mail@page.com</a> <br /> Web: <a href="#">www.page.com</a></p> 
                            </div>
                    </div><!-- /.column-two-third -->
	                <div class="column-one-third">
                   		<h5 class="line"><span>ផ្តល់មតិយោបល់</span></h5><div class="contact-form">
	                        <form action="" method="post" id="contactForm" name="contactForm">
	                            <div class="form">
	                                <label>Name*</label>
	                                <div class="input">
	                                    <span class="name"></span>
	                                    <input type="text" class="name" name="yourname" id="yourname" style="color:#000;">
	                                </div>
	                            </div>
	                            <div class="form">
	                                <label>Email*</label>
	                                <div class="input">
	                                    <span class="email"></span>
	                                    <input type="text" class="name" name="email" id="email" style="color:#000;">
	                                </div>
	                            </div>
	                            <div class="form">
	                                <label>Subject*</label>
	                                <div class="input">
	                                    <span class="website"></span>
	                                    <input type="text" class="name" name="tele" id="tele" style="color:#000;">
	                                </div>
	                            </div>
	                            <div class="form">
	                                <label>Message*</label>
	                                <textarea name="message" style="width:278px;color:#000;"></textarea>
	                            </div>
	                            <div class="form2">
	                                <!--<input type="submit" class="send-message" value="Send Message" />-->
	                                <a href="javascript:submitForm();" class="send">Send Message</a>
	                            </div>
	                            
	                        </form>
	                        
	                        <div class="alertMessage"></div>
	                    </div>
	                </div><!-- /.column-one-third -->
	            </div>    
        </section>
        <!-- / Content -->
        
		<!--footer  -->
    	 <jsp:include page="includes/footer.jsp"></jsp:include>
    	<!--/footer  -->
    </div>
	</div>
</div>
<!-- / Body Wrapper -->

<!-- SCRIPTS -->
<script type="text/javascript" src="js/jquery.js"></script>
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
<script type="text/javascript" src="js/myscript.js"></script>

<!--[if lt IE 9]> <script type="text/javascript" src="js/html5.js"></script> <![endif]-->
<!-- <script type="text/javascript" src="js/mypassion.js"></script> -->

<!-- SCRIPTS -->

<!--[if lt IE 9]> <script type="text/javascript" src="js/html5.js"></script> <![endif]-->
<!-- <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script> -->
<!-- <script type="text/javascript" src="js/mypassion.js"></script> -->

</body>
</html>
