<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Feed">
    <jsp:body>
        <div class="center">
            <h1>feed</h1>
            <form action="image" method="POST" enctype="multipart/form-data">
                <h4>Postar Imagem</h4>
                <input type="file" name="imagem" accept="image/*" />
                <input type="submit" value="Postar"/>
            </form>
            <form action="/feed" method="get" enctype="multipart/form-data">
                <h4>Pesquisar:</h4>
                <input type="text" placeholder="Digite um nome de usuário ou imagem" name="q" />
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