package test;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.SAP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SAPTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }
    @Test
    void successfullySaveTest() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Amor, 22", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);
        assertEquals("enviando pro sap", SAP.send(invoice));
    }

    /*@Test
    void failInvalidInvoice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> SAP.send(new Invoice("Carlos", 10.5)));

        final Invoice invalidNameInvoice = new Invoice("", 10.5);
        invalidNameInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> SAP.send(invalidNameInvoice));

        final Invoice invalidValueInvoice = new Invoice("Carlos", -10.5);
        invalidValueInvoice.setTaxes(0.5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> SAP.send(invalidValueInvoice));
    }*/


}
