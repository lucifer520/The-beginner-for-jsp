<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 核心标签库 -->

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- <%@ taglib prefix="xml"  uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglin prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%> --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:useBean id="linkman" class="com.LinkmanForm"></jsp:useBean>
<!-- 表达式标签 -->
escapeXml 的属性为false时：<c:out value="<br>" escapeXml="false"/>
escapeXml 的属性为false时：<c:out value="<br>" />
<br>
*********************************************************************************<br>
<c:out value="${user }" default="user的值为空"></c:out>
<c:out value="${user }"></c:out>
user 的值为空
<br>
<c:set var="user" value="xutao" scope="session"></c:set>
类型一：${sessionScope.user }
<br>

<c:set var="money" scope="request">sssss和${12*3 }</c:set>
类型二：${requestScope.money }
<br>

类型三：
<c:set target="${linkman }" property="id" value="1"></c:set>
<c:set target="${linkman }" property="name" value="许涛"></c:set>
<c:set target="${linkman }" property="tel" value="123456"></c:set>
id属性为：<c:out value="${linkman.id }"></c:out>
name属性为：<c:out value="${linkman.name }"></c:out>
tel属性为：<c:out value="${linkman.tel }"></c:out>
<br>
类型四：
<c:set target="${linkman }" property="id" >1</c:set>
<c:set target="${linkman }" property="name" >许涛</c:set>
<c:set target="${linkman }" property="tel" >123456</c:set>
id属性为：<c:out value="${linkman.id }"></c:out>
name属性为：<c:out value="${linkman.name }"></c:out>
tel属性为：<c:out value="${linkman.tel }"></c:out>




<br>************************c:remove*********************<br>
<c:set var="softName" value="许涛的神话" scope="page"></c:set>
<c:out value="softName"></c:out>                   <!-- 输出的只是softName -->
<c:out value="${pageScope.softName }"></c:out>     <!-- 输出的是softName的value 值  "许涛的神话" -->
       ${pageScope.softName }                       <!-- 输出的是softName的value 值  "许涛的神话" -->
       
 <br>
 <c:remove var="softName" scope="page"/>
 <c:out value="${scopePage.softName }" default="softName的值已经 remove"></c:out>

<br>************************c:catch***********************<br>
 <c:catch var="exception">
 <%
 int number=Integer.parseInt(request.getParameter("number"));
 out.println("合计金额："+52*number);
 
 %>
 </c:catch>
  抛出异常信息:<c:out value="${exception }"></c:out>
  
  
<br><!--  if标签 --><br>
<br>*************************c:if choose when  otherwise********************
语法一：<br>  test:可以应用EL表达式，var scope不可以引用""
<br>
<c:if test="${empty param.comment }">
      <form name="form1" method="post" action="">
         <textarea name="comment" rows="4" cols="30"></textarea>
         <input type="submit" name="Submit" value="发表评论">
      
      </form>


</c:if>  
${param.comment }


<br><!-- choose when otherwise标签     如同switch case一样的作用 --><br>
<c:choose>
      <c:when test="${empty sessionScope.userChoose }">
           <form action="login.jsp" name="form2" method="post">
                                            用户 名：<input type="text" name="user2" id="user2">
                   <input type="submit" name="Submit1" value="登录">
           </form>
      </c:when>
      <c:otherwise>
         <c:out value="欢迎您  ${sessionScope.userChoose }"></c:out>
         <a href="logout.jsp"> 退出</a>
      </c:otherwise>


</c:choose>







</body>
</html>