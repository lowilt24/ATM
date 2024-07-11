package Grafico;

import Logica.Cajero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsulta extends JFrame {
    private JPanel panel;
    private JButton volver;
    private Cajero cajero;
    private int pin;

    public VentanaConsulta(int pin) {
        configurarVentana();
        this.pin = pin;
        cajero = new Cajero();
        iniciarComponentes();
    }

    private void configurarVentana(){
        setTitle("Consulta");
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        texto();
        crearBotones();
        accionarBotones();
    }

    private void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void texto(){
        JLabel texto = new JLabel();
        texto.setText("SU BALANCE TOTAL ES DE: $" + cajero.consultarSaldo());
        texto.setBounds(100, 300, 300, 30);
        texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(texto);
    }

    private void crearBotones(){
        volver = new JButton();
        volver.setBounds(20, 20, 100, 30);
        volver.setText("VOLVER");
        panel.add(volver);
    }

    private void accionarBotones(){
        ActionListener accionVolver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanPrincipal ventanPrincipal = new VentanPrincipal();
                ventanPrincipal.setVisible(true);
                dispose();
            }
        };
        volver.addActionListener(accionVolver);
    }
}

