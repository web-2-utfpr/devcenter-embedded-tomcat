<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Feed">
    <jsp:body>
        <div class="row center feed">
            <h3>public feed</h3>
            <c:forEach var="image" items="${images}">
                <a href="/profile?u=${image.getUsuario()}">
                    <t:image url="${image.getUrl()}" create_time="${image.getCreate_time()}" nome="${image.getUsuario()}" />
                </a>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>