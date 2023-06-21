package br.edu.ifgoias.academico.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.AlunoRepository;
import br.edu.ifgoias.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public void run(String... args) throws Exception {

		Curso c1 = new Curso(null, "História");
		Curso c2 = new Curso(null, "Sistemas de Informação");

		cursoRepository.save(c1);
		cursoRepository.save(c2);

		Aluno a1 = new Aluno("Otaniel", "M", new Date());
		a1.setCurso(c1);
		alunoRepository.save(a1);

		Aluno a2 = new Aluno("Meredite", "F", new Date());
		a2.setCurso(c2);
		alunoRepository.save(a2);
	}

}