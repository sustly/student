<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@ page import="com.sustly.bean.StudentInfo" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有学生信息</title>
</head>
<style type="text/css">
	form{margin: 0px;}
	td{font-size: 12px;}
	h2{margin: 2px}
</style>
<script type="text/javascript">
    function check(form){
        with(form){
            self.location=document.referrer;//去另一个页面刷新
            return true;;
        }
    }
</script>
<body>
	<table align="center" width="600" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="6">
				<h2>所有学生信息</h2>
			</td>
		</tr>
		<tr bgcolor="#b8860b">
			<th align="center" colspan="6" >
				<a href="${pageContext.request.contextPath}/addStudent"><font color="white">添加学生</font></a>
			</th>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<th width="100"><b>学生名称</b></th>
			<th width="100"><b>性别</b></th>
			<th width="100"><b>班级</b></th>
			<th width="100"><b>学号</b></th>
			<th width="100"><b>修改</b></th>
			<th width="100"><b>删除</b></th>
		</tr>
			<%
					List<StudentInfo> list = (List<StudentInfo>)request.getAttribute("list");
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						for(StudentInfo st : list){
			%>
				<tr align="center" bgcolor="white">
					<td><%=st.getName()%></td>
					<td><%=st.getGender()%></td>
					<td><%=st.getClassName()%></td>
					<td><%=st.getSchoolId()%></td>
					<td>
						<a href= "${pageContext.request.contextPath}/updateGo?uuid=<%=st.getUuid()%>" onclick="check()">修改</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/deleteByName?name=<%=st.getName()%>" onclick="check()">删除</a>
					</td>
				</tr>
			<%
					}
				}
			%>
	</table>
</body>
</html>