package testintra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherDataPage_Selenium {
    private WebDriver driver;

    public WeatherDataPage_Selenium(WebDriver driver) {
        this.driver = driver;
    }

    public void searchWeatherForCity(String cityName) {
        driver.findElement(By.xpath("//input[@id='wxloacation']")).sendKeys(cityName);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    public boolean isWeatherForecastShown() {
        return driver.findElement(By.xpath("//h1[@class='h3 d-flex align-items-end justify-content-between mb-4']")).isDisplayed();
    }
    public boolean areMaxTemperaturesDisplayed() {
        return driver.findElement(By.xpath("(//div[@class='fs-2 text-center'])[1]")).isDisplayed();
    }
    public boolean areMinTemperaturesDisplayed() {
        return driver.findElement(By.xpath("(//div[@class='fs-2 text-center'])[2]")).isDisplayed();
    }
}
