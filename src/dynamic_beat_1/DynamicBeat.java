package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);//ȭ�� ������ ���� �Ұ���
		setLocationRelativeTo(null);//ȭ�� �� �߾ӿ� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���� ���Ḧ ������ ������ �����Ű�� ����
		setVisible(true);//ȭ�� ����� ���ؼ�
		
	}
}
