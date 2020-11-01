package br.edu.unicarioca.arquitetura.redes.udp;
import java.net.*;
import java.nio.ByteBuffer;
 
class Servidor {
	public static void main(String args[]) throws Exception {
 
		int porta = 12345;
		
		try (DatagramSocket servidor = new DatagramSocket(porta)) {
			byte[] recebe = new byte[1024];
			byte[] envia = new byte[1024];
 

 
				DatagramPacket recebeDados = new DatagramPacket(recebe,recebe.length);
				System.out.println("Esperando por datagrama UDP na porta " + porta);
				
				servidor.receive(recebeDados);

				int valor = ByteBuffer.wrap(recebeDados.getData()).getInt();
				
				System.out.println("Valor recebido: "+valor);
				
				InetAddress IPAddress = recebeDados.getAddress();
				int port = recebeDados.getPort();
				
				envia = ByteBuffer.allocate(4).putInt(fatorial(valor)).array();
				
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