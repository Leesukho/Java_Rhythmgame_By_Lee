package dynamic_beat_14;

public class Beat {
	private int time;
	private String noteName;
	
	public int getTime() {//get 메소드와 Set 메소드는 어디에 어떻게 쓰이는가? 
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public Beat(int time, String noteName) { //생성자
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
}
