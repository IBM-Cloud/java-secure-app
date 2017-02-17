<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.owasp.encoder.*" %>
<jsp:include page="/BadServlet" flush="true" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<body>
     <form action=${pageContext.request.contextPath}/BadServlet method="get">
          Username: <input type="text" name="username" value="<script>alert('You Are Attacked! This attack script is now running on your browser. It could have sent your credentials to the attacker server.');</script>"/></b>
          Password: <input type="text" name="password" value="*****" /></b>
          <input type="submit" value="Submit"/>
     </form>
</body>

</html>