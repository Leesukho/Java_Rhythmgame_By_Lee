package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	private boolean isloop;//���ѹݺ����� 1���� ����ϴ����� Ȯ���ϴ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name,boolean isloop) {
		try {
			this.isloop=isloop;
			file=new File(Main.class.getResource("../music/introMusic.mp3").toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public int getTime() {
		if(player==null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isloop=false;
		player.close();
		this.interrupt();
	}
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isloop);
		}catch(Exception e) {
			
		}
	}
}