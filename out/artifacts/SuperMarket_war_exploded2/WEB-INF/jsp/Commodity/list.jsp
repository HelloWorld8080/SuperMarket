<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/18
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<% String appPath = request.getContextPath();%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="<%=appPath%>/comm/addPage"> 添加</a>

<h2>${commodities.size()}</h2>
<tr>
    <td>商品名称</td>
    <td>商品价格</td>
    <td>商品二维码</td>
</tr>
<table>
    <c:forEach var="commodity" items="${commodities}" varStatus="status">
        <tr>
            <td>${commodity.commodityName}</td>
            <td>${commodity.commodityPrice}</td>
            <td>${commodity.commodityBarCode}</td>
            <td>
                <a href="<%=appPath%>/comm/edit/${commodity.commodityId}">编辑</a> |
            </td>

        </tr>
    </c:forEach>
</table>

<script src="https://code.jquery.com/jquery.js"></script>

</body>

</html>
