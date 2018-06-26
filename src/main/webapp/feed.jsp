<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="page ${page} feed">
    <jsp:body>
        <div id="app" class="row center feed">
            <span class="red-text">${error}</span>
            <h5>feed page ${page}</h5>
            <c:forEach var="image" items="${images}">
                <a v-for="(image, index) in images" :key="index" :href="'/profile/' + image.user.nome">
                    <div class="card white-text light-blue">

                      <div class="card-image">
                        <img :src="image.url" width="400px">
                      </div>
                      <div class="row">
                        <div class="col left">
                          {{image.user.nome}}
                        </div>
                        <div class="col right">
                          {{image.created_at}}
                        </div>
                      </div>
                    </div>
                  </a>
            </c:forEach>
            <a href="/feed?p=${page-1}"><</a>
            <a href="/feed?p=${page+1}">></a>
        </div>
        <script>
            let page = ${page};
        </script>
        <script src="js/feed.js"></script>
    </jsp:body>
</t:wrapper>