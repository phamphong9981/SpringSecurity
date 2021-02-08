<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>Form Login1</h2>
<h4>${message}</h4>
<form name='loginForm' action="<c:url value='/admin/j_spring_security_logi' />" method='POST'>
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="login" /></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>