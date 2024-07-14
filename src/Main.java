
public class Main {

	public static void main(String[] args) {

		Banco banco = new Banco("Digital Innovation Bank");

		Cliente flavio = new Cliente("Flavio");
		Conta contaFlavio = new ContaCorrente(flavio);
		Cliente jose = new Cliente("Jose");
		Conta contaJose = new ContaCorrente(jose);
		Cliente carlos = new Cliente("Carlos");
		Conta contaCarlos = new ContaPoupanca(carlos);
		Cliente zenildo = new Cliente("Zenildo");
		Conta contaZenildo = new ContaCorrente(zenildo);
		Cliente alberto = new Cliente("Alberto");
		Conta contaAlberto = new ContaPoupanca(alberto);


		banco.adicionarConta(contaFlavio);
		banco.adicionarConta(contaJose);
		banco.adicionarConta(contaCarlos);
		banco.adicionarConta(contaZenildo);
		banco.adicionarConta(contaAlberto);

		banco.listarContasPorNome();
		banco.listarContasPorNumero();

	}

}
