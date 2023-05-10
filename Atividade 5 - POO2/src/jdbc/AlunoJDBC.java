package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {

	Connection con;
	String sql;
	PreparedStatement pst;
	
	public void salvar(Aluno a) throws SQLException {
		
		try {
			con = db.getConexao();
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?,?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			String dateStr = a.getDt_nasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate dataLocal = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			pst.setDate(3, Date.valueOf(dataLocal));
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno realizado com sucesso!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			pst.close();
			db.closeConexao(); 
		}
	}

	
	public List<Aluno> listar() {
	    List<Aluno> alunos = new ArrayList<>();
	    try (Connection con = db.getConexao();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM aluno")) {
	        while (rs.next()) {
	            Aluno aluno = new Aluno();
	            aluno.setId(rs.getInt("id"));
	            aluno.setNome(rs.getString("nome"));
	            aluno.setSexo(rs.getString("sexo"));
	            aluno.setDt_nasc(rs.getDate("dt_nasc").toLocalDate());
	            alunos.add(aluno);
	        }
	    } catch (SQLException | IOException ex) {
	        System.out.println("Erro ao listar alunos: " + ex.getMessage());
	    }
	    return alunos;
	}
	
	public void apagar(int id) throws SQLException, IOException {
	    try {
	        con = db.getConexao();
	        sql = "DELETE FROM aluno WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.executeUpdate();
	        System.out.println("\nAluno com o ID " + id + " foi excluído com sucesso!");

	    } catch (SQLException e) {
	        System.out.println("Erro ao excluir aluno: " + e.getMessage());
	    } finally {
	        pst.close();
	        db.closeConexao();
	    }
	}

	
	public void alterar(Aluno a) throws SQLException {
	    try {
	        con = db.getConexao();
	        sql = "SELECT * FROM aluno WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, a.getId());
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE id = ?";
	            pst = con.prepareStatement(sql);
	            pst.setString(1, a.getNome());
	            pst.setString(2, a.getSexo());
	            String dateStr = a.getDt_nasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            LocalDate dataLocal = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            pst.setDate(3, Date.valueOf(dataLocal));
	            pst.setInt(4, a.getId());
	            pst.executeUpdate();
	            System.out.println("\nAluno alterado com sucesso!");
	        } else {
	            System.out.println("\nAluno não encontrado.");
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        try {
	            pst.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        db.closeConexao();
	    }
	}

}
