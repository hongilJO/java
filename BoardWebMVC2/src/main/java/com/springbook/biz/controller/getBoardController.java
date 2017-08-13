package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.view.controller.Controller;

public class getBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("글 상세 조회 기능");
		
		// 1. 검색할 게시글 번호 추출 
		String seq = request.getParameter("seq");
	 	
		BoardDTO dto =  new BoardDTO();
	 	
		dto.setSeq(Integer.parseInt(seq));

		BoardDAO dao = new BoardDAO();
		BoardDTO board = dao.getBoard(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
	}

}
