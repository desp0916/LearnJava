package alpha;

class Single {
	private static Single instance;
	public static Single getInstance() {
		if (instance == null) instance = create();
		return instance;
	}
	protected Single() {}
	static Single create() { return new Single(); }

}

public class SingleSub extends Single {

}
