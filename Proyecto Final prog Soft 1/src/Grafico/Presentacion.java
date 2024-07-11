package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presentacion extends JFrame {
    private JPanel panel;
    private JButton continuar;

    public Presentacion() {
        configurarVentana();
        iniciarComponentes();
    }

    public void configurarVentana() {
        setTitle("Cajero Automático");
        setSize(1200, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        crearPanel();
        crearTitulos();
        crearImagenes();
        crearBotonContinuar();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearTitulos(){
        JTextArea titulo = new JTextArea();
        titulo.setBounds(200, 20, 800, 200);


        titulo.setText("        UNIVERSIDAD TECNOLÓGICA DE PANAMA\n" +
                       "Facultad de Ingeniería de Sistemas Computacionales\n" +
                       "                   Ingeniería de Software\n" +
                       "\n" +
                       "                          Integrantes:\n");
        titulo.setEditable(false);
        titulo.setBackground(Color.GRAY);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);
        panel.add(titulo);

        JTextArea integrantes = new JTextArea();
        integrantes.setBounds(460, 220, 800, 100);
        integrantes.setText("Belton, Marcial\n" +
                            "Moreno, Josue\n" +
                            "Moreno, Milagros\n" +
                            "Wiltshire, Louis\n");
        integrantes.setEditable(false);
        integrantes.setBackground(Color.GRAY);
        integrantes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        integrantes.setForeground(Color.BLACK);
        panel.add(integrantes);

        JLabel grupo = new JLabel("Grupo:");
        grupo.setBounds(460, 350, 150, 40);
        grupo.setFont(new Font("Tahoma", Font.BOLD, 30));
        grupo.setForeground(Color.BLACK);
        panel.add(grupo);

        JLabel grupoNum = new JLabel("1SF123");
        grupoNum.setBounds(480, 400, 150, 40);
        grupoNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        grupoNum.setForeground(Color.BLACK);
        panel.add(grupoNum);

        JLabel profesor = new JLabel("Profesor:");
        profesor.setBounds(450, 450, 150, 40);
        profesor.setFont(new Font("Tahoma", Font.BOLD, 30));
        profesor.setForeground(Color.BLACK);
        panel.add(profesor);

        JLabel profesorNom = new JLabel("Rodrigo Yángüez");
        profesorNom.setBounds(445, 500, 150, 40);
        profesorNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        profesorNom.setForeground(Color.BLACK);
        panel.add(profesorNom);

        JLabel fecha = new JLabel("Fecha:");
        fecha.setBounds(470, 550, 150, 40);
        fecha.setFont(new Font("Tahoma", Font.BOLD, 30));
        fecha.setForeground(Color.BLACK);
        panel.add(fecha);

        JLabel fechaNum = new JLabel("12-JULIO-2024");
        fechaNum.setBounds(445, 600, 150, 40);
        fechaNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fechaNum.setForeground(Color.BLACK);
        panel.add(fechaNum);

    }

    private void crearImagenes(){
        ImageIcon imgUtp = new ImageIcon("utp.png");
        JLabel imagenUTP = new JLabel(imgUtp);
        imagenUTP.setBounds(20,20,160,160);
        imagenUTP.setIcon(new ImageIcon(imgUtp.getImage().getScaledInstance(imagenUTP.getWidth(), imagenUTP.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(imagenUTP);

        ImageIcon imgFISC = new ImageIcon("FISCCC.png");
        JLabel imagenFISC = new JLabel(imgFISC);
        imagenFISC.setBounds(1000,20,160,160);
        imagenFISC.setIcon(new ImageIcon(imgFISC.getImage().getScaledInstance(imagenFISC.getWidth(), imagenFISC.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(imagenFISC);
    }

    private void crearBotonContinuar() {
        continuar = new JButton("CONTINUAR");
        continuar.setBounds(445, 650, 150, 50);
        panel.add(continuar);

        continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuentas cuentas = new Cuentas();
                SeleccionCuentaVentana seleccionCuentaVentana = new SeleccionCuentaVentana(cuentas);
                seleccionCuentaVentana.setVisible(true);
                dispose();
            }
        });
    }
}
