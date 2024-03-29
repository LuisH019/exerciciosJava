package exercicio5;

import java.util.Scanner;

import exercicio3.Conta;

public class Main {
	public static void main(String args[]) {
		Scanner leitor = new Scanner (System.in);
		Carro car = new Carro();
		CarroDao dao = new CarroDao();
		int idOperar;
		
		int op;
		
		do {
			System.out.println("----- MENU -----");
			
			System.out.print("Escolha uma das opcoes abaixo:\n"
					+ "0 - Sair\n"
					+ "1 - Cadastrar carro\n"
					+ "2 - Listar carros\n"
					+ "3 - Acelerar/frear\n"
					+ "Digite: ");
			op = Integer.parseInt(leitor.nextLine());
			
			switch (op) {
				case 0:
					System.out.println("Obrigado por usar o sistema!");
				break;
				
				case 1:
					System.out.println("----- Cadastro de carro -----");
					
					System.out.print("Digite o modelo do carro: ");
					car.setModelo(leitor.nextLine());
					
					System.out.print("Digite a marca do carro: ");
					car.setMarca(leitor.nextLine());
					
					System.out.print("Digite o ano do carro: ");
					car.setAno(Integer.parseInt(leitor.nextLine()));
					
					System.out.print("Digite a velocidade do carro (em Km/h): ");
					car.setVelocidadeAtual(Double.parseDouble(leitor.nextLine()));
					
					dao.cadastrar(car);
					
					dao.mostrar(dao.getDbCarro().size() - 1);
					
					System.out.println("Cadastro concluído!");
				break;
				
				case 2:
					System.out.println("----- Lista de CarrOs -----");
					
					for (int i = 0; i < dao.getDbCarro().size(); i++){
						dao.mostrar(i);
					}
				break;
				case 3:
					if (!dao.getDbCarro().isEmpty()) {
						System.out.println("----- Acelerar/frear -----");
						
						System.out.print("Digite o ID que deseja operar: ");
						idOperar = Integer.parseInt(leitor.nextLine());
						
						if (dao.verificarId(idOperar)) {
							System.out.println("----- Informações do carro -----");
							dao.mostrar(idOperar);
							
							System.out.print("Escolha uma das opcoes abaixo:\n"
									+ "1 - Frear\n"
									+ "2 - Acelerar\n"
									+ "Digite: ");
							op = Integer.parseInt(leitor.nextLine());
							
							switch (op) {
								case 1:
									System.out.println("----- Frear -----");
									
									System.out.print("Digite quanto deseja frear (em Km/h): ");
									dao.frear(idOperar, Double.parseDouble(leitor.nextLine()));
								break;
								
								case 2:
									System.out.println("----- Acelerar -----");
									
									System.out.print("Digite quanto deseja acelerar (em Km/h): ");
									dao.acelerar(idOperar, Double.parseDouble(leitor.nextLine()));
								break;
								
								default:
									System.out.println("ERRO: Opção inválida!");
								break;
							}
							
							dao.mostrar(idOperar);
						}
						
						else {
							System.out.println("ERRO: Carro inexistente!");
						}
					}
					else {
						System.out.println("ERRO: Não há nenhum carro para operar!");
					}
					
					
					
				break;
				
				default:
					System.out.println("ERRO: Opção inválida!");
				break;
				
			}
		}
		while(op != 0);
	}
}
