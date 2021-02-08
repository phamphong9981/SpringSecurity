<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>Spring MVC - Security </h1>
<h2>${message}</h2>
<a href='<c:url value="/admin" />'>admin</a>
<a href='<c:url value="/user" />'>user</a>
</body>
</html>
