package logicGates;

public class XORGate extends BinaryLogicGate {

        public XORGate(LogicComponent left, LogicComponent right) {
                super(left, right);
        }

        /*
         * XOR is true only when one is true and the other is false
         */
        @Override
        public boolean evaluate() {
                if (this.left.evaluate() && !this.right.evaluate()) {
                        return true;
                }else if (!this.left.evaluate() && this.right.evaluate()) {
                        return true;
                }else
                        return false;
        }

}
