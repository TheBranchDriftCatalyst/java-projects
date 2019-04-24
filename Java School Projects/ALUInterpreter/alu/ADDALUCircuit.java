package alu;
import logicGates.*;


public class ADDALUCircuit extends ALUCircuit {
	protected SignalGenerator[] carryArray;
	
	public ADDALUCircuit(int width) {
		super(width);
		
		carryArray = new SignalGenerator[width];
		
		for (int i = 0; i < width; i++){
			carryArray[i] = new SignalGenerator(false);
		}
		
		for (int i = 0; i < width; i++){
			this.comp[i] = new FullAddCircuit(inputA[i], inputB[i], carryArray[i]);
		}
	}
	
	@Override
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
		 * we just created the correct signal arrays, we need to loop backwards through these arrays
		 * evaluate the carry of characters at i then set carry of carry array i-1
		 */

		
		for (int i = carryArray.length - 1; i > 0;  i--){
			FullAddCircuit addCircuit = new FullAddCircuit(inputA[i], inputB[i], carryArray[i]);
			
			if (addCircuit.evaluateCary())
				this.carryArray[i-1].setSignal(true);

			else{
				continue;
			}	
		}
		
		/*
		 * We need to now compare the bits with the approprate logicgates.
		 */
		
		for(int i = 0; i < 8; i++){

			FullAddCircuit addCircuit = new FullAddCircuit(inputA[i], inputB[i], carryArray[i]);
			if (addCircuit.evaluate()){
				result += "1";
			}else
				result += "0";
			
			if (i == 0 && addCircuit.evaluateCary())
				result = "1" + result;
		}
		

		
		return result;
	}


}
