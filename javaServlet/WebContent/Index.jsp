<%@page contentType="text/html;charset=utf-8"%>
<%@page pageEncoding="utf-8"%>
<%@page import="java.io.*" %>
 	<%
	            response.setHeader("Cache-Control", "no-store");
	            response.setDateHeader("Expires", 0);
	%>
	<%!//设定问题选项
	    public String[] getQuestion(String s) {
	        //定义了4个选项
	        String[] strQ = new String[4];
	        String strTemp = null;
	        int i;
	        BufferedReader br = null;
	        try {
	            FileReader fr = new FileReader(s);
	            br = new BufferedReader(fr);
	        } catch (Exception e) {
	            System.out.println(e);
	            System.exit(0);
	        }
	        for (i = 0; i < 4; i++) {
	            try {
	            	
	            strTemp = br.readLine();
	            
	            } catch (Exception e) {
	            	
	            }
	             
	            if (strTemp == null) {
	                strTemp = "";
	            }
	            strQ[i] = strTemp;
	        }
	        return strQ;
	    }%>
	
	<%
	            String s = null;
	            String[] question = new String[4];
	
	//从question.txt文件中获取问题选项
	            s = request.getRealPath("question.txt");
	//将选项赋给question
	            question = getQuestion(s);
	%> 
	
<html>
<head>
<title></title>
</head>
<body>
你喜欢清风阁论坛吗？
<br>
 <form name=frm method=post action=write.jsp>
 <tr>
	   <td>
	   <%
	            String ss = null;
	            for (int i = 0; i < 4; i++) {
	                ss = "<input type=\"radio\" name=\"choice\" value=" + i + ">" + (char) ('A' + i) + "、" + question[i] + "<br>";
	                out.println(ss);
            }
	     %> 
	    </td>
</tr>
 <tr>
	     <td align=center>
	            <input type=submit value="投  票">
	     </td>
 </tr>
</form>


	        <hr>
	        <h2>投票结果如下：</h2>
	        <img src="http://localhost:8081/jsp/chap08/VoteImage" width=150 height=100>
	   		<img src="yang.jpg" width=150 height=100>
	        <br>
</body>
</html>

	        