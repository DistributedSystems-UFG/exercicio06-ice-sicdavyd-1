import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                "SimplePrinterAdapter", "default -p 11000");

            // Registra Printer
            adapter.add(new PrinterImpl(), Util.stringToIdentity("SimplePrinter"));

            // NOVO: Registra TemperatureConverter
            adapter.add(new TemperatureConverterImpl(), Util.stringToIdentity("SimpleConverter"));

            adapter.activate();
            System.out.println("Server running on port 11000...");
            communicator.waitForShutdown();

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
