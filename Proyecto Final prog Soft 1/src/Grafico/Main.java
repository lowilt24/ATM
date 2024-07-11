package Grafico;

import Logica.Cuentas;

public class Main {
    public static void main(String[] args) {
        Cuentas cuentas = new Cuentas();
        VentanPrincipal ventanPrincipal = new VentanPrincipal(cuentas);
        ventanPrincipal.setVisible(true);
    }
}
