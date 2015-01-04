<%--JavaBean.jsp文件，理解useBean动作的scope作用范围 --%>
 
<html>
<body>
<%-- 引用自己编写的javaBean生成的bean组件 --%>
<jsp:useBean id="student" scope="application" class="rmg.student" />
<%=student.getName()%><br>
<% student.setName("cong"); %>

<%-- 用getProperty动作来返回bean组件的属性值 --%>
<jsp:getProperty name="student" property="classNo" /> <br>
<jsp:getProperty name="student" property="name" /> <br>
<jsp:getProperty name="student" property="age" /> <br>
<jsp:getProperty name="student" property="sexy" /> <br>
<%-- 取属性值 --%>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.getSexy() %> <br>
<%--引用Java类库中生成的bean组件 --%>
<jsp:useBean id="date" scope="session" class="java.util.Date" />
<%=date%><br>
</body>
</html>
