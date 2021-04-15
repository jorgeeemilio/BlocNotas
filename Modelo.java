package es.studium.BlocNotas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modelo
{
	public int contarPalabras(String cadena)
	{
		int palabras = 0;
		for(int i = 0; i<cadena.length(); i++)
		{
			if((cadena.charAt(i)==' ')||(cadena.charAt(i)=='\n'))
			{
				palabras++;
			}
		}
		palabras++;
		return palabras;
	}
	public int contarLetras(String cadena)
	{
		int letras = 0;
		Pattern patron;
		Matcher matcher;
		patron = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]");
		for(int i = 0; i<cadena.length(); i++)
		{
			matcher = patron.matcher(cadena.charAt(i)+"");
			if(matcher.matches())
			{
				letras++;
			}
		}
		return letras;
	}
	public int contarVocales(String cadena)
	{
		int vocales = 0;
		Pattern patron;
		Matcher matcher;
		patron = Pattern.compile("[aeiouAEIOUáéíóúÁÉÍÓÚ]");
		for(int i = 0; i<cadena.length(); i++)
		{
			matcher = patron.matcher(cadena.charAt(i)+"");
			if(matcher.matches())
			{
				vocales++;
			}
		}
		return vocales;
	}
	public void guardarFichero(String ruta, String cadena)
	{
		//FileWriter también puede lanzar una excepción
		try
		{
			// Destino de los datos
			FileWriter fw = new FileWriter(ruta);
			// Buffer de escritura
			BufferedWriter bw = new BufferedWriter(fw);
			// Objeto para la escritura
			PrintWriter salida = new PrintWriter(bw);
			//Guardamos la primera línea
			salida.println(cadena);
			//Cerrar el objeto salida, el objeto bw y el fw
			salida.close();
			bw.close();
			fw.close();
		}
		catch(IOException i)
		{}
	}
	public String cargarFichero(String ruta)
	{
		String contenido = "";
		try
		{
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s=br.readLine())!=null)
			{
				contenido = contenido + s + '\n';
			}
			br.close();
			fr.close();
		}
		catch(Exception e) {}
		return contenido;
	}
}
