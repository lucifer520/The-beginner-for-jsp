<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body style="background:url('content/images/bg2.jpg') no-repeat;">
<div >
<center><font  size="20">注册  </font>                  </center>
</div>
<div >
<form action="UserInsertServlet" method="post"  ">
<table align="center"  border="0" width="500">
        <tr> 
             <td align="right"  width="30%"> 用户名：</td>
             <td> <input type="text" name="username" class="box"></td>
        </tr>
        <tr>
            <td align="right"> 密码：</td>
            <td> <input type="password" name="password" class="box"></td>
         </tr> 
         <tr>
               <td align="right">确认密码: </td>
               <td><input type="passwprd" name="repassword"  class="box"></td>
         </tr>
         <tr>
         		<td align="right"> 性别：</td>
         		<td> 
         		        <input type="radio" name="sex" value="男" checked="checked">男
         		        <input type="radio" name="sex" value="女">女
         		 </td>
         </tr>
         <tr>
                  <td align="right"	>QQ: </td>
                  <td> <input type="text" name="QQnumber" class="box"></td>
          </tr>
           <tr>
                  <td align="right"	>email: </td>
                  <td> <input type="text" name="email" class="box"></td>
          </tr>
           <tr>
                  <td align="right"	>电话号码: </td>
                  <td> <input type="text" name="phoneNumber" class="box"></td>
          </tr>
          <tr>
                <td colspan="2" align="center" height="40">
                
                    <input type="submit" name="Submit" value="注册">
                    <input type="reset"    value="重写">
                     <input type="button"  onclick="window.location.href='index.jsp'" value="返回首页">   
                </td>           
           </tr>    
</table>
</form>
</div>
  <%   
                  if(request.getAttribute("message")!=null){
        	  			out.println("<script>alert('"+request.getAttribute("message")+"');</script>");
                  }
      	  
   %>
</body>
</html>