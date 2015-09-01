<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${sessionScope.ka_user }" var="user"></c:set>
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
        		<c:when test="${user.user_gender=='male'}">
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
}
</script>