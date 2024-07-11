package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionCuentaVentana extends JFrame {
    private JPanel panel;
    private JButton ahorro, corriente;
    private Cuentas cuentas;

    public SeleccionCuentaVentana(Cuentas cuentas) {
        this.cuentas = cuentas;
        configurarVentana();
        iniciarComponentes();
    }

    public void configurarVentana() {
        setTitle("Seleccione el Tipo de Cuenta");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        crearPanel();
        crearPistaText();
        crearBotones();
    }

    private void crearPistaText(){
        JLabel pistaText = new JLabel("Pistas: Número de grupo y año del proyecto");
        pistaText.setBounds(20,330,350,30);
        pistaText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(pistaText);
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearBotones() {
        ahorro = new JButton("Cuenta de Ahorro");
        ahorro.setBounds(100, 100, 200, 50);
        panel.add(ahorro);

        corriente = new JButton("Cuenta Corriente");
        corriente.setBounds(100, 200, 200, 50);
        panel.add(corriente);

        ahorro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solicitarPin("Ahorro");
            }
        });

        corriente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solicitarPin("Corriente");
            }
        });
    }

    private void solicitarPin(String tipoCuenta) {
        String inputPIN = JOptionPane.showInputDialog(null, "Ingrese su PIN de 4 dígitos:");
        try {
            int pin = Integer.parseInt(inputPIN);
            if (cuentas.verificarPin(tipoCuenta, pin)) {
                VentanPrincipal ventanaPrincipal = new VentanPrincipal(cuentas, tipoCuenta);
                ventanaPrincipal.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "PIN incorrecto, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un PIN válido (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
