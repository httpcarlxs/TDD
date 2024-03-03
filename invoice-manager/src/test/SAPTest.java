package test;

import models.Invoice;
import org.junit.jupiter.api.Test;
import util.SAP;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SAPTest {
    @Test
    void saveTest() {
        assertEquals("enviando pro sap", SAP.send(new Invoice("", 0)));
    }
}
