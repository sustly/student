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
    <script type="application/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $("#userName").blur(function () {
                var url="http://localhost:8082/home/checkUser";
                var param={username:this.value};
                $.post(url, param, function (data) {
                    if(data.isSuccess == true){
                        $("#userMsg").text("");
                    }else {
                        $("#userMsg").text(data.Msg).css({"color":"red"});
                    }
                },"json");
            });

            //http 415转换错误，无法修改contentType为json
            /*$("#passWord").blur(function () {
                var url="http://localhost:8082/checkPassWord";
                var name = $("#userName").val();
                var pass = this.value;
                var param={id:name,password:pass};
                $.post(url, param, function (data) {
                    if(data.isSuccess == true){
                        $("#userMsg").text("");
                    }else {
                        $("#userMsg").text(data.Msg).css({"color":"red"});
                    }
                },"json");
            });*/

            $("#passWord").blur(function () {
                var url="http://localhost:8082/home/checkPassWord";
                var name = $("#userName").val();
                var pass = this.value;
                var param={id:name,password:pass};
                $.ajax({
                    url:url,
                    type:"POST",
                    contentType: 'application/json;charset=UTF-8',
                    data:JSON.stringify(param),
                    success:function (data) {
                        if(!data.isSuccess == true){
                            $("#userMsg").text(data.Msg).css({"color":"red"});
                        }else {
                            $("#userMsg").text("");
                        }
                    }
                });

            });
        });
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/home/teacherLogin" method="post">
<div id="login_div">
	<h2>用户登录</h2>
    <span id="userMsg"></span><br/>
    <input class="login_input" type="text" name="id" placeholder="用户名" id="userName"  style="margin-top:30px; border-radius:5px;"/><br/>
    
    <br/>

    <input class="login_input" type="password" name="password" placeholder="密码" id="passWord" style="margin-top:0; border-radius:5px;border-top:1px solid #ccc"/><br/>
    
    <div id="remember">
      <p><input type="checkbox" style="vertical-align:-3px;"/>记住密码</p>
       <p style="left:0;text-align:right">忘记密码?</p>
    </div>

  <input id="login" type="submit" value="登录"/>

  <a href="${pageContext.request.contextPath}/registerUser"><font color="white">注册账号</font></a>
	
	</div>

</form>
</body>
</html>
