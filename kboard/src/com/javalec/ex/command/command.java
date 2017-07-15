package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface command {
	
	void execute(HttpServletRequest rq, HttpServletResponse rp);
}
