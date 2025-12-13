package example;

import javax.swing.*;
import java.awt.*;

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

    public static void main(String[] args) {
        //Ejemplo1:
        //usandoJFrame();

        //Ejemplo2:
        //usandoJLabel();

        //Ejemplo3:
        //usandoJButton();

        //Ejemplo4
        //useJTextField();

        //calculadora();

        //usandoBorderLayout();
        usandoBoxLayout();
    }
}
