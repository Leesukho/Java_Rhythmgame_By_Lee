package dynamic_beat_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x,y = 580-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;  //현재 note의 위치 변수 , y가 1초가 되기위해서 판정라인-1000(1초)/떨어지는시간＊속도
	private String noteType;
	
	public Note( String noteType) { //생성자
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
		this.noteType = noteType; //초기화
		}
	
	public void screenDraw(Graphics2D g) { //하나의 Note에 대한 이미지를 만들수 있도록
		if(!noteType.contentEquals("Space")) {
			g.drawImage(noteBasicImage,x,y,null); //현재 자신이 위치한 공간에 그려줌
		}
		else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null); //note의 가로는 100픽셀 이기 때문에 100을 더한다
		}
		
	}
	public void drop() {
		y+=Main.NOTE_SPEED; //NOTE_SPEED만큼 ｙ좌표가 증가(아래쪽으로 7만큼 떨어진다)
	}
	@Override
	public void run() { //Thread 때문에?
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);//SLEEP_TIME만큼 쉴수있다 (원래 저 안에는 ms단위의 수치가 들어가야함)0.01(10)초 설정
				//1총 700픽셀만큼 Y좌표가 아래로 내려간다
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
