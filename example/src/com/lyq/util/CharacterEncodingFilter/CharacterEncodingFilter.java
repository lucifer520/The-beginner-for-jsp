package com.lyq.util.CharacterEncodingFilter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(filterName="CharacterEncodingFilter",urlPatterns="/*",dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST},initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})

public class CharacterEncodingFilter implements Filter {
	//字符编码
	protected String encoding=null;
	//FilterConfig 对像
	protected FilterConfig filterConfig=null;
	
	//初始化方法
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		//对FilterConfig 赋值
		this.filterConfig=arg0;
		//对初始化参数赋值
		this.encoding=arg0.getInitParameter("encoding");
		

	}
	
	 //过滤器处理方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		//判断字符编码是否有效
	if(encoding!=null){
		//设置request字符编码
		request.setCharacterEncoding(this.encoding);
		//设置response字符编码
		response.setContentType("text/html;charset="+this.encoding);
		
	}
	//传递给下一个过滤器
	arg2.doFilter(request, response);

	}

	@Override
	public void destroy() {
		//释放资源
		this.encoding=null;
		this.filterConfig=null;
		
	}

	
	

}
