package exercicio3;

public class Conta {
	private String nomeTitular;
	private int numeroConta;
	private double saldo;
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(double saque) {
		if (saque < this.saldo){
			this.saldo = this.saldo - saque;
			System.out.println("Saque concluido!");
			return true;
		}
		else {
			System.out.println("ERRO: Saldo insuficiente!");
			return false;
		}
	}
	
	public void depositar(double deposito) {
		this.saldo = this.saldo + deposito;
		System.out.println("Depósito concluido!");
	}
	
	public void exibirInformacoes() {
		System.out.println("---------------------");
		System.out.println("Numero da conta: " + this.numeroConta);
		System.out.println("Nome do titular: " + this.nomeTitular);
		System.out.println("Saldo: R$ " + this.saldo);
		System.out.println("---------------------");
	}
	
	public boolean verificarConta(int numeroComparar) {
		if (numeroComparar == getNumeroConta()) {
			return true;
		}
		else {
			return false;
		}
	}
}
