<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
</head>
<style>
    .Bo{background-color: rgb(233, 230, 223);
    width: 17.5cm;
    border-radius: 1cm;
    padding: 1cm;
    box-shadow: 10px 10px 10px black;}

    .bog{
        width: 20cm;
        border-radius: 20px;
    }

    body{background-color: #3AAFA9 ;
    color:black;
    margin-top: 5cm;
    font-size: 4em;
    font-weight: bold;}

    #email {height: 3em;
        font-size: 18px;
        margin-right: 4.5em;}
    #pass {height: 3em;
        font-size: 18px;}
    #login{height: 2.5em;
        font-size: 18px;}
    #submit{height: 2.5em;
        font-size: 18px;}
        
    input{
	  font-size: 16px;
	  width: 100%;
	  padding: 12px 10px;
	  border: 0;
	  outline: none;
	  border-radius: 5px;
	}
	
	.add{
	    width: 350px;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%,-50%);
	    position: absolute;
	    color: #000000;
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
    <Center>
    	<div class="add">
	    	<form action="check">
	    		<input type="text" name="name" placeholder="Name" size="30">
	    		<input type="password" name="pw" placeholder="Password" size="30">
	    		<input type="submit" id="btn" value=" Submit "/>
	    	</form>
    	</div>
    	
    </Center>
</body>
</html>