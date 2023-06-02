package org.kosta.myproject.test.step1;

public class TestRedirectString {
	public static void main(String[] args) {
		String url = "redirect:register-result.jsp";
		//redirect: 로 시작되면 true 아니면 false
		System.out.println(url.startsWith("redirect:")); 
		//url 문자열을 redirect: 을 제외한 문자열을 추출해본다
		//인덱스 9부터 시작하는 문자열 추출
		System.out.println(url.substring(9));
	}
}
