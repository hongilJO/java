package com.javalec.ex;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formEx
 */
//@WebServlet("/formEx")
public class formEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubtf
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		String passwd = request.getParameter("passwd");
		response.setContentType("text/html;utf-8");
		String []hoby=request.getParameterValues("hobby");
		for (int i=0 ; i < hoby.length; i++){
			System.out.println(hoby[i]);
		}
		System.out.println(id+passwd);
		
	}

}
