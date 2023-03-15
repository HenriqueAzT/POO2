public class Orientador {
    private String nome;
    private int numEstudantes = 0;
    
    public Orientador(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void adicionarEstudante() throws LimiteEstudantesException {
        if (numEstudantes >= 2) {
            throw new LimiteEstudantesException("Limite de orientandos atingido! O orientador só pode ter no máximo 2 orientandos.");
        }
        numEstudantes++;
    }

	@Override
	public String toString() {
		return "Orientador [nome=" + nome + ", numEstudantes=" + numEstudantes + "]";
	}
}