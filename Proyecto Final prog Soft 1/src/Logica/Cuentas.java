package Logica;

public class Cuentas {
    private double saldoAhorro;
    private double saldoCorriente;
    private final int pinAhorro = 2024;
    private final int pinCorriente = 1123;

    public Cuentas() {
        this.saldoAhorro = 0.0; // Saldo inicial en 0
        this.saldoCorriente = 0.0; // Saldo inicial en 0
    }

    public double consultarSaldo(int pin) {
        if (pin == pinAhorro) {
            return saldoAhorro;
        } else if (pin == pinCorriente) {
            return saldoCorriente;
        } else {
            throw new IllegalArgumentException("PIN incorrecto");
        }
    }

    public void ingresar(double cantidad, int pin) throws MultiploCincoException {
        if (cantidad % 5 != 0) {
            throw new MultiploCincoException("El monto debe ser múltiplo de 5.");
        }
        if (pin == pinAhorro) {
            saldoAhorro += cantidad;
        } else if (pin == pinCorriente) {
            saldoCorriente += cantidad;
        } else {
            throw new IllegalArgumentException("PIN incorrecto");
        }
    }

    public boolean retirar(double cantidad, int pin) {
        if (pin == pinAhorro) {
            if (saldoAhorro >= cantidad) {
                saldoAhorro -= cantidad;
                return true; // Retiro exitoso
            } else {
                return false; // Fondos insuficientes
            }
        } else if (pin == pinCorriente) {
            if (saldoCorriente >= cantidad) {
                saldoCorriente -= cantidad;
                return true; // Retiro exitoso
            } else {
                return false; // Fondos insuficientes
            }
        } else {
            throw new IllegalArgumentException("PIN incorrecto");
        }
    }

    public class MultiploCincoException extends Exception {
        public MultiploCincoException(String message) {
            super(message);
        }
    }
}
