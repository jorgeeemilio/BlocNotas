package es.studium.BlocNotas;

public class BlocNotas
{
	public static void main(String[] args)
	{
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		new Controlador(vista, modelo);
	}
}
