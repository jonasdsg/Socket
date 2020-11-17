package br.edu.unicarioca.arquitetura.redes.udp;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
 
class Cliente {
	public static void main(String args[]) throws Exception {
		//Utiliza a interface Scanner para obter dados do teclado.
		Scanner teclado = new Scanner(System.in);
		 
		//Instancia um ponto de fluxo de dados 
		DatagramSocket cliente = new DatagramSocket();
 
		String servidor = "localhost";
		int porta = 12345;
		
		//Armazena o endereço ip do servidor.
		InetAddress ip = InetAddress.getByName(servidor);
 
		byte[] dados = new byte[1024];
		byte[] recebe = new byte[1024];
 
		System.out.println("Digite o numero a ser enviado ao servidor: ");
		int valorEnviado = teclado.nextInt();
		//Armazena um array de bytes com os dados a serem enviados.
		dados = ByteBuffer.allocate(4).putInt(valorEnviado).array();
		
		//Prepara os dados para envio.
		DatagramPacket pacoteEnviado = new DatagramPacket(dados,dados.length, ip, porta);
 
		//Envia os pacotes
		cliente.send(pacoteEnviado);
		
		//Obtem o ponto de resposta do servidor.
		DatagramPacket pacoteRecebido = new DatagramPacket(recebe,recebe.length);

		//Realiza a conexão
		cliente.receive(pacoteRecebido);
		
		//Armazena a resposta.
		int valorRecebido = ByteBuffer.wrap(pacoteRecebido.getData()).getInt();
 
		System.out.println("O fatorial de "+valorEnviado+" é : " + valorRecebido);
		cliente.close();
		System.out.println("Socket cliente fechado!");
	}
}