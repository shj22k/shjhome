package org.kosta.myproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1.반응이오는지 체크
			// System.out.println(request.getServletPath());

			// 2./FrontTest.do -> / 와 .do 를 제거
			// System.out.println(request.getServletPath().substring(1,request.getServletPath().lastIndexOf(".")));
			// //FrontTest
			String command = request.getServletPath().substring(1, request.getServletPath().lastIndexOf("."));

			// 3.reflection API로 동적인 객체생성을 지원받는다 -> handlerMapping
			Controller controller = HandlerMapping.getInstance().create(command);

			// 4.path를 return 받는다
			String viewpath = controller.handleRequest(request, response);

			// 5.방식에 따라 redirect, forward를 분기하여 값을 보낸다
			if (viewpath.startsWith("redirect:")) {
				response.sendRedirect(viewpath.substring(9)); // substring은 경로상의 redirect: 를 제거하겠다는 의미이다
			} else {
				request.getRequestDispatcher(viewpath).forward(request, response);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}
}
