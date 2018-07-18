<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/18
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="/bootstrap/js/bootstrap.css"></script>

<% String appPath = request.getContextPath();%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="<%=appPath%>/addPage"> 添加</a>


<tr>
    <td>进货单号</td>
    <td>商品价格</td>
    <td>商品二维码</td>
</tr>
<table>
    <c:forEach var="purchase" items="${purchases}" varStatus="status">
        <tr>
            <td>${purchase.purchaseId}</td>
            <td>${purchase.purchaseAt}</td>
            <td>${purchase.employeeId}</td>
            <td>
                <a href="<%=appPath%>/edit/${purchase.purchaseId}">编辑</a> |
            </td>

        </tr>
    </c:forEach>
</table>

<script src="https://code.jquery.com/jquery.js"></script>

</body>

</html>
