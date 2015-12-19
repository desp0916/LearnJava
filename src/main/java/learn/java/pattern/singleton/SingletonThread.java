package learn.java.pattern.singleton;

public class SingletonThread extends Thread {
    private static Singleton sg = Singleton.getInstance();
    @Override
	public void run() {
        System.out.println("SingletonThread.run()");
    }
    public Singleton getSg() {
    	return sg;
    }
}
