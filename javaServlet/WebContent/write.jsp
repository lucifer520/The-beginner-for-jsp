<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%!
	    public int[] getNumber(String s) {
	//定义了4个投票数值
	        int[] mCount = new int[4];
            String strTemp = null;
	        int i;
	        java.io.RandomAccessFile rf = null;
	        try {
	            rf = new java.io.RandomAccessFile(s, "r");
	        } catch (Exception e) {
	        }
	        for (i = 0; i < 4; i++) {
	            try {
	                strTemp = rf.readLine();
	            } catch (Exception e) {
	            }
	            if (strTemp == null) {
	                strTemp = "0";
	            }
	            mCount[i] = new Integer(strTemp).intValue();
	        }
	        return mCount;
	    }
    public void setNumber(String s, int[] x) {
	        try {
	//通过文件输出流来计算投票数值
	            java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileOutputStream(s));
	            for (int i = 0; i < 4; i++) {
	//打印输出投票值
	                pw.println(x[i] + "");
	            }
	            pw.close();
	        } catch (Exception e) {
	        }
	    }
%>
	
<%
	            String tmp = null;
	            int choice = -1;
	            int[] count = new int[4];
	            tmp = request.getParameter("choice");
	            if (tmp == null) {
	            } else {
	                choice = new Integer(tmp).intValue();
	            }
	          //从count.txt文件中得到投票值
	           String s = request.getRealPath("count.txt");
	            if (choice >= 0) {
	            	//累计投票值
	             count = getNumber(s);
	             count[choice]++;
	            setNumber(s, count);
	            	            }
	            	//将页面重定向到index.jsp页
	            response.sendRedirect("index.jsp");
%>
     
	            
	            
	            
