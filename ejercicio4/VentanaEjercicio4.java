package ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEjercicio4 extends JFrame implements ActionListener {
    private JLabel labelNombreEquipo;
    private JTextField textFieldNombreEquipo;
    private JLabel labelUniversidad;
    private JTextField textFieldUniversidad;
    private JLabel labelLenguajeProgramacion;
    private JTextField textFieldLenguajeProgramacion;

    private JButton buttonAgregarEquipo;
    private JLabel labelMensajeEquipo;

    private JLabel labelNombreProgramador;
    private JTextField textFieldNombreProgramador;
    private JLabel labelApellidosProgramador;
    private JTextField textFieldApellidosProgramador;

    private JButton buttonAgregarProgramador;
    private JButton buttonSalir;


    private Container contenedor;


    public VentanaEjercicio4(){
        setTitle("Ejercicio 4");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicio();
    }
    EquipoProgramacion equipo = new EquipoProgramacion();
    String nombreEquipo = equipo.getNombreEquipo();
    String universidad = equipo.getUniversidad();
    String lenguajeProgramacion = equipo.getLenguajeProgramacion();
    Programador programador = new Programador();
    String nombreProgramador = programador.getNombre();
    String apellidosProgramador = programador.getApellidos();


    public void inicio() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        labelNombreEquipo = new JLabel("Nombre del Equipo:");
        labelNombreEquipo.setBounds(50, 30, 150, 30);
        contenedor.add(labelNombreEquipo);
        textFieldNombreEquipo = new JTextField();
        textFieldNombreEquipo.setBounds(250, 30, 200, 30);
        contenedor.add(textFieldNombreEquipo);
        labelUniversidad = new JLabel("Universidad:");
        labelUniversidad.setBounds(50, 70, 150, 30);
        contenedor.add(labelUniversidad);
        textFieldUniversidad = new JTextField();
        textFieldUniversidad.setBounds(250, 70, 200, 30);
        contenedor.add(textFieldUniversidad);
        labelLenguajeProgramacion = new JLabel("Lenguaje de Programación:");
        labelLenguajeProgramacion.setBounds(50, 110, 200, 30);
        contenedor.add(labelLenguajeProgramacion);
        textFieldLenguajeProgramacion = new JTextField();
        textFieldLenguajeProgramacion.setBounds(250, 110, 200, 30);
        contenedor.add(textFieldLenguajeProgramacion);
        buttonAgregarEquipo = new JButton("Agregar Equipo");
        buttonAgregarEquipo.setBounds(150, 150, 200, 30);
        contenedor.add(buttonAgregarEquipo);

        buttonAgregarEquipo.addActionListener(this);

    }
    public void agregarProgramador(){
        labelNombreEquipo.setVisible(false);
        textFieldNombreEquipo.setVisible(false);
        labelUniversidad.setVisible(false);
        textFieldUniversidad.setVisible(false);
        labelLenguajeProgramacion.setVisible(false);
        textFieldLenguajeProgramacion.setVisible(false);
        buttonAgregarEquipo.setVisible(false);
        labelMensajeEquipo = new JLabel("Agregar programador. Equipo: " + nombreEquipo);
        labelMensajeEquipo.setBounds(50, 10, 400, 30);
        labelMensajeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
        contenedor.add(labelMensajeEquipo);
        labelNombreProgramador = new JLabel("Nombre:");
        labelNombreProgramador.setBounds(50, 70, 150, 30);
        contenedor.add(labelNombreProgramador);
        textFieldNombreProgramador = new JTextField();
        textFieldNombreProgramador.setBounds(200, 70, 200, 30);
        contenedor.add(textFieldNombreProgramador);
        labelApellidosProgramador = new JLabel("Apellidos:");
        labelApellidosProgramador.setBounds(50, 110, 150, 30);
        contenedor.add(labelApellidosProgramador);
        textFieldApellidosProgramador = new JTextField();
        textFieldApellidosProgramador.setBounds(200, 110, 200, 30);
        contenedor.add(textFieldApellidosProgramador);
        buttonAgregarProgramador = new JButton("Agregar Programador");
        buttonAgregarProgramador.setBounds(150, 150, 200, 30);
        contenedor.add(buttonAgregarProgramador);

        buttonAgregarProgramador.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == buttonAgregarEquipo) {
            try {
                nombreEquipo = textFieldNombreEquipo.getText();
                EquipoProgramacion.validarCampo(nombreEquipo);
                universidad = textFieldUniversidad.getText();
                EquipoProgramacion.validarCampo(universidad);
                lenguajeProgramacion = textFieldLenguajeProgramacion.getText();
                EquipoProgramacion.validarCampo(lenguajeProgramacion);

                equipo.setNombreEquipo(nombreEquipo);
                equipo.setUniversidad(universidad);
                equipo.setLenguajeProgramacion(lenguajeProgramacion);

                JOptionPane.showMessageDialog(contenedor, "Equipo " + nombreEquipo +" registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                agregarProgramador();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (evento.getSource() == buttonAgregarProgramador) {
            try {

                nombreProgramador = textFieldNombreProgramador.getText();
                EquipoProgramacion.validarCampo(nombreProgramador);
                apellidosProgramador = textFieldApellidosProgramador.getText();
                EquipoProgramacion.validarCampo(apellidosProgramador);

                programador.setNombre(nombreProgramador);
                programador.setApellidos(apellidosProgramador);

                if (equipo.estaLleno()) {
                    throw new Exception("El equipo ya está lleno. Puedes salir");
                }
                equipo.agregarProgramador(programador);

                JOptionPane.showMessageDialog(contenedor, "Programador " + programador.getNombre() +  " agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                textFieldNombreProgramador.setText("");
                textFieldApellidosProgramador.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (evento.getSource() == buttonSalir) {
            JOptionPane.showMessageDialog(contenedor, "Gracias por usar el programa.", "Información", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }
}
