<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>

	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel = "stylesheet" type = "text/css" href = "css/register.css"/>

</head>

<body>
<form action="${pageContext.request.contextPath}/register" method="post">
<div id="login_div">
	<h2>用户注册</h2>
	<s:actionerror></s:actionerror>
   <input class="login_input" type="text" name="id" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/><br/>
    <br/>
    <input class="login_input" type="password" name="password" placeholder="密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
 	<br/>
    <input class="login_input" type="password" name="rpassword" placeholder="确认密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
    
    <br/>
   
  <input id="login" type="submit" value="快速注册"/>

	</div>
</form>
</body>
</html>
