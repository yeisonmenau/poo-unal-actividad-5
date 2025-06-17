package ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaEjercicio1 extends JFrame implements ActionListener {
    private JLabel dividendoLabel;
    private JLabel divisorLabel;

    private JTextField dividendoTextField;
    private JTextField divisorTextField;

    private JButton calcularButton;
    private JButton borrarButton;
    private JLabel resultadoLabel;
    private Container contenedor;

    public VentanaEjercicio1() {
        setTitle("Ejercicio 1");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicio();

    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        dividendoLabel = new JLabel("Numerador:");
        dividendoLabel.setBounds(50, 30, 100, 30);
        contenedor.add(dividendoLabel);
        divisorLabel = new JLabel("Denominador:");
        divisorLabel.setBounds(50, 70, 100, 30);
        contenedor.add(divisorLabel);
        dividendoTextField = new JTextField();
        dividendoTextField.setBounds(150, 30, 200, 30);
        contenedor.add(dividendoTextField);
        divisorTextField = new JTextField();
        divisorTextField.setBounds(150, 70, 200, 30);
        contenedor.add(divisorTextField);
        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(50, 120, 100, 30);
        contenedor.add(calcularButton);
        borrarButton = new JButton("Borrar");
        borrarButton.setBounds(200, 120, 100, 30);
        contenedor.add(borrarButton);
        resultadoLabel = new JLabel();
        resultadoLabel.setBounds(50, 170, 300, 30);
        contenedor.add(resultadoLabel);

        calcularButton.addActionListener(this);
        borrarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcularButton) {
            try {
                double dividendo = Double.parseDouble(dividendoTextField.getText());
                double divisor = Double.parseDouble((divisorTextField.getText()));
                if (divisor == 0) {
                    JOptionPane.showMessageDialog(contenedor, "No se puede dividir por 0", "Error", JOptionPane.ERROR_MESSAGE);
                    dividendoTextField.setText("");
                    divisorTextField.setText("");
                }
                else {
                    double resultado = dividendo / divisor;
                    resultadoLabel.setText("Resultado: " + String.valueOf(resultado));
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(contenedor, "Entrada inválida", "Error", JOptionPane.ERROR_MESSAGE);
                dividendoTextField.setText("");
                divisorTextField.setText("");
            }
        } else if (evento.getSource() == borrarButton) {
            dividendoTextField.setText("");
            divisorTextField.setText("");
        }
    }

}
