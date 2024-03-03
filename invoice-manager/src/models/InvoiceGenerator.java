package models;

import util.InvoiceDao;
import util.SAP;
import util.SMTP;

public class InvoiceGenerator {
    public Invoice generateInvoice(Bill bill) {
        Invoice invoice = new Invoice(bill.getClientName(), bill.getValue());
        invoice.setTaxes(calculateTaxes(bill));
        return invoice;
    }

    public double calculateTaxes(Bill bill) {
        return 0.25;
    }

    public String sendEmail(Invoice invoice) {
        return SMTP.send(invoice);
    }

    public String sendToSAP(Invoice invoice) {
        return SAP.send(invoice);
    }

    public String save(Invoice invoice) {
        return InvoiceDao.save(invoice);
    }
}
