package com.springbook.biz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserDTO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String url = request.getRequestURI(); //port 이후에 나오는 경로값 추출 /biz2/*.do
		System.out.println(url);
		String path = url.substring(url.lastIndexOf("/")); // 뒤에서 부터 / 을 포함한 문자열을 찾는다. /*.do
		System.out.println(path);
		
		if (path.equals("/login.do")) {
			System.out.println("로그인 되었습니다.");
			
			// 사용자 입력 정보 추출 
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// db 연동 
			UserDTO dto = new UserDTO();
			
			dto.setId(id);
			dto.setPassword(password);
			
			UserDAO dao = new UserDAO();
			UserDTO user = dao.getUser(dto);
			
			// 화면 네비게이션 
			if (user != null){
				response.sendRedirect("getBoardList.do");
			}else {
				response.sendRedirect("login.do");
			}
		}else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 되었습니다.");
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록이 되었습니다.");
			
			//1. 사용자 입력 정보 추출
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer =  request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			
			BoardDAO dao = new BoardDAO();
				
			dao.insertBoard(dto);
			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정이 되었습니다.");
			
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(dto);
			
			response.sendRedirect("getBoardList.do");
			
		}else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제가 되었습니다.");
			
			String seq = request.getParameter("seq");
			BoardDTO dto = new BoardDTO();
			dto.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(dto);
			
			response.sendRedirect("getBoardList.do");
		}else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 기능");
			
			// 1. 검색할 게시글 번호 추출 
			String seq = request.getParameter("seq");
		 	
			BoardDTO dto =  new BoardDTO();
		 	
			dto.setSeq(Integer.parseInt(seq));

			BoardDAO dao = new BoardDAO();
			BoardDTO board = dao.getBoard(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			response.sendRedirect("getBoard.jsp");
			
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 조회 기능");
			
			// 사용자 입력 정보 추출(검색 기능은 나중에 구현)
			// DB 연동 처리 
			BoardDTO dto = new BoardDTO();
			BoardDAO dao = new BoardDAO();

			List<BoardDTO> boardList = dao.getBoardList(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");

		}
		
	}
	

}
