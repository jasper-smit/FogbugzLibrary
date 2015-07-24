<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>
<head>

    <title>DOC bestand als WIKI-pagina</title>
    <style type="text/css">
    body {
        font-family: Helvetica;
    }
    h1 {
        font-size: 32pt;
    }
    </style>

</head>

<body>

<h1>Er is iets fout gegaan...</h1>

<b>${exception} </b><br/>
<code>
    <c:forEach var="ste" items="${stacktrace}">
        ${ste} <br/>
    </c:forEach>
</code>

<h3>Message</h3>
${exceptionMessage}
<h3>Cause</h3>
<c:if test="${!empty exceptionCause}">
    ${exceptionCause}

    <c:forEach var="ste" items="${exceptionCauseTrace}">
        ${ste} <br/>
    </c:forEach>
</c:if>
<img src="../web/helaas.png" alt="Bummer" /> <br/>



</body>
</html>