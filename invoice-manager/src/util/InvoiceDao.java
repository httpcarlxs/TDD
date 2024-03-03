package util;

import models.Invoice;

public class InvoiceDao {
    public static String save(Invoice invoice) {
        invoice.validateInvoice();
        return "salvando no banco";
    }
}
