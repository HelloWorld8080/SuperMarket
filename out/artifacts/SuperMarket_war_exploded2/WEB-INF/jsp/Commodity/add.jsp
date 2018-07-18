<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/19
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String appPath = request.getContextPath(); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=appPath%>/comm/create" method="post" >
    <table>
        <tr>
            <td>商品名称</td>
            <td>
                <input type="text" name="commodityName">
            </td>
        </tr>

        <tr>
            <td>商品价格</td>
            <td>
                <input type="text" name="commodityPrice">
            </td>
        </tr>
        <tr>
            <td>是否打折</td>
            <td>
                <input type="text" name="isDiscount">
            </td>
        </tr>
        <tr>

            <td>打折开始于</td>
            <td>
                <input type="date" name="discountStartAt">
            </td>
        </tr>
        <tr>
            <td>打折结束于</td>
            <td>
                <input type="date" name="discountEndAt">
            </td>
        </tr>
        <tr>
            <td>条形码</td>
            <td>
                <input type="text" name="commodityBarCode">
            </td>
        </tr>
            <td>
                <input type="submit">
            </td>
        </tr>
    </table>
        <input name="file" type="file">
        <input type="submit" />
    </form>
</form>
</body>
</html>
