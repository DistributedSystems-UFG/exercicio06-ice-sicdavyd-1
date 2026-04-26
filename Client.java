import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            // ── Printer ───────────────────────────────────────────────
            ObjectPrx base = communicator.stringToProxy(
                "SimplePrinter:default -h 127.0.0.1 -p 11000");

            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
            if (printer == null) throw new Error("Invalid proxy (Printer)");

            // Função original
            System.out.println(printer.printString("Hello from Java!"));

            // NOVO: imprime a string invertida
            System.out.println("Reversed: " + printer.printReversed("Hello from Java!"));

            // NOVO: imprime a string repetida 3 vezes
            System.out.println("Repeated: " + printer.repeatString("Ice", 3));

            // ── TemperatureConverter ──────────────────────────────────
            ObjectPrx baseConv = communicator.stringToProxy(
                "SimpleConverter:default -h 127.0.0.1 -p 11000");

            Demo.TemperatureConverterPrx converter =
                Demo.TemperatureConverterPrx.checkedCast(baseConv);
            if (converter == null) throw new Error("Invalid proxy (TemperatureConverter)");

            // NOVO: converte 100°C para Fahrenheit
            System.out.printf("100°C em Fahrenheit: %.2f°F%n",
                converter.celsiusToFahrenheit(100.0f));

            // NOVO: converte 212°F para Celsius
            System.out.printf("212°F em Celsius: %.2f°C%n",
                converter.fahrenheitToCelsius(212.0f));

            // NOVO: converte 0°C para Kelvin
            System.out.printf("0°C em Kelvin: %.2fK%n",
                converter.celsiusToKelvin(0.0f));

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
