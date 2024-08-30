package controller;

import database.DBConnection;
import model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecepcionistaController {
    public boolean cadastrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, idade, sexo, cpf, senha_atendimento) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, paciente.getSexo());
            stmt.setString(4, paciente.getCpf());
            stmt.setInt(5, paciente.getSenhaAtendimento());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

