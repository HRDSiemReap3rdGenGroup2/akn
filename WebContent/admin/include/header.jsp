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
									<span class="text-lg text-bold text-primary">AKN News</span>
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
						
						<!-- <li>
							Search form
							<form class="navbar-search" role="search">
								<div class="form-group">
									<input type="text" class="form-control" name="headerSearch" placeholder="Enter your keyword">
								</div>
								<button type="submit" class="btn btn-icon-toggle ink-reaction"><i class="fa fa-search"></i></button>
							</form>
						</li> -->
						
						<li>
							<a href="#contact" style="margin-right:37px" data-toggle="modal">
								<div class="gui-icon"><i class="md md-settings"></i></div>
							</a>
							
							<c:set var="duration" value="${applicationScope.autoscan }"></c:set>
							
							<!-- Modal -->
							  <div class="modal fade" id="contact" role= "dialog">
							    	<div class="modal-dialog">
							        	<div class="modal-content">
							               	<div class="form-horizontal">
							            		<div class="modal-header">
							                    	 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
							                		<h4>Auto Scan News</h4>
							                	</div>
							                	<div class="modal-body">
							                    	<div class="form-group">
							                    		<label for="contact-name" class="col-lg-2 control-label">Duration : </label>
							                            <div class="col-lg-10">
							                            	<select id="duration" name="select2" class="form-control">
																
																<c:choose>
																	<c:when test="${duration==null }">
																		<option value="0">Manually</option>
																		<option value="5">5 minutes</option>
																		<option value="60">1 hour</option>
																		<option value="1440">1 day</option>
																	</c:when>
																	<c:when test="${duration==0 }">
																		<option value="0">Manually</option>
																		<option value="5">5 minutes</option>
																		<option value="60">1 hour</option>
																		<option value="1440">1 day</option>
																	</c:when>
																	<c:when test="${duration==5 }">
																		<option value="5">5 minutes</option>
																		<option value="60">1 hour</option>
																		<option value="1440">1 day</option>
																		<option value="0">Manually</option>		
																	</c:when>
																	<c:when test="${duration==60 }">
																		<option value="60">1 hour</option>
																		<option value="1440">1 day</option>
																		<option value="5">5 minutes</option>
																		<option value="0">Manually</option>
																	</c:when>																	
																	<c:when test="${duration==1440 }">
																		<option value="1440">1 day</option>
																		<option value="5">5 minutes</option>
																		<option value="60">1 hour</option>
																		<option value="0">Manually</option>
																	</c:when>
																</c:choose>
																
															</select>
							                            </div>
							                        </div>
							                	</div>
							                	<div class="modal-footer">
							                		<a class="btn btn-default" data-dismiss="modal">Cancel</a>
							                    	<button class="btn btn-primary"  data-dismiss="modal" id="btnsave">Save</button>
							                	</div>
							               	</div>
							            </div>
							        </div>
							    </div>
								<!--end modal  -->
						</li>	
						
					</ul><!--end .header-nav-options -->
					<ul class="header-nav header-nav-profile">
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle ink-reaction" data-toggle="dropdown">
								<img src="../../assets/img/avatar1.jpg?1403934956" alt="" />
								
								<span class="profile-info">${sessionScope.user.user_name }
								<c:choose>
									<c:when test="${sessionScope.user.user_type==1 }">
										<small>Administrator</small>
									</c:when>
									<c:when test="${sessionScope.user.user_type==2 }">
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
								<li><a href="changeusername?user_id=${sessionScope.user.user_id }&username=${sessionScope.user.user_name}"><i class="md md-edit"></i> Change Username</a></li>
								<li><a href="changepassword?user_id=${sessionScope.user.user_id }"><i class="md md-https"></i> Change Password</a></li>
								<li class="divider"></li>
								<li><a href="../../../user/signout"><i class="fa fa-fw fa-power-off text-danger"></i> Logout</a></li>
							</ul><!--end .dropdown-menu -->
						</li><!--end .dropdown -->	
					</ul><!--end .header-nav-profile -->
					
				</div><!--end #header-navbar-collapse -->
				
			</div>
		</header>