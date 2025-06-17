package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEjercicio2 extends JFrame implements ActionListener {
    private JLabel nombreLabel;
    private JLabel apellidosLabel;
    private JLabel edadLabel;

    private JTextField nombreTextField;
    private JTextField apellidosTextField;
    private JTextField edadTextField;

    private JButton registrarButton;
    private JButton borrarButton;

    private JLabel mensajeLabel;

    private Container contenedor;

    public VentanaEjercicio2(){
        setTitle("Ejercicio 1");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicio();
    }
    public void inicio(){
        contenedor = getContentPane();
        contenedor.setLayout(null);
        nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(100, 30, 100, 30);
        contenedor.add(nombreLabel);
        apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setBounds(100, 70, 100, 30);
        contenedor.add(apellidosLabel);
        edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(100, 110, 100, 30);
        contenedor.add(edadLabel);
        nombreTextField = new JTextField();
        nombreTextField.setBounds(200, 30, 200, 30);
        contenedor.add(nombreTextField);
        apellidosTextField = new JTextField();
        apellidosTextField.setBounds(200, 70, 200, 30);
        contenedor.add(apellidosTextField);
        edadTextField = new JTextField();
        edadTextField.setBounds(200, 110, 200, 30);
        contenedor.add(edadTextField);
        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(120, 160, 100, 30);
        contenedor.add(registrarButton);
        borrarButton = new JButton("Borrar");
        borrarButton.setBounds(270, 160, 100, 30);
        contenedor.add(borrarButton);
        mensajeLabel = new JLabel();
        mensajeLabel.setBounds(20, 200, 460, 30);
        contenedor.add(mensajeLabel);

        registrarButton.addActionListener(this);
        borrarButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == registrarButton) {
            try {
                String nombre = nombreTextField.getText();
                String apellidos = apellidosTextField.getText();
                int edad = Integer.parseInt(edadTextField.getText());
                Vendedor vendedor = new Vendedor(nombre, apellidos, edad);
                vendedor.verificarEdad(edad);
                nombreTextField.setText("");
                apellidosTextField.setText("");
                edadTextField.setText("");
                mensajeLabel.setText("Vendedor " + vendedor.getNombre() + " registrado correctamente. Puedes añadir otro vendedor.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(contenedor, "La edad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                edadTextField.setText("");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                edadTextField.setText("");
            }
        } else if (evento.getSource() == borrarButton) {
            nombreTextField.setText("");
            apellidosTextField.setText("");
            edadTextField.setText("");
            mensajeLabel.setText("");


        }
    }
}
