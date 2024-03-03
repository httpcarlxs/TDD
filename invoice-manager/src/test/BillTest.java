package test;

import models.Bill;
import models.ServiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    @Test
    void successfullyCreatedBillTest() {
        Bill consultancyBill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.CONSULTANCY, 10.5);
        Bill trainingBill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.TRAINING, 10.5);
        Bill otherBill = new Bill("Brenda", "Rua da Paz, 100", ServiceType.OTHERS, 10.5);
        assertNotNull(consultancyBill);
        assertNotNull(trainingBill);
        assertNotNull(otherBill);
    }

    @Test
    void failCreateBillTest() {
        assertThrows(IllegalArgumentException.class, () -> new Bill("", "Rua da Paz, 100", ServiceType.CONSULTANCY, 10.5));
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "", ServiceType.TRAINING, 10.5));
        assertThrows(IllegalArgumentException.class, () -> new Bill("Brenda", "Rua da Paz, 100", ServiceType.OTHERS, -10.5));
    }

    @Test
    void successfullyGetAttributesTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill = new Bill(name, address, ServiceType.TRAINING, value);

        assertEquals(name, bill.getClientName());
        assertEquals(address, bill.getAddress());
        assertEquals(ServiceType.TRAINING, bill.getServiceType());
        assertEquals(value, bill.getValue());
    }

    @Test
    void successfullySetAttributesTest(){
        String name = "Brenda", address = "Rua do Sol";
        double value = 10.5;

        Bill bill = new Bill("Carlos", "Rua da Chuva", ServiceType.TRAINING, 1000);
        bill.setClientName(name);
        bill.setAddress(address);
        bill.setServiceType(ServiceType.CONSULTANCY);
        bill.setValue(value);

        assertEquals(name, bill.getClientName());
        assertEquals(address, bill.getAddress());
        assertEquals(ServiceType.CONSULTANCY, bill.getServiceType());
        assertEquals(value, bill.getValue());
    }

    @Test
    void equalsIdenticBillsTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill1 = new Bill(name, address, ServiceType.TRAINING, value);
        Bill bill2 = new Bill(name, address, ServiceType.TRAINING, value);

        assertEquals(bill1, bill2);
    }

    @Test
    void equalsDifferentBillsTest() {
        String name = "Brenda", address = "Rua da Pagode";
        double value = 10.5;
        Bill bill1 = new Bill(name, address, ServiceType.TRAINING, value);
        Bill bill2 = new Bill(name, address, ServiceType.CONSULTANCY, value);
        Bill bill3 = new Bill(name, "Rua do Mar", ServiceType.TRAINING, value);
        Bill bill4 = new Bill(name, address, ServiceType.TRAINING, 15.0);
        Bill bill5 = new Bill("Carlos", address, ServiceType.TRAINING, value);

        assertNotEquals(bill1, bill2);
        assertNotEquals(bill1, bill3);
        assertNotEquals(bill1, bill4);
        assertNotEquals(bill1, bill5);
    }
}
