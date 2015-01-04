package com.news.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.news.opation.News;

public interface NewsDaoInterface {
	public ArrayList getNewsList(String dirPath);
	public News getNew(String filePath);
	
	
}
