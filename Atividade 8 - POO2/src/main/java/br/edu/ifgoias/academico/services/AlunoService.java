package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno not found"));
	}

	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public void delete(Integer id) {
		alunoRepository.deleteById(id);
	}

	public Aluno update(Integer id, Aluno aluno) {
		return alunoRepository.findById(id).map(alunoDB -> {
			alunoDB.setNome(aluno.getNome());
			alunoDB.setSexo(aluno.getSexo());
			alunoDB.setDt_nasc(aluno.getDt_nasc());
			alunoDB.setCurso(aluno.getCurso());
			return alunoRepository.save(alunoDB);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno not found"));
	}

}