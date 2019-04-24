package alu;


public class ANDALUCircuit extends ALUCircuit {

	public ANDALUCircuit(int width) {
		super(width);
		
		for (int i = 0; i < width; i++){
			this.comp[i] = new ANDGate(inputA[i], inputB[i]);
		}
		
	}
	
}
