package Logica;


public class Cuentas {
    private int saldoAhorro;
    private int saldoCorriente;
    private final int pinAhorro = 2024;
    private final int pinCorriente = 1123;

    public Cuentas() {
        this.saldoAhorro = 0;
        this.saldoCorriente = 0;
    }

    public boolean verificarPin(String tipoCuenta, int pin) {
        if (tipoCuenta.equals("Ahorro")) {
            return pin == pinAhorro;
        } else if (tipoCuenta.equals("Corriente")) {
            return pin == pinCorriente;
        }
        return false;
    }

    public void ingresar(String tipoCuenta, int monto) throws MultiploCincoException, MenorACincoException, MaxRetiroIngresoException {
        if (monto % 5 != 0) {
            throw new MultiploCincoException("El monto debe ser múltiplo de 5.");
        } else if (monto < 5) {
            throw new MenorACincoException("La mínima cantidad a depositar es de $5 por transacción.");
        } else if (monto > 500) {
            throw new MaxRetiroIngresoException("La máxima cantidad a depositar es de $500 por transacción.");
        }

        if (tipoCuenta.equals("Ahorro")) {
            saldoAhorro += monto;
        } else if (tipoCuenta.equals("Corriente")) {
            saldoCorriente += monto;
        }
    }

    public void retirar(String tipoCuenta, int monto) throws SaldoInsuficienteException, MultiploCincoException, MenorACincoException, MaxRetiroIngresoException {
        if (monto % 5 != 0) {
            throw new MultiploCincoException("El monto debe ser múltiplo de 5.");
        } else if (monto < 5) {
            throw new MenorACincoException("La mínima cantidad a retirar es de $5 por transacción.");
        } else if (monto > 500) {
            throw new MaxRetiroIngresoException("La máxima cantidad a retirar es de $500 por transacción.");
        }

        if (tipoCuenta.equals("Ahorro")) {
            if (saldoAhorro < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente en la cuenta de ahorro.");
            }
            saldoAhorro -= monto;
        } else if (tipoCuenta.equals("Corriente")) {
            if (saldoCorriente < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente en la cuenta corriente.");
            }
            saldoCorriente -= monto;
        }
    }

    public int getSaldo(String tipoCuenta) {
        if (tipoCuenta.equals("Ahorro")) {
            return saldoAhorro;
        } else if (tipoCuenta.equals("Corriente")) {
            return saldoCorriente;
        }
        return 0;
    }

    public static class MaxRetiroIngresoException extends Exception {
        public MaxRetiroIngresoException(String message) {
            super(message);
        }
    }

    public static class MenorACincoException extends Exception {
        public MenorACincoException(String message) {
            super(message);
        }
    }

    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }

    public static class MultiploCincoException extends Exception {
        public MultiploCincoException(String message) {
            super(message);
        }
    }
}
