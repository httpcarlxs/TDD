package test.funtionalTests;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionTableTests {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void testConsultancyInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, -0.1));
    }

    @Test
    void testTrainingInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", ServiceType.TRAINING, -0.1));
    }

    @Test
    void testOthersInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", ServiceType.OTHERS, -0.1));
    }

    @Test
    void testNonSpecifiedTypeInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", null, -0.1));
    }

    @Test
    void testConsultancyValidValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, 0);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(0.25, invoice.getTaxes());
    }

    @Test
    void testTrainingValidValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.TRAINING, 0);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(0.15, invoice.getTaxes());
    }

    @Test
    void testOthersValidValue() {
        Bill bill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.OTHERS, 0);
        Invoice invoice = null;
        try {
            invoice = generator.generateInvoice(bill);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(invoice);
        assertEquals(0.06, invoice.getTaxes());
    }

    @Test
    void testNonSpecifiedValidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", null, 0));
    }
}
