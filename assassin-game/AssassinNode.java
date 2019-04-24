package project4;

public class AssassinNode
{
        public String name;
        public String killer;
        public AssassinNode next;

        public AssassinNode(String name)
        {
                this(name, null);
        }

        public AssassinNode(String name, AssassinNode next) {
                this.name = name;
                this.killer = null;
                this.next = next;
        }
}
