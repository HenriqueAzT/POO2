package model.entities;

import java.time.LocalDate;

public class Aluno {

	private int id;
	private String nome;
	private String sexo;
	private LocalDate dt_nasc;
	private float nota;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(LocalDate localDate) {
		this.dt_nasc = localDate;
	}
	
	public Aluno(int id, String nome, String sexo, LocalDate dt_nasc, float nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dt_nasc = dt_nasc;
		this.nota = nota;
	}
	public Aluno() {
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float f) {
		this.nota = f;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + dt_nasc + ", nota=" + nota
				+ "]";
	}
	
	
	
}
