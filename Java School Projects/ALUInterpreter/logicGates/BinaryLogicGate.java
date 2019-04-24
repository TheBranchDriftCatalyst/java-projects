package logicGates;

public abstract class BinaryLogicGate implements LogicComponent{

	protected LogicComponent right;
	protected LogicComponent left;

	public BinaryLogicGate(LogicComponent leftComp, LogicComponent rightComp){
		this.left = leftComp;
		this.right = rightComp;
	}

}
