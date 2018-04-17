<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="windows-1256" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="My Images">
    <jsp:attribute name="header">
        <title>Home</title>
    </jsp:attribute>

    <jsp:body>
        <div class="center">
            <h3>${user.getNome()}`s feed</h1>
            <form action="image" method="POST" enctype="multipart/form-data">
                <h4>Postar Imagem</h4>
                <input type="file" name="imagem" accept="image/*" required="true" />
                <input type="submit" value="Postar"/>
            </form>
            </br>
            <c:forEach var="image" items="${images}">
                <img src="${image.getUrl()}" width="400px"> <br/> 
                ${image.getCreate_time()}
                <br/><br/>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>