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
	
	table{
		border-radius: 10px;
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
	    <h2>Book List</h2>
	    <a href="<%=request.getContextPath()%>/new"><input id="btn" type="button" value="Add Book" width="100"/></a>
		<table>
	        <thead>
	            <tr bgcolor="blue">
	                <th>Book Id</th>
	                <th>Title</th>
	                <th>Author</th>
	                <th>Category</th>
	                <th>Valid</th>
	                <th>Action</th>
			    </tr>
	        </thead>
	
	        <tbody>
	        	<c:forEach var="book" items="${listBook}">
	        		<tr bgcolor="lightgrey">
		                <td><c:out value="${book.bookId}"/></td>
		                <td><c:out value="${book.title}"/></td>
		                <td><c:out value="${book.author}"/></td>
		                <td><c:out value="${book.category}"/></td>
		                <c:if test="${book.valid == 1.0}">
		                	<td>yes</td>
		                </c:if>
		                <c:if test="${book.valid == 0.0}">
		                	<td>no</td>
		                </c:if>
		                <td><a href="edit?id=<c:out value='${book.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="delete?id=<c:out value='${book.id}' />">Delete</a></td>
				    </tr>
	        	</c:forEach>
	        </tbody>
	
		    <br><br>
		</table>
	</Center>

</body>
</html>