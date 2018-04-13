<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Homepage">
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:body>
        <div class="row center-align">
            <div class="col card hoverable s10 m12 l12">
                <form action="login" method="POST">
                    <div class="card-content">
                        <span class="card-title">Signin</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <label for="nome">Username</label>
                                <input type="text" class="validate" name="nome" id="nome" />
                            </div>
                            <div class="input-field col s12">
                                <label for="senha">Password </label>
                                <input type="password" class="validate" name="senha" id="senha" />
                            </div>
                        </div>
                    </div>
                    <div class="card-action right-align">
                        <input type="reset" id="reset" class="btn-flat grey-text waves-effect">
                        <input type="submit" class="btn green waves-effect waves-light" value="Signin">
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>
</t:wrapper>