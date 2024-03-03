package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import util.InvoiceDao;

class InvoiceDaoTest {
    @Test
    void saveTest() {
        assertEquals("salvando no banco", InvoiceDao.save(new Invoice()));
    }
}
