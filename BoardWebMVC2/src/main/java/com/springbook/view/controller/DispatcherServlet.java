package com.springbook.view.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    		handlerMapping = new HandlerMapping();
    		viewResolver = new ViewResolver();
    		viewResolver.setPrefix("/");
    		viewResolver.setSuffix(".jsp");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); //port 이후에 나오는 경로값 추출 /biz2/*.do
		//System.out.println(url);
		String contextPath = request.getContextPath();
		//System.out.println(prefixPath);
		String path = uri.substring(uri.lastIndexOf("/")); // 뒤에서 부터 /을 포함한 문자열을 찾는다. /*.do
		//System.out.println(path);
		
		Controller ctrl = handlerMapping.getController(path);
		String viewName = ctrl.handleRequest(request, response);
		String view = null;
		
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(contextPath,viewName);
		}else {
			view = contextPath + "/" + viewName;
		}
		
		response.sendRedirect(view);
		
	}
	

}
