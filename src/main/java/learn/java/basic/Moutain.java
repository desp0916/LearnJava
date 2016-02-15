package learn.java.basic;

class Atom {
	Atom() {
		System.out.print("atom ");
	}
}

class Rock extends Atom {
	Rock(String type) {
		System.out.print(type);
	}
}

class Moutain extends Rock {
	Moutain() {
		super("granite ");
		new Rock("granite ");
	}

	public static void main(String[] args) {
		new Moutain();
	}

	public static void main(String[]...a) {

	}
}
