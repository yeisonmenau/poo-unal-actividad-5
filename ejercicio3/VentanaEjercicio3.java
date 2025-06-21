package ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class VentanaEjercicio3 extends JFrame implements ActionListener {
    private JLabel logaritmoLabel;
    private JLabel raizCuadradaLabel;
    private JLabel resultadologaritmoLabel;
    private JLabel resultadoRaizCuadradaLabel;

    private JTextField logaritmoTextField;
    private JTextField raizCuadradaTextField;

    private JButton calcularLogaritmoButton;
    private JButton calcularRaizCuadradaButton;

    private JButton borrarButton;

    private Container contenedor;

    CalculosNumericos calculadora = new CalculosNumericos();

    public VentanaEjercicio3(){
        setTitle("Ejercicio 3");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicio();
    }
    public void inicio(){
        contenedor = getContentPane();
        contenedor.setLayout(null);
        logaritmoLabel = new JLabel("Logaritmo Neperiano:");
        logaritmoLabel.setBounds(50, 30, 150, 30);
        contenedor.add(logaritmoLabel);

        raizCuadradaLabel = new JLabel("Raíz Cuadrada:");
        raizCuadradaLabel.setBounds(50, 90, 150, 30);
        contenedor.add(raizCuadradaLabel);

        logaritmoTextField = new JTextField();
        logaritmoTextField.setBounds(200, 30, 80, 30);
        contenedor.add(logaritmoTextField);

        raizCuadradaTextField = new JTextField();
        raizCuadradaTextField.setBounds(200, 90, 80, 30);
        contenedor.add(raizCuadradaTextField);

        calcularLogaritmoButton = new JButton("Calcular");
        calcularLogaritmoButton.setBounds(300, 30, 150, 30);
        contenedor.add(calcularLogaritmoButton);

        calcularRaizCuadradaButton = new JButton("Calcular");
        calcularRaizCuadradaButton.setBounds(300, 90, 150, 30);
        contenedor.add(calcularRaizCuadradaButton);

        resultadologaritmoLabel = new JLabel();
        resultadologaritmoLabel.setBounds(50, 60, 460, 30);
        contenedor.add(resultadologaritmoLabel);

        resultadoRaizCuadradaLabel = new JLabel();
        resultadoRaizCuadradaLabel.setBounds(50, 120, 460, 30);
        contenedor.add(resultadoRaizCuadradaLabel);

        borrarButton = new JButton("Borrar");
        borrarButton.setBounds(200, 150, 80, 30);
        contenedor.add(borrarButton);

        borrarButton.addActionListener(this);
        calcularLogaritmoButton.addActionListener(this);
        calcularRaizCuadradaButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcularLogaritmoButton) {
            try {
                double numero = Double.parseDouble(logaritmoTextField.getText());
                double resultado = calculadora.calcularLogaritmoNeperiano(numero);
                resultadologaritmoLabel.setText("Logaritmo Neperiano de " + numero + " es: " + resultado);
            } catch (ArithmeticException | InputMismatchException e) {
                JOptionPane.showMessageDialog(contenedor, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                logaritmoTextField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(contenedor, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                logaritmoTextField.setText("");
            }
        }
        if (evento.getSource() == calcularRaizCuadradaButton) {
            try {
                double numero = Double.parseDouble(raizCuadradaTextField.getText());
                double resultado = calculadora.calularRaizCuadrada(numero);
                resultadoRaizCuadradaLabel.setText("Raíz Cuadrada de " + numero + " es: " + resultado);
            } catch (ArithmeticException | InputMismatchException e) {
                JOptionPane.showMessageDialog(contenedor, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                raizCuadradaTextField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(contenedor, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                raizCuadradaTextField.setText("");
            }
        }
        if (evento.getSource() == borrarButton) {
            logaritmoTextField.setText("");
            raizCuadradaTextField.setText("");
            resultadologaritmoLabel.setText("");
            resultadoRaizCuadradaLabel.setText("");
        }
    }
}
