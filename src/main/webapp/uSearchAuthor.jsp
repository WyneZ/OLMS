<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{align-items: center;
	}

	table,th,td{
	    border: 2px solid black;
	}
	
	td,th{
	    padding: 15px;
	    text-align: center;	
	}
	
	body{
		font-size: 2em;
		background-color: tomato;
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
	  color: #fff;
	  font-size: 18px;
	  font-weight: bold;
	  margin: 20px 0;
	  padding: 10px 15px;
	  width: 5%;
	  border-radius: 5px;
	  border: 0;
	  background-color: #27a327;
	  box-shadow: 2px 2px 2px black;
	  cursor: pointer;
	}
	
	#b{
		padding: 10px;
		border-radius: 10px;
		cursor: pointer;
		background-color: tomato;
		border-color: white;
		box-shadow: 5px 5px 5px black;
	}
	
	#aName{
		box-shadow: 5px 5px 5px black;
		height: 1cm;
		width: 15%;
		border-radius: 7px;
		text-align: center;
		font-size: 20px;
	}

</style>
<body>

	<nav style="background-color: tomato">
		<div>
			<a href="" id="cap"> Library Management System </a>
		</div>

        <a href="<%=request.getContextPath()%>/user" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Book List"></a>
        
        <a href="<%=request.getContextPath()%>/uSearchAuthor" id="rList" style="text-decoration:none;
        color=white;"><input type="button" id="b" value="Search By Author"></a>
        
	</nav>
	
	<Center>
		<form action="uSearchAuthor" method="post">
	    	<input type="text" name="author" id="aName" placeholder="Name"/>
	        <br>
	       	<center>
	        	<input type="submit" id="btn" value="Search"/>
	        </center>
	    </form>
	            
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
		    	<c:forEach var="book" items="${authorList}">
		        	<tr bgcolor="lightgrey">
			        	<td><c:out value="${book.bookId}"/></td>
			        	<td><c:out value="${book.title}"/></td>
			        	<td><c:out value="${book.author}"/></td>
			            <td><c:out value="${book.category}"/></td>
			          	<c:if test="${book.valid == 1.0}">
		                	<td>yes</td>
		               		<td><a href="rent?id=<c:out value='${book.id}' />">Rent</a></td>
		                </c:if>
		                <c:if test="${book.valid == 0.0}">
		                	<td>no</td>
		                	<td>Rent</td>
		                </c:if>
					</tr>
		    	</c:forEach>
		    </tbody>
			<br><br>
		</table>
	</Center>
            
            
    
    

</body>
</html>