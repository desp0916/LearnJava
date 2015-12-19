package learn.java.pattern.observer.weather;

/**
 * 氣象站
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		// 目前氣象佈告欄
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		// 氣象統計佈告欄
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		// 氣象預測佈告欄
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		// 酷熱指數佈告欄
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		// 模擬新的氣象數據，一有新的數據進來，在所有有註冊為觀察者
		// （使用weatherData.registerObservers(this)）
		// 的佈告欄上就會立即更新相應的狀態
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
