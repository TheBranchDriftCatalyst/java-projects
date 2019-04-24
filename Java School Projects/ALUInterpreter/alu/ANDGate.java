package alu;
import logicGates.*;



public class ANDGate extends BinaryLogicGate {

	public ANDGate(LogicComponent left, LogicComponent right) {
		super(left, right);
	}
	
	/*
	 * AND is only TRUE when both are true
	 */
	@Override
	public boolean evaluate() {
		if (this.left.evaluate() && this.right.evaluate()){
			return true;
		}else
			return false;
	}

}
