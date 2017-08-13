package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.view.controller.Controller;

public class InsertBoardContoller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("글 등록이 되었습니다.");
		
		//1. 사용자 입력 정보 추출
		String title = request.getParameter("title");
		String writer =  request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
			
		dao.insertBoard(dto);
		
		return "getBoardList.do";
	}

}
