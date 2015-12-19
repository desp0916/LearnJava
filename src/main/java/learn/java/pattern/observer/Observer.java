package learn.java.pattern.observer;

/**
 * http://openhome.cc/Gossip/DesignPattern/ObserverPattern.htm
 *
 */

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
