package Grafico;

import Logica.Cuentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIngreso extends JFrame {
    private JPanel panel;
    private JButton volver, otro;
    private JButton[] botonesCantidades;
    private JTextField otroTextField;
    private Cuentas cuentas;
    private String tipoCuenta;

    public VentanaIngreso(Cuentas cuentas, String tipoCuenta) {
        configurarVentana();
        this.cuentas = cuentas;
        this.tipoCuenta = tipoCuenta;
        iniciarComponentes();
    }

    public void configurarVentana() {
        setTitle("Depósito");
        setSize(700, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        crearPanel();
        crearTexto();
        crearBotonesCant();
        crearBotonVolver();
    }

    private void crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }

    private void crearTexto() {
        JLabel texto = new JLabel("Seleccione el valor a depositar");
        texto.setBounds(200, 60, 350, 30);
        texto.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(texto);
    }

    private void crearBotonesCant() {
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
            botonesCantidades[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int monto = Integer.parseInt(e.getActionCommand().replace("$", ""));
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                            "¿Está seguro que desea depositar $" + monto + " en su cuenta?",
                            "Confirmación de depósito",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        try {
                            cuentas.ingresar(tipoCuenta, monto);
                            JOptionPane.showMessageDialog(null, "Depósito exitoso de $" + monto);
                        } catch (Cuentas.MultiploCincoException | Cuentas.MenorACincoException | Cuentas.MaxRetiroIngresoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }

        // Otra cantidad
        otro = new JButton("OTRO");
        otro.setBounds(230,550,200,100);
        panel.add(otro);

        otro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                otroTextField = new JTextField();
                otroTextField.setBounds(260,570, 150, 30);
                panel.add(otroTextField);
                otro.hide();

                JLabel text = new JLabel("Ingrese valor a depositar: ");
                text.setBounds(100, 570, 200, 30);
                panel.add(text);

                JButton confirmar = new JButton("Confirmar");
                confirmar.setBounds(260, 620, 150, 30);
                panel.add(confirmar);

                confirmar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int monto = Integer.parseInt(otroTextField.getText());
                            int confirmacion = JOptionPane.showConfirmDialog(null,
                                    "¿Está seguro que desea depositar $" + monto + " en su cuenta?",
                                    "Confirmación de depósito",
                                    JOptionPane.YES_NO_OPTION);
                            if (confirmacion == JOptionPane.YES_OPTION) {
                                cuentas.ingresar(tipoCuenta, monto);
                                JOptionPane.showMessageDialog(null, "Depósito exitoso de $" + monto);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ingrese un monto válido", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (Cuentas.MultiploCincoException | Cuentas.MenorACincoException | Cuentas.MaxRetiroIngresoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                panel.revalidate();
                panel.repaint();
            }
        });
    }

    private void crearBotonVolver() {
        volver = new JButton("VOLVER");
        volver.setBounds(20, 20, 100, 30);
        panel.add(volver);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanPrincipal ventanaPrincipal = new VentanPrincipal(cuentas, tipoCuenta);
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }
}
