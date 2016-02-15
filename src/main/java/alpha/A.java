package alpha;

public interface A {
	public void m1();
}

class B implements A {
}

class C implements A {
	@Override
	public void m1() {
	}
}

class D implements A {
	public void m1(int x) {
	}
}

abstract class E implements A {
}

abstract class F implements A {
	@Override
	public void m1() {
	}
}

abstract class G implements A {
	public void m1(int x) {
	}
}