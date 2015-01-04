package com.news.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.news.opation.News;

public class NewFileDao implements NewsDaoInterface{
	int count=0;
	public HashMap<String, News> getNewsList(String dirPath){
		HashMap<String, News> hm = new  HashMap<String, News>();
		File f = new File(dirPath);
		File[] newFiles = f.listFiles();
		for(int i=0; i<newFiles.length; i++){
			String addr=newFiles[i].getName();
			String newFilePath = dirPath + "\\" + addr;
			News n = getNew(newFilePath);
			hm.put(count+"", n);
			count++;
			
		}
		return hm;
	}
	public News getNew(String filePath){
		News n = new News();
		try{
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String JSONTmp = br.readLine();
				JSONObject j = new JSONObject(JSONTmp);
				
				n.setTitle(j.getString("title"));
				n.setNewTime(j.getString("time"));
				n.setAuthor(j.getString("author"));
				n.setContent(j.getString("content"));
				n.setFilePath(filePath);
				br.close();
				return n;
		}catch(JSONException e){
				e.printStackTrace();
		}catch(IOException e){
				e.printStackTrace();
		}	
		return null;
			
	}	
	
	
	
}
