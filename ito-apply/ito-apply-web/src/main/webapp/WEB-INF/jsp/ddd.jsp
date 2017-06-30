<%--
  Created by IntelliJ IDEA.
  User: 韩九日
  Date: 2017/6/27
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/resume/upload" method="post" enctype="multipart/form-data">
    姓名:<input type="text" name="r_name">
    性别:<input type="text" name="r_sex">
    年龄:<input type="text" name="r_age">
    手机号:<input type="text" name="r_telephone">
    岗位:<input type="text" name="r_post">
    期望工作地点:<input type="text" name="r_city">
    工作年限:<input type="text" name="r_life">
    导入简历<input type="file" name="r_resume">
    <input type="submit">
</form>
<%--<a href="${pageContext.request.contextPath}/resume/word">解析word</a>
<a href="${pageContext.request.contextPath}/resume/pdf">解析pdf</a>
<a href="${pageContext.request.contextPath}/resume/excel">解析excel</a>
<a href="${pageContext.request.contextPath}/resume/image">读取图片</a>--%>

</body>
</html>
