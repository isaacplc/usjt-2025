import javax.swing.*;
import java.awt.event.*;

public class BancoAppGUI extends JFrame {
    private JTextField nomeField, valorField;
    private JTextArea saidaArea;
    private ContaBancaria conta;

    public BancoAppGUI() {
        setTitle("Banco Limpo v2");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(30, 20, 100, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 20, 150, 25);
        add(nomeField);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(30, 60, 100, 25);
        add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(100, 60, 150, 25);
        add(valorField);

        JButton criarContaBtn = new JButton("Criar Conta");
        criarContaBtn.setBounds(30, 100, 120, 25);
        add(criarContaBtn);

        JButton depositarBtn = new JButton("Depositar");
        depositarBtn.setBounds(160, 100, 120, 25);
        add(depositarBtn);

        JButton sacarBtn = new JButton("Sacar");
        sacarBtn.setBounds(30, 140, 120, 25);
        add(sacarBtn);

        JButton saldoBtn = new JButton("Ver Saldo");
        saldoBtn.setBounds(160, 140, 120, 25);
        add(saldoBtn);

        saidaArea = new JTextArea();
        saidaArea.setBounds(30, 180, 300, 150);
        saidaArea.setEditable(false);
        add(saidaArea);

        // Ações
        criarContaBtn.addActionListener(e -> criarConta());
        depositarBtn.addActionListener(e -> depositar());
        sacarBtn.addActionListener(e -> sacar());
        saldoBtn.addActionListener(e -> mostrarSaldo());
    }

    private void criarConta() {
        String nome = nomeField.getText();
        if (nome.isEmpty()) {
            saidaArea.setText("Informe um nome válido!");
            return;
        }
        conta = new ContaBancaria(new Cliente(nome));
        saidaArea.setText("Conta criada para " + nome + ".");
    }

    private void depositar() {
        if (conta == null) {
            saidaArea.setText("Crie uma conta primeiro!");
            return;
        }
        try {
            double valor = Double.parseDouble(valorField.getText());
            conta.depositar(valor);
            saidaArea.setText("Depósito realizado. Saldo atual: R$ " + conta.getSaldo());
        } catch (Exception ex) {
            saidaArea.setText(ex.getMessage());
        }
    }

    private void sacar() {
        if (conta == null) {
            saidaArea.setText("Crie uma conta primeiro!");
            return;
        }
        try {
            double valor = Double.parseDouble(valorField.getText());
            conta.sacar(valor);
            saidaArea.setText("Saque realizado. Saldo atual: R$ " + conta.getSaldo());
        } catch (Exception ex) {
            saidaArea.setText(ex.getMessage());
        }
    }

    private void mostrarSaldo() {
        if (conta == null) {
            saidaArea.setText("Crie uma conta primeiro!");
            return;
        }
        saidaArea.setText("Saldo atual de " + conta.getNomeCliente() + ": R$ " + conta.getSaldo());
    }

    public static void main(String[] args) {
        new BancoAppGUI().setVisible(true);
    }
}
