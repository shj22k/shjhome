package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class FindMemberByAddressController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPath = null;
		String address = request.getParameter("address");
		ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberListByAddress(address);
		if(list!=null) {
			viewPath = "findbyaddress-member-list.jsp";
			request.setAttribute("memList", list);
		}
		return viewPath;
	}
}
