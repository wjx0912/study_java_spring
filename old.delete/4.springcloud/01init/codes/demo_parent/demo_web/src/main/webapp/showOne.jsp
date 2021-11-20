<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"  %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改用户信息</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/update" method="post">

    Id : <input type="text" readonly name="id" value="${requestScope.user.id}"> <br>
    姓名: <input type="text" name="name" value="${requestScope.user.name}"> <br>
    年龄: <input type="text" name="age" value="${requestScope.user.age}"> <br>
    工资: <input type="text" name="salary" value="${requestScope.user.salary}"> <br>

    <input type="submit" value="修改用户信息">

</form>

</body>
</html>