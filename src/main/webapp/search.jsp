<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="search result">
    <jsp:body>
        <h3 class="center">"${q}" results</h3>
        <div class="row center feed">
            <c:forEach var="user" items="${users}">
                <a href="/profile?u=${user.getNome()}">
                    <div class="card light-blue">
                        <h5 class="white-text">
                            ${user.getNome()}
                        </h5>
                    </div>
                </a>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>