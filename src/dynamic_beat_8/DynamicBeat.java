package dynamic_beat_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
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

	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground2.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private int mouseX,mouseY;
	
	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList=new ArrayList<Track>(); //������ ���� �������ִ� Trick ArrayList�� �ۼ�
	
	private Music selectedMusic;
	private Image titleImage;
	private Image selectedImage;
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
		
		Music introMusic = new Music("officialdism_Yesterday.mp3", true);
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
				introMusic.close(); //�⺻ ����� (introMusic)�ݱ�
				selectTrack(0);//���� ó���� ���� Ʈ���� �����ض�
				startButton.setVisible(false); //startButton�� �Ⱥ��̰� ���ִ°�
				quitButton.setVisible(false); //quitButton�� �Ⱥ��̰� ���ִ°�
				leftButton.setVisible(true);//leftButton�� ���̰� ���ִ°�
				rightButton.setVisible(true);//rightButton�� ���̰� ���ִ°�
				easyButton.setVisible(true);//easyButton�� ���̰� ���ִ°�
				hardButton.setVisible(true);//rightButton�� ���̰� ���ִ°�
				
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();//Start ��ư�� ������ ��� �̹��� ���
				isMainScreen = true;
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
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);// �׻� �����̴� ��� ���� ȭ��
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
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
	}


}

