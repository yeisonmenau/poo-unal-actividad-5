package ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VentanaEjercicio5 extends JFrame implements ActionListener {
    private JLabel mensajeLabel;
    private JLabel rutaLabel;
    private JLabel contenidoArchivoLabel;
    private JButton leerButton;
    private JButton seleccionarButton;
    private JFileChooser fileChooser;
    private Container contenedor;
    private List<String> contenidoArchivo = new java.util.ArrayList<>();
    LecturaArchivo lecturaArchivo = new LecturaArchivo();

    public VentanaEjercicio5() {
        setTitle("Ejercicio 5");
        setSize(315, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicio();

    }
    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        mensajeLabel = new JLabel("Paso 1: Buscar archivo. Paso 2: Leer archivo" );
        mensajeLabel.setBounds(10, 30, 290, 30);
        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contenedor.add(mensajeLabel);

        rutaLabel = new JLabel("ejercicio5/archivo.txt");
        rutaLabel.setBounds(10, 50, 290, 30);
        rutaLabel.setFont(new Font("Arial", Font.BOLD, 11));
        rutaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contenedor.add(rutaLabel);

        leerButton = new JButton("Leer Archivo");
        leerButton.setBounds(50, 120, 200, 30);
        contenedor.add(leerButton);

        seleccionarButton = new JButton("Seleccionar Archivo");
        seleccionarButton.setBounds(50, 80, 200, 30);
        contenedor.add(seleccionarButton);

        contenidoArchivoLabel = new JLabel();
        contenidoArchivoLabel.setBounds(50, 150, 300, 100);
        contenedor.add(contenidoArchivoLabel);

        seleccionarButton.addActionListener(this);
        leerButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seleccionarButton) {
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                lecturaArchivo.setRutaArchivo(fileChooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Archivo seleccionado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == leerButton) {
            try {
                lecturaArchivo.leerArchivo();
                contenidoArchivo = lecturaArchivo.getContenido();
                String mensaje = contenidoArchivo.get(0);
                contenidoArchivoLabel.setText(mensaje);

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado un archivo", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
