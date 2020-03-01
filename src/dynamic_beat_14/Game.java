package dynamic_beat_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//�ϳ��ϳ��� ������ �ϳ��ϳ��� �����ν� �ٷ����� �־���ؼ� �̷��� Ŭ������ ���� ���� ����
public class Game extends Thread {//Thread �� �ϳ��� ���α׷����� ����Ǵ� ���� ���α׷�


	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();// ��Ʈ���� ������
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();// ��Ʈ �����ϴ� ���� �׵θ��� ������ ��
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();// ���� ���� ���� ������ ��
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	
	private String titleName; //���� ������ ���� �̸�
	private String difficulty; //���� ������ ���� ���̵�
	private String musicTitle;
	private Music gameMusic; //���� ���� �ν���Ʈ?
	
	ArrayList<Note> noteList = new ArrayList<Note>(); 
	
	public 	Game(String titleName,String difficulty, String musicTitle) { //������ ����
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle,false); //�ݺ� ���
	}

	public void screenDraw(Graphics2D g){ //���� ����ȭ�� (��Ʈ,���̸�,����,���̵�,Ű�е�)
		g.drawImage(noteRouteSImage, 228, 30, null); // S
		g.drawImage(noteRouteDImage, 332, 30, null); // D
		g.drawImage(noteRouteFImage, 436, 30, null); // F
		g.drawImage(noteRouteSpace1Image, 540, 30, null); //Space Bar(1)
		g.drawImage(noteRouteSpace2Image, 640, 30, null); //Space Bar(2)
		g.drawImage(noteRouteJImage, 744, 30, null); // J
		g.drawImage(noteRouteKImage, 848, 30, null); // K 
		g.drawImage(noteRouteLImage, 952, 30, null); // L
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		//Y���� 580 �� PinPoint
		for(int i=0;i<noteList.size();i++) {
			Note note=noteList.get(i);
			note.screenDraw(g);		
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(titleName,20,702);
		g.drawString(difficulty,1190,702); //���̵�
		g.setFont(new Font("Arial",Font.PLAIN,27));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant",Font.BOLD,30)); 
		g.drawString("000000", 565, 702); //����
		
		
	}
	public void pressS() { //S��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void pressD() { //D��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressF() { //F��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressSpace() { //Space��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		//Space��ư 1���� Space1,2�� ���� ����
		new Music("drumBig1.mp3",false).start();
	}
	public void pressJ() { //J��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressK() { //K��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressL() { //L��ư�� ������ ��� �Ķ������� �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseS() { //S��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseD() { //D��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseF() { //F��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseSpace() { //Space��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		//Space��ư 1���� Space1,2�� ���� ����
	}
	public void releaseJ() { //J��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseK() { //K��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseL() { //L��ư�� �� ��� ȸ������ �ٲ�(���� ���� ȭ���� ��Ʈ ������)
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(); //��Ʈ�� �������� �ֵ��� ��

	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	public void dropNotes() {
		Beat[] beats =null;{ //class���ٰ� ���� ����?
				if(titleName.equals("officialdism_fate")) {
					int startTime = 1000 - Main.REACH_TIME * 1000;
					
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							
					};
				}
				else if(titleName.equals("officialdism_Yesterday")) {
					int startTime = 4400 - Main.REACH_TIME * 1000;
					int gap = 130; //�ּ� ������ ����
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							new Beat(startTime + gap *2,"J"),
							new Beat(startTime + gap *4,"D"),
					};
				}
				else if(titleName.equals("officialdism_pretender")) {
					int startTime = 3000 - Main.REACH_TIME * 1000;
					int gap = 180; //Pretender ����
					beats = new Beat[] {
							new Beat(startTime - gap * 1,"Space"),
							new Beat(startTime + gap * 14,"S"),
							new Beat(startTime + gap * 15,"D"),
							new Beat(startTime + gap * 16,"F"),
							new Beat(startTime + gap * 24,"Space"),
							new Beat(startTime + gap * 27,"J"),
							new Beat(startTime + gap * 28,"K"),
							new Beat(startTime + gap * 29,"L"),
							new Beat(startTime + gap * 35,"K"),
							new Beat(startTime + gap * 38,"L"),
							new Beat(startTime + gap * 40,"S"),
							new Beat(startTime + gap * 44,"F"),
							new Beat(startTime + gap * 44,"J"),
							new Beat(startTime + gap * 44,"Space"),
							new Beat(startTime + gap * 50,"S"),
							new Beat(startTime + gap * 56,"S"),
							new Beat(startTime + gap * 57,"D"),
							new Beat(startTime + gap * 58,"F"),
							 
							
							
					};
				}
		
		};
		int i=0;
		gameMusic.start(); //���� ��� / �迭�� �ʱ�ȭ �Ǿ ���� �ð������� �ּ�ȭ ��Ű�� ���� �� �ڸ��� ��ġ
		while(i<beats.length && !isInterrupted()) { //1�� i�� �������Ѽ� ��Ʈ�� �ǽð����� �����Ѵ�
			boolean dropped = false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
