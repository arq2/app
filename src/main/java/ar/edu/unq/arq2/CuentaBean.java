package ar.edu.unq.arq2;

public class CuentaBean {
    private int numero;
    private String propietario;
    private double saldo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuentaBean)) return false;

        CuentaBean that = (CuentaBean) o;

        if (getNumero() != that.getNumero()) return false;
        if (Double.compare(that.getSaldo(), getSaldo()) != 0) return false;
        return getPropietario().equals(that.getPropietario());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getNumero();
        result = 31 * result + getPropietario().hashCode();
        temp = Double.doubleToLongBits(getSaldo());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

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
