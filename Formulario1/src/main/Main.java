package main;

import formulario.Campo;
import formulario.CampoPredefinido;
import formulario.CampoTexto;
import formulario.Formulario;
import strategy.ValidarNumer;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre",new CampoTexto()));
		formulario.addCampo(new Campo("Apellido",new CampoTexto()));
		formulario.addCampo(new Campo("Tel�fono",new ValidarNumer()));
		formulario.addCampo(new Campo("Ciudad",new CampoPredefinido("Santander", "Oviedo", "Cádiz")));

		formulario.PideDatos();
		formulario.escribeFormulario();
	}
}
