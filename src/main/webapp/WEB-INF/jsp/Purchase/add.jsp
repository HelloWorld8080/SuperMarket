<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/19
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% String appPath = request.getContextPath(); %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="/jquery/jquery-3.3.1.js"></script>
<script></script>
<script>
    (function($){
        $.fn.serializeJson = function(){
            var jsonData1 = {};
            var serializeArray = this.serializeArray();
            alert(serializeArray);
            // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
            $(serializeArray).each(function () {
                if (jsonData1[this.name]) {
                    if ($.isArray(jsonData1[this.name])) {
                        jsonData1[this.name].push(this.value);
                    } else {
                        jsonData1[this.name] = [jsonData1[this.name], this.value];
                    }
                } else {
                    jsonData1[this.name] = this.value;
                }
            });
            // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
            var vCount = 0;
            // 计算json内部的数组最大长度
            for(var item in jsonData1){
                var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
                vCount = (tmp > vCount) ? tmp : vCount;
            }
                var purchaseId = $(" input[id ='purchaseId']").val();
                var jsonData2 = new Array();
                alert(purchaseId);
                for(var i = 0; i < vCount; i++){
                    var jsonObj = {};
                    jsonObj['purchaseId'] = purchaseId;
                    for(var item in jsonData1) {
                        jsonObj[item] = jsonData1[item][i];
                    }
                    jsonData2.push(jsonObj);
                    console.log(jsonObj);

                }
                return JSON.stringify(jsonData2);

        };
    })(jQuery);

    function submitUserList_4() {
        alert("ok");
        var jsonStr = $("#form2").serializeJson();
        console.log("jsonStr:\r\n" + jsonStr);
        alert(jsonStr);
        $.ajax({
            url: "${ctx}/pur/addChild",
            type: "POST",
            contentType : 'application/json;charset=utf-8', //设置请求头信息
            dataType:"json",
            data: jsonStr,
            success: function(data){
                alert(data);
            },
            error: function(res){
                alert(res.responseText);
            }
        });
    }

</script>
<script>
    function printVal(){
        var a = $(" input[ id= 'purchaseId1'] ").val();
        $("#purchaseId").attr("value", a);//推荐这种写法,可正常赋值
        // var b = $("input[id ='purchaseId1']").val();
        // alert(b)


    }
    //可以将方法绑定在指定的按钮
    function requestJson(){
        var name =$("#employeeName").val();
        alert(name);
        $("#input02").text("cuole");

        if(name===""){
            alert("用户名不能为空！");
            return false;
        }
        else
        {
            $.ajax({
                type:'post',
                url:" ${appPath}/pur/valid",
                dataType:"json",//注意使用的是打他dataType，而不是Content-Type
                async: true,
                data:{"name":name},

                success:function(data){
                    if(data === 0){
                        alert("no");
                        $("#setName").append("<p>Wrong</p>");
                        $("#setName").attr("value", 0);

                    }
                    else
                    {
                        $("#setName").attr("value", data);
                        alert("yes")
                    }
                }
            });
        }
    }
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=appPath%>/pur/createPurchase" method="post" id="form1">
    <table id="tb1">
        <tr>
            <td>进货编次</td>
            <td>
                <input type="text" name="purchaseId" id="purchaseId1">
            </td>
        </tr>
        <tr>
            <td>进货时间</td>
            <td>
                <input type="date" name="purchaseAt">
            </td>
        </tr>
        <tr>
            <td>负责人姓名</td>
            <td>
                <input type="text"  id="employeeName" onblur="requestJson()"> ${msg}
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="employeeId" id="setName">
            </td>

        </tr>
            <td>
                <input type="submit">
            </td>
        </tr>

    </table>
    <table></table>
</form>
<form  id="form2" method="post" action="/pur/addChild">
<table id="tb">
    <input id="purchaseId" hidden>
        <tr>
            <td>商品编号</td>
            <td>
                <input type="text" name="commodityId" onblur="printVal()">
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
        <tr>
            <td>添加</td>
            <td>
                <input type="button" onclick="add()">
            </td>
        </tr>


</table>
    <tr>
        <td> <input type="submit" onclick="submitUserList_4()"></td>
    </tr>
</form>


<%--<form>--%>
        <%--<table id="tb">--%>
            <%--<td>            <form:input path="purchaseId"></form:input></td>--%>
            <%--&lt;%&ndash;<form:input path="commodityId"></form:input>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<form:input path="purchasePrice"></form:input>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<form:input path="supplierId"></form:input>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<form:input path="purchaseAmount"></form:input>&ndash;%&gt;--%>
        <%--</table>--%>
    <%--</form>--%>
    <%--<input type="button" value="add" onclick="add()">--%>


</body>
<script>
    var count = 1;
    function add() {
        var trObj = document.createElement("tr");
        trObj.id = new Date().getTime();
        count++;
        trObj.innerHTML = "     <input id=\"purchaseId\" hidden>\n       <tr>\n" +
            "            <td>商品编号</td>\n" +
            "            <td>\n" +
            "                <input type=\"text\" name=\"commodityId\" onblur=\"printVal()\">\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "\n" +
            "        <tr>\n" +
            "            <td>商品进价</td>\n" +
            "            <td>\n" +
            "                <input type=\"text\" name=\"purchasePrice\">\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td>供应商</td>\n" +
            "            <td>\n" +
            "                <input type=\"text\" name=\"supplierId\">\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td>购买数量</td>\n" +
            "            <td>\n" +
            "                <input type=\"text\" name=\"purchaseAmount\">\n" +
            "            </td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "            <td>添加</td>\n" +
            "            <td>\n" +
            "                <input type=\"button\" onclick=\"add()\">\n" +
            "            </td>\n" +
            "        </tr>";
        document.getElementById("tb").appendChild(trObj);
    }

</script>

</html>
