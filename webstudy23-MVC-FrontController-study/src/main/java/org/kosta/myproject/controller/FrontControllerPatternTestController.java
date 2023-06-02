package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerPatternTestController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//forward test
		return "test-result.jsp";
//		return "redirect:test-result.jsp";
		// error 처리 테스트
//		return null;
	}

}
