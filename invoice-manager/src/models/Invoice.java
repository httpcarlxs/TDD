package models;

public class Invoice {
    private String clientName;
    private double value;
    private double taxes;

    public Invoice(String clientName, double value) {
        this.clientName = clientName;
        this.value = value;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
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
}
