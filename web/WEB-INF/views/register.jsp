<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>

	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel = "stylesheet" type = "text/css" href = "../../css/register.css"/>

</head>

<body>
<form action="${pageContext.request.contextPath}/register" method="post" id="login_form">
<div id="login_div">
	<h2>用户注册</h2>
    <span id="usernameMsg"></span><br/>
   <input class="login_input" type="text" name="id" placeholder="用户名" id="username" style="margin-top:30px; border-radius:5px;"/><br/>
    <br/>
    <input class="login_input" type="password" name="password" placeholder="密码" id="password" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
 	<br/>
    <input class="login_input" type="password" name="rpassword" placeholder="确认密码"  id="rpassword" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
    
    <br/>
   
  <input id="login" type="submit"  value="快速注册"/>

	</div>
</form>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

    $(function () {
        $("#username").blur(function () {
            if(this.value==""){
                $("#usernameMsg").text("用户名不能为空！").css({"color":"red"});
                return;
            }
            var obj = {
                id: this.value
            };
            $.ajax({
                url:"http://localhost:8082/checkId",
                type:"POST",
                contentType: 'application/json;charset=UTF-8',
                data:JSON.stringify(obj),
                success:function (data) {
                    if(!data.isSuccess == true){
                        $("#usernameMsg").text(data.Msg).css({"color":"red"});
                    }else {
                        $("#usernameMsg").text("");
                    }
                }
            });
        });

        $("#rpassword").blur(function () {
            var psaaword = $("#password").val();
            var rpassword = this.value;
            if (psaaword == rpassword) {
                $("#usernameMsg").text("");
                return true;
            }else {
                $("#usernameMsg").text("两次密码输入不一致！").css({"color":"red"});
                return false;
            }
        });

        $("#login_form").submit(function () {
            if($("#username").val() == null){
                $("#usernameMsg").text("用户名不能为空！").css({"color":"red"});
                return false;
            }
            if($("#password").val() == null){
                $("#usernameMsg").text("密码不能为空！").css({"color":"red"});
                return false;
            }
            if($("#rpassword").val() == null){
                $("#usernameMsg").text("请再次输入密码！").css({"color":"red"});
                return false;
            }
            var psaaword = $("#password").val();
            var rpassword = this.value;
            if (psaaword == rpassword) {
                $("#usernameMsg").text("");
                return true;
            }else {
                $("#usernameMsg").text("两次密码输入不一致！").css({"color":"red"});
                return false;
            }
        });


    });

</script>
</body>
</html>
