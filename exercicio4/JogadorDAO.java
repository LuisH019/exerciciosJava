package exercicio4;

import java.util.ArrayList;

public class JogadorDAO {
	private ArrayList <Jogador> dbJogador;
	private int id = 0;

	public JogadorDAO() {
		dbJogador = new ArrayList <Jogador>();
	}
	
	public void cadastrar(Jogador cadastro) {
		dbJogador.add(cadastro);
		id++;
	}
	
	public boolean verificarId (int idVerificar) {
		if (idVerificar > id || idVerificar < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void mostrar(int idMostrar) {
		System.out.println("---------------------");
		System.out.println("Nome do jogador: " + dbJogador.get(idMostrar).getNome());
		System.out.println("Nivel do jogador: " + dbJogador.get(idMostrar).getNivel());
		System.out.println("Pontuação " + dbJogador.get(idMostrar).getPontuacao());
		System.out.println("ID: " + idMostrar);
		System.out.println("---------------------");
	}
	
	public void editar(Jogador editado, int idEditado) {
		dbJogador.set(idEditado, editado);
	}
	
	public ArrayList<Jogador> getDbJogador() {
		return dbJogador;
	}

	public void setDbJogador(ArrayList<Jogador> dbJogador) {
		this.dbJogador = dbJogador;
	}
	
}
