package com.Servlwt;
	import java.io.IOException;
	import java.io.PrintWriter;	
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;	
	import java.io.*;
	import java.util.*;
	import com.sun.image.codec.jpeg.*;
	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.awt.*;
	import java.awt.geom.*;
	import java.awt.image.*;
	
	public class VoteImage extends HttpServlet {
	
	    private String strFile = null;
	    //设定图片选项的颜色
	    private Color color[] = {Color.red, Color.black, Color.orange, Color.green};
	    private int baseAng = 100;
	
	    //处理Http的Get请求
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //从count.txt文件中获取投票值
	        strFile = request.getRealPath("count.txt");
	        response.setContentType("image/jpeg");
	        float[][] xy = new float[4][2];
	        xy = getNumAndPercent(strFile);
	        //设定一个分成4份的圆形比例图
	        int[] ang = new int[4];
	        ang[0] = (int) (xy[0][1] * 360);
	        ang[1] = (int) (xy[1][1] * 360);
	        ang[2] = (int) (xy[2][1] * 360);
	        ang[3] = 360 - ang[0] - ang[1] - ang[2];
	        	        BufferedImage image = new BufferedImage(150, 100, BufferedImage.TYPE_INT_RGB);
	        	        Graphics2D g = (Graphics2D) image.getGraphics();
	        	        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        	        g.setColor(Color.white);
	        	        g.fillRect(0, 0, 150, 100);
	        	        AffineTransform at = null;
	        	        Arc2D arc = null;
	        	        int fromAng = baseAng;
	        	        at = AffineTransform.getRotateInstance((-20 * java.lang.Math.PI) / 180, 45, 37);
	        	        g.setTransform(at);
	        	        g.setColor(color[0]);
	        	        fromAng += ang[0];
	        	        for (int i = 1; i < 4; i++) {
	        	            g.setColor(color[i]);
	        	            arc = new Arc2D.Double(10, 24, 80, 50, fromAng, ang[i], Arc2D.PIE);
	        	            g.fill(arc);
	        	            fromAng += ang[i];
	        	        }
	        	        at = AffineTransform.getRotateInstance(0, arc.getCenterX(), arc.getCenterY());
	                g.setTransform(at);
	        	        for (int i = 0; i < 4; i++) {
	        	            //选项与相应的颜色对应
	        	            g.setColor(color[i]);
	        	            g.fillRect(100, 15 * i + 20, 10, 10);
	        	            g.drawString((char) ('A' + i) + "", 120, 15 * i + 20 + 8);
	        	        }
	        	
	        	        JPEGImageEncoder jpegimageencoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
	        	        jpegimageencoder.encode(image);
	        	    }	

	        	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        	            throws ServletException, IOException {
	        	        doGet(request, response);
	        	    }
	        	
	        	    public synchronized float[][] getNumAndPercent(String sFileName) {
	        	        float xx[][] = new float[4][2];
	        	        int totalNum = 0;
	        	        String strTemp = null;
	        	        int i = 0;
	        	        java.io.RandomAccessFile rf = null;
	        	        	        try {
	        	        	            rf = new java.io.RandomAccessFile(sFileName, "r");
	        	        	        } catch (Exception e) {
	        	        	            System.out.println(e);
	        	        	            System.exit(0);
	        	        	        }
	        	        	        for (i = 0; i < 4; i++) {
	        	        	            int m = 0;
	        	        	            try {
	        	        	                strTemp = rf.readLine();
	        	        	            } catch (Exception e) {
	        	        	            }
	        	        	        }
	        	        	        return xx;
	        	    }
	}



