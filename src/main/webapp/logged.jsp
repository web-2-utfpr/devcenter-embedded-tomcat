<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        <title>Home</title>
    </jsp:attribute>

    <jsp:body>
        <h1>Welcome ${user.getNome()}</h1>
        <h4>Postar Imagem</h4>
        <form action="image" method="POST" enctype="multipart/form-data">
            <input type="file" name="imagem" accept="image/*" />
            <input type="submit" value="Postar"/>
        </form>
        <c:forEach var="image" items="${images}">
            <img src="${image.getUrl()}" width="400px"> <br/> 
            ${image.getCreate_time()}
            <br/><br/>
        </c:forEach>
    </jsp:body>
</t:wrapper>