package learn.java.pattern.observer.weatherobservable;

import java.util.Observable;

public class WeatherData extends Observable {

	private float temprature;
	private float humidity;
	private float pressure;

	public WeatherData() {
	}

	//我們沒有利用 notiftyObservers() 傳送資料物件，表示我們採用的作法是「pull」
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temprature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemprature() {
		return temprature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
