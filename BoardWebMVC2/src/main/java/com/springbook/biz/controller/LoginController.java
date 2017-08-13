package com.springbook.biz.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserDTO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// db 연동
		UserDTO dto = new UserDTO();

		dto.setId(id);
		dto.setPassword(password);

		UserDAO dao = new UserDAO();
		UserDTO user = dao.getUser(dto);

		// 화면 네비게이션
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.do";
		}
	}

}
