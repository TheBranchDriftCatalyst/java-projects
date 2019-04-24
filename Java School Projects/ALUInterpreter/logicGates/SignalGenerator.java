package logicGates;

public class SignalGenerator implements LogicComponent{
	
	private boolean bool;
	
	public SignalGenerator(boolean signal){
		this.bool = signal;
	}
	
	@Override
	public boolean evaluate() {
		return bool;
	}
	
	public boolean getSignal(){
		return bool;
	}
	
	public void setSignal(boolean bool){
		this.bool = bool;
	}

}
