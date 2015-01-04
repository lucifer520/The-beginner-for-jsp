<%@ page language="java" contentType="text/html; charset=utf8" import="com.cdd.bean.User" import="com.cdd.jdbc.FileUtil" 
	import=" java.util.ArrayList" import="com.cdd.bean.UpFile"  import="java.util.*"
    %>
 
    <jsp:useBean id="User" class="com.cdd.bean.User"  scope="page"/>  
    <jsp:useBean id="files" class="com.cdd.jdbc.FileUtil" scope="page"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>首页</title>
</head>
<body onload="test();">
 <script >
    function test(){ 
	   <%String use=(String)session.getAttribute("uses");%>
	  <% if(use!=null)
		   {%>
			   userInfo5.style.display="none";
			   document.getElementById("userInfo6").innerHTML="<%=use%>"+ "&nbsp;&nbsp;<a href='javascript:void(0);' onclick='back();'>退出"+"</a>";
			   userInfo6.style.display="block";
		  <% }%>
		 
      }    
   function back(){
	   <%session.removeAttribute("User");%>
	  /*  out.print("hello"); */
	   <%session.invalidate();%>  
	   userInfo5.style.display="block";
	   userInfo6.style.display="none";
   }
  </script>    
 
             <div id="userInfo5" style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 923px; top: 11px;">
                  <span id="userInfo5">    <font size="-1" color="#FFFFFF">
                  &nbsp;&nbsp;&nbsp; 你现在是游客身份，如想要成为会员，请 &nbsp;&nbsp;<a href="SignIn.jsp" >登录</a>&nbsp;
                   <a href="Registration.jsp" > 注册</a>
                         </font>
                  </span>
               </div> 
                <div id="userInfo6" style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 1223px; top: 11px; display:none; ">
                  <span id="userInfo6">    <font size="-1" color="#e0ded2">
      
                  </font>
                  </span>
               </div>   
          <div id="image1" style="width:1300px;position: absolute;top: 40px;">
               <center>
            <img width="300px" height="100px"  src="content/images/logo.jpg" alt="logo" />
               </center>
          </div>   
          <div id="search" style="width:1300px;position: absolute;top: 145px;">
          <form action=""    method="post">
               <center>
              <input type="text" name="text1" style="width:500px;height:25px;" id="text1" >
              <input type="submit" value="搜索歌曲" style=" width:100px; height:30px; border:#F00 1px solid; background:#69F; color:#FFF;">
               </center>
               </form>
          </div>
<div id="playlist2" style="display:block; position: absolute; width: 655px; height: 500px; z-indent: 2; left: 323px; top: 211px;" >
<ol>
<% 
String  ss=(String)request.getParameter("text1"); 
if(ss!=null){
   ss=new String(ss.getBytes("iso-8859-1"),"utf-8"); 
} 
	   ArrayList<UpFile> list=new ArrayList<UpFile>();
               	 list= files.fuzzySearchFile(ss);
               	 Iterator it=list.iterator();
               	 while(it.hasNext()){
               		 UpFile mUpFile=new UpFile();
               		 mUpFile=(UpFile)it.next();
           
%>
    <li>
        <a href="javascript:void(0);" data-name=<%=mUpFile.getFile_downPerson() %>><%=mUpFile.getFile_name() %></a> 
        <a href="DownServlet?path=<%=mUpFile.getFile_address() %>" style=" position: absolute;left:523px;" > 下载 </a> 
    </li>
  <%} %> 
</ol>
</div>                
</body >
</html>