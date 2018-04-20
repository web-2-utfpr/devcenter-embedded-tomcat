<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true" required="false" %>
<%@ attribute name="scripts" fragment="true" required="false" %>
<%@ attribute name="title"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>inst4gram ${title}</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <jsp:invoke fragment="header"/>

    </head>
    <body>
        <div class="container">
            <% if(request.getSession().getAttribute("loggedUser")!= null) { %>
            <jsp:include page='includes/loggedheader.jsp' />
            <% } else { %>
            <jsp:include page='includes/header.jsp' />
            <% } %>
            <div class="content">
                <jsp:doBody />
            </div>
        </div>
        <jsp:include page='includes/footer.jsp' />

        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
        <jsp:invoke fragment="scripts"/>
    </body>
</html>