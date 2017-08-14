package com.springbook.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserDTO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			mav.setViewName("redirect:getBoardList.do");
		}else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
