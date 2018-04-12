<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${user.getNome()}</h1>

        <c:forEach var="image" items="${images}">
            <img src="${image.getUrl()}" width="400px"> <br/> 
            ${image.getCreate_time()}
            <br/><br/>
        </c:forEach>

        <form action="image" method="POST" enctype="multipart/form-data">
            <input type="file" name="imagem" />
            <input type="submit" value="Postar"/>
        </form>
    </body>
</html>
