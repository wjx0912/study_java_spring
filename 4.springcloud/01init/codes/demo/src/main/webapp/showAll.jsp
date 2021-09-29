<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"  %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户列表</title>
</head>
<body>


    <c:forEach items="${requestScope.users}" var="user" >
        id:${user.id} name:${user.name} age:${user.age} salary:${user.salary}
        <a href="">删除</a>
        <a href="${pageContext.request.contextPath}/user/findById?id=${user.id}">修改</a> <br>
    </c:forEach>


    <a href="${pageContext.request.contextPath}/save.jsp">添加</a>

</body>
</html>