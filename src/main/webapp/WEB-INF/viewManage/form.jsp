<!DOCTYPE html>
<html>
<head>
    <title>
        <sitemesh:write property='title' /> - ltcms
    </title>
    <sitemesh:write property='head' />
</head>
<body>
<header>header</header>
<hr />
<%--demo.html的title将被填充到这儿：--%>
<sitemesh:write property='title' /><br />
<%--demo.html的body将被填充到这儿：--%>
<sitemesh:write property='body' />
<hr />
<footer>footer</footer>
</body>
</html>
