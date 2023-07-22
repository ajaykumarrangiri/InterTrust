package testintra;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void testGetWeatherForecast() {
        // Set base URL for the API
        RestAssured.baseURI = "https://weather.visualcrossing.com"; 
        int expectedQueryCost = 1;
        double expectedLatitude = 12.9664;
        double expectedLongitude = 77.5872;
        String expectedResolvedAddress = "Bengaluru, KA, India";
        String expectedAddress = "Bangalore";
        String expectedTimezone = "Asia/Kolkata";
        double expectedTzoffset = 5.5;
        String expectedDescription = "Similar temperatures continuing with a chance of rain multiple days";

        
        Response response = given()
                .param("city", "Bangalore") 
                .when()
                .get("/VisualCrossingWebServices/rest/services/timeline/Bangalore?unitGroup=metric&key=R8FA6ZWHH7P7RHNN263HQ8R4K&contentType=json");

        // Validate the response status code
        response.then().statusCode(200);

      
        response.then().body("queryCost", equalTo(expectedQueryCost))
        response.then().body("latitude", equalTo(expectedLatitude))
        response.then() .body("longitude", equalTo(expectedLongitude))
        response.then().body("resolvedAddress", equalTo(expectedResolvedAddress))
        response.then().body("address", equalTo(expectedAddress))
        response.then().body("timezone", equalTo(expectedTimezone))
        response.then().body("tzoffset", equalTo(expectedTzoffset))
        response.then().body("description", equalTo(expectedDescription))
       

    //More validations
        response.then().body("temperature", notNullValue(),
                "humidity", notNullValue(),
                "weather_description", notNullValue(),
                "wind_speed", notNullValue(),
                "uv_index", notNullValue(),
                "visibility", notNullValue(),
                "sunrise_time", notNullValue(),
                "sunset_time", notNullValue());
                "days[0].datetime", notNullValue())
                "days[0].tempmax", notNullValue())
                "days[0].tempmin", notNullValue())
                 "days[0].temp", notNullValue())
                 "days[0].feelslikemax", notNullValue())
              "days[0].feelslikemin", notNullValue())
               "days[0].feelslike", notNullValue())
                 "days[0].dew", notNullValue())
                "days[0].humidity", notNullValue())
                "days[0].precip", notNullValue())
              "days[0].precipprob", notNullValue())
             "days[0].precipcover", notNullValue())
             "days[0].preciptype", notNullValue())
             "days[0].snow", notNullValue())
             "days[0].snowdepth", notNullValue())
             "days[0].windgust", notNullValue())
             "days[0].windspeed", notNullValue())
            "days[0].winddir", notNullValue()
    }
}
