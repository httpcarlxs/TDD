package test;

import models.Bill;
import models.ServiceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BillTest {
    @Test
    void successfullyCreatedBill() {
        Bill bill = new Bill("", "", ServiceType.CONSULTANCY, 0);
        assertTrue(bill != null);
    }
}
