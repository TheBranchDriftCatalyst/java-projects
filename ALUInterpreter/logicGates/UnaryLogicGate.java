package logicGates;

public abstract class UnaryLogicGate implements LogicComponent {

        protected LogicComponent parent;

        public UnaryLogicGate(LogicComponent comp){
                this.parent = comp;
        }

}
