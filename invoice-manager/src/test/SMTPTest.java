package test;

import org.junit.jupiter.api.Test;
import util.SMTP;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SMTPTest {
    @Test
    void saveTest() {
        assertEquals("salvando no banco", SMTP.send(new Invoice()));
    }
}
