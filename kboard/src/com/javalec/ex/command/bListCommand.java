package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.board_dao;
import com.javalec.ex.dto.board;

public class bListCommand implements command {
	
	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		board_dao dao = new board_dao();
		ArrayList<board> list = dao.get_boardlist();
		rq.setAttribute("list", list);
	}

}
