package exercicio1;

import java.util.Scanner;

public class Main {
	public static void main (String args[]) {
		char operacao;
		double x, y, resultado;
		int chave = 1;
		
		Scanner leitor = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		do {
			System.out.print("Digite o 1º número: ");
			x = Double.parseDouble (leitor.nextLine());
			
			System.out.print("Insira a operacao:\n'+' para soma\n"
					+ "'-' para subtração\n"
					+ "'*' para multiplicação\n"
					+ "'/' para divisão\n"
					+ "Digite: ");
			operacao = leitor.next().charAt(0);
			
			System.out.print("Digite o 2º número: ");
			y = Double.parseDouble (leitor.nextLine());
			
			switch (operacao) {
				case '+' : 
					resultado = calc.soma(x, y);
				break;
				
				case '-' : 
					resultado = calc.subtracao(x, y);
				break;
				
				case '*' : 
					resultado = calc.multiplicacao(x, y);
				break;
				
				case '/' : 
					resultado = calc.divisao(x, y);
				break;
				
				default : 
					resultado = 0.0;
				break;
			}
			System.out.println("\n\nResultado: " + x + " " + operacao + " " + y + " = " + resultado);
			
			System.out.println("\n\nDeseja continuar?\n1 - Sim\n0 - Não\nDigite: ");
			chave = Integer.parseInt(leitor.nextLine());
		}
		while (chave == 1);
	}
}
