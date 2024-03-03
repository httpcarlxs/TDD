package test;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InvoiceTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void successfullyCreatedInvoiceTest() {
        Invoice invoice = new Invoice("testName", 10.5);
        assertEquals(invoice.getClientName(), "testName");
        assertEquals(invoice.getValue(), 10.5);
        assertEquals(invoice.getTaxes(), 0.0); // standard initialization value for a double
    }

    @Test
    void failCreateInvoiceTest() {
        assertThrows(IllegalArgumentException.class, () -> new Invoice("", 10.5));
        assertThrows(IllegalArgumentException.class, () -> new Invoice("Brenda", -10.5));
    }

    @Test
    void successfullyGetAttributesTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill = new Bill(name, address, ServiceType.TRAINING, value);
        Invoice invoice = generator.generateInvoice(bill);

        assertEquals(name, invoice.getClientName());
        assertEquals(0.15, invoice.getTaxes());
        assertEquals(value, invoice.getValue());
    }

    @Test
    void successfullySetAttributesTest(){
        String name = "Brenda";
        double value = 10.5;

        Bill bill = new Bill("Carlos", "Rua da Chuva", ServiceType.TRAINING, 1000);

        Invoice invoice = generator.generateInvoice(bill);

        invoice.setTaxes(0.25);
        invoice.setClientName(name);
        invoice.setValue(value);

        assertEquals(name, invoice.getClientName());
        assertEquals(0.25, invoice.getTaxes());
        assertEquals(value, invoice.getValue());
    }

    @Test
    void equalsIdenticInvoicesTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill1 = new Bill(name, address, ServiceType.TRAINING, value);
        Bill bill2 = new Bill(name, address, ServiceType.TRAINING, value);

        Invoice invoice1 = generator.generateInvoice(bill1);
        Invoice invoice2 = generator.generateInvoice(bill2);

        assertEquals(invoice1, invoice2);
    }

    @Test
    void equalsDifferentInvoicesTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill1 = new Bill(name, address, ServiceType.TRAINING, value);
        Bill bill2 = new Bill(name, address, ServiceType.CONSULTANCY, value);
        Bill bill3 = new Bill(name, address, ServiceType.OTHERS, value);
        Bill bill4 = new Bill("Carlos", address, ServiceType.TRAINING, value);
        Bill bill5 = new Bill(name, address, ServiceType.TRAINING, 15);

        Invoice invoice1 = generator.generateInvoice(bill1);
        Invoice invoice2 = generator.generateInvoice(bill2);
        Invoice invoice3 = generator.generateInvoice(bill3);
        Invoice invoice4 = generator.generateInvoice(bill4);
        Invoice invoice5 = generator.generateInvoice(bill5);

        assertNotEquals(invoice1, invoice2);
        assertNotEquals(invoice1, invoice3);
        assertNotEquals(invoice1, invoice4);
        assertNotEquals(invoice1, invoice5);
    }
}
