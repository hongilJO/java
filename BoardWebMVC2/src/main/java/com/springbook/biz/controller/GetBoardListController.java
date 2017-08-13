package com.springbook.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// DB 연동 처리
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();

		List<BoardDTO> boardList = dao.getBoardList(dto);

		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		return "getBoardList";
	}

}
