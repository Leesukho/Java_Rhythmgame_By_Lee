package dynamic_beat_13;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 7; //Note가 떨어지는 속도가 7
	public static final int SLEEP_TIME = 10; //Note가 얼마간의 시간 주기로 떨어지는지(만약 이 SLEEP TIME이 없으면 한순간에 떨어진다)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DynamicBeat();
		
	}

}
