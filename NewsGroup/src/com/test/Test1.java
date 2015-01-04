package com.test;
import java.util.*;
import com.news.dao.NewFileDao; 
import com.news.option.News;
public class Test1 {
	public static void main(String args[]){
		NewFileDao newDao=new NewFileDao();
		HashMap<String, News> hm =new HashMap<String, News>();
		hm=newDao.getNewsList("F:\\apache-tomcat-6.0.39\\webapps\\test\\news");
		Iterator iter=hm.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry=(Map.Entry)iter.next();
			Object key=entry.getKey();
			Object val=entry.getValue();
			News n=(News)val;
			System.out.println(n.getTitle());
	}

}
}
