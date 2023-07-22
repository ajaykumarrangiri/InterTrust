package testintra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
      
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

       
        WebDriver driver = new ChromeDriver();

     
        VisualCrossingPage_selenium visualCrossingPage = new VisualCrossingPage_selenium(driver);
        visualCrossingPage.openPage("https://www.visualcrossing.com");

       
        WeatherDataPage_Selenium weatherDataPage = visualCrossingPage.clickWeatherDataMenu();

      
        String cityName = "Bangalore"; //
        weatherDataPage.searchWeatherForCity(cityName);

      
        boolean isForecastShown = weatherDataPage.isWeatherForecastShown();
        if (isForecastShown) {
            System.out.println("Weather forecast is shown for city: " + cityName);
        } else {
            System.out.println("Weather forecast is not shown for city: " + cityName);
        }
        // Additional test scenarios
        // Verify MaxTemperature Display
        boolean isTemperatureDisplayed = weatherDataPage.areMaxTemperaturesDisplayed();
        System.out.println("Temperature is displayed: " + isTemperatureDisplayed);

        // Verify MinTemperature Display
        boolean areWeatherIconsDisplayed = weatherDataPage.areMinTemperaturesDisplayed();
        System.out.println("Weather icons are displayed: " + areWeatherIconsDisplayed);

       

        driver.quit();
    }
}
