package project1REDO;

public class VideoTape extends Video{

	public VideoTape(String title, int year, int runTime) {
		super(title, year, runTime);
	}

	@Override
	public String getType() {
		return super.getType() + " " + "Tape";
	}

	public String toString(){
	return super.toString();
	}

}
