package test.funtionalTests;

import models.InvoiceGenerator;
import org.junit.jupiter.api.BeforeEach;

public class DecisionTableTests {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

}
