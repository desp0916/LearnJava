package learn.java.pattern.observer.weather;
/**
 * http://openhome.cc/Gossip/DesignPattern/ObserverPattern.htm
 *
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
