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
						<c:set var="duration" value="${applicationScope.autoscan }"></c:set>
						
						<c:choose>
							<c:when test="${duration==null || duration==0 }">
								<li>
									<a style="display:none;" class="scanning">
										<img src="../../assets/img/load.gif" width="70%"/>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a style="display:inline;" class="scanning">
										<img src="../../assets/img/load.gif" width="70%"/>
									</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<li>
							<a href="#contact" style="margin-right:37px" data-toggle="modal">
								<div class="gui-icon"><i class="md md-settings"></i></div>
							</a>
							
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
					
						<c:set value="${sessionScope.ka_user }" var="user"></c:set>
						
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle ink-reaction" data-toggle="dropdown">
								<img src="../../assets/img/avatar1.jpg?1403934956" alt="" />
								
								<span class="profile-info">${user.username }
								<c:choose>
									<c:when test="${user.usertypeid==5 }">
										<small>Administrator</small>
									</c:when>
									<c:when test="${user.usertypeid==3 }">
										<small>Editor</small>
									</c:when>
								</c:choose>
								
								</span>
							</a>
							<!-- <div style="height:0px;overflow:hidden">
				  				<input type="file" id="fileInput" name="fileInput" />
							</div> -->
							<ul class="dropdown-menu animation-dock">
								<li><button style="background-color:transparent;border:none;padding-left:19px" onclick="changepassword('${user.userid }');"><i class="md md-local-see"></i> Change Password</button></li>
								<li class="divider"></li>
								<li><a href="../../../user/signout"><i class="fa fa-fw fa-power-off text-danger"></i> Logout</a></li>
							</ul><!--end .dropdown-menu -->
						</li><!--end .dropdown -->	
					</ul><!--end .header-nav-profile -->
					
				</div><!--end #header-navbar-collapse -->
				
			</div>
		</header>