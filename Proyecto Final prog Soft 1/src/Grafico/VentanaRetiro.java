package Grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRetiro extends JFrame{
    private JPanel panel;
    private JButton volver, otro;
    private JButton[] botonesCantidades;


    public VentanaRetiro() {
        configurarVentana();
        iniciarComponentes();
    }

    public void configurarVentana(){
        setTitle("Retiro");
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        crearPanel();
        crearTexto();
        crearBotonesCant();
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
        texto.setText("Seleccione el valor a retirar");
        texto.setBounds(150, 50, 300, 30);
        texto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(texto);
    }

    private void crearBotonesCant(){
        int[] cantidades = {5, 10, 20, 50, 100, 200};
        botonesCantidades = new JButton[cantidades.length];

        int xInicial = 20;
        int yInicial = 150;
        int xGap = 430;
        int yGap = 150;

        for (int i = 0; i < cantidades.length; i++) {
            botonesCantidades[i] = new JButton(cantidades[i] + "$");
            botonesCantidades[i].setBounds(xInicial + (i % 2) * xGap, yInicial + (i / 2) * yGap, 200, 100);
            panel.add(botonesCantidades[i]);
        }

        // Otra cantidad
        otro = new JButton("OTRO");
        otro.setBounds(230,550,200,100);
        panel.add(otro);
    }

    private void crearBotonVolver(){
        // Botón "Volver"
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

        ActionListener accionOtro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField otroTextField = new JTextField();
                otroTextField.setVisible(true);
                otroTextField.setBounds(260,570, 150, 30);
                panel.add(otroTextField);
                otro.hide();

                JLabel text = new JLabel("Ingrese valor a retirar: ");
                text.setBounds(100, 570, 200, 30);
                text.setVisible(true);
                panel.add(text);

            }
        };
        otro.addActionListener(accionOtro);
    }
}

