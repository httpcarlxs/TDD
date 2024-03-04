package models;

import java.util.Objects;

public class Bill {
    private String clientName;
    private String address;
    private ServiceType serviceType;
    private double value;

    public Bill(String clientName, String address, ServiceType serviceType, double value) throws IllegalArgumentException {
        if (clientName.isBlank()) {
            throw new IllegalArgumentException("Blank client name on the bill");
        }

        if (address.isBlank()) {
            throw new IllegalArgumentException("Blank client name on the bill");
        }

        if (serviceType == null) {
            throw new IllegalArgumentException("Service type not specified on the bill");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Incoherent value on the bill");
        }

        this.clientName = clientName;
        this.address = address;
        this.serviceType = serviceType;
        this.value = value;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAddress() {
        return address;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public double getValue() {
        return value;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(value, bill.value) == 0 && Objects.equals(clientName, bill.clientName) && Objects.equals(address, bill.address) && serviceType == bill.serviceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, address, serviceType, value);
    }
}
