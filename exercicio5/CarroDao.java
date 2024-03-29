package exercicio5;

import java.util.ArrayList;

public class CarroDao {
	private ArrayList <Carro> dbCarro;
	private int id = 0;

	public CarroDao() {
		dbCarro = new ArrayList <Carro>();
	}
	
	public void cadastrar(Carro cadastro) {
		dbCarro.add(cadastro);
		id++;
	}
	
	public boolean verificarId (int idVerificar) {
		if (idVerificar > id) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void mostrar(int idMostrar) {
		System.out.println("---------------------");
		System.out.println("Modelo do carro: " + dbCarro.get(idMostrar).getModelo());
		System.out.println("Marca do carro: " + dbCarro.get(idMostrar).getMarca());
		System.out.println("Ano " + dbCarro.get(idMostrar).getAno());
		System.out.println("Velocidade atual " + dbCarro.get(idMostrar).getVelocidadeAtual() + " Km/h");
		System.out.println("ID: " + idMostrar);
		System.out.println("---------------------");
	}
	
	public void frear (int idAlterar, double freio) {
		double velocidadeAtual = dbCarro.get(idAlterar).getVelocidadeAtual();
		
		if(freio > velocidadeAtual) {
			dbCarro.get(idAlterar).setVelocidadeAtual(0);
		}
		else {
			dbCarro.get(idAlterar).setVelocidadeAtual(velocidadeAtual - freio);
		}
	}
	
	public void acelerar (int idAlterar, double aceleracao) {
		double velocidadeAtual = dbCarro.get(idAlterar).getVelocidadeAtual();
		
		dbCarro.get(idAlterar).setVelocidadeAtual(velocidadeAtual + aceleracao);
	}
	
	
	public ArrayList<Carro> getDbCarro() {
		return dbCarro;
	}

	public void setDbCarro(ArrayList<Carro> dbCarro) {
		this.dbCarro = dbCarro;
	}
	
}
