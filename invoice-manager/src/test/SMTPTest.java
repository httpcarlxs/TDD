package test;

import models.Invoice;
import org.junit.jupiter.api.Test;
import util.SMTP;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SMTPTest {
    @Test
    void saveTest() {
        assertEquals("enviando por email", SMTP.send(new Invoice("", 0)));
    }
}
