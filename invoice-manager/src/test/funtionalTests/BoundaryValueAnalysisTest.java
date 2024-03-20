package test.funtionalTests;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoundaryValueAnalysisTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void testCreateInvoiceBelowMinValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", ServiceType.OTHERS, -0.1));
    }

    @Test
    void testCreateInvoiceMinValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, 0);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(0, invoice.getValue());
    }

    @Test
    void testCreateInvoiceFirstValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, 0.1);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(0.1, invoice.getValue());
    }

    @Test
    void testCreateInvoiceRandomValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, 15);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(15, invoice.getValue());
    }

}
