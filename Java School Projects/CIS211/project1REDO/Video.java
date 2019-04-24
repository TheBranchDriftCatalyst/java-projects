package project1REDO;

public class Video extends LibraryItem{

	protected int runTime;
	
	public Video(String title, int year, int runTime) {
		super(title, year);
		this.runTime = runTime;
	}

	@Override
	public String getType() {
		return "Video";
	}

	public String toString(){
		return super.toString() + "Run Time: " + this.runTime + " minutes. ";
	}
	
	public int getRunTime(){
		return this.runTime;
	}
}
