/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author maribelmoreno
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import crud.CrudAspirante;
import modelo.Aspirante;


public class InterfazAspirante extends JFrame {

    private CrudAspirante crud;
    private JTextField txtCedula, txtNombre, txtEdad, txtExperiencia, txtProfesion, txtTelefono;
    private JTextArea txtArea, txtAreaAspirantes, txtAreaResultados;
    private JTable tablaAspirantes;
    private DefaultTableModel model;
    private JPanel panelInputs;
    private JScrollPane scrollPane;
    private JFrame frame;

    public InterfazAspirante() {
    txtAreaAspirantes = new JTextArea();
    txtAreaAspirantes.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(txtAreaAspirantes);
    crud = new CrudAspirante();
    frame = new JFrame("Bolsa de empleo");
    setTitle("Bolsa de Empleo");
    setSize(900, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    
    
    // Título de la aplicación
    ImageIcon icon = new ImageIcon("data/imagenes/bolsadeempleo.png");
    Image img = icon.getImage();

    // Obtener el ancho del JFrame
    int anchoFrame = getWidth(); // El ancho total de la aplicación
    int nuevoAncho = anchoFrame - 20; // Dejar un margen de 10px a cada lado

    // Definir una altura fija para que actúe como encabezado
    int alturaEncabezado = 150; // Altura fija para el encabezado

    // Escalar la imagen proporcionalmente según el ancho y altura
    Image imgEscalada = img.getScaledInstance(nuevoAncho, alturaEncabezado, Image.SCALE_SMOOTH);
    ImageIcon iconEscalado = new ImageIcon(imgEscalada);

    // Agregar la imagen al JLabel y adaptarla al ancho del JFrame
    JLabel lblImagen = new JLabel(iconEscalado);
    lblImagen.setBounds(10, 10, nuevoAncho, alturaEncabezado); // Ajusta la posición y el tamaño
    add(lblImagen);


    // Título de lista de aspirantes
    JLabel lblListaAspirantes = new JLabel("Lista de Aspirantes", SwingConstants.CENTER);
    lblListaAspirantes.setFont(new Font("Arial", Font.BOLD, 18));
    lblListaAspirantes.setBounds(0, 170, 900, 30);
    add(lblListaAspirantes);

    // Configuración de la JTable
    String[] columnas = {"Cédula", "Nombre Completo", "Edad", "Experiencia", "Profesión", "Teléfono"};
    model = new DefaultTableModel(columnas, 0);
    tablaAspirantes = new JTable(model);
    scrollPane = new JScrollPane(tablaAspirantes);
    scrollPane.setBounds(10, 200, 880, 150);
    add(scrollPane);
    
    cargarAspirantesEnLista();
    

    // Panel para los campos de entrada, inicialmente oculto
    panelInputs = new JPanel();
    panelInputs.setLayout(null);
    panelInputs.setBounds(10, 350, 560, 200);
    panelInputs.setVisible(false); // Ocultar el panel de inputs inicialmente
    add(panelInputs);

    // Campos del formulario
    JLabel lblCedula = new JLabel("Cédula:");
    lblCedula.setBounds(10, 10, 80, 20);
    panelInputs.add(lblCedula);
    txtCedula = new JTextField();
    txtCedula.setBounds(100, 10, 150, 20);
    panelInputs.add(txtCedula);

    JLabel lblNombre = new JLabel("<html>Nombre<br>Completo:</html>");
    lblNombre.setBounds(10, 30, 120, 40);
    panelInputs.add(lblNombre);
    txtNombre = new JTextField();
    txtNombre.setBounds(100, 40, 150, 20);
    panelInputs.add(txtNombre);

    JLabel lblEdad = new JLabel("Edad:");
    lblEdad.setBounds(10, 70, 80, 20);
    panelInputs.add(lblEdad);
    txtEdad = new JTextField();
    txtEdad.setBounds(100, 70, 150, 20);
    panelInputs.add(txtEdad);

    JLabel lblExperiencia = new JLabel("<html>Años de<br>Experiencia:</html>");
    lblExperiencia.setBounds(10, 80, 80, 40);
    panelInputs.add(lblExperiencia);
    txtExperiencia = new JTextField();
    txtExperiencia.setBounds(100, 100, 150, 20);
    panelInputs.add(txtExperiencia);

    JLabel lblProfesion = new JLabel("Profesión:");
    lblProfesion.setBounds(10, 130, 80, 20);
    panelInputs.add(lblProfesion);
    txtProfesion = new JTextField();
    txtProfesion.setBounds(100, 130, 150, 20);
    panelInputs.add(txtProfesion);

    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setBounds(10, 160, 80, 20);
    panelInputs.add(lblTelefono);
    txtTelefono = new JTextField();
    txtTelefono.setBounds(100, 160, 150, 20);
    panelInputs.add(txtTelefono);    

    // Botón Agregar Aspirante
    ImageIcon iconAgregar = new ImageIcon("data/imagenes/agregar.png");
    Image imgAgregar = iconAgregar.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgAgregarEscalada = imgAgregar.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnAgregar = new JButton("Agregar Aspirante");
    // Asignamos el icono escalado al botón
    btnAgregar.setIcon(new ImageIcon(imgAgregarEscalada));
    // Ajustamos el tamaño del botón
    btnAgregar.setBounds(10, 370, 140, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnAgregar);
    
    // Botón Mostrar información Aspirante
    ImageIcon iconInformacion = new ImageIcon("data/imagenes/informacion.png");
    Image imgInformacion = iconInformacion.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgInformacionEscalada = imgInformacion.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnMostrarinformacionaspirante = new JButton("Información Aspirante");//Muestra la información del aspirante a partir de la cédula.
    // Asignamos el icono escalado al botón
    btnMostrarinformacionaspirante.setIcon(new ImageIcon(imgInformacionEscalada));
    // Ajustamos el tamaño del botón
    btnMostrarinformacionaspirante.setBounds(170, 370, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnMostrarinformacionaspirante.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnMostrarinformacionaspirante.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnMostrarinformacionaspirante);
    
    
    // Botón Buscar Aspirante
    ImageIcon iconBuscar = new ImageIcon("data/imagenes/buscar.png");
    Image imgBuscar = iconBuscar.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgBuscarEscalada = imgBuscar.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnBuscar = new JButton("Buscar Aspirante");
    // Asignamos el icono escalado al botón
    btnBuscar.setIcon(new ImageIcon(imgBuscarEscalada));
    // Ajustamos el tamaño del botón
    btnBuscar.setBounds(350, 370, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnBuscar.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnBuscar);
    
    // Botón contratar Aspirante
    ImageIcon iconContratar = new ImageIcon("data/imagenes/contratar.png");
    Image imgContratar  = iconContratar.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgContratarEscalada = imgContratar.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnContratar = new JButton("Contratar Aspirante"); 
    // Asignamos el icono escalado al botón
    btnContratar.setIcon(new ImageIcon(imgContratarEscalada));
    // Ajustamos el tamaño del botón
    btnContratar.setBounds(530, 370, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnContratar.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnContratar.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnContratar);
    
    
    // Botón eliminar Aspirante
    ImageIcon iconEliminar = new ImageIcon("data/imagenes/eliminar.png");
    Image imgEliminar  = iconEliminar.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgEliminarEscalada = imgEliminar.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnEliminar = new JButton("Eliminar Aspirante"); // Se elimina aspirante que tiene 1 año de experiencia.
    // Asignamos el icono escalado al botón
    btnEliminar.setIcon(new ImageIcon(imgEliminarEscalada));
    // Ajustamos el tamaño del botón
    btnEliminar.setBounds(720, 370, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnEliminar);
        
      
    // JComboBox para seleccionar el criterio de ordenación
    String[] criterios = {"Experiencia", "Edad", "Profesión"};
    JComboBox<String> comboOrdenar = new JComboBox<>(criterios);
    comboOrdenar.setBounds(170, 520, 160, 30);
    add(comboOrdenar);
    
    // Botón para ordenar aspirantes
    ImageIcon iconOrdenar = new ImageIcon("data/imagenes/ordenar.png");
    Image imgOrdenar = iconOrdenar.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgOrdenarEscalada = imgOrdenar.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnOrdenar = new JButton("Ordenar Aspirantes"); //Permite ordenar la lista de aspirantes por los diferentes criterios: años de experiencia, edad y profesión.
    // Asignamos el icono escalado al botón
    btnOrdenar.setIcon(new ImageIcon(imgOrdenarEscalada));
    // Ajustamos el tamaño del botón
    btnOrdenar.setBounds(170, 540, 160, 110); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnOrdenar.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnOrdenar.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnOrdenar);
    
    // Botón Mostrar cédulas Aspirantes
    ImageIcon iconCedula = new ImageIcon("data/imagenes/cedula.png");
    Image imgCedula = iconCedula.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgCedulaEscalada = imgCedula.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnMostrarcedulas = new JButton("Cédulas Aspirantes");
    // Asignamos el icono escalado al botón
    btnMostrarcedulas.setIcon(new ImageIcon(imgCedulaEscalada));
    // Ajustamos el tamaño del botón
    btnMostrarcedulas.setBounds(10, 520, 140, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnMostrarcedulas.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnMostrarcedulas.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnMostrarcedulas);
    
    
    // Botón Aspirante con mayor experiencia
    ImageIcon iconExperiencia = new ImageIcon("data/imagenes/experiencia.png");
    Image imgExperiencia = iconExperiencia.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgExperienciaEscalada = imgExperiencia.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnMayorexperiencia = new JButton("Aspirante con mayor experiencia"); 
    // Asignamos el icono escalado al botón
    btnMayorexperiencia.setIcon(new ImageIcon(imgExperienciaEscalada));
    // Ajustamos el tamaño del botón
    btnMayorexperiencia.setBounds(350, 520, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnMayorexperiencia.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnMayorexperiencia.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnMayorexperiencia);
    
 
    
    // Botón Aspirante más joven
    ImageIcon iconJoven = new ImageIcon("data/imagenes/joven.png");
    Image imgJoven  = iconJoven.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgJovenEscalada = imgJoven.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnAspirantejoven = new JButton("Aspirante más joven"); 
    // Asignamos el icono escalado al botón
    btnAspirantejoven.setIcon(new ImageIcon(imgJovenEscalada));
    // Ajustamos el tamaño del botón
    btnAspirantejoven.setBounds(530, 520, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnAspirantejoven.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnAspirantejoven.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnAspirantejoven);
    
    
    // Botón promedio de edad de los Aspirantes
    ImageIcon iconPromedio= new ImageIcon("data/imagenes/edad.png");
    Image imgPromedio  = iconPromedio.getImage();
    // Escalamos la imagen a un tamaño adecuado
    Image imgPromedioEscalada = imgPromedio.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    // Creamos el botón con texto
    JButton btnPromedio = new JButton("Promedio de edad"); 
    // Asignamos el icono escalado al botón
    btnPromedio.setIcon(new ImageIcon(imgPromedioEscalada));
    // Ajustamos el tamaño del botón
    btnPromedio.setBounds(720, 520, 160, 130); // Ajustamos el tamaño para que quepan imagen y texto
    // Configuramos la posición del texto
    btnPromedio.setHorizontalTextPosition(SwingConstants.CENTER); // Centra el texto horizontalmente
    btnPromedio.setVerticalTextPosition(SwingConstants.BOTTOM); // Coloca el texto debajo de la imagen
    // Añadimos el botón al panel o contenedor
    add(btnPromedio);    
    
    // Inicializa txtArea correctamente
    txtArea = new JTextArea();
    txtArea.setBounds(10, 600, 880, 50);
    add(txtArea);
    
    

    

    // Acción de agregar aspirante
        btnAgregar.addActionListener(e -> {
            panelInputs.setVisible(true); // Mostrar el formulario
            limpiarFormulario(); // Limpiar el formulario cuando se abre
        });
        
        

        // Acción de agregar el aspirante a la tabla
        JButton btnGuardarAspirante = new JButton("Guardar");
        btnGuardarAspirante.setBounds(270, 160, 100, 30);
        panelInputs.add(btnGuardarAspirante);
        
        btnGuardarAspirante.addActionListener(e -> {
            String cedula = txtCedula.getText();
            String nombre = txtNombre.getText();
            String profesion = txtProfesion.getText();
            String telefono = txtTelefono.getText();

            // Manejo de excepción al convertir a enteros
            int edad = 0;
            int experiencia = 0;
            try {
                edad = Integer.parseInt(txtEdad.getText());
                experiencia = Integer.parseInt(txtExperiencia.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos para Edad y Experiencia.");
                return; // Salir del método si ocurre una excepción
            }
            
            // Validación de la cédula: solo permite dígitos
            if (!cedula.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una cédula válida (solo dígitos).");
                return; // Salir del método si la cédula no es válida
            }
            // Validación del teléfono: solo permite dígitos y opcionalmente el símbolo "+"
            if (!telefono.matches("\\+?\\d+")) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un teléfono válido (solo dígitos y opcionalmente el símbolo +).");
                return; // Salir del método si el teléfono no es válido
            }
            
            // Validación de la edad: debe ser mayor a 18
            if (edad <= 18) {
                JOptionPane.showMessageDialog(this, "La edad debe ser superior a 18 años.");
                return; // Salir del método si la edad no es válida
            }

            // Crear el objeto Aspirante solo si la conversión fue exitosa y el teléfono es válido
            Aspirante aspirante = new Aspirante(cedula, nombre, edad, experiencia, profesion, telefono);
            crud.agregarAspirante(aspirante);
            agregarAspiranteTabla(aspirante); // Agrega a la tabla
            txtArea.setText("Aspirante agregado.");
            // Limpiar el formulario después de agregar
            limpiarFormulario();
            panelInputs.setVisible(false); // Ocultar el formulario después de agregar
        });
        
    // Acción Mostrar información aspirante a partir de la cédula
    btnMostrarinformacionaspirante.addActionListener(e -> {
        // Crear un cuadro de entrada para que el usuario ingrese el nombre
        String cedulaBuscada = JOptionPane.showInputDialog(null, "Ingrese la cédula del aspirante:");

        // Verificar si el usuario no canceló el cuadro de entrada
        if (cedulaBuscada != null && !cedulaBuscada.trim().isEmpty()) {
            // Buscar el aspirante usando el nombre ingresado
            Aspirante aspirante = crud.buscarPorCedula(cedulaBuscada);

            // Crear una nueva ventana para mostrar los resultados
            JFrame ventanaResultados = new JFrame("Resultados de Búsqueda");
            ventanaResultados.setSize(400, 300); // Tamaño de la ventana
            ventanaResultados.setLayout(new BorderLayout()); // Usar un layout para organizar componentes

            // Crear un área de texto para mostrar la información del aspirante
            JTextArea txtAreaResultados = new JTextArea();
            if (aspirante != null) {
                // Mostrar la información del aspirante si se encontró
                txtAreaResultados.setText("Cédula: " + aspirante.getCedula() + "\n" +
                                        "Nombre: " + aspirante.getNombreCompleto() + "\n" +
                                        "Edad: " + aspirante.getEdad() + "\n" +
                                        "Años de Experiencia: " + aspirante.getExperiencia() + "\n" +
                                        "Profesión: " + aspirante.getProfesion() + "\n" +
                                        "Teléfono: " + aspirante.getTelefono() + "\n"); // Corregido: eliminada la coma
            } else {
                // Informar que no se encontró el aspirante
                txtAreaResultados.setText("Aspirante no encontrado.");
            }

            // Añadir el área de texto al centro de la ventana
            JScrollPane scrollPaneResultados = new JScrollPane(txtAreaResultados); // Añadir scroll si es necesario
            ventanaResultados.add(scrollPaneResultados, BorderLayout.CENTER); // Añadir el área de texto al centro

            // Crear un botón de cerrar
            JButton btnCerrarVentana = new JButton("Cerrar");
            btnCerrarVentana.addActionListener(ev -> ventanaResultados.dispose()); // Cerrar la ventana al hacer clic
            ventanaResultados.add(btnCerrarVentana, BorderLayout.SOUTH); // Añadir el botón al sur

            // Hacer la ventana visible
            ventanaResultados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana
            ventanaResultados.setVisible(true);
        } else {
            // Informar al usuario si no se ingresó un nombre válido
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });
    
        
        
    // Acción de Buscar Aspirante
    btnBuscar.addActionListener(e -> {
        // Crear un cuadro de entrada para que el usuario ingrese el nombre
        String nombreBuscado = JOptionPane.showInputDialog(null, "Ingrese el nombre del aspirante:");

        // Verificar si el usuario no canceló el cuadro de entrada
        if (nombreBuscado != null && !nombreBuscado.trim().isEmpty()) {
            // Buscar el aspirante usando el nombre ingresado
            Aspirante aspirante = crud.buscarPorNombre(nombreBuscado);

            // Crear una nueva ventana para mostrar los resultados
            JFrame ventanaResultados = new JFrame("Resultados de Búsqueda");
            ventanaResultados.setSize(400, 300); // Tamaño de la ventana
            ventanaResultados.setLayout(new BorderLayout()); // Usar un layout para organizar componentes

            // Crear un área de texto para mostrar la información del aspirante
            JTextArea txtAreaResultados = new JTextArea();
            if (aspirante != null) {
                // Mostrar la información del aspirante si se encontró
                txtAreaResultados.setText("Cédula: " + aspirante.getCedula() + "\n" +
                                        "Nombre: " + aspirante.getNombreCompleto() + "\n" +
                                        "Edad: " + aspirante.getEdad() + "\n" +
                                        "Años de Experiencia: " + aspirante.getExperiencia() + "\n" +
                                        "Profesión: " + aspirante.getProfesion() + "\n" +
                                        "Teléfono: " + aspirante.getTelefono() + "\n"); // Corregido: eliminada la coma
            } else {
                // Informar que no se encontró el aspirante
                txtAreaResultados.setText("Aspirante no encontrado.");
            }

            // Añadir el área de texto al centro de la ventana
            JScrollPane scrollPaneResultados = new JScrollPane(txtAreaResultados); // Añadir scroll si es necesario
            ventanaResultados.add(scrollPaneResultados, BorderLayout.CENTER); // Añadir el área de texto al centro

            // Crear un botón de cerrar
            JButton btnCerrarVentana = new JButton("Cerrar");
            btnCerrarVentana.addActionListener(ev -> ventanaResultados.dispose()); // Cerrar la ventana al hacer clic
            ventanaResultados.add(btnCerrarVentana, BorderLayout.SOUTH); // Añadir el botón al sur

            // Hacer la ventana visible
            ventanaResultados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana
            ventanaResultados.setVisible(true);
        } else {
            // Informar al usuario si no se ingresó un nombre válido
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });
    
    // Acción contratar aspirante
    btnContratar.addActionListener(e -> {
        // Crear un cuadro de entrada para que el usuario ingrese la cédula del aspirante a contratar
        String cedulaAspirante = JOptionPane.showInputDialog(null, "Ingrese la cédula del aspirante a contratar:");

        // Verificar si el usuario no canceló el cuadro de entrada
        if (cedulaAspirante != null && !cedulaAspirante.trim().isEmpty()) {
            // Llamar al método para eliminar el aspirante
            boolean eliminado = crud.eliminarAspirante(cedulaAspirante);

            // Verificar si la eliminación fue exitosa
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Aspirante contratado y eliminado de la lista.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarAspirantesEnLista();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un aspirante con esa cédula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Informar al usuario si no se ingresó una cédula válida
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

    // Acción eliminar Aspirantes que tienen 1 año de experiencia.
    btnEliminar.addActionListener(e -> {
        int anios = 1; // Solo queremos eliminar aspirantes con 1 año de experiencia

        // Crear la instancia de CrudAspirante si no está ya creada
        CrudAspirante crud = new CrudAspirante(); 

        crud.eliminarPorExperiencia(anios);
        
        cargarAspirantesEnLista();

        // Opcional: Puedes mostrar un mensaje al usuario sobre el resultado
        JOptionPane.showMessageDialog(null, "Aspirantes con " + anios + " año(s) de experiencia eliminados.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
    });
    
    // Acción de mostrar cédulas
    btnMostrarcedulas.addActionListener(e -> {
        // Obtener las cédulas
        List<String> cedulas = crud.obtenerCedulas();

        // Crear una nueva ventana (JFrame)
        JFrame ventanaCedulas = new JFrame("Cédulas Aspirantes");
        ventanaCedulas.setSize(400, 300); // Tamaño de la ventana
        ventanaCedulas.setLayout(new BorderLayout()); // Usar un layout para organizar componentes

        // Crear un área de texto para mostrar las cédulas
        JTextArea txtAreaCedulas = new JTextArea();
        txtAreaCedulas.setText(String.join("\n", cedulas));
        txtAreaCedulas.setEditable(false); // Hacer que el área de texto no sea editable
        JScrollPane scrollPaneCedulas = new JScrollPane(txtAreaCedulas); // Añadir scroll si es necesario
        ventanaCedulas.add(scrollPaneCedulas, BorderLayout.CENTER); // Añadir el área de texto al centro

        // Crear un botón de cerrar
        JButton btnCerrarVentana = new JButton("Cerrar");
        btnCerrarVentana.addActionListener(ev -> ventanaCedulas.dispose()); // Cerrar la ventana al hacer clic
        ventanaCedulas.add(btnCerrarVentana, BorderLayout.SOUTH); // Añadir el botón al sur

        // Hacer la ventana visible
        ventanaCedulas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana
        ventanaCedulas.setVisible(true);
    });
    
    // Acción Ordenar de acuerdo a criterio de usuario
    btnOrdenar.addActionListener(e -> {
        String criterioSeleccionado = (String) comboOrdenar.getSelectedItem();  // Obtener el criterio seleccionado
        String criterio = "";
    
        // Convertir el criterio a un formato adecuado para tu método
        switch (criterioSeleccionado) {
            case "Experiencia":
                criterio = "experiencia";
                break;
            case "Edad":
                criterio = "edad";
                break;
            case "Profesión":
                criterio = "profesion";
                break;
        }
    
        // Actualizar la lista de aspirantes ordenados
        actualizarListaAspirantesOrdenados(criterio);
    });
    
    // Acción aspirante con mayor experiencia
        btnMayorexperiencia.addActionListener(e -> {
        // Llamar al método para obtener el aspirante con mayor experiencia
        Aspirante aspiranteMayorExperiencia = crud.obtenerAspiranteMayorExperiencia();

        // Verificar si se encontró un aspirante
        if (aspiranteMayorExperiencia != null) {
            // Mostrar los datos del aspirante en un mensaje
            String mensaje = String.format("Aspirante con mayor experiencia:\n" +
                                            "Cédula: %s\n" +
                                            "Nombre: %s\n" +
                                            "Edad: %d\n" +
                                            "Experiencia: %d años\n" +
                                            "Profesión: %s\n" +
                                            "Teléfono: %s",
                                            aspiranteMayorExperiencia.getCedula(),
                                            aspiranteMayorExperiencia.getNombreCompleto(),
                                            aspiranteMayorExperiencia.getEdad(),
                                            aspiranteMayorExperiencia.getExperiencia(),
                                            aspiranteMayorExperiencia.getProfesion(),
                                            aspiranteMayorExperiencia.getTelefono());
        
            JOptionPane.showMessageDialog(null, mensaje, "Aspirante Mayor Experiencia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si no se encuentra ningún aspirante
            JOptionPane.showMessageDialog(null, "No se encontraron aspirantes en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });
        
    // Acción Aspirante más joven
    btnAspirantejoven.addActionListener(e -> {
        // Llamar al método para obtener el aspirante más joven
        Aspirante aspiranteMasJoven = crud.obtenerAspiranteMasJoven();

        // Verificar si se encontró un aspirante
        if (aspiranteMasJoven != null) {
            // Mostrar los datos del aspirante en un mensaje
            String mensaje = String.format("Aspirante más joven:\n" +
                                            "Cédula: %s\n" +
                                            "Nombre: %s\n" +
                                            "Edad: %d\n" +
                                            "Experiencia: %d años\n" +
                                            "Profesión: %s\n" +
                                            "Teléfono: %s",
                                            aspiranteMasJoven.getCedula(),
                                            aspiranteMasJoven.getNombreCompleto(),
                                            aspiranteMasJoven.getEdad(),
                                            aspiranteMasJoven.getExperiencia(),
                                            aspiranteMasJoven.getProfesion(),
                                            aspiranteMasJoven.getTelefono());
        
            JOptionPane.showMessageDialog(null, mensaje, "Aspirante Más Joven", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si no se encuentra ningún aspirante
            JOptionPane.showMessageDialog(null, "No se encontraron aspirantes en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });
    
    // Acción promedio de edad de los aspirantes
    btnPromedio.addActionListener(e -> {
        // Llamar al método para obtener el promedio de edad
        double promedioEdad = crud.obtenerPromedioEdad();

        // Verificar si el promedio es válido
        if (promedioEdad > 0) {
            // Mostrar el promedio de edad en un mensaje
            String mensaje = String.format("El promedio de edad de los aspirantes es: %.2f años", promedioEdad);
            JOptionPane.showMessageDialog(null, mensaje, "Promedio de Edad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si no hay aspirantes en la base de datos
            JOptionPane.showMessageDialog(null, "No se encontraron aspirantes en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });
    
}
    
    
    // Método para cargar los aspirantes desde la base de datos y mostrarlos en la tabla
    public void cargarAspirantesEnLista() {
        List<Aspirante> listaAspirantes = crud.obtenerTodosLosAspirantes();  // Obtener lista desde la base de datos
        DefaultTableModel model = (DefaultTableModel) tablaAspirantes.getModel();  // Obtener el modelo de la tabla

        // Limpiar la tabla antes de añadir nuevos datos
        model.setRowCount(0);

        // Añadir los datos a la tabla
        for (Aspirante aspirante : listaAspirantes) {
            Object[] rowData = { 
                aspirante.getCedula(), 
                aspirante.getNombreCompleto(), 
                aspirante.getEdad(), 
                aspirante.getExperiencia(), 
                aspirante.getProfesion(), 
                aspirante.getTelefono()
            };
            model.addRow(rowData);  // Añadir cada aspirante a la tabla
        }
        tablaAspirantes.revalidate();  // Refresca el componente
        tablaAspirantes.repaint();      // Repaint opcional
    }

    


    // Método para limpiar el formulario
    private void limpiarFormulario() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtProfesion.setText("");
        txtTelefono.setText("");
        txtEdad.setText("");
        txtExperiencia.setText("");
    }
    
    // Método para actualizar tabla según elección del usuario
    public void actualizarListaAspirantesOrdenados(String criterio) {
        List<Aspirante> listaAspirantes = crud.obtenerAspirantesOrdenados(criterio);  // Obtener lista desde la base de datos
        DefaultTableModel model = (DefaultTableModel) tablaAspirantes.getModel();  // Obtener el modelo de la tabla

        // Limpiar la tabla antes de añadir nuevos datos
        model.setRowCount(0);

        // Añadir los datos a la tabla
        for (Aspirante aspirante : listaAspirantes) {
            Object[] rowData = { 
                aspirante.getCedula(), 
                aspirante.getNombreCompleto(), 
                aspirante.getEdad(), 
                aspirante.getExperiencia(), 
                aspirante.getProfesion(), 
                aspirante.getTelefono()
            };
            model.addRow(rowData);  // Añadir cada aspirante a la tabla
        }
    }
    

    
    

    private void agregarAspiranteTabla(Aspirante aspirante) {
        Object[] fila = {aspirante.getCedula(), aspirante.getNombreCompleto(), aspirante.getEdad(),
                         aspirante.getExperiencia(), aspirante.getProfesion(), aspirante.getTelefono()};
        model.addRow(fila);
    }

    public static void main(String[] args) {
        new InterfazAspirante().setVisible(true);
    }
}

