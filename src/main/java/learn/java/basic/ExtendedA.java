package learn.java.basic;

class ClassA {
	public int numberOfInstances;

	protected ClassA(int numberOfInstances) {
		this.numberOfInstances = numberOfInstances;
	}
}

class ExtendedA extends ClassA {
	private ExtendedA(int numberOfInstances) {
		super(numberOfInstances);
	}

	public static void main(String[] args) {
		ExtendedA ext = new ExtendedA(420);
		System.out.print(ext.numberOfInstances);
	}
}

class One {
	void foo() {
		System.out.println("foo()");
	}
}

class Two extends One {
	public static void main(String[] args) {
		new One().foo();
	}

}