package br.edu.unicarioca.arquitetura.redes.implement;

import java.net.ServerSocket;

public class Servidor {
	ServerSocket servidor = null;
	
	public boolean iniciarServidor(int porta) {
		if(servidor == null) {
			try {
				servidor = new ServerSocket(porta);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
