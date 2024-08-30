package view;

import database.DBConnection;
import controller.LoginController;
import controller.AdminController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

    private JTextField txtLogin;
    private JTextField txtSenha;
    private JTextField txtArea;

    public AdminView() {
        setTitle("Administrador - UPA");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Define cores 
        Color backgroundColor = new Color(117, 186, 165);
        Color buttonColor = new Color(100, 180, 255);
        Color textColor = new Color(40, 40, 40);

        // Define fonte 
        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(250, 150, 80, 25);
        lblLogin.setFont(font);
        add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(350, 150, 200, 25);
        txtLogin.setFont(font);
        add(txtLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(250, 180, 80, 25);
        lblSenha.setFont(font);
        add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setBounds(350, 180, 200, 25);
        txtSenha.setFont(font);
        add(txtSenha);

        JLabel lblArea = new JLabel("Área de Atuação:");
        lblArea.setBounds(250, 210, 120, 25);
        lblArea.setFont(font);
        add(lblArea);

        txtArea = new JTextField();
        txtArea.setBounds(390, 210, 160, 25);
        txtArea.setFont(font);
        add(txtArea);

        JButton btnAlterarSenha = new JButton("Alterar Senha");
        btnAlterarSenha.setBounds(155, 250, 150, 30);
        btnAlterarSenha.setFont(font);
        btnAlterarSenha.setBackground(buttonColor);
        btnAlterarSenha.setForeground(Color.WHITE);
        btnAlterarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarSenha();
            }
        });
        add(btnAlterarSenha);

        JButton btnCriarUsuario = new JButton("Criar Usuário");
        btnCriarUsuario.setBounds(325, 250, 150, 30);
        btnCriarUsuario.setFont(font);
        btnCriarUsuario.setBackground(buttonColor);
        btnCriarUsuario.setForeground(Color.WHITE);
        btnCriarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarUsuario();
            }
        });
        add(btnCriarUsuario);

        JButton btnExcluirUsuario = new JButton("Excluir Usuário");
        btnExcluirUsuario.setBounds(495, 250, 150, 30);
        btnExcluirUsuario.setFont(font);
        btnExcluirUsuario.setBackground(buttonColor);
        btnExcluirUsuario.setForeground(Color.WHITE);
        btnExcluirUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirUsuario();
            }
        });
        add(btnExcluirUsuario);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(325, 300, 150, 30);
        btnSair.setFont(font);
        btnSair.setBackground(buttonColor);
        btnSair.setForeground(Color.WHITE);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaLogin();
            }
        });
        add(btnSair);

        // Define cor de fundo
        getContentPane().setBackground(backgroundColor);
        getContentPane().setLayout(new BorderLayout());

    }

    private void alterarSenha() {
        AdminController adminController = new AdminController();
        boolean sucesso = adminController.alterarSenha(txtLogin.getText(), txtSenha.getText());
        JOptionPane.showMessageDialog(this, sucesso ? "Senha alterada com sucesso" : "Erro ao alterar senha");
    }

    private void criarUsuario() {
        AdminController adminController = new AdminController();
        boolean sucesso = adminController.criarUsuario(txtLogin.getText(), txtSenha.getText(), txtArea.getText());
        JOptionPane.showMessageDialog(this, sucesso ? "Usuário criado com sucesso" : "Erro ao criar usuário");
    }

    private void excluirUsuario() {
        AdminController adminController = new AdminController();
        boolean sucesso = adminController.excluirUsuario(txtLogin.getText());
        JOptionPane.showMessageDialog(this, sucesso ? "Usuário excluído com sucesso" : "Erro ao excluir usuário");
    }

    private void voltarParaLogin() {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof LoginView) {
                window.setVisible(true);
                dispose();
                return;
            }

            LoginController loginController = new LoginController();
            new LoginView(loginController).setVisible(true);
            dispose();
        }
    }

    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }
}
