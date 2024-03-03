package test;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import util.InvoiceDao;
import util.SAP;

class InvoiceDaoTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }
    @Test
    void saveTest() {
        Bill bill = new Bill("Brenda", "Rua do Amor, 22", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);
        assertEquals("salvando no banco", InvoiceDao.save(invoice));
    }

    @Test
    void failInvalidInvoice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InvoiceDao.save(new Invoice("Carlos", 10.5)));

        final Invoice invalidNameInvoiceInvoice = new Invoice("", 10.5);
        invalidNameInvoiceInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> InvoiceDao.save(invalidNameInvoiceInvoice));

        final Invoice invalidValueInvoice = new Invoice("Carlos", -10.5);
        invalidValueInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> InvoiceDao.save(invalidValueInvoice));
    }
}
