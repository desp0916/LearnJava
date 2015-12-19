package learn.java.pattern.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	// 建構式需要  weatherData 物件（也就是主題），以為註冊之用
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	// 當此方法被呼叫時，把溫度和濕度儲存起來，然後呼叫 display()
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	// 只是把最近的溫度和濕度顯示出來
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature +
				"F degrees and " + humidity + "% humidity");
	}
}
