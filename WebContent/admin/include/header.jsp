<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<header id="header" >
			<div class="headerbar">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand" >
							<div class="brand-holder">
								<a href="dashboard">
									<span class="text-lg text-bold text-primary">NEWS ADMIN</span>
								</a>
							</div>
						</li>
						<li>
							<a class="btn btn-icon-toggle menubar-toggle" data-toggle="menubar" href="javascript:void(0);">
								<i class="fa fa-bars"></i>
							</a>
						</li>
					</ul>
				</div>
				
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="headerbar-right">
					<ul class="header-nav header-nav-options">
						<li>
							<!-- Search form -->
							<form class="navbar-search" role="search">
								<div class="form-group">
									<input type="text" class="form-control" name="headerSearch" placeholder="Enter your keyword">
								</div>
								<button type="submit" class="btn btn-icon-toggle ink-reaction"><i class="fa fa-search"></i></button>
							</form>
						</li>
						
					</ul><!--end .header-nav-options -->
					<ul class="header-nav header-nav-profile">
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle ink-reaction" data-toggle="dropdown">
								<img src="../../assets/img/avatar1.jpg?1403934956" alt="" />
								
								<span class="profile-info">${sessionScope.user }
								<c:choose>
									<c:when test="${sessionScope.user_type==1 }">
										<small>Administrator</small>
									</c:when>
									<c:when test="${sessionScope.user_type==2 }">
										<small>Editor</small>
									</c:when>
								</c:choose>
								
								</span>
							</a>
							<div style="height:0px;overflow:hidden">
				  				<input type="file" id="fileInput" name="fileInput" />
							</div>
							<ul class="dropdown-menu animation-dock">
								<li><button style="background-color:transparent;border:none;padding-left:19px" onclick="chooseFile();"><i class="md md-local-see"></i> Change Profile</button></li>
								<li><a href="changeusername?user_id=${sessionScope.user_id }&username=${sessionScope.user}"><i class="md md-edit"></i> Change Username</a></li>
								<li><a href="changepassword?user_id=${sessionScope.user_id }"><i class="md md-https"></i> Change Password</a></li>
								<li class="divider"></li>
								<li><a href="../../../user/signout"><i class="fa fa-fw fa-power-off text-danger"></i> Logout</a></li>
							</ul><!--end .dropdown-menu -->
						</li><!--end .dropdown -->	
					</ul><!--end .header-nav-profile -->
					
				</div><!--end #header-navbar-collapse -->
				
			</div>
		</header>