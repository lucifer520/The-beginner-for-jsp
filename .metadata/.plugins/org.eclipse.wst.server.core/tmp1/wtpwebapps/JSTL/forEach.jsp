<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach</title>
</head>
<body>
<%ArrayList list=new ArrayList();
  list.add("明日科技");
  list.add("编程词典");
  list.add("www.bccd.com");
  request.setAttribute("list", list);
%>

利用&It;c:forEath&It;标签遍历List集合的结果如下<br>
<c:forEach  items="${ requestScope.list}" var="keyword" varStatus="id" begin="0" >
 ${id.index } &nbsp;${keyword }<br>

</c:forEach>
 <p>
属性名     是否支持动态属性值    属性类型         属性描述
</p>
<p>
var        false                String          指定将当前迭代元素保存在page域中的属性名
</p>
items       True               任何类型数据      用于迭代的集合对象
<p>
varStatus   false              String           指定将表示当前迭代元素的状态信息的对象保存在page域中的属性名。当前迭代元  
                                                                                                      素的状态信息对象实际上是javax.servlet.jsp.jstl.core.LoopTagStatus类  中的  对象实例\
<p>
begin 
</p>
<p>
end
</p>
<p>
step
</p>



<p>
varStatus 属性
</p>
<p>
 index                  当前循环的索引值 从0开始
 </p>
 <p>
 count                  计数
</p>
<p>
  frist                 是否为第一吃次循环
  </p>
  <p>
 last                    是否为最后一次循环
</p>


</body>
</html>