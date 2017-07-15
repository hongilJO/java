package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.bContentCommand;
import com.javalec.ex.command.bDeleteCommand;
import com.javalec.ex.command.bListCommand;
import com.javalec.ex.command.bModifyCommand;
import com.javalec.ex.command.bWriteCommand;
import com.javalec.ex.command.command;

/**
 * Servlet implementation class frontController
*/
@WebServlet("*.do")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private void actionDo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 String uri = request.getRequestURI();
		 String cpath = request.getContextPath();
		 String rq = uri.substring(cpath.length());
		 String viewpage= null;
		 
		 if (rq.equals("/list.do")){
			 command cmd = new bListCommand();
			 cmd.execute(request, response);
			 viewpage = "list.jsp";
		 }else if(rq.equals("/content_view.do")){
			 command cmd = new bContentCommand();
			 cmd.execute(request, response);
			 viewpage = "content_view.jsp";
		 }else if(rq.equals("/write.do")){
			 command cmd = new bWriteCommand();
			 cmd.execute(request, response);
			 viewpage = "list.do";
		 }else if(rq.equals("/write_view.do")){
			 viewpage = "write_view.jsp";
		 }else if(rq.equals("/modify.do")){
			 command cmd = new bModifyCommand();
			 cmd.execute(request, response);
			 viewpage="list.do";
		 }else if(rq.equals("/delete.do")){
			 command cmd = new bDeleteCommand();
			 cmd.execute(request, response);
			 viewpage="list.do";
		 }
		 
		RequestDispatcher rd= request.getRequestDispatcher(viewpage);
		try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

}
