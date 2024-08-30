package view;

import controller.LoginController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JTextField loginField;
    private JPasswordField senhaField;
    private JTextField areaField;
    private JButton loginButton;
    private final LoginController loginController;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;
        iniciarUI();
    }

    private void iniciarUI() {
        setTitle("Login - UPA");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define cores
        Color backgroundColor = new Color(117, 186, 165);
        Color buttonColor = new Color(100, 180, 255);
        Color textColor = new Color(40, 40, 40);

        // Define fonte
        Font font = new Font("Arial", Font.PLAIN, 14);

        // Define titulo
        JLabel loginLabel = new JLabel("Login:");

        loginLabel.setBounds(280, 150, 80, 25);
        loginLabel.setFont(font);
        add(loginLabel);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(280, 180, 80, 25);
        senhaLabel.setFont(font);
        add(senhaLabel);

        JLabel areaLabel = new JLabel("Área de Atuação:");
        areaLabel.setBounds(280, 210, 120, 25);
        areaLabel.setFont(font);
        add(areaLabel);

        // Define campos
        loginField = new JTextField();
        loginField.setBounds(360, 150, 160, 25);
        loginField.setFont(font);
        add(loginField);

        senhaField = new JPasswordField();
        senhaField.setBounds(360, 180, 160, 25);
        senhaField.setFont(font);
        add(senhaField);

        areaField = new JTextField();
        areaField.setBounds(400, 210, 120, 25);
        areaField.setFont(font);
        add(areaField);

        // Define botão login
        loginButton = new JButton("Login");
        loginButton.setBounds(350, 250, 100, 30);
        loginButton.setFont(font);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        // Define cor de fundo
        getContentPane().setBackground(backgroundColor);
        getContentPane().setLayout(new BorderLayout());

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());
                String area = areaField.getText();

                boolean autenticado = loginController.autenticar(login, senha, area);

                if (autenticado) {
                    switch (area.toLowerCase()) {
                        case "administrador":
                            new AdminView().start();
                            break;
                        case "recepcionista":
                            new RecepcionistaView().start();
                            break;
                        case "triagem":
                            new TriagemView().start();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Área de Atuação desconhecida.");
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha está errado");
                }
                loginField.setText("");
                senhaField.setText("");
                areaField.setText("");
            }
        });
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginView(loginController).setVisible(true);
            }
        });
    }
}
