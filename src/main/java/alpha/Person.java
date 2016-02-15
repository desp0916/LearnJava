package alpha;

public class Person {
	public enum Name {
		GARY("Gary Liu"), ALEX("Alex Wu"), BENSON("Benson Wang");
		private final String name;
		Name(String name) { this.name = name; }
		public String getName() { return this.name; }
		@Override
		public String toString() {
			return this.name;
		}
	}

	public static void main(String args[]) {
//		System.out.println(Name.ALEX.name);
		for (Name name : Name.values()) {
			System.out.println(name);
		}
	}
}
