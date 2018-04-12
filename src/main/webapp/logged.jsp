<%-- 
    Document   : logged
    Created on : 12/04/2018, 00:39:58
    Author     : rafae
--%>

<%@page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" import="entities.User" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="dao.ImageDAO" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>JSP Page</title>
    </head>
    <body>
        <% User currentUser = (User)session.getAttribute("loggedUser");%>
        <h1>Welcome <%= currentUser.getNome() %></h1>

        <c:forEach var="row" items="${images}">
            <img src="${row.key}" width="400px"> <br/> 
            ${row.value}
            <br/><br/>
        </c:forEach>
    </body>
</html>
