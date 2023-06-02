package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class FindMemberByIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "findbyid-fail.jsp";
		MemberVO mvo = MemberDAO.getInstance().findMemberById(id);
		if(mvo!=null) {
			request.setAttribute("member", mvo);
			path = "findbyid-ok.jsp";
		}
		return path;
	}

}
