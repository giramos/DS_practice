package main;

import formulario.CampoNumero;
import formulario.CampoPredefinido;
import formulario.CampoTexto;
import formulario.Formulario;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new CampoTexto("Nombre"));
		formulario.addCampo(new CampoTexto("Apellido"));
		formulario.addCampo(new CampoNumero("Tel�fono"));
		formulario.addCampo(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cádiz"));

		formulario.PideDatos();
		formulario.escribeFormulario();
	}
}
