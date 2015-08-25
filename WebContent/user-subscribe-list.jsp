<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<c:set value="${sessionScope.user }" var="user"></c:set>
<h5 class="user-profile"><span>Subscribed news</span></h5>
<div class="main-content">
<div class="column-three-fourth">
<div class="wrap-news">
    
</div>
</div>
</div>
<script>
listNews();
function listNews(){
	$.post("getsubscribelist",{
		user_id:'${user.user_id}'
	},function(data){
		if(data.length==0){
			swal("You're not yet subscribe any category!");
		}
		var str="";
		for(var i=0;i<data.length;i++){
			str+="<div class='news-row' style=''>"
		    +"<a href='category?id="+data[i].category_id+"' target='_blank'>"
		    +"<h5 style='height:50px;overflow:hidden'>"+data[i].category_name+"</h5>"
		    +"</a>"
		    +"<button style='background-color:#E9967A' onclick='unsubscribe("+data[i].category_id+")' id='"+data[i].news_id+"'>Unsubscribe</button>"
		    +"</div>"	
		}
		$(".wrap-news").html(str);
	});	
}
function unsubscribe(category_id){
	swal({  
		title: "Are you sure?",  
				text: "", 
				type: "warning", 
				showCancelButton: true, 
				confirmButtonColor: "#DD6B55", 
				confirmButtonText: "Yes", 
				closeOnConfirm: false 
		},
				function(isConfirm){   
					if (isConfirm) {
							$.post("unsubscribenews",{category_id:category_id},function(data){
								if(data=='success'){
									swal({title:"Success!", text:"", type:"success"},function(isConfirm){
										listNews();
									});
								}else{
									swal("Error!", "", "error");
								}
							});
						}
				}
		);
}
</script>
</body>
</html>