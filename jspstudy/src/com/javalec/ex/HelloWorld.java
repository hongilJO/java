package com.javalec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * form 태그 method 속성값이 get, post 인지에 따라서 doGet, doPost 사용한다.
	 * 웹브라우저의 주소창을 이용하여 servlet을 요청한 경우에도 호출 됩니다.
	 * get 방식은 url값으로 정보가 전송되어 보안에 약함, post 방식은 header를 이용해 정보가 전송되어 보안에 강함
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    /* 요청 처리객체 httpServletRequest , 응답 처리객체 httpServletResponse 
	     * response.setContentType ("text/html")  응답을 html 형식으로 보냄 
	     *  서블릿은 자바파일이므로 html 코드가 없다
	     *  따라서 웹브라우저에 출력하기 위한 스트림인 response.getWriter()를 생성한다.
	     *  PrintWriter writer = response.getWriter();
	     *  writer.println("<html>")    ... wirter.println("</html>")
	     *  writer.close()
	     */
		// TODO Auto-generated method stub
		System.out.println("doget 호출 ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// context path 는 was에서 웹어플리케이션을 구분하기 위한 path 이다.
		// 이클립스에서 프로젝트를 생성하면 자동으로  Servers 밑의 server.xml에 이 값이 추가 된다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
