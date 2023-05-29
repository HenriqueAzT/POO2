package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.db.DB;
import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {
	

    private Connection conexao;

    public DisciplinaDAOImp(Connection conexao) {
        this.conexao = conexao;
    }
    public DisciplinaDAOImp() {
    	
    }

    @Override
    public void insert(Disciplina obj) {
        PreparedStatement pst = null;

        try {
            String sql = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNomeDisciplina());
            pst.setInt(2, obj.getCargaHoraria());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fechaPreparedStatement(pst);
        }
    }

    @Override
    public void update(Disciplina obj) {
        PreparedStatement pst = null;

        try {
            String sql = "UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE iddisciplina = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNomeDisciplina());
            pst.setInt(2, obj.getCargaHoraria());
            pst.setInt(3, obj.getIdDisciplina());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fechaPreparedStatement(pst);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement pst = null;

        try {
            String sql = "DELETE FROM disciplina WHERE iddisciplina = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fechaPreparedStatement(pst);
        }
    }

    @Override
    public Disciplina findById(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Disciplina disciplina = null;

        try {
            String sql = "SELECT * FROM disciplina WHERE iddisciplina = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                disciplina = instantiateDisciplina(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fechaResultSet(rs);
            DB.fechaPreparedStatement(pst);
        }

        return disciplina;
    }

    @Override
    public List<Disciplina> findAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Disciplina> disciplinas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM disciplina";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = instantiateDisciplina(rs);
                disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fechaResultSet(rs);
            DB.fechaPreparedStatement(pst);
        }

        return disciplinas;
    }

    private Disciplina instantiateDisciplina(ResultSet rs) throws SQLException {
        int idDisciplina = rs.getInt("iddisciplina");
        String nomeDisciplina = rs.getString("nomedisciplina");
        int cargaHoraria = rs.getInt("cargahoraria");
        return new Disciplina(idDisciplina, nomeDisciplina, cargaHoraria);
    }
}
