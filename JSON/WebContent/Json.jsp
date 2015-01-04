<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p id="demo">
JavaScript 能改变 HTML 元素的内容。
</p>
<p>


Name: <span id="jname"></span><br />
Age: <span id="jage"></span><br />
Address: <span id="jstreet"></span><br />
Phone: <span id="jphone"></span><br />
</p>




<script>
          function handleJson() { 
            var j={"name":"Michael","address":
                               { "city":"Beijing","street":" Chaoyang Road ","postcode":100025}
                                                  }; 
             document.write(j.name);  
             document.write(j.address.city); 
             document.write("<t>hhhhhhhh</t>");            //您只能在 HTML 输出中使用 document.write。如果您在文档加载后使用该方法，会覆盖整个文档。
              x=document.getElementById("demo") ;
             x.innerHTML="wewewrwer";
          
          } 
          
          var JSONObject= {
        		  "name":"Bill Gates",
        		  "street":"Fifth Avenue New York 666",
        		  "age":56,
        		  "phone":"555 1234567"};
        		  document.getElementById("jname").innerHTML=JSONObject.name
        		  document.getElementById("jage").innerHTML=JSONObject.age
        		  document.getElementById("jstreet").innerHTML=JSONObject.street
        		  document.getElementById("jphone").innerHTML=JSONObject.phone
</script>

<button type="button" onclick="alert('Welcome!')">点击这里</button>
<button type="button" onclick="handleJson()">点击这里</button>






</body>
</html>