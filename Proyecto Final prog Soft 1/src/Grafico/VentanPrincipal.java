package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanPrincipal extends JFrame {
    private JPanel panel;
    private JButton ingreso, retiro, consulta, volver;
    private Cuentas cuentas;
    private String tipoCuenta;

    public VentanPrincipal(Cuentas cuentas, String tipoCuenta) {
        configurarVentana();
        this.cuentas = cuentas;
        this.tipoCuenta = tipoCuenta;
        iniciarComponentes();
    }

    public void configurarVentana() {
        setTitle("Cajero Automático");
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        crearPanel();
        crearTitulos();
        crearBotones();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearTitulos(){
        JLabel titulo = new JLabel("Cajero");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 50));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(170, 20, 700, 65);
        panel.add(titulo);

        JLabel subTitulo = new JLabel("Seleccione la función que desee realizar");
        subTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        subTitulo.setForeground(Color.BLACK);
        subTitulo.setBounds(130, 100, 700, 30);
        panel.add(subTitulo);
    }

    private void crearBotones() {
        ingreso = new JButton("DEPOSITAR DINERO");
        ingreso.setBounds(160, 150, 200, 100);
        panel.add(ingreso);

        retiro = new JButton("RETIRAR DINERO");
        retiro.setBounds(160, 300, 200, 100);
        panel.add(retiro);

        consulta = new JButton("CONSULTAR SALDO");
        consulta.setBounds(160, 450, 200, 100);
        panel.add(consulta);

        volver = new JButton("VOLVER");
        volver.setBounds(20, 20, 100, 30);
        panel.add(volver);

        ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaIngreso ventanaIngreso = new VentanaIngreso(cuentas, tipoCuenta);
                ventanaIngreso.setVisible(true);
                dispose();
            }
        });

        retiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRetiro ventanaRetiro = new VentanaRetiro(cuentas, tipoCuenta);
                ventanaRetiro.setVisible(true);
                dispose();
            }
        });

        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaConsulta ventanaConsulta = new VentanaConsulta(cuentas, tipoCuenta);
                ventanaConsulta.setVisible(true);
                dispose();
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionCuentaVentana seleccionCuentaVentana = new SeleccionCuentaVentana(cuentas);
                seleccionCuentaVentana.setVisible(true);
                dispose();
            }
        });
    }
}
