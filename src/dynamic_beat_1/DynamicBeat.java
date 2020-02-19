package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);//화면 사이즈 변경 불가능
		setLocationRelativeTo(null);//화면 정 중앙에 띄우기 위해
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임 종료를 했을때 완전히 종료시키기 위해
		setVisible(true);//화면 출력을 위해서
		
	}
}
