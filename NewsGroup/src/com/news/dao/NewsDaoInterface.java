package com.news.dao;

import java.util.HashMap;
import com.news.option.News;

public interface NewsDaoInterface {
	public HashMap<String, News> getNewsList(String dirPath);
	public News getNew(String filePath);
	public void inputNews(String dirPath,String title,String time,String author,String content);
	public boolean deleteNews(String fileName);
	
}
