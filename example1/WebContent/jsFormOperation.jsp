<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		function check(){
			 //document 对像包含很多form，form对像包含很多elements对像，可以好似用数组下标访问
			 var name=document.regForm.elements[0].value; 
			 alert(name); 
			//getElementsByTagName 返回带指定标签的对象集合
			var  age=document.getElementsByTagName("input")[1].value;
			alert(age);
			
			//通过id 访问
			var addr=document.getElementById("addr").value;
			alert(addr);
			
			var  a=document.getElementsByTagName("input")[3].value;
			alert(a);
		}




</script>











<form name="regForm" action="" method="post">
<table width="397" height="225" border="1">
<tr>
<td colspan="2"><div align="center">用户注册</div></td>
</tr>
<tr> 
	<td width="73">  姓名</td>
	<td width="308"> <input name="name" type="text" id="name"/> </td>
</tr>

<tr>
	<td> 年龄</td>
	<td> <input name="age" type="text" id="age"/></td>
</tr>
<tr>
	<td>性别</td>
	<td><input type="radio" name="radsex" value="man" id="radsex"/> 男
	    <input type="radio" name="radsex" value="woman" id="radsex"/>女
	 </td>
</tr>

<tr>
	<td>地址</td>
	<td><textarea rows="4" cols="40" name="addr" id="addr"></textarea></td>
</tr>

<tr>
	<td colspan="2">
	 <div align="center">
	 	<input type="submit" name="Submit" value="提交" onclick="check()"/>
	</div>
   </td>
</tr>
</table>
</form>

</body>
</html>