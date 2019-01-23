<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>

	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel = "stylesheet" type = "text/css" href = "../../css/login.css"/>

</head>

<body>
<form action="${pageContext.request.contextPath}/teacherLogin" method="post">
<div id="login_div">
	<h2>用户登录</h2>
    <input class="login_input" type="text" name="id" placeholder="用户名" required="" autofocus="" style="margin-top:30px; border-radius:5px;"/><br/>
    
    <br/>

    <input class="login_input" type="password" name="password" placeholder="密码" required="" autofocus="" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
    
    <div id="remember">
      <p><input type="checkbox" style="vertical-align:-3px;"/>记住密码</p>
       <p style="left:0;text-align:right">忘记密码?</p>
    </div>

  <input id="login" type="submit" value="登录"/>

  <a href="${pageContext.request.contextPath}/register"><font color="white">注册账号</font></a>
	
	</div>

</form>
</body>
</html>
