package learn.java.pattern.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * 酷熱指數佈告欄
 *
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

	Observable observable;
	float heatIndex = 0.0f;

	public HeatIndexDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	/**
	 * 計算酷熱指數
	 * https://github.com/bethrobson/Head-First-Design-Patterns/blob/master/
	 * heatindex.txt
	 */
	private float computeHeatIndex(float t, float rh) {
		float index = (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) + (0.00941695 * (t * t))
				+ (0.00728898 * (rh * rh)) + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh))
				+ (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * (rh * rh * rh))
				+ (0.00000142721 * (t * t * t * rh)) + (0.000000197483 * (t * rh * rh * rh))
				- (0.0000000218429 * (t * t * t * rh * rh)) + 0.000000000843296 * (t * t * rh * rh * rh))
				- (0.0000000000481975 * (t * t * t * rh * rh * rh)));
		return index;
	}

	// 當此方法被呼叫時，把溫度和濕度儲存起來，然後呼叫 display()
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			float temperature = weatherData.getTemprature();
			float humidity = weatherData.getHumidity();
			this.heatIndex = computeHeatIndex(temperature, humidity);
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Heat index is " + heatIndex);
	}
}
