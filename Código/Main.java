import view.LoginView;
import database.DBConnection;
import controller.LoginController;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
            // Conectar ao banco de dados        
            LoginController loginController = new LoginController();
            
            LoginView loginView = new LoginView(loginController);
            loginView.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
    }
}
