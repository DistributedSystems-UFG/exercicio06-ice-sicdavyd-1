import com.zeroc.Ice.Current;

public class TemperatureConverterImpl implements Demo.TemperatureConverter {

    @Override
    public float celsiusToFahrenheit(float celsius, Current current) {
        float result = celsius * 9.0f / 5.0f + 32.0f;
        System.out.printf("[celsiusToFahrenheit] %.2f°C = %.2f°F%n", celsius, result);
        return result;
    }

    @Override
    public float fahrenheitToCelsius(float fahrenheit, Current current) {
        float result = (fahrenheit - 32.0f) * 5.0f / 9.0f;
        System.out.printf("[fahrenheitToCelsius] %.2f°F = %.2f°C%n", fahrenheit, result);
        return result;
    }

    @Override
    public float celsiusToKelvin(float celsius, Current current) {
        float result = celsius + 273.15f;
        System.out.printf("[celsiusToKelvin] %.2f°C = %.2fK%n", celsius, result);
        return result;
    }
}
