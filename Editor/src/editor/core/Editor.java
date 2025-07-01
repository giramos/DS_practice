package editor.core;

public class Editor {

    private Dibujo dibujo;

    public Editor() {
        dibujo = new Dibujo();

    }

    public void dibujar() {
        // Se dibuja el menú
        // Se dibuja la barra de herramientas lateral
        // Se dibuja la línea de estado
        dibujo.dibujar();
    }

    //$ Métodos del Interfaz de Usuario -----------------------------

    // Se pinchar el botón de una herramienta para activarla
    public void clickToolButton(String toolName) {
        // ?
    }

    public void pinchar(int x, int y) {
        // ?
    }

    public void mover(int x, int y) {
        // ?
    }

    public void soltar(int x, int y) {
        // ?
    }

    //$ Métodos del dibujo -----------------------------

    public Dibujo getDibujo() {
        return dibujo;
    }

}
