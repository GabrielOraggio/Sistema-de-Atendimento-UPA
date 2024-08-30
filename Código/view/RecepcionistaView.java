
package view;

import controller.RecepcionistaController;
import controller.LoginController;
import model.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RecepcionistaView extends JFrame {

    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSexo;
    private JTextField txtCpf;
    private int senhaAtual = 1;

    public RecepcionistaView() {
        setTitle("Recepcionista - UPA");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Define cores 
        Color backgroundColor = new Color(117, 186, 165);
        Color buttonColor = new Color(100, 180, 255);
        Color textColor = new Color(40, 40, 40);

        // Define fonte
        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(280, 130, 80, 25);
        lblNome.setFont(font);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(350, 130, 160, 25);
        txtNome.setFont(font);
        add(txtNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(280, 160, 80, 25);
        lblIdade.setFont(font);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(350, 160, 160, 25);
        txtIdade.setFont(font);
        add(txtIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(280, 190, 80, 25);
        lblSexo.setFont(font);
        add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(350, 190, 160, 25);
        txtSexo.setFont(font);
        add(txtSexo);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(280, 220, 80, 25);
        lblCpf.setFont(font);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(350, 220, 160, 25);
        txtCpf.setFont(font);
        add(txtCpf);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(255, 260, 130, 30);
        btnCadastrar.setFont(font);
        btnCadastrar.setBackground(buttonColor);
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPaciente();
            }
        });
        add(btnCadastrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(405, 260, 130, 30);
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

   private void cadastrarPaciente() {
        RecepcionistaController recepcionistaController = new RecepcionistaController();

        Paciente paciente = new Paciente();
        paciente.setNome(txtNome.getText());
        paciente.setIdade(Integer.parseInt(txtIdade.getText()));
        paciente.setSexo(txtSexo.getText());
        paciente.setCpf(txtCpf.getText());
        paciente.setSenhaAtendimento(senhaAtual); // Define a senha atual
        senhaAtual++;

        boolean sucesso = recepcionistaController.cadastrarPaciente(paciente);
        JOptionPane.showMessageDialog(this, sucesso ? "Paciente cadastrado com sucesso" : "Erro ao cadastrar paciente");
        
        txtNome.setText("");
        txtIdade.setText("");
        txtSexo.setText("");
        txtCpf.setText("");
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
                new RecepcionistaView().setVisible(true);
            }
        });
    }
}
