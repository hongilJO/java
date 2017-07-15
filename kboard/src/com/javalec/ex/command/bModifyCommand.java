package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.javalec.ex.dao.board_dao;

public class bModifyCommand implements command{

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		board_dao dao= new board_dao();
		String bid = rq.getParameter("bid");
		String btitle = rq.getParameter("btitle");
		String bcontent = rq.getParameter("bcontent");
		dao.update_board(Integer.parseInt(bid), btitle, bcontent);
	}

}
