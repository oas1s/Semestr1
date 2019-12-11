<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test</title>
</head>
<body>
<h1>${head}</h1>

<ul>
    <#list items as item>
        <li>
            <#if item < 0.4>
                <b>${item}!!!</b>
            <#else>
                ${item}
            </#if>
        </li>
    </#list>
</ul>
</body>
</html>