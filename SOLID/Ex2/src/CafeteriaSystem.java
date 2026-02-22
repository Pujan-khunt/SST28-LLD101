import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Formatter formatter;
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public CafeteriaSystem(Formatter formatter) {
        this.formatter = formatter;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(Customer customer, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);


        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (OrderLine line : lines) {
            MenuItem item = menu.get(line.itemId);
            invoiceItems.add(new InvoiceItem(item.name, line.qty, line.qty * item.price));
        }

        InvoiceCalculator calculator = new InvoiceCalculator();
        Invoice invoice = calculator.calculate(customer, lines, invId, invoiceItems, menu);

        String printable = formatter.format(invoice);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }

}
