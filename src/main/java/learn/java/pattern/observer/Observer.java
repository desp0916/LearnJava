package learn.java.pattern.observer;

/**
 * http://openhome.cc/Gossip/DesignPattern/ObserverPattern.htm
 *
 * 「Observer」pattern 最重要的概念是 decoupling。
 *
 * 所有氣象元件都必須實踐此觀察者介面。觀察者介面存在的原因，可以讓主題在需要通知觀察者時，有一個共同的方式！
 *
 */

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
