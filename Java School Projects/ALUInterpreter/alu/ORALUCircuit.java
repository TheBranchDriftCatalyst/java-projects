package alu;
import logicGates.*;

public class ORALUCircuit extends ALUCircuit {

        public ORALUCircuit(int width) {
                super(width);

                for (int i = 0; i < width; i++) {
                        this.comp[i] = new ORGate(inputA[i], inputB[i]);
                }

        }

}
