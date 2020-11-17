package br.edu.unicarioca.arquitetura.redes.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		//Utiliza a interface Scanner para obter dados do teclado.
		Scanner teclado = new Scanner(System.in);
		int valor = 0;
		try
		{
			System.out.println("Cliente iniciado!");
			//Instancia uma conexão para o endereço 127.0.0.1 na porta 12345
			Socket cliente = new Socket("127.0.0.1",12345);
			//Informa ao servidor a stream de saída do cliente.
			OutputStream servidor = cliente.getOutputStream();
			//prepara o stream de saída do cliente.
			DataOutputStream envia = new DataOutputStream(servidor);
			System.out.println("Digite o numero a ser enviado ao servidor: ");
			//envia o número digitado 
			envia.write(teclado.nextInt());
			//Recebe as informações processadas pelo servidor. 
			InputStream recebe = cliente.getInputStream();
			//Armazena o valor recebido.
			valor = recebe.read();
			System.out.println("valor que foi respondido: "+valor);
			cliente.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	


}
	
