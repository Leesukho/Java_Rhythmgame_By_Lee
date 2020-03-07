package dynamic_beat_15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//하나하나의 게임은 하나하나의 단위로써 다뤄질수 있어야해서 이렇게 클래스를 따로 만들어서 관리
public class Game extends Thread {//Thread 는 하나의 프로그램에서 실행되는 작은 프로그램


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
	
	private String titleName; //현재 실행할 곡의 이름
	private String difficulty; //현재 실행할 곡의 난이도
	private String musicTitle;
	private Music gameMusic; //음악 실행 인스턴트?
	
	ArrayList<Note> noteList = new ArrayList<Note>(); 
	
	public 	Game(String titleName,String difficulty, String musicTitle) { //생성자 생성
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle,false); //반복 취소
	}

	public void screenDraw(Graphics2D g){ //게임 실행화면 (노트,곡이름,점수,난이도,키패드)
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
		for(int i=0;i<noteList.size();i++) {
			Note note=noteList.get(i);
			if(!note.isProceeded()) { //사용되지 않는 노트는 화면에서 자동 삭제
				noteList.remove(i);
				i--;
				}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(titleName,20,702);
		g.drawString(difficulty,1190,702); //난이도
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
		judge("S");
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void pressD() { //D버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("D");
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressF() { //F버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("F");
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressSpace() { //Space버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("Space");
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		//Space버튼 1개로 Space1,2를 동시 조작
		new Music("drumBig1.mp3",false).start();
	}
	public void pressJ() { //J버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("J");
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3",false).start();
	}
	public void pressK() { //K버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("K");
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3",false).start();
	}
	public void pressL() { //L버튼을 눌렀을 경우 파란색으로 바뀜(게임 실행 화면의 노트 라인이)
		judge("L");
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
		dropNotes(this.titleName); //노트가 떨어질수 있도록 함

	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	public void dropNotes(String titleName) {
		Beat[] beats =null;{ //class에다가 변수 선언?
				if(titleName.equals("officialdism_fate") && difficulty.equals("Easy")) {
					int startTime = 1000 - Main.REACH_TIME * 1000;
					
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							
					};
				}	else if(titleName.equals("officialdism_fate") && difficulty.equals("Hard")) {
					int startTime = 1000 - Main.REACH_TIME * 1000;
					
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							
					};
				}
				else if(titleName.equals("officialdism_Yesterday") && difficulty.equals("Easy")) {
					int startTime = 4400 - Main.REACH_TIME * 1000;
					int gap = 130; //최소 박자의 간격
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							new Beat(startTime + gap *2,"J"),
							new Beat(startTime + gap *4,"D"),
					};
				}else if(titleName.equals("officialdism_Yesterday")&& difficulty.equals("Hard")) {
					int startTime = 4400 - Main.REACH_TIME * 1000;
					int gap = 130; //최소 박자의 간격
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							new Beat(startTime + gap *2,"J"),
							new Beat(startTime + gap *4,"D"),
					};
				}
				else if(titleName.equals("officialdism_pretender") && difficulty.equals("Easy")) {
					int startTime = 3000 - Main.REACH_TIME * 1000;
					int gap = 180; //Pretender 박자
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
							new Beat(startTime + gap * 60,"S"),
							new Beat(startTime + gap * 63,"D"),
							new Beat(startTime + gap * 70,"F"),
							new Beat(startTime + gap * 74,"Space"),
							 
							
							
					};
				}else if(titleName.equals("officialdism_pretender") && difficulty.equals("Hard")) {
					int startTime = 4400 - Main.REACH_TIME * 1000;
					int gap = 130; //최소 박자의 간격
					beats = new Beat[] {
							new Beat(startTime,"Space"),
							new Beat(startTime + gap *2,"J"),
							new Beat(startTime + gap *4,"D"),
					};
				}
				
		
		};
		int i=0;
		gameMusic.start(); //음악 재생 / 배열이 초기화 되어서 오는 시간격차를 최소화 시키기 위해 이 자리에 위치
		while(i<beats.length && !isInterrupted()) { //1씩 i를 증가시켜서 노트를 실시간으로 관리한다
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
	public void judge(String input) {
		for(int i=0; i<noteList.size(); i++) {
			Note note=noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.getNoteType();
				note.judge();
				break;
			}
		}
	}
}
