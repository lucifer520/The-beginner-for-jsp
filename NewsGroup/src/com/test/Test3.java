package com.test;
import java.util.*;
import com.news.dao.NewFileDao; 
import com.news.option.News;

public class Test3 {
	public static void main(String args[]){
	 NewFileDao nf=new NewFileDao();
	 String dirpath="F:\\apache-tomcat-6.0.39\\webapps\\test\\news";
	 nf.inputNews(dirpath,"CVCV","2014-5-2","Michelle","dfgfgfgfg");
	}
}
