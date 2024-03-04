package test;

import models.Bill;
import models.Invoice;
import models.InvoiceGenerator;
import models.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvoiceGeneratorTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void successfullyGenerateInvoice() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Emprego, 2024", ServiceType.OTHERS, 10.5);
        Invoice generatedInvoice = generator.generateInvoice(bill);
        Invoice testInvoice = new Invoice(bill.getClientName(), bill.getValue());
        testInvoice.setTaxes(0.06);

        assertEquals(generatedInvoice, testInvoice);
    }

    @Test
    void failGenerateInvoiceNullBill() {
        assertThrows(IllegalAccessException.class, () -> generator.generateInvoice(null));
    }
    @Test
    void successfullyCalculateTaxes() throws IllegalAccessException {
        Bill consultancyBill = new Bill("Brenda", "Rua do Aumento de Salário, 2025", ServiceType.CONSULTANCY, 10.5);
        Bill trainingBill = new Bill("Brenda", "Rua do VR e VA, 2025", ServiceType.TRAINING, 10.5);
        Bill otherBill = new Bill("Brenda", "Rua do Plano de Saúde, 2025", ServiceType.OTHERS, 10.5);

        Invoice consultancyInvoice = generator.generateInvoice(consultancyBill);
        Invoice trainingInvoice = generator.generateInvoice(trainingBill);
        Invoice otherInvoice = generator.generateInvoice(otherBill);

        assertEquals(0.25, consultancyInvoice.getTaxes());
        assertEquals(0.15, trainingInvoice.getTaxes());
        assertEquals(0.06, otherInvoice.getTaxes());
    }

    @Test
    void sendEmailTest() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Almoço, 20", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);

        assertEquals(generator.sendEmail(invoice), "enviando por email");
    }

    @Test
    void sendToSAPTest() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Salgadin de Cleide, 350", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);

        assertEquals(generator.sendToSAP(invoice), "enviando pro sap");
    }

    @Test
    void saveIntoDatabaseTest() throws IllegalAccessException {
        Bill bill = new Bill("Brenda", "Rua do Salgadin de Cleide, 350", ServiceType.OTHERS, 10.5);
        Invoice invoice = generator.generateInvoice(bill);

        assertEquals(generator.save(invoice), "salvando no banco");
    }
}
