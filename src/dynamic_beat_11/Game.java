package dynamic_beat_11;
//8:00
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
//하나하나의 게임은 하나하나의 단위로써 다뤄질수 있어야해서 이렇게 클래스를 따로 만들어서 관리
public class Game extends Thread {//Thread 는 하나의 프로그램에서 실행되는 작은 프로그램

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();// 떨어지는 노트
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();// 노트라인 구별선
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();// 노트 판정하는 빨간 테두리의 검정색 바
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();// 게임 제목 들어가는 검정색 바
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// 노트가 내려오는 라인
	


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
		//Y축이 580 이 PinPoint
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
		g.drawString("Easy",1190,702); //난이도
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
		g.drawString("000000", 565, 702); //점수 
	}
	public void pressS() { //S버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void pressD() { //D버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressF() { //F버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressSpace() { //Space버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		//Space버튼 1개로 Space1,2를 동시 조작
		new Music("drumBig1.mp3",false).start();
	}
	public void pressJ() { //J버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressK() { //K버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressL() { //L버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseS() { //S버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseD() { //D버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseF() { //F버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseSpace() { //Space버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		//Space버튼 1개로 Space1,2를 동시 조작
	}
	public void releaseJ() { //J버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseK() { //K버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releaseL() { //L버튼을 뗄 경우 회색으로 바뀜(게임 실행 화면의 노트 라인이)
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {

	}
}
