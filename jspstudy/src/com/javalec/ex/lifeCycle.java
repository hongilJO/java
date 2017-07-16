package com.javalec.ex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lifeCycle
 */
@WebServlet("/lifeCycle")
public class lifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter logfile ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lifeCycle() {
        super();
        System.out.println("생성자호출됌~~!");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init이 먼저 호출되었습니다.");
		try {
			logfile= new PrintWriter(new FileWriter("/Users/naver/Documents/workspace/jspstudy/src/com/javalec/ex/destory.txt",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * init 과 destroy는 generic servlet 추상클래스에서 오버라이드 하여 사용한다.
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy(){
		System.out.println("destroy가 호출되었습니다. 안녕~");
		logfile.printf("destory called!!");
		
	}
	/*
	 * 생성자 -> PostContruct-> init-> doget-> destroy-> PreDestory 호출됌 (순서대로)
	 */
	@PostConstruct
	public void initPostConstruct(){
		System.out.println("postconstruc호출됌!~!");
	}
	@PreDestroy
	public void preDestroy(){
		System.out.println("predestory호출됌!~");
		logfile.printf("predestory called!!");
		logfile.close();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("브라우저로 접근했으니 doGet 호출!!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost!");
	}

}
