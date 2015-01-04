<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function compute(op)   //定义函数
{
	var num1,num2;
	num1=parseFloat(document.myform.num1.value);
	num2=parseFloat(document.myform.num2.value);
	document.bgcolor='bule';
	if(op=="+")
		document.myform.result.value=num1+num2;
	if(op=="-")
		document.myform.result.value=num1-num2;
	if(op=="*")
		document.myform.result.value=num1*num2;
	if(op=="/")
		document.myform.result.value=num1/num2;

	
	
	}


</script>

<form action="" method="post" name="myform" id="myform">

<p>第一个数：
	<input name="num1" type="text" id="num1" size="25">
	<br>
	第二个数：
	<input name="num2" type="text" id="num1" size="25">
</p>

<input name="addButton" type="button" id="addButton" value="+" onClick="compute('+')">
<input name="subButton" type="button" id="subButton" value="-" onClick="compute('-')">
<input name="mulButton" type="button" id="mulButton" value="*" onClick="compute('-')">
<input name="divButton" type="button" id="divButton" value="/" onClick="compute('/')">
<p>
计算结果：<input name="result" type="text" id="result"  value="0" size="25">
</p>


</form>





</body>
</html>