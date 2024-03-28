package exercicio2;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main (String args[]) {
		Scanner leitor = new Scanner (System.in);
		ArrayList <Livro> biblioteca = new ArrayList<Livro>();
		int chave = 1, i = 0, exibir = 0;
		
		do {
			System.out.println("----- Cadastro livro " + i + " -----");
			
			biblioteca.add(new Livro());
			
			System.out.print("Digite o título do livro: ");
			biblioteca.get(i).setTitulo(leitor.nextLine());
			
			System.out.print("Digite o nome do autor do livro: ");
			biblioteca.get(i).setAutor(leitor.nextLine());
			
			System.out.print("Digite o ano de publicacao do livro: ");
			biblioteca.get(i).setAnoPublicacao(Integer.parseInt(leitor.nextLine()));
			
			System.out.println("Livro cadastrado!");
			
			i++;
			
			System.out.print("\nDeseja exibir os livros da biblioteca?\n"
					+ "1 - Sim\n"
					+ "0 - Não\n"
					+ "Digite: ");
			exibir = Integer.parseInt(leitor.nextLine());
			
			if(exibir == 1) {
				for(int j = 0; j < biblioteca.size(); j++) {
					System.out.println("----- Livro " + j + " -----");
					
					System.out.println("Título: " + biblioteca.get(j).getTitulo());
					System.out.println("Autor: " + biblioteca.get(j).getAutor());
					System.out.println("Ano de publicacao: " + biblioteca.get(j).getAnoPublicacao());
				}
			}
			
			System.out.println("---------------------");
			
			System.out.print("Deseja continuar a cadastrar libros?\n"
					+ "1 - Sim\n"
					+ "0 - Não\n"
					+ "Digite: ");
			chave = Integer.parseInt(leitor.nextLine());
		}
		
		
		while(chave == 1);
		
	}
}
