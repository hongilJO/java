package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletInitParam
 * 
 * 초기화 파라미터를 생성한 서블릿 파일의 WebServlet 어노테이션에 기술하여 작성한다.  @WebServlet(urlPatterns="/~~~~", initparams ={@WebInitParam(name="~~",value="~~~"),@WebInitParam(name="~~",value="~~~")})
 */
@WebServlet(urlPatterns="/servletInitParam", initParams = {@WebInitParam(name="id",value="hongil"),@WebInitParam(name="password",value="12345")})
public class servletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletInitParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = getInitParameter("id");
		String password = getInitParameter("password");
		PrintWriter wr= response.getWriter();
		wr.println("<html>");
		wr.println("<body>");
		wr.println("id:"+id);
		wr.println("password:"+password);
		wr.println("</body>");
		wr.println("</html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
