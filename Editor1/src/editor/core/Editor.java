package editor.core;

import java.util.*;

public class Editor {

	private Dibujo dibujo;
	Herramienta herramienta;
	Map<String, Herramienta> herramientas;

	public Editor() {
		dibujo = new Dibujo();
		herramientas = new HashMap<>();
		crearDicc(herramientas);

	}

	public void dibujar() {
		// Se dibuja el menú
		// Se dibuja la barra de herramientas lateral
		// Se dibuja la línea de estado
		dibujo.dibujar();
	}

	void crearDicc(Map<String, Herramienta> herramientas2) {
		herramientas2.put("circulo", new HerramientaCirculo(this));
		herramientas2.put("rectangulo", new HerramientaRectangulo(this));
		herramientas2.put("triangulo", new HerramientaTriangulo(this));
		herramientas2.put("seleccion", new HerramientaSeleccion(this));

	}

	// $ Métodos del Interfaz de Usuario -----------------------------

	// Se pinchar el botón de una herramienta para activarla
	public void clickToolButton(String toolName) {
		// ?
		setHerramienta(herramientas.get(toolName));
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public Map<String, Herramienta> getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(Map<String, Herramienta> herramientas) {
		this.herramientas = herramientas;
	}

	public void pinchar(int x, int y) {
		// ?
		herramienta.pichar(x, y);
	}

	public void mover(int x, int y) {
		// ?
		herramienta.mover(x, y);
	}

	public void soltar(int x, int y) {
		// ?
		herramienta.soltar(x, y);
	}

	// $ Métodos del dibujo -----------------------------

	public Dibujo getDibujo() {
		return dibujo;
	}

}
