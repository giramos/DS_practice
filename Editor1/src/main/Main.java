/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;

import editor.core.Editor;

public class Main {

    public static void main(String[] args) throws IOException {

        Editor editor = new Editor();

        simulateMouse(editor);
    }

    public static void simulateMouse(Editor editor) throws IOException {

        System.out.println("\nActivación de Herramientas: rectangulo | circulo | triangulo | seleccion");
        System.out.println("Acciones de Ratón: pinchar x,y | mover x,y | soltar x,y");
        System.out.println("Otros Comandos: dibujar | exit \n");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            String[] line = in.readLine().split("[ ,]");

            if (line[0].equals("exit"))
                return;

            //$ Pulsación de los botones de las herramientas -----------------------------

            if (line[0].startsWith("rec"))
                editor.clickToolButton("rectangulo");

            else if (line[0].startsWith("cir"))
                editor.clickToolButton("circulo");

            else if (line[0].startsWith("tri"))
                editor.clickToolButton("triangulo");

            else if (line[0].startsWith("sel"))
                editor.clickToolButton("seleccion");

            //$ Acciones del Ratón -----------------------------

            else if (line[0].startsWith("pin"))
                editor.pinchar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("mov"))
                editor.mover(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("sol"))
                editor.soltar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            //$ Otros comandos -----------------------------

            else if (line[0].startsWith("dib"))
                editor.dibujar();

            else
                System.out.println("Comando no válido");

        } while (true);
    }

}
