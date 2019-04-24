package alu;
import logicGates.*;


public class CEALUCircuit extends ALUCircuit {

        public CEALUCircuit(int width) {
                super(width);

                for (int i = 0; i < width; i++) {
                        this.comp[i] = new CECircuit(inputA[i], inputB[i]);
                }
        }

}
