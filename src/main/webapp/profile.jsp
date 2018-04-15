<%@page language="java" contentType="text/html" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="${user.getNome()}'s feed">
    <jsp:body>
        <div class="row center feed">
            <h3 >${user.getNome()}'s  feed</h3>
            <c:forEach var="image" items="${images}">
                <div class="card">
                    <div class="card-image">
                        <img src="${image.getUrl()}" width="400px"> <br/> 
                    </div>
                    <span class="card-content black-text">
                        ${image.getCreate_time()}
                    </span>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>