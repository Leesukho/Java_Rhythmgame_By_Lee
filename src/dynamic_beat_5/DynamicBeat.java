package dynamic_beat_5;

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
		
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground2.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX,mouseY;
	
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
		
		exitButton.setBounds(1245, 0, 30, 30);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
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
		startButton.addMouseListener(new MouseAdapter() {
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
				startButton.setVisible(false); //startButton�� �Ⱥ��̰� ���ִ°�
				quitButton.setVisible(false); //quitButton�� �Ⱥ��̰� ���ִ°�
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				
			}
		});
		
		add(startButton);
		

		quitButton.setBounds(40, 330, 400, 100);//�޴����� ���� �����ʿ� ��ġ�ϴ� ������
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
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
		g.drawImage(background, 0, 0, null);// �׻� �����̴� ��� ���� ȭ��
		paintComponents(g); // �׻� �����ϰ� ���������� �������� �ʴ� ���(�޴� ��,��ư ���)
		this.repaint();
	}
}
