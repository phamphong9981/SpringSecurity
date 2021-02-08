<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Admin Page</h1>
<h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>
<form action="<c:url value="/j_spring_security_logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout" />
</form>
<form action="<c:url value="/demo1" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Goto Demo Page1" />
</form>
<form action="<c:url value="/demo2" />" method="post">
    <input type="submit" value="Goto Demo Page2" />
</form>
</body>
</html>