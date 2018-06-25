<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="page ${page} feed">
    <jsp:body>
        <div class="row center feed">
            <span class="red-text">${error}</span>
            <h5>feed page ${page}</h5>
            <c:forEach var="image" items="${images}">
                <a href="/profile?u=${image.getUser().getNome()}">
                    <t:image url="${image.getUrl()}" create_time="${image.getCreated_at()}" nome="${image.getUser().getNome()}" />
                </a>
            </c:forEach>
            <a href="/feed?p=${page-1}"><</a>
            <a href="/feed?p=${page+1}">></a>
        </div>
    </jsp:body>
</t:wrapper>