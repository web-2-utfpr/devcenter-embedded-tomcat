<%@page contentType="text/html" pageEncoding="utf-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper title="Homepage">
    <jsp:body>
        <div class="row center-align feed">
            <div class="row">
                <span class="red-text">${error}</span>
            </div>
            <form action="login" method="POST" class="col form-login">
                <div class="input-field row">
                    <label for="nome">Username</label>
                    <input type="text" class="validate" name="nome" id="nome" required/>
                </div>
                <div class="input-field row">
                    <label for="senha">Password</label>
                    <input type="password" class="validate" name="senha" id="senha" required/>
                </div>
                <div class="row card-action">
                    <input type="reset" id="reset" class="btn-flat grey-text">
                    <input type="submit" class="btn green waves-light" value="Login">
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>