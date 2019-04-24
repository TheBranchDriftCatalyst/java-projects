package alu;
import logicGates.*;


public class FullAddCircuit implements LogicComponent{

	
	protected LogicComponent sigA;
	protected LogicComponent sigB;
	protected LogicComponent carry;
	protected LogicComponent sumCircuit;
	protected LogicComponent carryCircuit;
	
	public FullAddCircuit(LogicComponent a, LogicComponent b, LogicComponent c){
		this.sigA = a;
		this.sigB = b;
		this.carry = c;
		
		LogicComponent aXORbGate = new XORGate(a, b);
		
		sumCircuit = new XORGate(aXORbGate,c);
		carryCircuit = new ORGate(new ANDGate(a, b), new ANDGate(aXORbGate, c));
		
	}	
	
	@Override
	public boolean evaluate() {
		return sumCircuit.evaluate();
	}
	
	public boolean evaluateCary() {
		return carryCircuit.evaluate();
	}
	
}
