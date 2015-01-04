<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body style="background:url('content/images/bg2.jpg') no-repeat;">
<div >

<center><font  size="20">登录  </font>                  </center>


</div>
<div >
<form action="EnterServlet" method="post"  ">

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
                <td colspan="2" align="center" height="40">
                
                    <input type="submit" name="Submit" value="登录">
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