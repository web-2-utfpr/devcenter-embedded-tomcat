<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="${user.getNome()}'s feed">
    <jsp:body>
        <div class="row center feed">
            <span class="red-text">${error}</span>
            <h3><a href="mailto:${user.getEmail()}">${user.getNome()}</a></h3>
            <c:forEach var="image" items="${user.getPhotos()}">
                <t:image url="${image.getUrl()}" create_time="${image.getCreate_time()}"  />
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>