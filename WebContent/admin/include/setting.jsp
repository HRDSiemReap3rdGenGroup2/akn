<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
		
<script>
       	$('#btnsave').click(function(){
       		if($('#duration option:selected').val()==0){
       			$.post('stopscan',function(){
       				swal("Done!","Autoscan will terminated the process after the last scan is completed!","success");
       				$(".scanning").css("display","none");
       			});
       		}
       		else{
       			swal("Scanning","Starting Scanning","success");
       			$(".scanning").css("display","inline");
				$.post('updatescanduration',{duration:$('#duration option:selected').val()},function(){});
       		}
		});
       	
       	function changepassword(user_id){
       		swal({   title: "Change Password",   
      			 text: "Input news password..!",   
      			 type: "input",   showCancelButton: true, 
      			 inputType: "password",
      			 closeOnConfirm: false,   animation: "slide-from-top",   
      			 inputPlaceholder: "news password" 
      			 }, function(inputValue){   
      				 if (inputValue === false) return false;      
      				 if (inputValue === "") {     
      					 swal.showInputError("Please input password..!");     
      					 return false;   
      				 }  
      				 $.post('changepassword',{id:user_id, password:inputValue },function(data){
      					swal("Success", "Updated Successfully!", "success"); 
      				 });
      				 
      				 
      		});
       	}
       	
       	
</script>