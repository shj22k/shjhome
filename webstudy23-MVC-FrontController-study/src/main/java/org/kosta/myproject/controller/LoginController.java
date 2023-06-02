package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO mvo = MemberDAO.getInstance().login(id, password);
		if(mvo==null) {
			viewPath="redirect:login-fail.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("name", mvo.getName());
			viewPath="redirect:index.jsp";
		}
		return viewPath;
	}
	
}
