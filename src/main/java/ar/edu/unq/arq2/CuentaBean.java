package ar.edu.unq.arq2;

public class CuentaBean {
    private int numero;
    private String propietario;
    private double saldo;

    public CuentaBean() {
    }

    public CuentaBean(int numero, String propietario, double saldo) {
        this.numero = numero;
        this.propietario = propietario;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
