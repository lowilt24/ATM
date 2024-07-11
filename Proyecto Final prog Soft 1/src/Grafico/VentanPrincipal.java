package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanPrincipal extends JFrame {
    private JPanel panel;
    private JButton retiro, ingreso, consulta;
    private JComboBox<String> tipoCuenta;
    private int pinAhorro = 2024; // PIN para cuenta de ahorro
    private int pinCorriente = 1123; // PIN para cuenta corriente

    public VentanPrincipal(){
        configurarVentana();

        iniciarComponentes();
    }

    public void configurarVentana(){
        setTitle("Cajero Automático");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        titulo();
        seleccionTipoCuenta();
        crearBotones();
        accionarBotones();
    }

    private void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void titulo(){
        JLabel titulo = new JLabel();
        titulo.setText("Cajero");
        titulo.setBounds(400,20,200,100);
        titulo.setFont(new Font("IMPACT",Font.BOLD,60));
        panel.add(titulo);
    }

    private void seleccionTipoCuenta() {
        JLabel labelTipoCuenta = new JLabel("Seleccione el tipo de cuenta:");
        labelTipoCuenta.setBounds(360, 120, 200, 30);
        panel.add(labelTipoCuenta);

        String[] tipos = {"Ahorro", "Corriente"};
        tipoCuenta = new JComboBox<>(tipos);
        tipoCuenta.setBounds(380, 160, 150, 30);
        panel.add(tipoCuenta);
    }

    private void crearBotones(){
        // Botón Retiro
        retiro = new JButton("RETIRAR DINERO");
        retiro.setBounds(385,250,200,100);
        retiro.setOpaque(false);
        panel.add(retiro);

        // Botón Ingreso
        ingreso = new JButton("DEPOSITAR DINERO");
        ingreso.setBounds(385,400,200,100);
        panel.add(ingreso);

        // Botón Consulta
        consulta = new JButton("CONSULTAR SALDO");
        consulta.setBounds(385,550,200,100);
        panel.add(consulta);
    }

    private void accionarBotones(){

        //Botón Retiro
        ActionListener accionRetiro = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = solicitarPIN();
                if (pin != -1) {
                    VentanaRetiro ventanaRetiro = new VentanaRetiro(pin);
                    ventanaRetiro.setVisible(true);
                    dispose();
                }
            }
        };
        retiro.addActionListener(accionRetiro);

        //Botón Ingreso
        ActionListener accionIngreso = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = solicitarPIN();
                if (pin != -1) {
                    VentanaIngreso ventanaIngreso = new VentanaIngreso(pin);
                    ventanaIngreso.setVisible(true);
                    dispose();
                }
            }
        };
        ingreso.addActionListener(accionIngreso);

        // Botón consulta
        ActionListener accionConsultar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = solicitarPIN();
                if (pin != -1) {
                    VentanaConsulta ventanaConsulta = new VentanaConsulta(pin);
                    ventanaConsulta.setVisible(true);
                    dispose();
                }
            }
        };
        consulta.addActionListener(accionConsultar);
    }

    private int solicitarPIN() {
        String tipo = (String) tipoCuenta.getSelectedItem();
        int pin;
        if (tipo.equals("Ahorro")) {
            pin = pinAhorro;
        } else {
            pin = pinCorriente;
        }
        String inputPIN = JOptionPane.showInputDialog(null, "Ingrese su PIN de 4 dígitos:");
        try {
            int input = Integer.parseInt(inputPIN);
            if (input == pin) {
                return pin;
            } else {
                JOptionPane.showMessageDialog(null, "PIN incorrecto, intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un PIN válido (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static void main(String[] args) {
        VentanPrincipal ventana1 = new VentanPrincipal();
        ventana1.setVisible(true);
    }
}
