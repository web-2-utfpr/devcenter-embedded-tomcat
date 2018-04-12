<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:setDataSource var="dev" driver="com.mysql.cj.jdbc.Driver" 
                   url="jdbc:mysql://192.168.99.100:3306/instaclone?useSSL=false"
                   user="root"
                   password="root"
                   />

<sql:setDataSource var="prod" driver="com.mysql.cj.jdbc.Driver" 
                   url="jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10232125?useSSL=true"
                   user="sql10232125"
                   password="g1ALnJFmgv"
                   />

<sql:query var="rs" dataSource="${prod}">
    SELECT url, nome, create_time FROM imagem INNER JOIN usuario ON imagem.id_usuario = usuario.id
</sql:query>

<html>
    <head>
        <title>DB Test</title>
    </head>
    <body>

        <h2>Inst4gram</h2>

        <c:forEach var="row" items="${rs.rows}">
            ${row.nome}<br/>
            <img src="${row.url}" width="400px"> <br/> 
            ${row.create_time}
            <br/><br/>
        </c:forEach>

    </body>
</html>