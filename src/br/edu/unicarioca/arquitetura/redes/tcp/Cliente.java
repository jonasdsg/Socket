package br.edu.unicarioca.arquitetura.redes.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Socket cliente = null;
		int valor = 0;
		try
		{
			System.out.println("Cliente iniciado!");
			cliente = new Socket("127.0.0.1",12345);
			OutputStream servidor = cliente.getOutputStream();
			DataOutputStream envia = new DataOutputStream(servidor);
			System.out.println("Digite o numero a ser enviado ao servidor: ");
			envia.write(teclado.nextInt());
			InputStream recebe = cliente.getInputStream();
			valor = recebe.read();
			System.out.println("valor que foi respondido: "+valor);
			cliente.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	


}
	
