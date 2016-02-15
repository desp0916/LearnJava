package learn.java.basic;

class OneX {
	public OneX foo() { return this; }
}

class TwoX extends OneX {
	@Override
	public OneX foo() { return this; }
}

class ThreeX extends TwoX {
//	@Override
//	public TwoX foo() { return this; }
	@Override
	public OneX foo() { return this;}
}
