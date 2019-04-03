package CalucladoraTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket conexao = null;
		String conta = "";
		Scanner ler = new Scanner(System.in);
		
		// testa a conexao
		try {
			conexao = new Socket("localhost", 8080);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		// Define fluxo de entrada e de saída
		ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
		saida.flush();
		ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

		// ler a conta digitada pelo usuario
		System.out.print("Insira a conta a ser calculada pelo servidor: ");
		conta = ler.nextLine();
		//envia para o servidor
		saida.writeObject(conta);
		saida.flush();

		// ler o resultado da conta enviado pelo servidor
		double resultado = (double)entrada.readObject();
		System.out.printf("\nResultado: " + "%.2f", resultado);
		saida.close();
		entrada.close();
		conexao.close();		
	}
}
