package logicGates;

public class CECircuit implements LogicComponent {

        protected LogicComponent right;
        protected LogicComponent left;
        protected LogicComponent ceCircuitGraph;

        public CECircuit(LogicComponent leftComp, LogicComponent rightComp){
                this.left = leftComp;
                this.right = rightComp;

                ceCircuitGraph = new NOTGate(new XORGate(left, right));
        }

        @Override
        public boolean evaluate() {
                return ceCircuitGraph.evaluate();
        }

}
