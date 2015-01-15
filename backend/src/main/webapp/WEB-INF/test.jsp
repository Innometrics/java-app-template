<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
HelloWorld<br/>

appId=${profileCloudDAO.appId}<br/>
companyId=${profileCloudDAO.companyId}<br/>
bucketId=${profileCloudDAO.bucketId}<br/>
appKey=${profileCloudDAO.appKey}<br/><br/><br/>
Send Attribute
<form method="POST" action="${pageContext.request.contextPath}/sendAttribute">
    <p>
        Profile ID <input type="text" size="40" name="profileId" value="${profileId}"/>
        Section <input type="text" size="40" name="section" value="${section}"/>
        Attribute Key <input type="text" name="key" value="${key}"/>
        Atribute value  <input type="text"  name="value" value="${value}"/>
    </p>
    <p><input type="submit" value="send"/></p>
</form>

Urls<br/>
${urls}
</body>
</html>
