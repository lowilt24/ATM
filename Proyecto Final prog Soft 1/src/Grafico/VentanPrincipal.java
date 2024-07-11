package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanPrincipal extends JFrame {
    private JPanel panel;
    private JButton ingreso, retiro, consulta;
    private Cuentas cuentas;

    public VentanPrincipal(Cuentas cuentas) {
        configurarVentana();
        this.cuentas = cuentas;
        iniciarComponentes();
    }

    public void configurarVentana(){
        setTitle("Cajero Automático");
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        crearBotones();
        accionarBotones();
    }

    private void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearBotones(){
        ingreso = new JButton("Ingresar Dinero");
        ingreso.setBounds(100, 50, 200, 50);
        panel.add(ingreso);

        retiro = new JButton("Retirar Dinero");
        retiro.setBounds(100, 150, 200, 50);
        panel.add(retiro);

        consulta = new JButton("Consultar Saldo");
        consulta.setBounds(100, 250, 200, 50);
        panel.add(consulta);
    }

    private void accionarBotones(){
        ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pinString = JOptionPane.showInputDialog("Ingrese el PIN:");
                try {
                    int pin = Integer.parseInt(pinString);
                    VentanaIngreso ventanaIngreso = new VentanaIngreso(pin, cuentas);
                    ventanaIngreso.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un PIN válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pinString = JOptionPane.showInputDialog("Ingrese el PIN:");
                try {
                    int pin = Integer.parseInt(pinString);
                    VentanaRetiro ventanaRetiro = new VentanaRetiro(pin, cuentas);
                    ventanaRetiro.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un PIN válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pinString = JOptionPane.showInputDialog("Ingrese el PIN:");
                try {
                    int pin = Integer.parseInt(pinString);
                    VentanaConsulta ventanaConsulta = new VentanaConsulta(pin, cuentas);
                    ventanaConsulta.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un PIN válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Cuentas cuentas = new Cuentas();
        VentanPrincipal ventanPrincipal = new VentanPrincipal(cuentas);
        ventanPrincipal.setVisible(true);
    }
}
