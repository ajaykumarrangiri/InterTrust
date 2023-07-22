package testintra;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class VisualCrossingPage_selenium {


	    private WebDriver driver;

	    public VisualCrossingPage_selenium(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void openPage(String url) {
	        driver.get(url);
	    }

	    public WeatherDataPage_Selenium clickWeatherDataMenu() {
	        driver.findElement(By.linkText("weather-data")).click();
	        return new WeatherDataPage_Selenium(driver);
	    }
	}
