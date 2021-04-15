package es.studium.BlocNotas;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class Vista
{
	Frame ventana = new Frame("Gestión de archivos");

	MenuBar menuBar = new MenuBar();
	Menu mnuArchivo = new Menu("Archivo");
	Menu mnuGestion = new Menu("Gestión");

	// MenuItem del menú archivo
	MenuItem archivoNuevo = new MenuItem("Nuevo");
	MenuItem archivoAbrir = new MenuItem("Abrir");
	MenuItem archivoGuardar = new MenuItem("Guardar");
	MenuItem archivoSalir = new MenuItem("Salir");
	// MenuItem del menú gestion
	MenuItem gestionContarPalabras = new MenuItem("Contar palabras");
	MenuItem gestionContarLetras = new MenuItem("Contar letras");
	MenuItem gestionContarVocales = new MenuItem("Contar vocales");

	TextArea txaEditor = new TextArea(20, 60);

	Dialog dlgMensaje = new Dialog(ventana, "", true);
	Label lblMensaje = new Label("Hay X palabras en el texto");
	
	FileDialog fdGuardar = new FileDialog(ventana, 
			"Indicar nombre y ubicación del archivo",
			FileDialog.SAVE);
	FileDialog fdAbrir = new FileDialog(ventana, 
			"Indicar nombre y ubicación del archivo",
			FileDialog.LOAD);

	public Vista()
	{
		// SIN Layout para que ocupe toda la pantalla y 
		// que se adapte siempre que esta cambie de tamaño
		// Establecemos la barra de menú
		ventana.setMenuBar(menuBar);

		// Añadimos los elementos al menú archivo
		mnuArchivo.add(archivoNuevo);
		mnuArchivo.add(archivoAbrir);
		mnuArchivo.add(archivoGuardar);
		mnuArchivo.addSeparator();
		mnuArchivo.add(archivoSalir);

		// Añadimos los elementos al menú gestion
		mnuGestion.add(gestionContarPalabras);
		mnuGestion.add(gestionContarLetras);
		mnuGestion.add(gestionContarVocales);

		// Por último agregamos los elementos archivo 
		// y gestion a la barra
		menuBar.add(mnuArchivo);
		menuBar.add(mnuGestion);
		
		ventana.add(txaEditor);
		
		ventana.setSize(400,500);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		dlgMensaje.setLayout(new FlowLayout());
		dlgMensaje.add(lblMensaje);
		dlgMensaje.setSize(180,80);
		dlgMensaje.setLocationRelativeTo(null);
	}
}
