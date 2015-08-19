<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css">

</head>

<body>
	<table border="1" id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Extn.</th>
            </tr>
        </tfoot>
    </table>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="http://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
  
	<script>
	    $(document).ready(function() {
	      /*   $.post('listnews',function(data){
	        	$('#example').dataTable({
	                "ajax": data,
	                "columns": [
	                    { "data": "news_id" },
	                    { "data": "news_title" },
	                    { "data": "news_desc" },
	                    { "data": "news_date" }
	                ]
	            });
	        }); */
	        $.ajax({
	        	  type: 'POST',
	        	  url: "listnews",
	        	  dataType: "json",
	        	  contentType: "application/json"
	        });
	        
	    });
    </script>
    
    
    
</body>
</html>