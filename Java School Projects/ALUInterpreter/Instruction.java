public class Instruction {
        private String operationStr;
        private String operandStr;

        public Instruction(String operation, String operand){
                this.operationStr = operation;
                this.operandStr = operand;
        }

        public String getOperation(){
                return this.operationStr;
        }

        public String getOperand(){
                return this.operandStr;
        }

        public String toString(){
                return operationStr + ":" + operandStr;
        }

}
