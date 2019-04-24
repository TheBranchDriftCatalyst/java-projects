package logicGates;

public class NOTGate extends UnaryLogicGate {

        public NOTGate(LogicComponent comp) {
                super(comp);
        }

        @Override
        public boolean evaluate() {
                if (this.parent.evaluate())
                        return false;
                else
                        return true;

        }

}
