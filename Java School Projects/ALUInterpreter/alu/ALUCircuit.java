package alu;
import logicGates.*;

public abstract class ALUCircuit {

	protected SignalGenerator[] inputA;
	protected SignalGenerator[] inputB;
	protected LogicComponent[] comp;



	public ALUCircuit(int width){

		inputA = new SignalGenerator[width];
		inputB = new SignalGenerator[width];
		comp = new LogicComponent[width];



		for (int i = 0; i < width; i++){
			inputA[i] = new SignalGenerator(false);
			inputB[i] = new SignalGenerator(false);

		}

	}

	public String evaluate(String strA, String strB){

		String result = new String();

		for (int i = 0; i < strA.length(); i++){
			char curCharA = strA.charAt(i);

			if (curCharA == '1'){
				this.inputA[i].setSignal(true);
			}else
				this.inputA[i].setSignal(false);


		}

		for (int i = 0; i < strB.length(); i++){
			char curCharB = strB.charAt(i);

			if (curCharB == '1'){
				this.inputB[i].setSignal(true);
			}else
				this.inputB[i].setSignal(false);

		}

		/*
		 * We need to now compare the bits with the approprate logicgates.
		 */

		for(int i = 0; i < comp.length; i++){
			if (comp[i].evaluate()){
				result += "1";
			}else
				result += "0";
		}


		return result;
	}

}
