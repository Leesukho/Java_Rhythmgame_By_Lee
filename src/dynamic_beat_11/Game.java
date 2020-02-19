package dynamic_beat_11;
//8:00
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
//�ϳ��ϳ��� ������ �ϳ��ϳ��� �����ν� �ٷ����� �־���ؼ� �̷��� Ŭ������ ���� ���� ����
public class Game extends Thread {//Thread �� �ϳ��� ���α׷����� ����Ǵ� ���� ���α׷�

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();// �������� ��Ʈ
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
	


	public void screenDraw(Graphics2D g){ //
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
		g.drawImage(noteBasicImage, 228, 120, null);
		g.drawImage(noteBasicImage, 332, 580, null);
		g.drawImage(noteBasicImage, 436, 300, null);
		g.drawImage(noteBasicImage, 540, 401, null); // SpaceBar(1)
		g.drawImage(noteBasicImage, 640, 401, null); // SpaceBar(2)
		g.drawImage(noteBasicImage, 744, 516, null);
		g.drawImage(noteBasicImage, 848, 311, null);
		g.drawImage(noteBasicImage, 952, 30, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("officialdism-Yesterday",20,702);
		g.drawString("Easy",1190,702); //���̵�
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

	}
}