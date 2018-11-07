<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:wrapper title="${user.getNome()}'s feed">
    <jsp:body>
        <span class="red-text">${error}</span>
        <div class="container">
                <div class="jumbotron">
                  <h1>Perfil de Úsuário</h1>
                  <h4>${user.getNome()}</h3>
                  <h6>${user.getEmail()}</h6>  
                </div>
        </div>
        <h4> Meus vídeos</h4>
        <hr>
        <div class="photo-grid-container">
            <div class="photo-grid">
                <c:forEach var="image" items="${images}">
                    <div class='photo-grid-item'>
                        <t:image url="${image.getUrl()}" create_time="${image.getCreated_at()}"  />
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</jsp:body>
</t:wrapper>
