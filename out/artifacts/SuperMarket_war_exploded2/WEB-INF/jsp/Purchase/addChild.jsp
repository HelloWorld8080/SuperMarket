<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/21
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPtah = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form  id="form2" method="post" action=" <%=appPtah%>/pur/addChildren">
        <table id="tb">
            <input type="text" name="purchildId">
            <input type="text" name="purchaseId" id="purchaseId">
            <tr>
                <td>商品编号</td>
                <td>
                    <input type="text" name="commodityId">
                </td>
            </tr>

            <tr>
                <td>商品进价</td>
                <td>
                    <input type="text" name="purchasePrice">
                </td>
            </tr>
            <tr>
                <td>供应商</td>
                <td>
                    <input type="text" name="supplierId">
                </td>
            </tr>
            <tr>
                <td>购买数量</td>
                <td>
                    <input type="text" name="purchaseAmount">
                </td>
            </tr>
            <<input type="submit" value="zz">

        </table>
</form>

</body>
</html>
