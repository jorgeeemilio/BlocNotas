package es.studium.BlocNotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements ActionListener, WindowListener
{
	Vista vista;
	Modelo modelo;
	
	public Controlador(Vista v, Modelo m)
	{
		this.vista = v;
		this.modelo = m;
		
		this.vista.ventana.addWindowListener(this);
		this.vista.archivoNuevo.addActionListener(this);
		this.vista.archivoAbrir.addActionListener(this);
		this.vista.archivoGuardar.addActionListener(this);
		this.vista.archivoSalir.addActionListener(this);
		
		this.vista.gestionContarPalabras.addActionListener(this);
		this.vista.gestionContarLetras.addActionListener(this);
		this.vista.gestionContarVocales.addActionListener(this);
		
		this.vista.dlgMensaje.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{}

	@Override
	public void windowClosed(WindowEvent arg0)
	{}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if(this.vista.dlgMensaje.isActive())
		{
			this.vista.dlgMensaje.setVisible(false);
		}
		else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{}

	@Override
	public void windowIconified(WindowEvent arg0)
	{}

	@Override
	public void windowOpened(WindowEvent arg0)
	{}

	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(this.vista.archivoSalir))
		{
			System.exit(0);
		}
		else if(evento.getSource().equals(this.vista.archivoNuevo))
		{
			this.vista.txaEditor.selectAll();
			this.vista.txaEditor.setText("");
		}
		else if(evento.getSource().equals(this.vista.archivoGuardar))
		{
			this.vista.fdGuardar.setVisible(true);
			this.modelo.guardarFichero(this.vista.fdGuardar.getDirectory()+""+this.vista.fdGuardar.getFile(), this.vista.txaEditor.getText());
		}
		else if(evento.getSource().equals(this.vista.archivoAbrir))
		{

		}
		else if(evento.getSource().equals(this.vista.gestionContarPalabras))
		{
			int palabras;
			palabras = this.modelo.contarPalabras(this.vista.txaEditor.getText());
			this.vista.lblMensaje.setText("Hay " + palabras + " palabras en el texto");
			this.vista.dlgMensaje.setVisible(true);
		}
		else if(evento.getSource().equals(this.vista.gestionContarLetras))
		{
			int letras;
			letras = this.modelo.contarLetras(this.vista.txaEditor.getText());
			this.vista.lblMensaje.setText("Hay " + letras + " letras en el texto");
			this.vista.dlgMensaje.setVisible(true);
		}
		else if(evento.getSource().equals(this.vista.gestionContarVocales))
		{
			int vocales;
			vocales = this.modelo.contarVocales(this.vista.txaEditor.getText());
			this.vista.lblMensaje.setText("Hay " + vocales + " vocales en el texto");
			this.vista.dlgMensaje.setVisible(true);
		}
	}
}
