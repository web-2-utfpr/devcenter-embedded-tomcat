<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true" required="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <jsp:invoke fragment="header"/>
    </head>
    <body>
        <jsp:doBody />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    </body>
</html>