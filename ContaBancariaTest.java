public class ContaBancariaTest {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Kaique");
        ContaBancaria conta = new ContaBancaria(cliente);

        conta.depositar(1000);
        conta.sacar(200);

        assert conta.getSaldo() == 800 : "Erro no cálculo do saldo!";
        System.out.println("✅ Teste de ContaBancaria passou com sucesso!");
    }
}
