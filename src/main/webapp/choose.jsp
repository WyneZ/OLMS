<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

	

	<center>
			<a href="<%=request.getContextPath()%>/login"><input type="submit" value="Admin"></a>
			<a href="<%=request.getContextPath()%>/user"><input type="submit" value="User"></a>
	</center>
	

</body>
</html>