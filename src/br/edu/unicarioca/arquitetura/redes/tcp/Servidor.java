package br.edu.unicarioca.arquitetura.redes.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		int valor;
		try 
		{
			System.out.println("servidor iniciado");
			ServerSocket servidor = null;
			//Instancia um novo serviço que utiliza a porta 12345  
			servidor = new ServerSocket(12345);
			//Aguarda o recebimento de uma conexão
			Socket conexao = servidor.accept();
			//Salva os datagramas recebidos
			InputStream recebe = conexao.getInputStream();
			//Armazena a conexão de saída
			OutputStream resposta = conexao.getOutputStream();
			//Cria os pacotes para envio da informação
			DataOutputStream envia = new DataOutputStream(resposta);
			valor = recebe.read();
			//envia as informações processadas para o cliente
			envia.write(fatorial(valor));
			conexao.close();
			servidor.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int fatorial(int valor) {
		int tmp = 1;
		for(int i = 1; i< valor + 1; i++) tmp *= i;
		return tmp;
	}
}
	