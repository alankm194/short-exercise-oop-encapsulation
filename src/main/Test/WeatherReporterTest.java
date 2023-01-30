import com.techreturners.encapsulation.bankaccount.model.WeatherReporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherReporterTest {

    @Test
    public void whenCityIsLondonAndTempIsLowReturnsRainyAndColdResponse() {
        WeatherReporter wr = new WeatherReporter("London", 1);
        assertEquals("I am in London and it is 🌦. It's too cold 🥶!. The temperature in Fahrenheit is 33.8.",
                wr.print());
    }

}
