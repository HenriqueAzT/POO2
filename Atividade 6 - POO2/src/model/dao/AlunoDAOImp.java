package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;

public class AlunoDAOImp implements AlunoDAO {

    private Connection conexao;

    public AlunoDAOImp(Connection conexao) {
        this.conexao = conexao;
    }
    

    @Override
    public void insert(Aluno obj) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO aluno (nome, sexo, dt_nasc, nota) VALUES (?, ?, ?, ?)";
            pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSexo());
            pst.setDate(3, java.sql.Date.valueOf(obj.getDt_nasc()));
            pst.setFloat(4, obj.getNota());
            int linhas = pst.executeUpdate();

            if (linhas > 0) {
                rs = pst.getGeneratedKeys();
                rs.next();
                obj.setId(rs.getInt(1));
                System.out.println(obj.toString() + " foi criado com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar o aluno!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Aluno obj) {
        PreparedStatement pst = null;

        try {
            String sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ?, nota = ? WHERE idaluno = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getSexo());
            pst.setDate(3, java.sql.Date.valueOf(obj.getDt_nasc()));
            pst.setFloat(4, obj.getNota());
            pst.setInt(5, obj.getId());
            int linhas = pst.executeUpdate();

            if (linhas > 0) {
                System.out.println(obj.toString() + " foi atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar o aluno!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteById(Integer id) {
        PreparedStatement pst = null;

        try {
            String sql = "DELETE FROM aluno WHERE idaluno = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            int linhas = pst.executeUpdate();

            if (linhas > 0) {
                System.out.println("Aluno com id " + id + " foi excluído com sucesso !");
            } else {
                System.out.println("Não foi possível excluir o aluno com id " + id + " !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluno findById(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Aluno aluno = null;

        try {
            String sql = "SELECT * FROM aluno WHERE idaluno = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                aluno = instantiateAluno(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }

    @Override
    public List<Aluno> findAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM aluno";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Aluno aluno = instantiateAluno(rs);
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    private Aluno instantiateAluno(ResultSet rs) throws SQLException {
        int id = rs.getInt("idaluno");
        String nome = rs.getString("nome");
        String sexo = rs.getString("sexo");
        LocalDate dt_nasc = rs.getDate("dt_nasc").toLocalDate();
        float nota = rs.getFloat("nota"); // Adicionando o campo nota

        Aluno aluno = new Aluno(id, nome, sexo, dt_nasc, nota); // Atualizando a criação do objeto Aluno

        return aluno;
    }

}
