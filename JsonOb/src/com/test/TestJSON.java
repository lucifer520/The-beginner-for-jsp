package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.news.dao.NewFileDao;
import com.news.opation.News;

public class TestJSON {
	public static void main(String[] args){
		NewFileDao mNewFileDao=new NewFileDao();
		HashMap<String, News> newsList=mNewFileDao.getNewsList("D:\\eclisp\\jsonObject\\News");
		
		int a=newsList.size();
		for(int i=0;i<a;i++){
			System.out.println("第"+(i+1)+"条新闻:");
			System.out.println(newsList.get(i+"").getTitle());
			System.out.println(newsList.get(i+"").getNewTime());
			System.out.println(newsList.get(i+"").getAuthor());
			System.out.println(newsList.get(i+"").getContent());
			System.out.println();
			
			
		}
		
		
		
		
		/*try{
			JSONObject test = new JSONObject("{\"name\":\"hanjin\"}");	
			String name = test.getString("name");
			System.out.println(name);
		}catch(JSONException e){
			e.printStackTrace();
		}
		*/
		
	}
}
