package learn.java.pattern.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * 目前氣象狀況佈告欄
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	Observable observable;
	private float temperature;
	private float humidity;

	// 建構式需要  weatherData 物件（也就是主題），以為註冊之用
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	// 當此方法被呼叫時，把溫度和濕度儲存起來，然後呼叫 display()
	@Override
	public void update (Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemprature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	// 把目前的溫度和濕度顯示出來
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature +
				"F degrees and " + humidity + "% humidity");
	}
}
