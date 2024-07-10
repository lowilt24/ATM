package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanPrincipal extends JFrame {
    private JPanel panel;
    private JButton retiro, ingreso, consulta;

    public VentanPrincipal(){
        setTitle("Cajero Automático");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        titulo();
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

    private void crearBotones(){
        // Botón Retiro
        retiro = new JButton("RETIRAR DINERO");
        retiro.setBounds(385,150,200,100);
        retiro.setOpaque(false);
        panel.add(retiro);

        // Botón Ingreso
        ingreso = new JButton("DEPOSITAR DINERO");
        ingreso.setBounds(385,300,200,100);
        panel.add(ingreso);

        // Botón Consulta
        consulta = new JButton("CONSULTAR SALDO");
        consulta.setBounds(385,450,200,100);
        panel.add(consulta);
    }

    private void accionarBotones(){

        //Botón Retiro
        ActionListener accionRetiro = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRetiro ventanaRetiro = new VentanaRetiro();
                ventanaRetiro.setVisible(true);
                dispose();
            }
        };
        retiro.addActionListener(accionRetiro);

        //Botón Ingreso
        ActionListener accionIngreso = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaIngreso ventanaIngreso = new VentanaIngreso();
                ventanaIngreso.setVisible(true);
                dispose();
            }
        };
        ingreso.addActionListener(accionIngreso);

        // Botón consulta
        ActionListener accionConsultar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaConsulta ventanaConsulta = new VentanaConsulta();
                ventanaConsulta.setVisible(true);
                dispose();
            }
        };
        consulta.addActionListener(accionConsultar);
    }

}
