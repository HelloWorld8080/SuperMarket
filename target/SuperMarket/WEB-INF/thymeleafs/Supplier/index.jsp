<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
    <form action="/create"  method="post">
        <table>
            <tr>
<%--                <td></td>
                <td>
                    <input type="text" name="commodityId">
                </td>--%>
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
<P></P>
<script src="https://code.jquery.com/jquery.js"></script>
</body>
</html>
