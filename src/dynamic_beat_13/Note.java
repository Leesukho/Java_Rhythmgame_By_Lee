package dynamic_beat_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x,y = 580-1000/Main.SLEEP_TIME*Main.NOTE_SPEED;  //���� note�� ��ġ ���� , y�� 1�ʰ� �Ǳ����ؼ� ��������-1000(1��)/�������½ð����ӵ�
	private String noteType;
	
	public Note(int x, String noteType) { //������
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) { //�ϳ��� Note�� ���� �̹����� ����� �ֵ���
		if(noteType.contentEquals("short")) {
			g.drawImage(noteBasicImage,x,y,null); //���� �ڽ��� ��ġ�� ������ �׷���
		}
		else if(noteType.contentEquals("long")) {// Space Bar�� ���δ�
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null); //note�� ���δ� 100�ȼ� �̱� ������ 100�� ���Ѵ�
		}
		
	}
	public void drop() {
		y+=Main.NOTE_SPEED; //NOTE_SPEED��ŭ ����ǥ�� ����(�Ʒ������� 7��ŭ ��������)
	}
	@Override
	public void run() { //Thread ������?
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);//SLEEP_TIME��ŭ �����ִ� (���� �� �ȿ��� ms������ ��ġ�� ������)0.01(10)�� ����
				//1�� 700�ȼ���ŭ Y��ǥ�� �Ʒ��� ��������
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
