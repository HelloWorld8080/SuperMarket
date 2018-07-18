<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/18
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% String appPath = request.getContextPath(); %>

<html>
<head>
    <title>Title</title>
</head>
<body>
${commodities.size()}
<c:forEach var="commodity" items="${commodities}" varStatus="status">
    <tr>
        <td>${commodity.commodityName}</td>
        <td>${commodity.commodityName}</td>
        <td>${commodity.commodityBarCode}</td>

    </tr>
</c:forEach>

<form class="area-legend-symbol" action="<%=appPath%>/create" method="post">
    <table class="table table-hover table-striped">

        <tr>
            <td>图书编号</td>
            <td><input type="text" name="bood_id"></td>
        </tr>

        <tr>
            <td>图书名称</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>图书数量</td>
            <td><input type="text" name="number"> </td>
        </tr>

        <tr>
            <td>图书详情</td>
            <td><input name="detail" type="text"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>

    </table>

</form>


<form action="<%=appPath%>/create"  method="post" produces = "text/plain;charset=UTF-8" id="commodity">
    <table>
        <tr>
            <td>ID</td>
            <td>
                <input type="text" name="commodity_id">
            </td>
            <td>商品名称</td>
            <td>
                <input type="text" name="commodity_name">
            </td>
            <td>商品价格</td>
            <td>
                <input type="text" name="commodity_price">
            </td>
            <td>是否打折</td>
            <td>
                <input type="text" name="is_discount">
            </td>
            <td>打折开始于</td>
            <td>
                <input type="date" name="discount_start_at">
            </td>
            <td>打折结束于</td>
            <td>
                <input type="date" name="discount_end_at">
            </td>
            <td>条形码</td>
            <td>
                <input type="text" name="commodity_bar_code">
            </td>
            <td>
                <input type="submit" value="tijiao">
            </td>
        </tr>

        <tr>
                 <td></td>
                            <td>
                                <input type="text" name="commodity_id">
                            </td>
            <td>商品名称</td>
            <td>
                <input type="text" name="commodityName">
            </td>
            <td>商品价格</td>
            <td>
                <input type="text" name="commodityPrice">
            </td>
            <td>是否打折</td>
            <td>
                <input type="text" name="isDiscount">
            </td>
            <td>打折开始于</td>
            <td>
                <input type="date" name="discountStartAt">
            </td>
            <td>打折结束于</td>
            <td>
                <input type="date" name="discountEndAt">
            </td>
            <td>条形码</td>
            <td>
                <input type="text" name="commodityBarCode">
            </td>
            <td>
                <input type="submit">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
