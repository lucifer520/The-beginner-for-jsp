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
		ArrayList newsList=mNewFileDao.getNewsList("D:\\eclisp\\jsonObject\\News");
		Iterator it=newsList.iterator();
		while(it.hasNext()){
			HashMap<String, News> news=(HashMap<String, News>)it.next();
			System.out.println(news.get("D:\\eclisp\\jsonObject\\News\\1.txt").getTitle());
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
