package models;

public class Invoice {
    private String clientName;
    private double valor;
    private double taxes;

    public Invoice(String clientName, double valor) {
        this.clientName = clientName;
        this.valor = valor;
        this.taxes = 0;
    }
}
