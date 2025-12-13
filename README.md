# 🖼️ Java Swing Basics

Este proyecto está diseñado como un *sandbox* y un recurso de aprendizaje para dominar la construcción de interfaces gráficas de usuario (GUI) utilizando el *toolkit* **Swing** en Java.

Aquí encontrarás implementaciones prácticas de los principales gestores de diseño (*Layout Managers*) y ejemplos de los componentes más comunes de Swing.

---

## 🚀 Contenido del Repositorio

Actualmente, todo el código se encuentra en la clase principal `SwingBasics.java`, donde cada método ilustra un concepto o un gestor de diseño específico.

### 📦 Componentes Básicos (Widgets)

Ejemplos de cómo inicializar y configurar los componentes esenciales que forman la interfaz de usuario:

* **`JFrame`**: La ventana principal.
* **`JLabel`**: Etiquetas de texto estático.
* **`JButton`**: Botones interactivos.
* **`JPanel`**: Contenedores para agrupar componentes.

### 📐 Gestores de Diseño (Layout Managers)

Los *Layout Managers* son fundamentales para organizar y posicionar los componentes dentro de un contenedor. Cada método demuestra cómo se comporta un *layout* específico:

| Gestor de Diseño | Descripción | Clase/Método |
| :--- | :--- | :--- |
| **BorderLayout** | Divide el contenedor en cinco regiones: Norte, Sur, Este, Oeste y Centro. Es el layout por defecto de `JFrame`. | `usandoBorderLayout()` |
| **FlowLayout** | Organiza los componentes de izquierda a derecha, como una línea de texto. Es el layout por defecto de `JPanel`. | `usandoFlowLayout()` |
| **GridLayout** | Organiza los componentes en una cuadrícula (filas y columnas) donde todas las celdas tienen el mismo tamaño. | `usandoGridLayout()` |
| **BoxLayout** | Permite apilar componentes en una sola fila (X\_AXIS) o columna (Y\_AXIS). Ideal para barras de herramientas o menús verticales. | `usandoBoxLayout()` |
---

## 🛠️ Requisitos y Ejecución

Para ejecutar este proyecto, necesitas tener instalado:

* **Java Development Kit (JDK)**: Versión 21 o superior.

### 🏃 Cómo Ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/SergioLM7/JavaSwingBasics.git](https://github.com/SergioLM7/JavaSwingBasics.git)
    cd JavaSwingBasics
    ```

2.  **Compilar la clase Java:**
    ```bash
    javac SwingBasics.java
    ```

3.  **Ejecutar la aplicación:**
    ```bash
    java SwingBasics
    ```

> **Nota:** La clase principal `SwingBasics` tiene diferentes llamadas comentadas. Asegúrate de descomentar el método que deseas probar (por ejemplo, `usandoBoxLayout()`) antes de compilar y ejecutar.

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
