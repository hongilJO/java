package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;


public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("글 삭제가 되었습니다.");
		
		String seq = request.getParameter("seq");
		BoardDTO dto = new BoardDTO();
		dto.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
		
	}

}
