<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        <title>Register</title>
    </jsp:attribute>

    <jsp:body>
        <form action="register" method="POST"> 
            Please enter your username <input type="text" name="nome" required/><br> 
            Please enter your password <input type="text" name="senha" required/> <br> 
            Please enter your email <input type="text" name="email" required/> 
            <input type="submit" value="submit"> 
        </form> 
    </jsp:body>
</t:wrapper>
