package com.javalec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletContext
 */
//@WebServlet("/servletContext")
public class servletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// servlet context  
		// 서블릿 콘텍스트 는 여러 서블릿에서 공유하는 파라미터를 지정해주는 객체
		// web.xml에서 <context-param> 적고 <param-name> <param-value>로 지정한다.
		// getServletContext().getInitParameter()로 정보를 불러와서 사용한다.
		String gid = getServletContext().getInitParameter("globalid");
		String gpw = getServletContext().getInitParameter("globalpw");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(gid+gpw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
