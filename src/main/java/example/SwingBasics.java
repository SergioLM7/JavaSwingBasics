package example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SwingBasics {

    //¿Qué es Java Swing?

    /* Swing: biblioteca para crear GUI.
    Viene incluida en Java, podemos crear: ventanas, textos, menús...

    Los elementos a los que nos referimos llevan el nombre de componentes.
    Y el paquete es javax.swing
     */

    //1. Crear la primera ventana (JFrame)
    /* JFrame para todas las apps de Java Swing su 💖, y representa una ventana.*/
    public static void usandoJFrame() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho, alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir
        ventana.setVisible(true); //hace visible la ventana
    }

    //2. Agregar un JLabel
    /*
        JLabel permite mostrar texto
        Por defecto, el layout de JFrame es BorderLayout,
        y si añadimos solo 1 componente, ocupa to do el espacio.
        Aparece centrado y a la izquierda.
     */
    public static void usandoJLabel() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho, alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir

        JLabel texto = new JLabel("Hola DAM");
        ventana.add(texto);

        ventana.setVisible(true); //hace visible la ventana
    }

    //3. Agregar un JButton y capturar eventos
    /*
        JButton es un botón que el usuario puede pulsar y para que funcione al hacerle click,
        tenemos que escuchar eventos usando actionListenner()
     */
    public static void usandoJButton() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho, alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir

        JButton boton = new JButton("Haz click aquí");
        boton.setBounds(120, 70, 150, 30);

        ventana.add(boton);

        //Crear el evento
        boton.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "¡Botón puslado!");
        });

        JLabel texto = new JLabel("Hola DAM");
        ventana.add(texto);

        ventana.setVisible(true); //hace visible la ventana
    }

    //4. Agregar un JTexField (campo de texto)
    /*
        Permite que el usuario ingrese datos, por ejemplo, su nombre
        Vamos a añadir un botón que use ese nombre para decirle "hola"
     */
    public static void useJTextField() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho, alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir
        ventana.setLayout(null);

        JLabel etiqueta = new JLabel("Ingresa tu nombre: ");
        etiqueta.setBounds(50,30,150,25);
        ventana.add(etiqueta);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(180,30,150,25);

        ventana.add(campoTexto);

        JButton boton = new JButton("Saludar");
        boton.setBounds(140, 80, 120, 30);

        ventana.add(boton);

        //Crear el evento
        boton.addActionListener(e -> {
            String nombre = campoTexto.getText();
            JOptionPane.showMessageDialog(ventana, "¡Hola, " + nombre + "!");
        });

        ventana.setVisible(true); //hace visible la ventana
    }

    /*
    * Calculadora que suma dos doubles
    */
    public static void calculadora() {
        JFrame ventana = new JFrame("Calculadora");
        ventana.setSize(300, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JLabel etiqueta1 = new JLabel("Número 1");
        etiqueta1.setBounds(20, 20, 80, 25);
        ventana.add(etiqueta1);

        JTextField campo1 = new JTextField();
        campo1.setBounds(100,20,80,25);
        ventana.add(campo1);

        JLabel etiqueta2 = new JLabel("Número 2");
        etiqueta2.setBounds(20, 60, 80, 25);
        ventana.add(etiqueta2);

        JTextField campo2 = new JTextField();
        campo2.setBounds(100,60,80,25);
        ventana.add(campo2);

        JLabel etiqueta3 = new JLabel("Resultado");
        etiqueta3.setBounds(20, 100, 80, 25);
        ventana.add(etiqueta3);

        JTextField resultado = new JTextField();
        resultado.setBounds(100,100,80,25);
        ventana.add(resultado);

        JButton btnSumar = new JButton("+");
        btnSumar.setBounds(20, 140, 80, 25);
        btnSumar.addActionListener(e -> {
            try {
                double numero1 = Double.parseDouble(campo1.getText());
                double numero2 = Double.parseDouble(campo2.getText());
                double resultadoSuma = numero1 + numero2;

                resultado.setText(String.valueOf(resultadoSuma));
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(ventana, "Por favor, ingresa números válidos");

            }
        });
        ventana.add(btnSumar);


        ventana.setVisible(true);
    }

    //6. Layouts en Swing
    /*
        setLayout(null) -> para jugar con posicionamiento absoluto (coordenadas de cada componente) - Poco práctico!!!
        FlowLayout -> para componentes en fila, todos se ajustan automáticamente en el espacio disponible
        (si se hace más estrecha, se apilan uno encima de otro)
        BorderLayout -> divide la ventana en norte, sur, este, oeste y centro. El centro siempre es predominante, le da más espacio
        GridLayout -> grid de CSS, tabla con filas y columnas iguales
        BoxLayout -> los componentes en fila o columna (como el Flex de CSS) con alineación
     */
    public static void usandoFlowLayout() {
        JFrame ventana = new JFrame("FlowLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));

        ventana.setVisible(true);
    }

    public static void usandoGridLayout() {
        JFrame ventana = new JFrame("GridLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridLayout(4, 2, 5, 5)); //filas, columnas, gap de alto, gap de ancho

        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));
        ventana.add(new JButton("Botón 4"));

        ventana.setVisible(true);
    }

    public static void usandoBorderLayout() {
        JFrame ventana = new JFrame("BorderLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        ventana.add(new JButton("Norte"), BorderLayout.NORTH);
        ventana.add(new JButton("Sur"), BorderLayout.SOUTH);
        ventana.add(new JButton("Este"), BorderLayout.EAST);
        ventana.add(new JButton("Oeste"), BorderLayout.WEST);
        ventana.add(new JButton("Centro"), BorderLayout.CENTER);

        ventana.setVisible(true);
    }

    public static void usandoBoxLayout() {
        JFrame ventana = new JFrame("BoxLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));

        ventana.add(new JButton("One"));
        ventana.add(new JButton("Two"));
        ventana.add(new JButton("Three"));
        ventana.add(new JButton("Four"));
        ventana.add(new JButton("Five"));

        ventana.setVisible(true);
    }

    public static void usandoCombinationLayout() {
        JFrame ventana = new JFrame("CombinationLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Resultado: "));
        topPanel.add(new JTextField(10));

        ventana.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("4"));
        centerPanel.add(new JButton("5"));
        centerPanel.add(new JButton("6"));
        centerPanel.add(new JButton("7"));
        centerPanel.add(new JButton("8"));
        centerPanel.add(new JButton("9"));
        centerPanel.add(new JButton("0"));
        centerPanel.add(new JButton("C"));

        ventana.add(centerPanel, BorderLayout.CENTER);

        ventana.setVisible(true);
    }

    public static void usandoJList() {

        JFrame ventana = new JFrame("JList");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] fruitsList = new String[]{"apple", "orange", "pear", "lemon", "banana"};

        JList<String> list =  new JList<>(fruitsList);
        //Creamos un panel scrolleable que nos permita bajar hacia abajo en la lista
        JScrollPane scrollPane = new JScrollPane(list);

        ventana.add(scrollPane);

        ventana.setVisible(true);
    }

    public static void usandoJTable() {
        JFrame ventana = new JFrame("JTable");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] data = new String[][]{
            {"1", "Juan", "25"}, {"2", "José", "35"}, {"3", "Sofía", "18"},
        };

        String[] columns = new String[]{"id", "nombre", "edad"};

        JTable jTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(jTable);
        ventana.add(scrollPane);

        ventana.setVisible(true);
    }

    public static void usandoListaInteractiva() {

        JFrame ventana = new JFrame("JList + JButton");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(5,5));

        //Modelo para crear datos internos que ocupa un espacio vacío hasta que se le añadan datos
        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> list =  new JList<>(listModel);
        //Creamos un panel scrolleable que nos permita bajar hacia abajo en la lista
        JScrollPane scrollPane = new JScrollPane(list);
        ventana.add(scrollPane, BorderLayout.CENTER);

        JTextField field = new JTextField();
        JButton buttonAdd = new JButton("Add");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(field, BorderLayout.CENTER);
        panel.add(buttonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        JButton buttonShow = new JButton("Show");
        ventana.add(buttonShow, BorderLayout.SOUTH);

        //Add event
        buttonAdd.addActionListener(e -> {
            String texto = field.getText();
            if(!texto.isEmpty()) {
                listModel.addElement(texto);
            }
        });

        //Show selection
        buttonShow.addActionListener(e -> {
            String select =  list.getSelectedValue();
            if(select!=null) {
                JOptionPane.showMessageDialog(ventana, "🔘 You have selected: " + select);
            } else {
                JOptionPane.showMessageDialog(ventana, "❌ You have not selected any element ");

            }
        });

        ventana.setVisible(true);
    }

    public static void usandoTablaInteractiva() {

        JFrame ventana = new JFrame("JTable interactiva");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(5,5));

        String[] columns = new String[]{"id", "task"};

        //Panel superior
        JTextField field = new JTextField();
        JButton buttonAdd = new JButton("Add task");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(field, BorderLayout.CENTER);
        panel.add(buttonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        //Panel central
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable jTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(jTable);
        ventana.add(scrollPane, BorderLayout.CENTER);

        //Panel inferior
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        ventana.add(buttonPanel, BorderLayout.SOUTH);

        //Add event
        buttonAdd.addActionListener(e -> {
            String task = field.getText().trim();
            if(!task.isEmpty()) {
                int id = model.getRowCount() + 1;
                model.addRow(new Object[]{id, task});
                field.setText("");
            }
        });

        //Edit event
        editButton.addActionListener(e -> {
            int row =  jTable.getSelectedRow();
            if(row!=-1) {
                String newTask = JOptionPane.showInputDialog(ventana, "Editar tarea " + model.getValueAt(row, 1));
                if(newTask!=null && !newTask.trim().isEmpty()) {
                    model.setValueAt(newTask, row, 1);
                }
            } else {
                JOptionPane.showMessageDialog(ventana, "Select a task to be edited, please");
            }
        });

        //Delete event
        deleteButton.addActionListener(e -> {
            int row =  jTable.getSelectedRow();
            if(row!=-1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(ventana, "Select a task to be deleted, please");
            }
        });

        ventana.setVisible(true);
    }

    public static void usandoTablaInteractivaConArchivo() {

        JFrame ventana = new JFrame("Gestor de Tareas");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(5,5));
        ventana.getContentPane().setBackground(new Color(230, 230, 250));

        String[] columns = new String[]{"ID", "Task"};

        //Panel superior
        JTextField field = new JTextField();
        JButton buttonAdd = new JButton("Add task");
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(200, 200, 255));
        buttonAdd.setBackground(new Color(100, 149, 237));
        buttonAdd.setForeground(Color.BLUE);
        panel.add(field, BorderLayout.CENTER);
        panel.add(buttonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        //Panel central
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable jTable = new JTable(model);
        jTable.setFont(new Font("Arial", Font.BOLD, 16));
        jTable.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(jTable);
        ventana.add(scrollPane, BorderLayout.CENTER);

        //Panel inferior
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        ventana.add(buttonPanel, BorderLayout.SOUTH);

        File file = new File("tasks.txt");
        if(file.exists()) {
            try(Scanner sc = new Scanner(file)) {
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    model.addRow(new Object[]{model.getRowCount() + 1, line});
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //Add event
        buttonAdd.addActionListener(e -> {
            String task = field.getText().trim();
            if(!task.isEmpty()) {
                int id = model.getRowCount() + 1;
                model.addRow(new Object[]{id, task});
                field.setText("");
                saveTasks(model, file);
            }
        });

        //Edit event
        editButton.addActionListener(e -> {
           int row =  jTable.getSelectedRow();
           if(row!=-1) {
               String newTask = JOptionPane.showInputDialog(ventana, "Editar tarea " + model.getValueAt(row, 1));
               if(newTask!=null && !newTask.trim().isEmpty()) {
                   model.setValueAt(newTask, row, 1);
                   saveTasks(model, file);
               }
           } else {
               JOptionPane.showMessageDialog(ventana, "Select a task to be edited, please");
           }
        });

        //Delete event
        deleteButton.addActionListener(e -> {
            int row =  jTable.getSelectedRow();
            if(row!=-1) {
                model.removeRow(row);
                updateIDs(model);
                saveTasks(model, file);
            } else {
                JOptionPane.showMessageDialog(ventana, "Select a task to be deleted, please");
            }
        });

        ventana.setVisible(true);
    }

    public static void saveTasks(DefaultTableModel model, File file) {
        try (PrintWriter pw = new PrintWriter(file)) {
            for(int i = 0; i < model.getRowCount(); i++) {
                pw.println(model.getValueAt(i, 1));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateIDs(DefaultTableModel model) {
        for(int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i+1, i, 0);
        }
    }
}
