package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.board_dao;
import com.javalec.ex.dto.board;

public class bContentCommand implements command {


	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		board_dao dao = new board_dao();
		String bid = rq.getParameter("bid");
		board b = dao.get_board(Integer.parseInt(bid));
		rq.setAttribute("board", b);
	}
}
