package exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main (String args[]) {
		Scanner leitor = new Scanner (System.in);
		ArrayList <Conta> banco = new ArrayList<Conta>();
		int i = 0, op = 0, numeroConta;
		boolean contaValida = false;
		
		do {
			System.out.println("----- MENU -----");
			
			System.out.print("Escolha uma das opcoes abaixo:\n"
					+ "0 - Sair\n"
					+ "1 - Cadastrar conta\n"
					+ "2 - Listar contas\n"
					+ "3 - Sacar ou depositar\n"
					+ "Digite: ");
			op = Integer.parseInt(leitor.nextLine());
			
			switch (op) {
				case 0:
					System.out.println("Obrigado por usar o sistema!");
				break;
				
				case 1:
					System.out.println("----- Cadastro de conta -----");
					
					banco.add(new Conta());
					
					System.out.print("Digite o nome do titular da conta: ");
					banco.get(i).setNomeTitular(leitor.nextLine());
					
					banco.get(i).setNumeroConta(i);
					
					banco.get(i).setSaldo(0);
					
					System.out.println("Cadastro concluído!");
					
					banco.get(i).exibirInformacoes();
					
					i++;
				break;
				
				case 2:
					System.out.println("----- Lista de contas -----");
					
					for (int j = 0; j < banco.size(); j++){
						banco.get(j).exibirInformacoes();
					}
				break;
				case 3:
					if (i > 0) {
						System.out.println("----- Sacar ou depositar -----");
						System.out.print("Digite o numero da conta que deseja operar: ");
						numeroConta = Integer.parseInt(leitor.nextLine());
						
						for (int j = 0; j < banco.size(); j++) {
							if(banco.get(j).verificarConta(numeroConta)) {
								contaValida = true;
								break;
							}
						}
						
						if (contaValida) {
							System.out.println("----- Informações da conta -----");
							banco.get(numeroConta).exibirInformacoes();
							
							System.out.print("Escolha uma das opcoes abaixo:\n"
									+ "1 - Sacar\n"
									+ "2 - Depositar\n"
									+ "Digite: ");
							op = Integer.parseInt(leitor.nextLine());
							
							switch (op) {
								case 1:
									System.out.println("----- Sacar -----");
									do {
										System.out.print("Digite quanto deseja sacar: R$ ");
									}
									while (!banco.get(numeroConta).sacar(Double.parseDouble(leitor.nextLine())));
								break;
								
								case 2:
									System.out.println("----- Depositar -----");
									System.out.print("Digite o quanto deseja depositar: R$ ");
									banco.get(numeroConta).depositar(Double.parseDouble(leitor.nextLine()));
								break;
								
								default:
									System.out.println("ERRO: Opção inválida!");
								break;
							}
							System.out.println("----- Informações da conta -----");
							banco.get(numeroConta).exibirInformacoes();
						}
						
						else {
							System.out.println("ERRO: Conta inexistente!");
						}
					}
					else {
						System.out.println("ERRO: Não há nenhuma conta para operar!");
					}
					
					
					
				break;
				
				default:
					System.out.println("ERRO: Opção inválida!");
				break;
				
			}
			System.out.println("\n\n\n\n");
		}
		while(op != 0);
	}
	
}
