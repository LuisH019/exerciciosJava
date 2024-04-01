package exercicio6;
import java.util.ArrayList;

public class Contato {
    private String nome, email, endereco;
    private ArrayList<Telefone> telefones = new ArrayList<Telefone>();

    public Contato (){
        telefones = new ArrayList<Telefone>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }
    // public void setTelefones(ArrayList<Telefone> telefones) {
    //     this.telefones = telefones;
    // }

    public void mostrarTelefones (){
        for(int i = 0; i < telefones.size(); i++){
            System.out.println("---> (" + telefones.get(i).getDdd() + ") " + telefones.get(i).getNumero());
        }
    }

    public void cadastrarTelefone(Telefone cadastro){
        telefones.add(cadastro);
    }
}
