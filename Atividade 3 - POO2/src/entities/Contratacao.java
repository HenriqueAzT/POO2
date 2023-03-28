package entities;

import java.util.Date;
import java.util.Objects;

import entities.enums.Cargo;
import entities.enums.Status;

public class Contratacao {
	private Date dataI;
	private Cargo cargo;
	private Status status;
	private Funcionario funcionario;
	private Projeto projeto;
	public Contratacao(Date dataI, Cargo cargo, Funcionario funcionario,Projeto projeto) {
		this.dataI = dataI;
		this.cargo = cargo;
		this.funcionario = funcionario;
		this.projeto = projeto;
		this.status = Status.PENDENTE;
		projeto.adicionarContratação(this);
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Projeto getProjeto() {
		return projeto;
	}


	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}


	public Date getDataI() {
		return dataI;
	}

	public void setDataI(Date dataI) {
		this.dataI = dataI;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void contratar() {
		this.status = Status.CONTRATADO;
	}
	public void demitir() {
		this.status = Status.DEMITIDO;
		projeto.removerContratacao(this);
	}

	public Status getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cargo, dataI, funcionario, projeto, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratacao other = (Contratacao) obj;
		return cargo == other.cargo && Objects.equals(dataI, other.dataI)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(projeto, other.projeto)
				&& status == other.status;
	}
	
	



}