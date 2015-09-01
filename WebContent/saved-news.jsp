<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<c:set value="${sessionScope.ka_user }" var="user"></c:set>
<h5 class="user-profile"><span>Your Saved News</span></h5>
<div class="main-content">
<div class="column-three-fourth">
<div class="wrap-news">
    
			</div>
		</div>
	</div>
	<script>
	listNews();
	function listNews(){
		$.post("getsavednews",{
			user_id:'${user.user_id}'
		},function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				
				str+="<div class='news-row column-two-third' style='margin-left:0'>"
                +"<div class='items'>"
                +"<img src='"+data[i].news_img+"' style='height:170px'>"
                +"<a href='news?id="+data[i].news_id+"' target='_blank'><h5>"+data[i].news_title+"</h5></a>"
                +"<p class='publish-date'>"+data[i].news_date+"</p>"    
                +"<p>"+data[i].news_desc.substring(0,100)+"...</p>"
                +"<div>"
                +"<img src='img/logo/"+data[i].source_id+".png' style='width:20px;'>"
                +"<span style='color:#999'>Viewed:"+data[i].hit_count+"</span>"
				+"<button style='float:right;background-color:#E9967A' onclick='deleteNews("+data[i].news_id+")' id='"+data[i].news_id+"'>Delete</button>"
				+"</div>"
               	+"</div>"  
           		+"</div>";
			}
			$(".wrap-news").html(str);
		});	
	}
	function deleteNews(news_id){
		swal({  
			title: "Are you sure?",  
					text: "You're about to delete your saved news!", 
					type: "warning", 
					showCancelButton: true, 
					confirmButtonColor: "#DD6B55", 
					confirmButtonText: "Yes", 
					cancelButtonText: "No",  
					closeOnConfirm: false, 
					closeOnCancel: true 
			},
					function(isConfirm){   
						if (isConfirm) {
								$.post("deletesavednews",{news_id:news_id},function(data){
									if(data=='success'){
										swal({title:"Success!", text:"", type:"success"},function(isConfirm){
											listNews();
										});
									}else{
										swal("Error!", "Cannot delete", "error");
									}
								});
							} else {  
							} 
					}
			);
	}
	</script>
</body>
</html>