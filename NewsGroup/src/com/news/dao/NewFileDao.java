package com.news.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.news.option.News;

public class NewFileDao implements NewsDaoInterface{
	public HashMap<String, News> getNewsList(String dirPath){
		HashMap<String, News> hm = new  HashMap<String, News>();
		File f = new File(dirPath);
		File[] newFiles = f.listFiles();
		for(int i=0; i<newFiles.length; i++){
			String newFilePath = dirPath + "\\" + newFiles[i].getName();
			News n = getNew(newFilePath);
			n.setFilePath(newFilePath);
			hm.put(newFilePath, n);
		}
		return hm;
	}
	public News getNew(String filePath){
		News n = new News();
		try{
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line=br.readLine();
				String jsonTmp="";
				while(line!=null){
					jsonTmp+=line;
					line=br.readLine();
				}
				JSONObject j = new JSONObject(jsonTmp);
				n.setTitle(j.getString("title"));
				n.setNewTime(j.getString("time"));
				n.setAuthor(j.getString("author"));
				n.setContent(j.getString("content"));
				br.close();
				return n;
		}catch(JSONException e){
				e.printStackTrace();
		}catch(IOException e){
				e.printStackTrace();
		}	
		return null;
	}
	
	public void inputNews(String dirPath,String title,String time,String author,String content){
		String pathname = dirPath + "\\"+title+".txt";
		File f = new File(pathname);
		String c="{\"title\":\""+title+"\",\"time\":\""+time+"\",\"author\":\""+author+"\",\"content\":\""+content+"\"}";
		System.out.print(c);
		FileOutputStream o=null;  
		  try {  
		   o = new FileOutputStream(f);  
		      o.write(c.getBytes("GBK"));  
		      o.close();  
		
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean deleteNews(String fileName){
		 File file = new File(fileName);
		   boolean d = false;
		if(file.exists())
		   d = file.delete();
		 return d;
	}
	
}