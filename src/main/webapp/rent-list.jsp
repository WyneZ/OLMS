<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List JSP</title>
</head>
<style>
	table,th,td{
	    border: 2px solid black;
	}
	
	td,th{
	    padding: 15px;
	    text-align: center;	
	}
	
	body{
		font-size: 2em;;
	}
	
	header{
	    color: white;
	    background-color: brown;
	}
	
	nav{
	    display: flex;
	    padding: 20px;
	}
	
	#cap{
	    color: white;
	    text-decoration-line: none;
	    padding-right: 100px;
	    font-weight: bold;
	    font-size: larger;
	}
	
	#rList{
	    color: black;
	    font-size: 20px;
	    padding: 15px;
	}
	
	#btn{
	    height: 3em;
	    width: 7em;
	    font-size: 17px;
	    border-radius: 5px;
	    background-color: lightgreen;
	}
	
	#b{
		padding: 10px;
		border-radius: 10px;
		cursor: pointer;
		background-color: tomato;
		border-color: white;
		box-shadow: 5px 5px 5px black;
	}

</style>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	
		if(session.getAttribute("name") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
		
    <nav style="background-color: tomato">
		<div>
			<a href="" id="cap"> Library Management System </a>
		</div>

		<a href="<%=request.getContextPath()%>/rentList" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Rent List"></a>

        <a href="<%=request.getContextPath()%>/list" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Book List"></a>
        
        <a href="<%=request.getContextPath()%>/searchAuthor" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Search By Author"></a>
        
        <a href="<%=request.getContextPath()%>/logout" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Log Out"></a>
        
	</nav>
	
	<Center>
	    <h2>Rent List</h2>
		<table>
	        <thead>
	            <tr bgcolor="blue">
	                <th>Name</th>
	                <th>Roll no</th>
	                <th>Title</th>
	                <th>Author</th>
	                <th>Date</th>
	                <th>Action</th>
			    </tr>
	        </thead>
	
	        <tbody>
	        	<c:forEach var="user" items="${listUser}">
	        		<tr bgcolor="lightgrey">
		                <td><c:out value="${user.name}"/></td>
		                <td><c:out value="${user.roll_no}"/></td>
		                <td><c:out value="${user.title}"/></td>
		                <td><c:out value="${user.author}"/></td>
		                <td><c:out value="${user.date}"/></td>
		                <td><a href="deleteUser?id=<c:out value='${user.id}' />">Delete</a></td>
				    </tr>
	        	</c:forEach>
	        </tbody>
	
		    <br><br>
		</table>
	</Center>

</body>
</html>