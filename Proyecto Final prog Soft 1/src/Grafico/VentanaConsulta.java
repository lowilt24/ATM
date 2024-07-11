package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsulta extends JFrame {
    private JPanel panel;
    private JButton volver;
    private Cuentas cuentas;
    private int pin;

    public VentanaConsulta(int pin, Cuentas cuentas) {
        configurarVentana();
        this.pin = pin;
        this.cuentas = cuentas;
        iniciarComponentes();
    }

    public void configurarVentana(){
        setTitle("Consulta de Saldo");
        setSize(400,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        crearTexto();
        crearBotonVolver();
        accionarBotones();
    }

    private void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearTexto(){
        JLabel texto = new JLabel();
        texto.setText("Saldo disponible: $" + cuentas.consultarSaldo(pin));
        texto.setBounds(50, 50, 300, 30);
        texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(texto);
    }

    private void crearBotonVolver(){
        volver = new JButton();
        volver.setBounds(150, 150, 100, 30);
        volver.setText("VOLVER");
        panel.add(volver);
    }

    private void accionarBotones(){
        ActionListener accionVolver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanPrincipal ventanPrincipal = new VentanPrincipal(cuentas);
                ventanPrincipal.setVisible(true);
                dispose();
            }
        };
        volver.addActionListener(accionVolver);
    }
}
