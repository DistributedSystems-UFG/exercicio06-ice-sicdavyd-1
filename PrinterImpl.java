import com.zeroc.Ice.Current;

public class PrinterImpl implements Demo.Printer {

    @Override
    public String printString(String s, Current current) {
        System.out.println("[printString] " + s);
        return "Printed: " + s;
    }

    // NOVO: inverte a string e a retorna
    @Override
    public String printReversed(String s, Current current) {
        String result = new StringBuilder(s).reverse().toString();
        System.out.println("[printReversed] " + result);
        return result;
    }

    // NOVO: repete a string n vezes separada por espaço e a retorna
    @Override
    public String repeatString(String s, int n, Current current) {
        String result = (s + " ").repeat(n).strip();
        System.out.println("[repeatString] " + result);
        return result;
    }
}
