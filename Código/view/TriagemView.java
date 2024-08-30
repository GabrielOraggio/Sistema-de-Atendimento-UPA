package view;

import controller.LoginController;
import controller.TriagemController;
import model.Paciente;
import model.Triagem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriagemView extends JFrame {

    int idpaciente;
    int idadepaciente;
    int senhaatendimento;
    private JTextField txtSenha;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSexo;
    private JTextField txtCpf;
    private JTextField txtPressao;
    private JTextField txtTemperatura;
    private JTextField txtSintomas;

    public TriagemView() {
        setTitle("Triagem - UPA");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Define cores 
        Color backgroundColor = new Color(117, 186, 165);
        Color buttonColor = new Color(100, 180, 255);
        Color textColor = new Color(40, 40, 40);

        // Define fonte 
        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(445, 75, 80, 25);
        lblSenha.setFont(font);
        add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setBounds(500, 75, 70, 25);
        txtSenha.setFont(font);
        add(txtSenha);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(230, 110, 80, 25);
        lblNome.setFont(font);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(330, 110, 240, 25);
        txtNome.setFont(font);
        add(txtNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(230, 140, 80, 25);
        lblIdade.setFont(font);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(330, 140, 240, 25);
        txtIdade.setFont(font);
        add(txtIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(230, 170, 80, 25);
        lblSexo.setFont(font);
        add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(330, 170, 240, 25);
        txtSexo.setFont(font);
        add(txtSexo);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(230, 200, 80, 25);
        lblCpf.setFont(font);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(330, 200, 240, 25);
        txtCpf.setFont(font);
        add(txtCpf);

        JLabel lblPressao = new JLabel("Pressão:");
        lblPressao.setBounds(230, 230, 80, 25);
        lblPressao.setFont(font);
        add(lblPressao);

        txtPressao = new JTextField();
        txtPressao.setBounds(330, 230, 240, 25);
        txtPressao.setFont(font);
        add(txtPressao);

        JLabel lblTemperatura = new JLabel("Temperatura:");
        lblTemperatura.setBounds(230, 260, 100, 25);
        lblTemperatura.setFont(font);
        add(lblTemperatura);

        txtTemperatura = new JTextField();
        txtTemperatura.setBounds(330, 260, 240, 25);
        txtTemperatura.setFont(font);
        add(txtTemperatura);

        JLabel lblSintomas = new JLabel("Sintomas:");
        lblSintomas.setBounds(230, 290, 80, 25);
        lblSintomas.setFont(font);
        add(lblSintomas);

        txtSintomas = new JTextField();
        txtSintomas.setBounds(330, 290, 240, 25);
        txtSintomas.setFont(font);
        add(txtSintomas);

        JButton btnChamarNovaSenha = new JButton("Chamar Nova Senha");
        btnChamarNovaSenha.setBounds(230, 70, 200, 30);
        btnChamarNovaSenha.setFont(font);
        btnChamarNovaSenha.setBackground(buttonColor);
        btnChamarNovaSenha.setForeground(Color.WHITE);
        btnChamarNovaSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamarNovaSenha();
            }
        });
        add(btnChamarNovaSenha);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(230, 330, 165, 30);
        btnCadastrar.setFont(font);
        btnCadastrar.setBackground(buttonColor);
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarTriagem();
            }
        });
        add(btnCadastrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(405, 330, 165, 30);
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

    private void chamarNovaSenha() {
        TriagemController triagemController = new TriagemController();
        Paciente paciente = triagemController.chamarNovaSenha();
        if (paciente != null) {
            idpaciente = paciente.getId();
            idadepaciente = paciente.getIdade();
            senhaatendimento = paciente.getSenhaAtendimento();
            txtSenha.setText(paciente.getSenhaAtendimento() + "");
            txtNome.setText(paciente.getNome());
            txtIdade.setText(String.valueOf(paciente.getIdade()));
            txtSexo.setText(paciente.getSexo());
            txtCpf.setText(paciente.getCpf());
            
            
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum paciente na fila");
        }
    }

    private void cadastrarTriagem() {
        TriagemController triagemController = new TriagemController();
        Triagem triagem = new Triagem();
        triagem.setNome(txtNome.getText());
        triagem.setIdade(idadepaciente);
        triagem.setSexo(txtSexo.getText());
        triagem.setCpf(txtCpf.getText());
        triagem.setPacienteId(idpaciente);
        triagem.setPressao(txtPressao.getText());
        triagem.setTemperatura(Double.parseDouble(txtTemperatura.getText()));
        triagem.setSintomas(txtSintomas.getText());
        triagem.setSenhaAtendimento(senhaatendimento);
        boolean sucesso = triagemController.cadastrarTriagem(triagem);
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Triagem cadastrada com sucesso");
            
            txtSenha.setText("");
            txtNome.setText("");
            txtIdade.setText("");
            txtSexo.setText("");
            txtCpf.setText("");
            txtPressao.setText("");
            txtTemperatura.setText("");
            txtSintomas.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar triagem");
        }
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
                new TriagemView().setVisible(true);
            }
        });
    }
}
