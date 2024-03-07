package models;

import util.InvoiceDao;
import util.SAP;
import util.SMTP;

public class InvoiceGenerator {
    public Invoice generateInvoice(Bill bill) throws IllegalAccessException {
        if (bill == null) {
            throw new IllegalAccessException("Null bill");
        }
        Invoice invoice = new Invoice(bill.getClientName(), bill.getValue());
        invoice.setTaxes(calculateTaxes(bill.getServiceType()));
        return invoice;
    }

    public double calculateTaxes(ServiceType type) {
        return switch (type) {
            case CONSULTANCY -> 0.25;
            case TRAINING -> 0.15;
            case OTHERS -> 0.06;
        };
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
