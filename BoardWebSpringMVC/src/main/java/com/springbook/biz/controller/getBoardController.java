package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;


public class getBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("글 상세 조회 기능");
		
		// 1. 검색할 게시글 번호 추출 
		String seq = request.getParameter("seq");
	 	
		BoardDTO dto =  new BoardDTO();
	 	
		dto.setSeq(Integer.parseInt(seq));

		BoardDAO dao = new BoardDAO();
		BoardDTO board = dao.getBoard(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard");
		mav.addObject("board",board);
		
		return mav;
	}

}
