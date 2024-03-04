package test;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.SAP;
import util.SMTP;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SMTPTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }
    @Test
    void saveTest() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Amor, 22", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);
        assertEquals("enviando por email", SMTP.send(invoice));
    }

    /*@Test
    void failInvalidInvoice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> SMTP.send(new Invoice("Carlos", 10.5)));

        final Invoice invalidNameInvoice = new Invoice("", 10.5);
        invalidNameInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> SMTP.send(invalidNameInvoice));

        final Invoice invalidValueInvoice = new Invoice("Carlos", -10.5);
        invalidValueInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> SMTP.send(invalidValueInvoice));
    }*/
}
