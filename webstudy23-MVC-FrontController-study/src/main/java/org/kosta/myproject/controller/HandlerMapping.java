package org.kosta.myproject.controller;
/*
 * FrontControllerServlet(공통정책담당)과 Controller(개별컨트롤러로직담당)을
 * 연결하는 역할
 * Reflection API를 통해 Front에서 전달하는 command에 따라 런타임시에 
 * 동적으로 컨트롤러 객체를 생성해 Front에 리턴한다
 * 
 * HandlerMapping은 시스템 상에서 단 한번 생성해서 공유해 사용하면 되므로
 * Singleton Design Pattern 을 사용한다
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		String pachageInfo = this.getClass().getPackage().getName();
		StringBuilder sb = new StringBuilder(this.getClass().getPackage().getName());
		sb.append(".").append(command).append("Controller");
		return (Controller) Class.forName(sb.toString()).newInstance();
	}
}
