package util;

import models.Invoice;

public class SAP {
    public static String send(Invoice invoice) throws IllegalArgumentException{
        invoice.validateInvoice();

        return "enviando pro sap";
    }
}
