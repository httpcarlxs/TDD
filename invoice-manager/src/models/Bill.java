package models;

public class Bill {
    private String clientName;
    private String address;
    private ServiceType serviceType;
    private double value;

    public Bill(String clientName, String address, ServiceType serviceType, double value) {
        this.clientName = clientName;
        this.address = address;
        this.serviceType = serviceType;
        this.value = value;
    }

    public String getClientName() {
        return clientName;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public double getValue() {
        return value;
    }


}