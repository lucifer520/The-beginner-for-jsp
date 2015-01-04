package com.test;
import java.util.*;
import com.news.dao.NewFileDao;
import com.news.option.News;
public class TestFile {
 public static void main(String args[]){
	 NewFileDao newDao=new NewFileDao();
	Map map=new HashMap();
	map=newDao.getNewsList("D:/new");
	Iterator iter=map.entrySet().iterator();
	while(iter.hasNext()){
		Map.Entry entry=(Map.Entry)iter.next();
		Object key=entry.getKey();
		Object val=entry.getValue();
		News n=(News)val;
		System.out.println(n.getTitle());
		System.out.println(n.getAuthor());
		System.out.println(n.getContent());
	}
 }
}
