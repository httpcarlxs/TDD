package test;

import org.junit.jupiter.api.Test;
import util.SAP;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SAPTest {
    @Test
    void saveTest() {
        assertEquals("salvando no banco", SAP.send(new Invoice()));
    }
}
