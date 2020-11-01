package br.edu.unicarioca.arquitetura.redes.udp;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
 
class Cliente {
	public static void main(String args[]) throws Exception {
 
		Scanner teclado = new Scanner(System.in);
 
		DatagramSocket cliente = new DatagramSocket();
 
		String servidor = "localhost";
		int porta = 12345;
 
		InetAddress ip = InetAddress.getByName(servidor);
 
		byte[] dados = new byte[1024];
		byte[] recebe = new byte[1024];
 
		System.out.println("Digite o numero a ser enviado ao servidor: ");
		int valorEnviado = teclado.nextInt();
		dados = ByteBuffer.allocate(4).putInt(valorEnviado).array();
		
		DatagramPacket pacoteEnviado = new DatagramPacket(dados,dados.length, ip, porta);
 
		cliente.send(pacoteEnviado);
 
		DatagramPacket pacoteRecebido = new DatagramPacket(recebe,recebe.length);
 
		cliente.receive(pacoteRecebido);
		
		int valorRecebido = ByteBuffer.wrap(pacoteRecebido.getData()).getInt();
 
		System.out.println("O fatorial de "+valorEnviado+" é : " + valorRecebido);
		cliente.close();
		System.out.println("Socket cliente fechado!");
	}
}