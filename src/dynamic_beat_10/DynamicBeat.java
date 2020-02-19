package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground2.jpg")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();// ���� ���� ���� ������ ��
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();// ��Ʈ �����ϴ� ���� �׵θ��� ������ ��
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();// ��Ʈ�� �������� ����
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();// ��Ʈ���� ������
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();// �������� ��Ʈ
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX,mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false; //���� Gameȭ������ �Ѿ�Դ����� ���� ����
	
	ArrayList<Track> trackList=new ArrayList<Track>(); //������ ���� �������ִ� Trick ArrayList�� �ۼ�
	
	private Music selectedMusic;
	private Image titleImage;
	private Image selectedImage;
	private Music introMusic = new Music("officialdism_Yesterday.mp3", true);
	private int nowSelected = 0; //���� ���õ� ���� �ǹ� ó���� 0�� �־������ν� ù��° ���� ����

	
	public DynamicBeat() {
		setUndecorated(true); // �⺻ �޴� �� ����
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// ȭ�� ������ ���� �Ұ���
		setLocationRelativeTo(null);// ȭ�� �� �߾ӿ� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���� ���Ḧ ������ ������ �����Ű�� ����
		setVisible(true);// ȭ�� ����� ���ؼ�
		setBackground(new Color(0, 0, 0, 0));//paintComponents�� �������� ����� �������� �ƴ϶� �Ͼ������ �����ϱ� ����
		setLayout(null);
		
		introMusic.start(); 
		
		//ArrayList<Track>�� �迭�� ����
		trackList.add(new Track("Mighty Love Title Image.png","Mighty Love Start Image.png",
				"Mighty Love Game Image.jpg","officialdism_Yesterday_Highlight.mp3","officialdism_Yesterday.mp3"));
		//0��° �ε���
		trackList.add(new Track("Energy Title Image.png","Energy Start Image.png",
				"Energy Game Image.png","officialdism_pretender_Highlight.mp3","officialdism_pretender.mp3"));
		//1��° �ε���
		trackList.add(new Track("Wild Flower Title Image.png","Wild Flower Start Image.png",
				"Wild Flower Game Image.jpg","officialdism_fate_Highlight.mp3","officialdism_fate.mp3"));
		//2��° �ε��� 
		
		
		
		exitButton.setBounds(1245, 0, 30, 30);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {//Exit �� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				exitButton.setIcon(exitButtonEnteredImage); //�׸��� �ٲ��ش�
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��

				try {
					Thread.sleep(1000);//1������ �Ŀ� ���α׷��� ����ȴ�
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		add(exitButton);
		
		startButton.setBounds(40, 200, 400, 100);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() { //Start ��ư�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				startButton.setIcon(startButtonEnteredImage); //�׸��� �ٲ��ش�
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				enterMain();
						}
		});
		
		add(startButton);
		

		quitButton.setBounds(40, 330, 400, 100);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				quitButton.setIcon(quitButtonEnteredImage); //�׸��� �ٲ��ش�
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				//���� ���� �̺�Ʈ ����
				try {
					Thread.sleep(1000);//1������ �Ŀ� ���α׷��� ����ȴ�
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
		add(quitButton);
		leftButton.setVisible(false);//�� ó���� ������ �ʰ� �ϱ� ����
		leftButton.setBounds(140, 310, 60, 60);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				leftButton.setIcon(leftButtonEnteredImage); //�׸��� �ٲ��ش�
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				selectLeft();
				
				
			}
		});
		
		add(leftButton);
		
		rightButton.setVisible(false);//�� ó���� ������ �ʰ� �ϱ� ����
		rightButton.setBounds(1080, 310, 60, 60);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				rightButton.setIcon(rightButtonEnteredImage); //�׸��� �ٲ��ش�
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				selectRight();
				
			
			}
		});
		
		add(rightButton);

		easyButton.setVisible(false);//�� ó���� ������ �ʰ� �ϱ� ����
		easyButton.setBounds(375, 580, 250, 67);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				easyButton.setIcon(easyButtonEnteredImage); //�׸��� �ٲ��ش�
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				gameStart(nowSelected,"easy");
				
			
			}
		});
		
		add(easyButton);

		hardButton.setVisible(false);//�� ó���� ������ �ʰ� �ϱ� ����
		hardButton.setBounds(655, 580, 250, 67);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				hardButton.setIcon(hardButtonEnteredImage); //�׸��� �ٲ��ش�
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				gameStart(nowSelected,"hard");
				
			
			}
		});
		
		add(hardButton);
	
		backButton.setVisible(false);//�� ó���� ������ �ʰ� �ϱ� ����
		backButton.setBounds(20, 50, 60, 60);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {// quit�� ���� ��
			@Override
			public void mouseEntered(MouseEvent e) { //���콺�� �ش� ��ư ���� �ö������� �̺�Ʈ ó��
				backButton.setIcon(backButtonEnteredImage); //�׸��� �ٲ��ش�
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺�� �ö������� �հ��� ��ư���� �ٲ��
				}
			@Override
			public void mouseExited(MouseEvent e) { //���콺�� �ش� ��ư���� ���������� �̺�Ʈ ó��
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//���콺�� ��ư���� �������� �հ��� ��ư�� �������
			}
			@Override
			public void mousePressed(MouseEvent e) { //���콺�� �ش� ��ư�� Ŭ�� �������� �̺�Ʈ ó��
				backMain();
				
			
			}
		});
		
		add(backButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);// ��ġ�� ũ������
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
		

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);// �׻� �����̴� ��� ���� ȭ��
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null); // S
			g.drawImage(noteRouteImage, 332, 30, null); // D
			g.drawImage(noteRouteImage, 436, 30, null); // F
			g.drawImage(noteRouteImage, 540, 30, null); //Space Bar(1)
			g.drawImage(noteRouteImage, 640, 30, null); //Space Bar(2)
			g.drawImage(noteRouteImage, 744, 30, null); // J
			g.drawImage(noteRouteImage, 848, 30, null); // K 
			g.drawImage(noteRouteImage, 952, 30, null); // L
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
		paintComponents(g); // �׻� �����ϰ� ���������� �������� �ʴ� ���(�޴� ��,��ư ���)
		this.repaint();
	}
	public void selectTrack(int nowSelected) {//���� ���õ� ���� ��ȣ�� nowSelected�� �˷��ش� 0~2
		if(selectedMusic !=null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
	}
	//������,���� ��ư�� ���� �̺�Ʈ ó��
	public void selectLeft() {
		if(nowSelected==0)
			nowSelected = trackList.size()-1; //0��° ���϶� ������ ������ �Ǹ� ���� ������ ���� ������
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	public void selectRight() {
		if(nowSelected==trackList.size()-1)
			nowSelected = 0; //������ ���϶� �������� ������ �Ǹ� ���� ��(0)���� ���� ������
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected,String difficulty) {//���̵��� ���� ������ difficulty�� ����
		if(selectedMusic !=null) //��� ������ �������̶�� close�Ѵ�
			selectedMusic.close();
		isMainScreen = false; //���� ȭ���� �ƴ϶�°��� �˷��ش�, ScreenDraw�Լ� if�� ���ϰ� ������ �ȵȴ�
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getGameImage())).getImage();//���̵� ���� ��ư�� ������ ��� � ����BackGround�̹��� ���
		backButton.setVisible(true);
		isGameScreen = true;
	}
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();//���̵� ���� ��ư�� ������ ��� � ����BackGround�̹��� ���
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
	public void enterMain() {
		startButton.setVisible(false); //startButton�� �Ⱥ��̰� ���ִ°�
		quitButton.setVisible(false); //quitButton�� �Ⱥ��̰� ���ִ°�
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();//Start ��ư�� ������ ��� �̹��� ���
		isMainScreen = true;
		
		leftButton.setVisible(true);//leftButton�� ���̰� ���ִ°�
		rightButton.setVisible(true);//rightButton�� ���̰� ���ִ°�
		easyButton.setVisible(true);//easyButton�� ���̰� ���ִ°�
		hardButton.setVisible(true);//rightButton�� ���̰� ���ִ°�
		introMusic.close();

		selectTrack(0);//���� ó���� ���� Ʈ���� �����ض�
	}
	
}
