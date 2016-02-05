<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<title>Insert title here</title>
<body>

	<h1>
		Welcome to
		<%=request.getContextPath()%>
		@
		<%=new java.util.Date()%>
	</h1>
	
    <form action="rest/fileupload" method="post" enctype="multipart/form-data">
       <p>
        Choose a file : <input type="file" name="file" />
       </p>
       <input type="submit" value="Upload" />
    </form>

</body>
</html>