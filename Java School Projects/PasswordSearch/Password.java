

public class Password implements Comparable<Password> {

        private String name;
        private String pass;

        public Password(String name, String pass){
                this.name = name;
                this.pass = pass;
        }

        public String getPassword(){
                return this.pass;
        }

        public String getName(){
                return this.name;
        }

        public String toString(){
                return this.name + " :: " + this.pass;
        }

        @Override
        public int compareTo(Password p2) {
                return this.getName().compareTo(p2.getName());
        }
}
