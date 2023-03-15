public class Estudante {
    private int matricula;
    private int numOrientadores = 0;
    
    public Estudante(int matricula) throws IllegalArgumentException {
        if (matricula < 0 || matricula > 3) {
            throw new IllegalArgumentException("Matrícula inválida! A matrícula deve estar entre 0 e 3.");
        }
        this.matricula = matricula;
    }
    
    

	public Estudante(int matricula, int numOrientadores) {
		this.matricula = matricula;
		this.numOrientadores = numOrientadores;
	}



	public int getMatricula() {
        return matricula;
    }
    
    public void adicionarOrientador() throws LimiteOrientadorException {
        if (numOrientadores >= 2) {
            throw new LimiteOrientadorException("Limite de orientadores atingido! O estudante só pode ter no máximo 2 orientadores.");
        }
        numOrientadores++;
    }

	public void setMatricula(int matricula) {
	}

	@Override
	public String toString() {
		return "Estudante [matricula=" + matricula + ", numOrientadores=" + numOrientadores + "]";
	}
	
}