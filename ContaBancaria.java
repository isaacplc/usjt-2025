public class ContaBancaria {
    private Cliente cliente;
    private double saldo;

    public ContaBancaria(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }
}
