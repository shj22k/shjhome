package org.kosta.myproject.test.step3;
/*
 * Reflection API : 런타임시 동적으로 객체를 생성, 제어하는 기술
 * 
 * step3 에서는 실행 중인 현 클래스의 패키지 정보를 동적으로 가져와 객체 생성
 */
public class TestReflectionAPI2 {
	public Player autoCreate(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//현재 실행중인 객체의 패키지명을 가져온다
//		String packageInfo = this.getClass().getPackage().getName();
		StringBuilder packageInfo = new StringBuilder(this.getClass().getPackage().getName());
		packageInfo.append(".").append(command);
		System.out.println(packageInfo); //org.kosta.myproject.test.step3
		return (Player) Class.forName(packageInfo.toString()).newInstance();
	}
	public static void main(String[] args) {
		TestReflectionAPI2 ref = new TestReflectionAPI2();
		String command = "CDPlayer";
		Player player;
		try {
			player = ref.autoCreate(command);
			System.out.println("Reflection API로 런타임시에 동적으로 객체를 생성"+player);
			player.play();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
