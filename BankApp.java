import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BankApp extends JFrame {

    JTextField a, b;
    JTextArea c;
    JButton d, e, f, g;
    double h = 0.0;
    String i = "";

    public BankApp() {
        setTitle("Banco Ruim v1");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel j = new JLabel("Nome:");
        j.setBounds(30, 20, 100, 25);
        add(j);

        a = new JTextField();
        a.setBounds(100, 20, 150, 25);
        add(a);

        JLabel k = new JLabel("Valor:");
        k.setBounds(30, 60, 100, 25);
        add(k);

        b = new JTextField();
        b.setBounds(100, 60, 150, 25);
        add(b);

        d = new JButton("Criar Conta");
        d.setBounds(30, 100, 120, 25);
        add(d);

        e = new JButton("Depositar");
        e.setBounds(160, 100, 120, 25);
        add(e);

        f = new JButton("Sacar");
        f.setBounds(30, 140, 120, 25);
        add(f);

        g = new JButton("Ver Saldo");
        g.setBounds(160, 140, 120, 25);
        add(g);

        c = new JTextArea();
        c.setBounds(30, 180, 300, 150);
        add(c);

        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                i = a.getText();
                h = 0;
                c.setText("Conta criada para " + i + " com saldo R$ " + h);
            }
        });

        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    double x = Double.parseDouble(b.getText());
                    h = h + x;
                    c.setText("Depósito de R$ " + x + " realizado. Saldo atual: R$ " + h);
                } catch (Exception ex) {
                    c.setText("Erro no depósito");
                }
            }
        });

        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                double y = Double.parseDouble(b.getText());
                if (y > h) {
                    c.setText("Saldo insuficiente!");
                } else {
                    h = h - y;
                    c.setText("Saque de R$ " + y + " realizado. Saldo atual: R$ " + h);
                }
            }
        });

        g.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c.setText("Saldo atual de " + i + ": R$ " + h);
            }
        });
    }

    public static void main(String[] args) {
        new BankApp().setVisible(true);
    }
}
