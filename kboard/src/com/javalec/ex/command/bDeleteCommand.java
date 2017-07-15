package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.board_dao;
import com.javalec.ex.dto.board;

public class bDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		board_dao dao= new board_dao();
		String bid = rq.getParameter("bid");
		dao.delete_board(Integer.parseInt(bid));
	}

}
