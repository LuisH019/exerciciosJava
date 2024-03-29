package exercicio4;

import java.util.Scanner;

import exercicio3.Conta;

public class Main {
	public static void main(String args[]) {
		Scanner leitor = new Scanner (System.in);
		Jogador j = new Jogador();
		JogadorDAO dao = new JogadorDAO();
		int idOperar;
		
		int op;
		
		do {
			System.out.println("----- MENU -----");
			
			System.out.print("Escolha uma das opcoes abaixo:\n"
					+ "0 - Sair\n"
					+ "1 - Cadastrar jogador\n"
					+ "2 - Listar jogadores\n"
					+ "3 - Editar jogador\n"
					+ "Digite: ");
			op = Integer.parseInt(leitor.nextLine());
			
			switch (op) {
				case 0:
					System.out.println("Obrigado por usar o sistema!");
				break;
				
				case 1:
					System.out.println("----- Cadastro de jogador -----");
					
					System.out.print("Digite o nome do jogador: ");
					j.setNome(leitor.nextLine());
					
					j.setNivel(0);
					
					j.setPontuacao(0);
					
					dao.cadastrar(j);
					
					dao.mostrar(dao.getDbJogador().size() - 1);
					
					System.out.println("Cadastro concluído!");
				break;
				
				case 2:
					System.out.println("----- Lista de jogadores -----");
					
					for (int i = 0; i < dao.getDbJogador().size(); i++){
						dao.mostrar(i);
					}
				break;
				case 3:
					if (!dao.getDbJogador().isEmpty()) {
						System.out.println("----- Editar jogador -----");
						
						System.out.print("Digite o ID que deseja operar: ");
						idOperar = Integer.parseInt(leitor.nextLine());
						
						if (dao.verificarId(idOperar)) {
							System.out.println("----- Informações do jogador -----");
							dao.mostrar(idOperar);
							
							System.out.print("Digite o nível que o jogador terá: ");
							j.setNivel(Integer.parseInt(leitor.nextLine()));
							
							System.out.print("Digite a pontuação que o jogador terá: ");
							j.setPontuacao(Integer.parseInt(leitor.nextLine()));
							
							j.setNome(dao.getDbJogador().get(idOperar).getNome());
							
							dao.editar(j, idOperar);
						}
						
						else {
							System.out.println("ERRO: Jogador inexistente!");
						}
					}
					else {
						System.out.println("ERRO: Não há nenhum jogador para operar!");
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
