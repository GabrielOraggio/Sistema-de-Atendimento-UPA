package controller;

import database.DBConnection;
import view.LoginView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public boolean autenticar(String login, String senha, String areaAtuacao) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? AND area_atuacao = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setString(3, areaAtuacao);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}


