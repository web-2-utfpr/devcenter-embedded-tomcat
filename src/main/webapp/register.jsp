<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Register">
    <jsp:attribute name="header">
        <style>
            .login-box {
                height: 100%;
            }
        </style>
    </jsp:attribute>

    <jsp:body>
        <div class="row center-align">
            <div class="col card hoverable s12 m12 l12">
                <form action="register" method="POST">
                    <div class="card-content">
                        <span class="card-title">Signup</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <label for="nome">Username</label>
                                <input type="text" class="validate" name="nome" id="nome" required/>
                            </div>
                            <div class="input-field col s12">
                                <label for="senha">Password</label>
                                <input type="password" class="validate" name="senha" id="senha" required/>
                            </div>
                            <div class="input-field col s12">
                                <label for="email">Email</label>
                                <input type="email" class="validate" name="email" id="email" required/>
                            </div>
                        </div>
                    </div>
                    <div class="row card-action">
                        <div class="col s6">
                            <input type="reset" id="reset" class="btn-flat grey-text waves-effect">
                        </div>
                        <div class="col s6">
                            <input type="submit" class="btn green waves-effect waves-light" value="Signup">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</t:wrapper>
