package br.edu.unicarioca.arquitetura.redes.udp;
import java.net.*;
import java.nio.ByteBuffer;
 
class Servidor {
	public static void main(String args[]) throws Exception {
 
		int porta = 12345;
		//Instancia um serviço escutando a porta 12345.
		try (DatagramSocket servidor = new DatagramSocket(porta)) {
			byte[] recebe = new byte[1024];
			byte[] envia = new byte[1024];
			
			DatagramPacket recebeDados = new DatagramPacket(recebe,recebe.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);
			
			//Realiza o processo de escuta da porta.
			servidor.receive(recebeDados);
			
			//Armazena o valor recebido, convertendo-o para Inteiro.
			int valor = ByteBuffer.wrap(recebeDados.getData()).getInt();
			
			System.out.println("Valor recebido: "+valor);
			
			//Armazena o ip do cliente.
			InetAddress IPAddress = recebeDados.getAddress();
			int port = recebeDados.getPort();
			
			//Prepara os datagramas para resposta.
			envia = ByteBuffer.allocate(4).putInt(fatorial(valor)).array();
			
			//Envia os datagramas.
			DatagramPacket enviaDados = new DatagramPacket(envia,envia.length, IPAddress, port);
			servidor.send(enviaDados);
			System.out.println(" servidor finalizado");
				
			
		}
	}
	
	private static int fatorial(int valor) {
		int tmp = 1;
		for(int i = 1; i< valor + 1; i++) tmp *= i;
		return tmp;
	}
}