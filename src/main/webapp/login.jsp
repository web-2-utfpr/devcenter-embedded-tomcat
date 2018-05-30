<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="Homepage">
    <jsp:body>
        <div class="row center-align feed">
            <div class="row">
                <span class="red-text">${error}</span>
            </div>
            <div class="row">
                <span class="green-text">${msg}</span>
            </div>
            <form action="login" method="POST" class="col form-login">
                <div class="input-field row">
                    <label for="username">${labels["usernameLabel"]}</label>
                    <input type="text" class="validate" name="username" id="username" required/>
                </div>
                <div class="input-field row">
                    <label for="password">${labels["passwordLabel"]}</label>
                    <input type="password" class="validate" name="password" id="password" required/>
                </div>
                <div class="row card-action">
                    <input type="reset" id="reset" value=${labels["reset"]} class="btn-flat grey-text">
                    <input type="submit" value=${labels["login"]} class="btn green waves-light">
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>