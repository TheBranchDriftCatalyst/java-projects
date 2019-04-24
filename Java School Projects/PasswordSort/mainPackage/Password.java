package mainPackage;

public class Password implements Comparable<Password>{

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
		return this.name + "|" + this.pass;
	}

	@Override
	public int compareTo(Password p2) {
		String thisName = this.name;
		String thatName = p2.name;

		for(int i = 0; i < thisName.length() & 1 < thatName.length(); i++){
			if (thisName.charAt(i) < thatName.charAt(i)){
				return -1;
			}else if (thisName.charAt(i) > thatName.charAt(i)){
				return 1;
			}else
				continue;
		}
		return 0;
	}
}
