package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletInit
 */
//@WebServlet("/servletInit")
public class servletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ServletConfig
		// web.xml 파일에서 <servlet> 태그 밑에 <init-param> 으로 초기화 파라미터를 저장하고 <param-name> , <param-value>
		// 서블릿 클래스에서 가져와 사용한다.
		String id= getInitParameter("id"); //generic sevlet의 메소드를 상속받아 사용한다.
		String password = getInitParameter("password");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter wr= response.getWriter();
		wr.println("<html>");
		wr.println("<body>");
		wr.println("id:"+id);
		wr.println("password:"+password);
		wr.println("</body>");
		wr.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
