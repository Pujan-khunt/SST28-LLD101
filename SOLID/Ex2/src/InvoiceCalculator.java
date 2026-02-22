import java.util.List;
import java.util.Map;

public class InvoiceCalculator {
    public Invoice calculate(Customer customer, List<OrderLine> lines, String invId,
            List<InvoiceItem> invoiceItems, Map<String, MenuItem> menu) {
        double subtotal = calculateSubtotal(lines, menu);
        double taxPct = customer.taxPercent();
        double tax = subtotal * (taxPct / 100.0);
        double discountPct = customer.discountAmount(subtotal, lines.size());
        double discount = subtotal * (discountPct / 100.0);
        double total = subtotal + tax - discount;
        return new Invoice(invId, invoiceItems, subtotal, tax, taxPct, discount, discountPct,
                total);
    }

    private double calculateSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }
}
