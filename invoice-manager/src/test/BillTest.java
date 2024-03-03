package test;

import models.Bill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BillTest {
    @Test
    void successfullyCreatedBill() {
        Bill bill = new Bill();
        assertTrue(bill != null);
    }
}
