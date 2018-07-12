<%--
  Created by IntelliJ IDEA.
  User: 11291
  Date: 2018/5/22
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span id="span1"></span>
<input id="input02" type="text" onblur="add()">

<p></p>


<script src="/jquery/jquery-3.3.1.js"></script>
<script>
    function add() {
            var pMessage = $("<p></p>").text("show message");
            var trElement = $("<tr></tr>").append(pMessage);
            $("input").after(trElement);

        }

</script>
<form action="/pur/updateimg" method="post" enctype="multipart/form-data">
    <input name="file" type="file">
    <input type="submit" />
</form>

</body>
</html>
