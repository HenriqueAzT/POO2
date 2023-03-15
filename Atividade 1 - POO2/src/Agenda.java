import java.util.Arrays;

public class Agenda {
    private Contato[] contatos;

    public Agenda(int tamanho) {
        contatos = new Contato[tamanho];
    }

    public void adicionarContato(Contato novoContato) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
            	System.out.println("Contato adicionado");
                contatos[i] = novoContato;
                break;
            }
        }
    }

    public Contato buscarContato(String nome) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null && contatos[i].getNome().equals(nome)) {
            	System.out.println("Contato encontrado: " + contatos[i].getNome() + ", " + contatos[i].getEmail() + ", " + "na Posição: " + i);
                return contatos[i];
            }
        }
        System.out.println("Contato não encontrado");
        return null;
    }

    public void excluirContato(String nome) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null && contatos[i].getNome().equals(nome)) {
                contatos[i] = null;
                System.out.println("Contato excluido");
                return;
            }
        }
    }

	@Override
	public String toString() {
		return "Agenda [contatos=" + Arrays.toString(contatos) + "]";
	}
    
}