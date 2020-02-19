package dynamic_beat_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Title Image.png")).getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Start Image.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground2.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private int mouseX,mouseY;
	
	private boolean isMainScreen = false;
	
	public DynamicBeat() {
		setUndecorated(true); // 기본 메뉴 바 삭제
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 화면 사이즈 변경 불가능
		setLocationRelativeTo(null);// 화면 정 중앙에 띄우기 위해
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 게임 종료를 했을때 완전히 종료시키기 위해
		setVisible(true);// 화면 출력을 위해서
		setBackground(new Color(0, 0, 0, 0));//paintComponents를 했을때의 배경을 검정색이 아니라 하얀색으로 변경하기 위해
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);//메뉴바의 가장 오른쪽에 위치하는 사이즈
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {//Exit 에 관한 열
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 해당 버튼 위에 올라갔을때의 이벤트 처리
				exitButton.setIcon(exitButtonEnteredImage); //그림을 바꿔준다
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때는 손가락 버튼으로 바뀐다
				
				}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 해당 버튼에서 나왔을때의 이벤트 처리
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 버튼에서 나왔을때 손가락 버튼이 사라진다
			}
			@Override
			public void mousePressed(MouseEvent e) { //마우스가 해당 버튼을 클릭 했을때의 이벤트 처리

				try {
					Thread.sleep(1000);//1초정도 후에 프로그램이 종료된다
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		startButton.setBounds(40, 200, 400, 100);//메뉴바의 가장 오른쪽에 위치하는 사이즈
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { //Start 버튼에 관한 열
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 해당 버튼 위에 올라갔을때의 이벤트 처리
				startButton.setIcon(startButtonEnteredImage); //그림을 바꿔준다
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때는 손가락 버튼으로 바뀐다
				
				}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 해당 버튼에서 나왔을때의 이벤트 처리
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 버튼에서 나왔을때 손가락 버튼이 사라진다
			}
			@Override
			public void mousePressed(MouseEvent e) { //마우스가 해당 버튼을 클릭 했을때의 이벤트 처리
				startButton.setVisible(false); //startButton을 안보이게 해주는것
				quitButton.setVisible(false); //quitButton을 안보이게 해주는것
				leftButton.setVisible(true);//leftButton을 보이게 해주는것
				rightButton.setVisible(true);//rightButton을 보이게 해주는것
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();//Start 버튼이 눌렸을 경우 이미지 출력
				isMainScreen = true;
			}
		});
		
		add(startButton);
		

		quitButton.setBounds(40, 330, 400, 100);//메뉴바의 가장 오른쪽에 위치하는 사이즈
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {// quit에 관한 열
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 해당 버튼 위에 올라갔을때의 이벤트 처리
				quitButton.setIcon(quitButtonEnteredImage); //그림을 바꿔준다
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때는 손가락 버튼으로 바뀐다
				}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 해당 버튼에서 나왔을때의 이벤트 처리
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 버튼에서 나왔을때 손가락 버튼이 사라진다
			}
			@Override
			public void mousePressed(MouseEvent e) { //마우스가 해당 버튼을 클릭 했을때의 이벤트 처리
				//게임 시작 이벤트 종료
				try {
					Thread.sleep(1000);//1초정도 후에 프로그램이 종료된다
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		add(quitButton);
		leftButton.setVisible(false);//맨 처음엔 보이지 않게 하기 위해
		leftButton.setBounds(140, 310, 60, 60);//메뉴바의 가장 오른쪽에 위치하는 사이즈
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {// quit에 관한 열
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 해당 버튼 위에 올라갔을때의 이벤트 처리
				leftButton.setIcon(leftButtonEnteredImage); //그림을 바꿔준다
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때는 손가락 버튼으로 바뀐다
				}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 해당 버튼에서 나왔을때의 이벤트 처리
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 버튼에서 나왔을때 손가락 버튼이 사라진다
			}
			@Override
			public void mousePressed(MouseEvent e) { //마우스가 해당 버튼을 클릭 했을때의 이벤트 처리
				//왼쪽 버튼 이벤트
				
				
			}
		});
		
		add(leftButton);
		rightButton.setVisible(false);//맨 처음엔 보이지 않게 하기 위해
		rightButton.setBounds(1080, 310, 60, 60);//메뉴바의 가장 오른쪽에 위치하는 사이즈
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {// quit에 관한 열
			@Override
			public void mouseEntered(MouseEvent e) { //마우스가 해당 버튼 위에 올라갔을때의 이벤트 처리
				rightButton.setIcon(rightButtonEnteredImage); //그림을 바꿔준다
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때는 손가락 버튼으로 바뀐다
				}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 해당 버튼에서 나왔을때의 이벤트 처리
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//마우스가 버튼에서 나왔을때 손가락 버튼이 사라진다
			}
			@Override
			public void mousePressed(MouseEvent e) { //마우스가 해당 버튼을 클릭 했을때의 이벤트 처리
				//오른쪽 버튼 이벤트
				
			
			}
		});
		
		add(rightButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);// 위치와 크기지정
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);// 항상 움직이는 경우 실행 화면
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); // 항상 존재하고 역동적으로 움지이지 않는 경우(메뉴 바,버튼 등등)
		this.repaint();
	}
}
