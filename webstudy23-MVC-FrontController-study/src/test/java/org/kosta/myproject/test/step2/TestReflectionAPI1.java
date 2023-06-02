package org.kosta.myproject.test.step2;

public class TestReflectionAPI1 {
	public static void main(String[] args) {
		Player player = null;
		String classInfo = "org.kosta.myproject.test.step2.Youtube";
		try {
			player = (Player) Class.forName(classInfo).newInstance();
			System.out.println(player+" 객체생성");
			player.play();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
