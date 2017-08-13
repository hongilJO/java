package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("글 삭제가 되었습니다.");
		
		String seq = request.getParameter("seq");
		BoardDTO dto = new BoardDTO();
		dto.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(dto);
		
		return "getBoardList.do";
		
	}

}
