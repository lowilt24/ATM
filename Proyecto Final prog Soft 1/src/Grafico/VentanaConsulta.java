package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsulta extends JFrame {
    private JPanel panel;
    private JLabel saldoLabel;
    private JButton volver;
    private Cuentas cuentas;
    private String tipoCuenta;

    public VentanaConsulta(Cuentas cuentas, String tipoCuenta) {
        configurarVentana();
        this.cuentas = cuentas;
        this.tipoCuenta = tipoCuenta;
        iniciarComponentes();
    }

    public void configurarVentana() {
        setTitle("Consulta de Saldo");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        crearPanel();
        mostrarSaldo();
        crearBotonVolver();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void mostrarSaldo() {
        saldoLabel = new JLabel("Saldo: $" + cuentas.getSaldo(tipoCuenta));
        saldoLabel.setBounds(50, 50, 300, 30);
        saldoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(saldoLabel);
    }

    private void crearBotonVolver() {
        volver = new JButton("VOLVER");
        volver.setBounds(150, 100, 100, 40);
        panel.add(volver);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanPrincipal ventanaPrincipal = new VentanPrincipal(cuentas, tipoCuenta);
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }
}
