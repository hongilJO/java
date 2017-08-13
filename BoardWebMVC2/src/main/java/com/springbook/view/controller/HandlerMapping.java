package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.biz.controller.DeleteBoardController;
import com.springbook.biz.controller.GetBoardListController;
import com.springbook.biz.controller.InsertBoardContoller;
import com.springbook.biz.controller.LoginController;
import com.springbook.biz.controller.UpdateBoardController;
import com.springbook.biz.controller.getBoardController;
import com.springbook.biz.controller.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// TODO Auto-generated constructor stub
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do",new getBoardController());
		mappings.put("/insertBoard.do", new InsertBoardContoller());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

	
	
}
