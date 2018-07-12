<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/19
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String appPath = request.getContextPath(); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=appPath%>/comm/update" method="post">
    <table>
        <tr hidden>
            <td>
                <input name="commodityId" type="text" value="${commodity.commodityId}">
            </td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td>
                <input type="text" name="commodityName" value="${commodity.commodityName}">
            </td>
        </tr>

        <tr>
            <td>商品价格</td>
            <td>
                <input type="text" name="commodityPrice" value=" ${commodity.commodityPrice} ">
            </td>
        </tr>
        <tr>
            <td>是否打折</td>
            <td>
                <input type="text" name="isDiscount" value="${commodity.isDiscount}">
            </td>
        </tr>
        <tr>

            <td>打折开始于</td>
            <td>
                <input type="text" name="discountStartAt" value="${commodity.discountStartAt}">
            </td>
        </tr>
        <tr>
            <td>打折结束于</td>
            <td>
                <input type="text" name="discountEndAt" value=" ${commodity.discountEndAt}">
            </td>
        </tr>
        <tr>
            <td>条形码</td>
            <td>
                <input type="text" name="commodityBarCode" value=" ${commodity.commodityBarCode}">
            </td>
        </tr>
        <td>
            <input type="submit">
        </td>
        </tr>
    </table>
</form>
</body>
</html>
