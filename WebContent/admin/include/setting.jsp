<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
		
<script>
       	$('#btnsave').click(function(){
       		if($('#duration option:selected').val()==0){
       			$.post('stopscan',function(){
       				swal("Done!","Autoscan will terminated the process after last scan is completed!","success");
       			});
       		}
       		else{
       			swal("Scanning","Scanning Started..!","success");
				$.post('updatescanduration',{duration:$('#duration option:selected').val()},function(){});
       		}
		});
</script>