package Logica;


public class Cajero {
    private double saldo;

    public Cajero() {
        this.saldo = 0.0; // Saldo inicial en 0
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) throws MultiploCincoException {
        if (cantidad % 5 != 0) {
            throw new MultiploCincoException("El monto debe ser múltiplo de 5.");
        }
        saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true; // Retiro exitoso
        } else {
            return false; // Fondos insuficientes
        }
    }

    public class MultiploCincoException extends Exception {
        public MultiploCincoException(String message) {
            super(message);
        }
    }
}
