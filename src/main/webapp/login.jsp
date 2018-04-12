<%-- 
    Document   : login
    Created on : 12/04/2018, 00:23:23
    Author     : rafae
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256"> 
        <title>Login Page</title> 
    </head> 
    <body> 
        <form action="login" method="POST"> 
            Please enter your username <input type="text" name="nome" required/><br> 
            Please enter your password <input type="text" name="senha" required/> 
            <input type="submit" value="submit"> 
        </form> 
    </body> 
</html>
