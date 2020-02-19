package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);//화면 사이즈 변경 불가능
		setLocationRelativeTo(null);//화면 정 중앙에 띄우기 위해
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임 종료를 했을때 완전히 종료시키기 위해
		setVisible(true);//화면 출력을 위해서
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground2.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}
