package Grafico;

import Grafico.VentanPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRetiro extends JFrame{
    JPanel panel;
    JButton volver;
    JButton listo;
    JButton cant5, cant10, cant20, cant50, cant100, cant200, otro;


    public VentanaRetiro() {
        setTitle("Retiro");
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        crearPanel();
        texto();
        //crearTextField();
        crearBotonesCant();
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
        texto.setText("Ingrese un valor para retirar");
        texto.setBounds(150, 50, 300, 30);
        texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(texto);
    }

    /*private void crearTextField(){
        JTextField canxRet = new JTextField();
        canxRet.setBounds(100, 290, 300, 30);
        canxRet.setFont(new Font("Times", Font.PLAIN, 12));
        panel.add(canxRet);
    }*/

    private void crearBotonesCant(){
        //5
        cant5 = new JButton("5$");
        cant5.setBounds(20,150,200,100);
        panel.add(cant5);

        //10
        cant10 = new JButton("10$");
        cant10.setBounds(20,300,200,100);
        panel.add(cant10);

        //20
        cant20 = new JButton("20$");
        cant20.setBounds(20,450,200,100);
        panel.add(cant20);

        //50
        cant50 = new JButton("50$");
        cant50.setBounds(450,150,200,100);
        panel.add(cant50);

        //100
        cant100 = new JButton("100$");
        cant100.setBounds(450,300,200,100);
        panel.add(cant100);

        //200
        cant200 = new JButton("200$");
        cant200.setBounds(450,450,200,100);
        panel.add(cant200);

        // Otra cantidad
        otro = new JButton("OTRO");
        otro.setBounds(230,550,200,100);
        panel.add(otro);
    }

    private void crearBotones(){
        // Botón "Volver"
        volver = new JButton();
        volver.setBounds(20, 20, 100, 30);
        volver.setText("VOLVER");
        panel.add(volver);

        // Botón "Listo"
        listo = new JButton();
        listo.setBounds(100, 320, 100, 30);
        listo.setText("LISTO");
        panel.add(listo);
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

        ActionListener accionOtro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField otroTextField = new JTextField();
                otroTextField.setVisible(true);
                //otroTextField.setText("Ingrese un valor para retirar");
                otroTextField.setBounds(260,570, 150, 30);
                panel.add(otroTextField);
                otro.hide();

                JLabel text = new JLabel("INgrese valor a retirar: ");
                text.setBounds(100, 570, 200, 30);
                text.setVisible(true);
                panel.add(text);

            }
        };
        otro.addActionListener(accionOtro);
    }
}

