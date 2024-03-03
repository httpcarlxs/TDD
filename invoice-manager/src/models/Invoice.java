package models;

import java.util.Objects;

public class Invoice {
    private String clientName;
    private double value;
    private double taxes;

    public Invoice(String clientName, double value) {
        if (clientName.isBlank()) {
            throw new IllegalArgumentException("Blank client name on the bill");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Incoherent value on the bill");
        }

        this.clientName = clientName;
        this.value = value;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getClientName() {
        return clientName;
    }

    public double getValue() {
        return value;
    }

    public double getTaxes() {
        return taxes;
    }

    public void validateInvoice() throws IllegalArgumentException {
        if (clientName.isBlank()) {
            throw new IllegalArgumentException("Blank client name on the invoice");
        }

        if (taxes != 0.06 && taxes != 0.15 && taxes != 0.25) {
            throw new IllegalArgumentException("Incoherent taxes on the invoice");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Incoherent value on the invoice");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(value, invoice.value) == 0 && Double.compare(taxes, invoice.taxes) == 0 && Objects.equals(clientName, invoice.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, value, taxes);
    }
}
