<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.cdd.bean.User" import="com.cdd.jdbc.FileUtil" 
	import=" java.util.ArrayList" import="com.cdd.bean.UpFile"  import="java.util.*"
    pageEncoding="UTF-8"%>
 
    <jsp:useBean id="User" class="com.cdd.bean.User"  scope="page"/>  
    <jsp:useBean id="files" class="com.cdd.jdbc.FileUtil" scope="page"/> 
<html class="imageBg">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>MP3 下载站</title>
<link rel="stylesheet" href="styles/style.css">
 	<%-- <%
 	response.setHeader("Pragma","No-cache");
 	response.setHeader("Cache-Control","no-cache");
 	response.setDateHeader("Expires", 0);
 	response.flushBuffer();
 	%>
--%>
</head>
<body>
  <script >
   function test(){
	   <%String use=(String)session.getAttribute("uses");%>
	  <% if(use!=null)
		   {%>
			   userInfo1.style.display="none";
			   userInfo3.style.display="block";
			   document.getElementById("userInfo2").innerHTML="<%=use%>"+ "&nbsp;&nbsp;<a href='javascript:void(0);' onclick='back();'>退出"+"</a>";
			   userInfo2.style.display="block";
		  <% }%>
       }    
   function back(){
	   <%session.removeAttribute("User");%>
	  /*  out.print("hello"); */
	   <%session.invalidate();%>  
	   userInfo1.style.display="block";
	   userInfo2.style.display="none";
   }
  </script>    
             <div  style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 923px; top: 11px;">
                  <span id="userInfo1">    <font size="-1" color="#FFFFFF">
                  &nbsp;&nbsp;&nbsp; 你现在是游客身份，如想要成为会员，请 &nbsp;&nbsp;<a href="SignIn.jsp" >登录</a>&nbsp;
                   <a href="Registration.jsp" > 注册</a>
                         </font>
                  </span>
               </div> 
                <div id="userInfo2" style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 1223px; top: 11px; display:none; ">
                  <span id="userInfo2">    <font size="-1" color="#FFFFFF">
                  
                  </font>
                  </span>
               </div>
               
                <div id="userInfo3" style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 1150px; top: 540px; display:none; ">
                  <span id="userInfo3">    <font size="-1" color="#FFFFFF">
                  		<a href="fileUpload.jsp" > <img width="200px" height="100px"  src="content/images/2.jpg" alt="上传" /></a>
                  </font>
                  </span>
               </div>
               
               <div id="userInf4" style="position: absolute; width: 355px; height: 28px; z-indent: 2; left: 0px; top: 550px; display:block; ">
                  <span id="userInfo4">    <font size="-1" color="#FFFFFF">
                  		<button onclick="show();"> <img id="userInfo5" src="../content/images/2.jpg" alt="SHOW" /> </button>
                  </font>
                  </span>
               </div>
        <div class="wrapper">
            <div id="player">
                <audio controls id="audio" src="./content/songs/na_ge.mp3">!Audio Not Support :(</audio>
            </div>
            <div id="playlist" style="display:none;" >
                <ol>
               <%
               	ArrayList<UpFile> list=new ArrayList<UpFile>();
                               	 list= files.questFile();
                               	 Iterator it=list.iterator();
                               	 while(it.hasNext()){
                               		 UpFile mUpFile=new UpFile();
                               		 mUpFile=(UpFile)it.next();
               %>
                    <li>
                        <a href="javascript:void(0);" data-name=<%=mUpFile.getFile_downPerson() %>><%=mUpFile.getFile_name() %></a> 
                        <a href="DownServlet?path=<%=mUpFile.getFile_address() %>" >  下载 </a> 
                    </li>
                  <%} %> 
                </ol>
                <div class="info">
                    <div class="bg" id="bg_dark" title="use color for background"></div>
                    <div class="bg" id="bg_pic" title="use image for background"></div>
                </div>
            </div>
            <div id="lyricWrapper">
                <div id="lyricContainer">
                </div>
            </div>
        </div>
   <script src="scripts/selected.js"></script>   
    </body>
</html>

</body>
</html>