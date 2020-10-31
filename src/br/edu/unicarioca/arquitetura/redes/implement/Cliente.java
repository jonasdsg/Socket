package br.edu.unicarioca.arquitetura.redes.implement;

import java.io.IOException;
import java.net.Socket;

public class Cliente implements Tarefa{
	private Socket cliente = null;
	public boolean conectar() {
		
		if(cliente==null) {
			try {
				cliente = new Socket("localhost",163);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
