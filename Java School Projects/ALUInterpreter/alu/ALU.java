package alu;


public class ALU {

        private ANDALUCircuit andALU;
        private ORALUCircuit orALU;
        private CEALUCircuit ceALU;
        private ADDALUCircuit addALU;

        public ALU(int width){
                this.andALU = new ANDALUCircuit(width);
                this.orALU = new ORALUCircuit(width);
                this.ceALU = new CEALUCircuit(width);
                this.addALU = new ADDALUCircuit(width);
        }

        public String evaluateAND(String in1, String in2){
                return this.andALU.evaluate(in1, in2);
        }

        public String evaluateOR(String in1, String in2){
                return this.orALU.evaluate(in1, in2);
        }

        public String evaluateCE(String in1, String in2){
                return this.ceALU.evaluate(in1, in2);
        }

        public String evaluateADD(String in1, String in2){
                return this.addALU.evaluate(in1, in2);
        }

}
