<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rent Book</title>
    <link rel="stylesheet" href="addbook.css">
</head>
<style>
	*{
	    padding: 0;
	    margin: o;
	    font-family: sans-serif;
	}
	
	body{
	    background: url(https://ninenovelhome.files.wordpress.com/2022/05/parts-of-the-book.jpeg);
	    background-size: cover;
	}
	
	.add{
	    width: 350px;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%,-50%);
	    position: absolute;
	    color: #000000;
	}
	
	.add h1{
	  font-size: 40px;
	  text-align: center;
	  text-transform: uppercase;
	  margin: 40px 0;
	}
	
	.add p{
	  font-size: 20px;
	  margin: 15px;
	}
	
	.add input{
	  font-size: 16px;
	  width: 100%;
	  padding: 12px 10px;
	  border: 0;
	  outline: none;
	  border-radius: 5px;
	}
	
	#btn{
	  color: #fff;
	  font-size: 18px;
	  font-weight: bold;
	  margin: 20px 0;
	  padding: 10px 15px;
	  width: 50%;
	  border-radius: 5px;
	  border: 0;
	  background-color: #27a327;
	}
</style>
<body>
    <div class="add">
            <h1>Rent Book</h1>
            <form action="insertUser" method="post">
                <p>Name</p>
                <input type="text" name="name" placeholder="Name"/>	
                <p>Roll No</p>
                <input type="text" name="roll_no" placeholder="Roll no"/>
                <p>Title</p>
                <input type="text" name="title" placeholder="Title" value="${b.title}"/>	
                <p>Author</p>
                <input type="text" name="author" placeholder="Author" value="${b.author}">
                <p>Date</p>
                <input type="text" name="date" placeholder="Date" value ="<%= (new java.util.Date()).toLocaleString()%>"/>	
                <br>
              <center>
                <input type="submit" id="btn" value="Submit"/>
              </center>
            </form>
    </div>
</body>
</html>