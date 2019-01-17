<%@ page import="com.sinuonan.bean.StudentInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加学生信息</title>
    <script type="text/javascript">
        function check(form) {
            with (form) {
                if (gender.value == "") {
                    alert("性别不能为空");
                    return false;
                }
                if (className.value == "") {
                    alert("班级不能为空");
                    return false;
                }
                if (schoolId.value == "") {
                    alert("学号不能为空");
                    return false;
                }
                if (isNaN(schoolId.value)) {
                    alert("格式错误！");
                    return false;
                }
                self.location = document.referrer;//去另一个页面刷新
                return true;
            }
        }
    </script>
</head>
<body>
<% StudentInfo st = (StudentInfo) request.getAttribute("st");%>
<form action="${pageContext.request.contextPath}/update" method="post" onsubmit="return check(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>添加学生信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">学生名称：</td>
            <td>
                <input type="hidden" name="uuid" value="<%=st.getUuid()%>"/>
                <input type="text" name="name" value="<%=st.getName()%>" /></td>
        </tr>
        <tr>
            <td align="right">性　　别：</td>
            <td><input type="text" name="gender" value="<%=st.getGender()%>" /></td>
        </tr>
        <tr>
            <td align="right">班    级：</td>
            <td><input type="text" name="className" value="<%=st.getClassName()%>" /></td>
        </tr>
        <tr>
            <td align="right">学    号：</td>
            <td><input type="text" name="schoolId" value="<%=st.getSchoolId()%>"  /></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="更 新">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
