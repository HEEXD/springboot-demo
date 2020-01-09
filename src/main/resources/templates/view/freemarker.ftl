<!DOCTYPE HTML>
<html lang="en">
<#assign ctx=springMacroRequestContext.contextPath />
<head>
    <meta charset="UTF-8"/>
    <title>springboot-freeMarker demo</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/myTable.css" />
</head>
<body>
<h1 style="text-align:center">freeMarker demo</h1>
<table class="myTable">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>年龄</th>
    </tr>
    <#list list as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>
