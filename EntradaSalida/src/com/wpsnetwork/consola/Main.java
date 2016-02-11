package com.wpsnetwork.consola;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.SingleSelectionModel;

public class Main {

	public static void main(String[] args) {
		
		//Acceso a bajo nivel con bytes
		//=============================
		
		Path fichero = Paths.get("ficheroBinario.ser");
		try {
			
			OutputStream out = new FileOutputStream(fichero.toFile());
			out.write(new byte[]{'h','o','l','a'});
			out.close(); 									//Cerramos el recurso
			
			
			InputStream in = new FileInputStream(fichero.toFile());
			byte[] arrayLeido = new byte[4];
			in.read(arrayLeido);
			in.close(); 									//Cerramos el recurso
			
			char[] arrayChars = new char[arrayLeido.length];
			
			for(int i=0; i< arrayLeido.length; i++)
				arrayChars[i]= (char) arrayLeido[i];
				
			System.out.println(Arrays.toString(arrayChars));	
			
			//Escritura con buffer
			OutputStream out2 = new BufferedOutputStream(new FileOutputStream("ficheroBinarioLargo.ser"));
			byte[] buffer = new byte[1024];
			Arrays.fill(buffer, (byte) 'a');
			for(int i=0; i<10;i++){
				out2.write(buffer,0,1024);
			}
			out2.flush(); 		//Forzamos al SO a guardar la información a disco
			out2.close();
			
			//Lectura con buffer
			Path ficheroBinarioLargo = Paths.get("ficheroBinarioLargo.ser");
			InputStream in2 = new BufferedInputStream(new FileInputStream(ficheroBinarioLargo.toFile()));
			byte[] bufferLeido = new byte[(int)Files.size(ficheroBinarioLargo)];
			int bytesAcumulados = 0;
			int bytesLeidos;
			
			while((bytesLeidos = in2.read(buffer)) > 0){
				for(int i=0; i<buffer.length;i++)
					bufferLeido[bytesAcumulados + i] = buffer[i];
				bytesAcumulados += bytesLeidos;
			}
			
			in2.close();
			
			char[] bufferChars = new char[bufferLeido.length];
			
			for(int i=0; i< bufferLeido.length; i++)
				bufferChars[i]= (char) bufferLeido[i];
				
			System.out.println(Arrays.toString(bufferChars));
			
			//Con primitivos a nivel de bytes
			DataOutputStream out3 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ficheroBinarioLargo.toFile())));
			out3.writeInt(1);
			out3.writeDouble(2.0);
			out3.writeUTF("Cadena String");
			out3.close();
			
			DataInputStream in3 = new DataInputStream(new BufferedInputStream(new FileInputStream(ficheroBinarioLargo.toFile())));
			System.out.println(in3.readInt());
			System.out.println(in3.readDouble());
			System.out.println(in3.readUTF());
			in3.close();
			
			//Escribir a nivel de texto
			Path ficheroCaracteres = Paths.get("ficheroCaracteres.txt");
			PrintWriter out4 = new PrintWriter(new BufferedWriter(new FileWriter(ficheroCaracteres.toFile())));
			out4.println("Cadena con número " + 2.0 );
			out4.close();
			
			BufferedReader in4 = new BufferedReader(new FileReader(ficheroCaracteres.toFile()));
			String cadena;
			while((cadena = in4.readLine())!=null)
				System.out.println(cadena);
			in4.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}













