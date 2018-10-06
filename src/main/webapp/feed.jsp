<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="page ${page} feed">
    <jsp:body>
        <span class="red-text">${error}</span>
        <div class="photo-grid-container">
            <div class="photo-grid">
                <c:forEach var="image" items="${images}">
                    <div class='photo-grid-item'>
                        <a href="/profile?u=${image.getUser().getNome()}">
                            <t:image url="${image.getUrl()}" create_time="${image.getCreated_at()}" nome="${image.getUser().getNome()}" />
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div>
            <a ${page > 0 ? "" : "style=\"display:none;\""} href="/feed?p=${page-1}"><</a>
            <a ${hasNextPage ? "" : "style=\"display:none;\""} href="/feed?p=${page+1}">></a>
        </div>
    </jsp:body>
</t:wrapper>