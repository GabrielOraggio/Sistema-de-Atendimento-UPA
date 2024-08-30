package controller;

import database.DBConnection;
import model.Triagem;
import model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriagemController {
    public Paciente chamarNovaSenha() {
        String sql = "SELECT * FROM paciente ORDER BY senha_atendimento LIMIT 1";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setIdade(rs.getInt("idade"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setSenhaAtendimento(rs.getInt("senha_atendimento"));
                return paciente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

 public boolean cadastrarTriagem(Triagem triagem) {
        String sqlInsertTriagem = "INSERT INTO triagem (nome, idade, sexo, cpf, paciente_id, pressao, temperatura, sintomas, senha_atendimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlDeletePaciente = "DELETE FROM paciente WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmtInsert = conn.prepareStatement(sqlInsertTriagem);
             PreparedStatement stmtDelete = conn.prepareStatement(sqlDeletePaciente)) {

            conn.setAutoCommit(false);

            stmtInsert.setString(1, triagem.getNome());
            stmtInsert.setInt(2, triagem.getIdade());
            stmtInsert.setString(3, triagem.getSexo());
            stmtInsert.setString(4, triagem.getCpf());
            stmtInsert.setInt(5, triagem.getPacienteId());
            stmtInsert.setString(6, triagem.getPressao());
            stmtInsert.setDouble(7, triagem.getTemperatura());
            stmtInsert.setString(8, triagem.getSintomas());
            stmtInsert.setInt(9, triagem.getSenhaAtendimento());
            stmtInsert.executeUpdate();

            // Excluir paciente da tabela paciente
            stmtDelete.setInt(1, triagem.getPacienteId());
            stmtDelete.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

