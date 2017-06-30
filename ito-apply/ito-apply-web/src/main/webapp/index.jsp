<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/user/showUser" method="post" >
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
</form>

</body>
</html>
