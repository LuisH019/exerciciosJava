package exercicio6;
import java.util.ArrayList;

public class AgendaDao {
    private ArrayList <Contato> agenda;
	private int id = 0;

	public AgendaDao() {
		agenda = new ArrayList <Contato>();
	}
	
	public void cadastrar(Contato cadastro) {
		agenda.add(cadastro);
		
		id++;
		System.out.println("Contato cadastrado com sucesso!");
	}

	public int buscar(String nome){
		int idBusca = -1;

		for (int i = 0; i < agenda.size(); i++){
			if (nome.equalsIgnoreCase(agenda.get(i).getNome())){
				idBusca = i;
				break;
			}
		}

		return idBusca;
	}

	public void editar(Contato editado, int idEditar) {
		agenda.set(idEditar, editado);
		System.out.println("Contato editado com sucesso!");
	}

	public void apagar(int idApagar) {
		agenda.remove(idApagar);
		System.out.println("Contato apagado com sucesso!");
	}

	// public boolean verificarBusca(int idBusca){
	// 	if (idBusca != -1){
	// 		return true;
	// 	}
	// 	else {
	// 		System.out.println("ERRO: Não há registros com esse nome!");
	// 		return false;
	// 	}
	// }

	public void mostrar(int idMostrar) {
		System.out.println("---------------------");
		System.out.println("Nome: " + agenda.get(idMostrar).getNome());
		System.out.println("Telefone(s): ");
		agenda.get(idMostrar).mostrarTelefones();
		System.out.println("E-mail: " + agenda.get(idMostrar).getEmail());
		System.out.println("Endereco: " + agenda.get(idMostrar).getEndereco());
		System.out.println("ID: " + idMostrar);
		System.out.println("---------------------");
	}
	
	public ArrayList<Contato> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<Contato> agenda) {
		this.agenda = agenda;
	}
}
