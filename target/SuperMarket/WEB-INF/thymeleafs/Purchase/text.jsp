<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/21
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.css" >
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css" >
<script src="/jquery/jquery-3.3.1.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>
<script>
        //可以将方法绑定在指定的按钮
        function requestJson(){
            var name =$("#name").val();
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
                            if(data === 1){

                            }
                            else if (data === 0)
                            {
                                alert("NO")
                            }
                        // if(data===null){
                        //     alert("没有这个用户！")
                        // }
                        // else{
                        //     alert("登录成功")
                        //   //  window.location.href ="index.jsp";
                        //
                        // }

                    }

                });

            }

        }
        function add() {
            $("#input02").html("<p>fuck</p>");
        }
</script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form class="form-horizontal">
        <fieldset>
            <div id="legend" class="">
                <legend class="">form1</legend>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">Text input</label>
                <div class="controls">
                    <input type="text" placeholder="placeholder" class="input-xlarge" id="name">
                    <p class="help-block">Supporting help text</p>
                </div>
            </div>



            <div class="control-group">
                <label class="control-label">Button</label>

                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" onclick="requestJson()">Button</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>

<td id="texthh">
<input type="text" id="input02" onblur="add()">
</td>
</body>
</html>
