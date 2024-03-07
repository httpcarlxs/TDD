package util;

import models.Invoice;

public class SMTP {
    public static String send(Invoice invoice) throws IllegalArgumentException{
        invoice.validateInvoice();
        return "enviando por email";
    }
}
