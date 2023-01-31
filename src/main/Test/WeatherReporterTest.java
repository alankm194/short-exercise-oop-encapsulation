import com.techreturners.encapsulation.bankaccount.model.WeatherReporter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherReporterTest {


    @Test
    public void whenCityIsLondon_ReturnLondonLocationAndRainyEmoji() {
        WeatherReporter wr = new WeatherReporter("London", 1);
        assertTrue(wr.print().startsWith("I am in London and it is 🌦"));
    }

    @Test
    public void whenCityIsCapeTownAnd_ReturnsCapeTownLocationAndSunsetEmoji() {
        WeatherReporter wr = new WeatherReporter("Cape Town", 15);
        assertTrue(wr.print().startsWith("I am in Cape Town and it is 🌅"));
    }
    @Test
    public void whenCityIsCalifornia_ReturnsCaliforniaLocationAndCloudyEmoji() {
        WeatherReporter wr = new WeatherReporter("California", 15);
        assertTrue(wr.print().startsWith("I am in California and it is 🌤"));
    }

    @Test
    public void whenCityIsNotListed_ReturnGlasgowAndWeatherDefaultEmoji() {
        WeatherReporter wr = new WeatherReporter("Glasgow", 33);
        assertTrue(wr.print().startsWith("I am in Glasgow and it is 🔆"));
    }

    @Test
    public void whenCityIsLondonAndTempIsOKReturnsCompleteResponse() {
        WeatherReporter wr = new WeatherReporter("London", 15);
        assertEquals("I am in London and it is 🌦. Ahhh...it's just right 😊!. The temperature in Fahrenheit is 59.",
                wr.print());
    }

    @Test
    public void whenTempIs9_ReturnsTooColdResponseAndFahrenheitIs48point2() {
        WeatherReporter wr = new WeatherReporter("London", 9);
        assertEquals("I am in London and it is 🌦. It's too cold 🥶!. The temperature in Fahrenheit is 48.2.",
                wr.print());
    }

    @Test
    public void whenTempIs10_ReturnsJustRightResponseAndFahrenheitIs50() {
        WeatherReporter wr = new WeatherReporter("London", 10);
        assertEquals("I am in London and it is 🌦. Ahhh...it's just right 😊!. The temperature in Fahrenheit is 50.",
                wr.print());
    }

    @Test
    public void whenTempIs29_ReturnsJustRightResponseAndFahrenheitIs84Point2() {
        WeatherReporter wr = new WeatherReporter("London", 29);
        assertEquals("I am in London and it is 🌦. Ahhh...it's just right 😊!. The temperature in Fahrenheit is 84.2.",
                wr.print());
    }
    @Test
    public void whenTempIs31_ReturnsToHotResponseAndFahrenheitIs87point8() {
        WeatherReporter wr = new WeatherReporter("London", 31);
        assertEquals("I am in London and it is 🌦. It's too hot 🥵!. The temperature in Fahrenheit is 87.8.",
                wr.print());
    }
}
