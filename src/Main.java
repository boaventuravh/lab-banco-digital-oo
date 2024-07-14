
public class Main {

	public static void main(String[] args) {

		Banco banco = new Banco("Digital Innovation Bank");

		Cliente flavio = new Cliente("Flavio");
		Conta contaFlavio = new ContaCorrente(flavio);
		contaFlavio.depositar(1000.0);
		contaFlavio.setLimiteChequeEspecial(500.0);

		Cliente jose = new Cliente("Jose");
		Conta contaJose = new ContaCorrente(jose);
		contaJose.depositar(1500.0);
		contaJose.setLimiteChequeEspecial(700.0);

		Cliente carlos = new Cliente("Carlos");
		Conta contaCarlos = new ContaPoupanca(carlos);
		contaCarlos.depositar(2000.0);
		contaCarlos.setLimiteChequeEspecial(0.0); // Contas poupança geralmente não têm cheque especial

		Cliente zenildo = new Cliente("Zenildo");
		Conta contaZenildo = new ContaCorrente(zenildo);
		contaZenildo.depositar(1200.0);
		contaZenildo.setLimiteChequeEspecial(600.0);

		Cliente alberto = new Cliente("Alberto");
		Conta contaAlberto = new ContaPoupanca(alberto);
		contaAlberto.depositar(2500.0);
		contaAlberto.setLimiteChequeEspecial(0.0);


		banco.adicionarConta(contaFlavio);
		banco.adicionarConta(contaJose);
		banco.adicionarConta(contaCarlos);
		banco.adicionarConta(contaZenildo);
		banco.adicionarConta(contaAlberto);

		banco.listarContasPorNome();
		banco.listarContasPorNumero();

		contaFlavio.sacar(200.0);
		System.out.println("Saldo de Flavio apos saque: " + contaFlavio.getSaldo());

		// Depósito
		contaJose.depositar(300.0);
		System.out.println("Saldo de Jose apos deposito: " + contaJose.getSaldo());

		// Transferência
		contaCarlos.transferir(500.0, contaZenildo);
		System.out.println("Saldo de Carlos apos transferencia: " + contaCarlos.getSaldo());
		System.out.println("Saldo de Zenildo apos receber transferencia: " + contaZenildo.getSaldo());


	}

}
