package dynamic_beat_15;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x,y = 580-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;  //���� note�� ��ġ ���� , y�� 1�ʰ� �Ǳ����ؼ� ��������-1000(1��)/�������½ð����ӵ�
	private String noteType;
	private boolean proceeded = true; //���� ��Ʈ�� ���� ����
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {//���� ��Ʈ�� ������ �� �ʰ� �ϴ� �Լ�
		proceeded = false;
	}
	
	
	
	public Note( String noteType) { //������
		if(noteType.contentEquals("S")) {
			x = 228;
			}
		else if(noteType.contentEquals("D")) {
			x = 332;
		}
		else if(noteType.contentEquals("F")) {
			x = 436;
		}
		else if(noteType.contentEquals("Space")) {
			x = 540;
		}
		else if(noteType.contentEquals("J")) {
			x = 744;
		}
		else if(noteType.contentEquals("K")) {
			x = 848;
		}
		else if(noteType.contentEquals("L")) {
			x = 952;
		}
		this.noteType = noteType; //�ʱ�ȭ
		}
	
	public void screenDraw(Graphics2D g) { //�ϳ��� Note�� ���� �̹����� ����� �ֵ���
		if(!noteType.contentEquals("Space")) {
			g.drawImage(noteBasicImage,x,y,null); //���� �ڽ��� ��ġ�� ������ �׷���
		}
		else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null); //note�� ���δ� 100�ȼ� �̱� ������ 100�� ���Ѵ�
		}
		
	}
	public void drop() {
		y+=Main.NOTE_SPEED; //NOTE_SPEED��ŭ ����ǥ�� ����(�Ʒ������� 7��ŭ ��������)
		if(y>620) { //Note�� �����ٸ� ����� ����
			System.out.println("Miss");
			close();
		}
	
	}
	@Override
	public void run() { //Thread ������?
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);//SLEEP_TIME��ŭ �����ִ� (���� �� �ȿ��� ms������ ��ġ�� ������)0.01(10)�� ����
				}//1�� 700�ȼ���ŭ Y��ǥ�� �Ʒ��� ��������
				else {
					interrupt();//Thread�� �����ϵ��� interrupt�� �ɾ��ش�
					break;
				}
				
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void judge() {
	if(y >= 613) {
		System.out.println("Late");
		close();
	}
	else if(y >= 600) {
		System.out.println("Good");
		close();
	}
	else if(y >= 587) {
		System.out.println("Great");
		close();
	}
	else if(y >= 573) {
		System.out.println("Perpect");
		close();
	}
	else if(y >= 565) {
		System.out.println("Great");
		close();
	}
	else if(y >= 550) {
		System.out.println("Good");
		close();
	}
	else if(y >= 535) {
		System.out.println("Early");
		close();
	}
	
	}
	
}
