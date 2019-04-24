package logicGates;


public class ORGate extends BinaryLogicGate {

	public ORGate(LogicComponent left, LogicComponent right) {
		super(left, right);
	}
	
	/*
	 * OR is true when A=1 & B=1, A=1 & B=0, A=0 & B=1
	 * OR is false only when both are false
	 */
	@Override
	public boolean evaluate() {
		if (!this.left.evaluate() && !this.right.evaluate()){
			return false;
		}else
			return true;
	}
	
	

}
