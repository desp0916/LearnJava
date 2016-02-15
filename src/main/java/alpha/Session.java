package alpha;

public abstract class Session implements Runnable, Cloneable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	@Override
	public Object clone(){ return this.clone(); }
}
