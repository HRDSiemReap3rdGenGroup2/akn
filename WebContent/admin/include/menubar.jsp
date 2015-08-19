<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menubar" class="menubar-inverse ">
	<div class="menubar-fixed-panel">
		<div>
			<a class="btn btn-icon-toggle btn-default menubar-toggle" data-toggle="menubar" href="javascript:void(0);">
				<i class="fa fa-bars"></i>
			</a>
		</div>
		<div class="expanded">
			<a href="dashboard">
				<span class="text-lg text-bold text-primary ">NEWS&nbsp;ADMIN</span>
			</a>
		</div>
	</div>
	<div class="menubar-scroll-panel">
		
		<c:set value="${ sessionScope.user_type}" var="usertype"></c:set>
		
		<!-- BEGIN MAIN MENU -->
		<ul id="main-menu" class="gui-controls">

			<!-- BEGIN DASHBOARD -->
			<li id="dashboard">
				<a href="dashboard" >
					<div class="gui-icon"><i class="md md-home"></i></div>
					<span class="title">Dashboard</span>
				</a>
			</li><!--end /menu-li -->
			<!-- END DASHBOARD -->

			<!-- BEGIN NEWS -->
			<li class="gui-folder" id="news">
				<a>
					<div class="gui-icon"><i class="md md-cast-connected"></i></div>
					<span class="title">News</span>
				</a>
				<!--start submenu -->
				<ul>
					<li><a href="formnews" ><span class="title">Add News</span></a></li>
					<li><a href="listnews" ><span class="title">List News</span></a></li>
				</ul><!--end /submenu -->
			</li><!--end /menu-li -->
			<!-- END NEWS -->
			
			<!-- BEGIN CATEGORY -->
			<li class="gui-folder" id="categorymenu">
				<a>
					<div class="gui-icon"><i class="md md-apps"></i></div>
					<span class="title">Category</span>
				</a>
				<!--start submenu -->
				<ul>
					<li><a href="formmodule" ><span class="title">Add Category</span></a></li>
					<li><a href="listmodule" ><span class="title">List Category</span></a></li>
				</ul><!--end /submenu -->
			</li><!--end /menu-li -->
			<!-- END CATEGORY -->
			
			
			<c:if test="${usertype==1 }">
				<!-- BEGIN USER -->
				<li class="gui-folder" id="usermenu">
					<a>
						<div class="gui-icon"><i class="md md-people"></i></div>
						<span class="title">User</span>
					</a>
					<!--start submenu -->
					<ul>
						<li><a href="formuser" ><span class="title">Add User</span></a></li>
						<li><a href="listuser" ><span class="title">List User</span></a></li>
					</ul><!--end /submenu -->
				</li><!--end /menu-li -->
				<!-- END USER -->
			</c:if>
			
			<!-- BEGIN MENU -->
			<li class="gui-folder" id="menu">
				<a>
					<div class="gui-icon"><i class="md md-menu"></i></div>
					<span class="title">Menu</span>
				</a>
				<!--start submenu -->
				<ul>
					<li><a href="fixedmenu" ><span class="title">Fixed Menu</span></a></li>
				</ul><!--end /submenu -->
			</li><!--end /menu-li -->
			<!-- END MENU -->
			
			<!-- BEGIN RECOMENDATION -->
			<li class="gui-folder" id="mailmenu">
				<a>
					<div class="gui-icon"><i class="md md-mail"></i></div>
					<span class="title">Mail</span>
					<!--start submenu -->
				</a>
				<ul>
					<li><a href="compose" ><span class="title">Send Mail</span></a></li>
				</ul><!--end /submenu -->
			</li><!--end /menu-li -->
			<!-- END RECOMENDATION -->
			
		</ul><!--end .main-menu -->
		<!-- END MAIN MENU -->
	
		<div class="menubar-foot-panel">
			<small class="no-linebreak hidden-folded">
				<span class="opacity-75">Copyright &copy; 2014</span> <strong>CodeCovers</strong>
			</small>
		</div>
	</div><!--end .menubar-scroll-panel-->

</div><!--end #menubar-->




