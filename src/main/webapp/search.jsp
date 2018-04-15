<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="Search">
    <jsp:body>
        <div class="row feed center">
            <h3>Search "${q}" results</h3>
            <c:forEach var="user" items="${users}">
                <a href="/profile?u=${user.getNome()}">
                    <div class="card-panel medium">
                        <span class="black-text">
                            ${user.getNome()}
                        </span>
                    </div>
                </a>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>