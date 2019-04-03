package CalucladoraTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws IOException {
		String conta = "";
		double resultado = 0;
		ServerSocket servidor = null;

		try {
			// Instancia o ServerSocket ouvindo a porta 8080
			servidor = new ServerSocket(8080);
			System.out.println("Servidor ouvindo a porta 8080");
		} catch (Exception e) {
			System.out.println("Não foi possível conectar ao servidor!");
		}
		// o método accept() bloqueia a execução até que
		// o servidor receba um pedido de conexão
		Socket conexao = servidor.accept();
		System.out.println("conexao conectado: " + conexao.getInetAddress().getHostAddress());

		// Definindo entrada e saída
		ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
		ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

		try {
			conta = (String)entrada.readObject();
			String[] contaArray = conta.split("(?=[-+/*()])|(?<=[^-+//][-+/*])|(?<=[()])");

			for (int i = 0; i < contaArray.length; i++) {
				System.out.print(contaArray[i] + " ");
			}
			System.out.println();
			
			if (contaArray[1].equals("-")) {
				resultado = Double.parseDouble(contaArray[0])	- Integer.parseInt(contaArray[2]);
			} else if (contaArray[1].equals("+")) {
				resultado = Double.parseDouble(contaArray[0])	+ Integer.parseInt(contaArray[2]);
			} else if (contaArray[1].equals("*")) {
				resultado = Double.parseDouble(contaArray[0])	* Integer.parseInt(contaArray[2]);
			} else if (contaArray[1].equals("/")) {
				resultado = Double.parseDouble(contaArray[0])	/ Integer.parseInt(contaArray[2]);
			}
			System.out.println(resultado);
			
			saida.writeObject(resultado);
			saida.close();
			conexao.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
