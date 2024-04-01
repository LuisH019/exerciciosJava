package exercicio6;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);
		Contato cont = new Contato();
        Telefone tel = new Telefone();
		AgendaDao dao = new AgendaDao();
        String busca;
		int numTelefones, idOperar;
		
		int op;
		
		do {
			System.out.println("----- MENU -----");
			
			System.out.print("Escolha uma das opcoes abaixo:\n"
					+ "0 - Sair\n"
					+ "1 - Cadastrar contato\n"
					+ "2 - Ver agenda de contatos\n"
					+ "3 - Buscar/editar/apagar contato\n"
					+ "Digite: ");
			op = Integer.parseInt(leitor.nextLine());
			
			switch (op) {
				case 0:
					System.out.println("Obrigado por usar o sistema!");
				break;
				
				case 1:
					System.out.println("----- Cadastro de contato -----");

                    System.out.println("Digite a quantidade de telefones que deseja cadastrar: ");
                    numTelefones = Integer.parseInt(leitor.nextLine());

                    for (int i = 0; i < numTelefones; i++){
                        System.out.println("----- Telefone " + (i + 1) + " -----");

                        System.out.println("Digite o DDD: ");
                        tel.setDdd(Integer.parseInt(leitor.nextLine()));
    
                        System.out.println("Digite o numero do telefone: ");
                        tel.setNumero(leitor.nextLine());

                        cont.cadastrarTelefone(tel);

                        tel = new Telefone();
                    }
                    
                    System.out.println("----- Informacoes pessoais -----");

					System.out.print("Digite o nome do contato: ");
					cont.setNome(leitor.nextLine());
					
                    System.out.print("Digite o email do contato: ");
					cont.setEmail(leitor.nextLine());

                    System.out.print("Digite o endereco do contato: ");
					cont.setEndereco(leitor.nextLine());
					
					dao.cadastrar(cont);
					
					dao.mostrar(dao.getAgenda().size() - 1);

                    cont = new Contato();
				break;
				
				case 2:
					System.out.println("----- Agenda de contatos -----");
					
					for (int i = 0; i < dao.getAgenda().size(); i++){
						dao.mostrar(i);
					}
				break;
				case 3:
					if (!dao.getAgenda().isEmpty()) {
						System.out.println("----- Buscar/editar/apagar contato -----");
						
						System.out.print("Digite o nome do contato que deseja operar: ");
                        busca = leitor.nextLine();

						idOperar = dao.buscar(busca);
						
						if ( idOperar != -1) {
							System.out.println("----- Informacoes do contato -----");
							dao.mostrar(idOperar);
							
							System.out.print("Escolha uma das opcoes abaixo:\n"
							        + "0 - Voltar\n"		
                                    + "1 - Editar\n"
									+ "2 - Remover\n"
									+ "Digite: ");
							op = Integer.parseInt(leitor.nextLine());
							
							switch (op) {
                                case 0:
                                    op = 3;
                                break;

								case 1:
									System.out.println("----- Editar contato-----");

                                    System.out.println("Digite a nova quantidade de telefones que deseja cadastrar: ");
                                    numTelefones = Integer.parseInt(leitor.nextLine());

                                    for (int i = 0; i < numTelefones; i++){
                                        System.out.println("----- Telefone " + (i + 1) + " -----");

                                        System.out.println("Digite o DDD: ");
                                        tel.setDdd(Integer.parseInt(leitor.nextLine()));
                    
                                        System.out.println("Digite o numero do telefone: ");
                                        tel.setNumero(leitor.nextLine());

                                        cont.cadastrarTelefone(tel);

                                        tel = new Telefone();
                                    }
                                    
                                    System.out.print("Digite o novo nome do contato: ");
                                    cont.setNome(leitor.nextLine());
                                    
                                    System.out.print("Digite o novo email do contato: ");
                                    cont.setEmail(leitor.nextLine());

                                    System.out.print("Digite o novo endereco do contato: ");
                                    cont.setEndereco(leitor.nextLine());
                                    
                                    dao.editar(cont, idOperar);

                                    cont = new Contato();

                                    dao.mostrar(idOperar);
								break;
								
								case 2:
									dao.apagar(idOperar);
								break;
								
								default:
									System.out.println("ERRO: Opcao invalida!");
								break;
							}
						}
						
						else {
							System.out.println("ERRO: Contato inexistente!");
						}
					}
					else {
						System.out.println("ERRO: Nao ha nenhum contato para operar!");
					}
				break;
				
				default:
					System.out.println("ERRO: Opcao invalida!");
				break;
			}
		}
		while(op != 0);
    }
}