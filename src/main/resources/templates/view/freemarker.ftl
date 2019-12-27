<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>springboot-freeMarker demo</title>
</head>
<body>
<h1>freeMarker demo</h1>
<table>
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
