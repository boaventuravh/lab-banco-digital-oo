import java.util.Objects;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected double limiteChequeEspecial;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0;
		this.limiteChequeEspecial = 0;
	}

	@Override
	public void sacar(double valorSaque) {
		if(valorSaque <= 0) {
			throw new IllegalArgumentException("O saque nao pode ser zero ou negativo");
		}
		if (podeSacarComSaldo(valorSaque)){
			sacarSaldo(valorSaque);
		} else if (podeSacarComChequeEspecial(valorSaque)){
			sacarChequeEspecial(valorSaque);
		}else {
			System.out.println("Nao foi possivel realizar esse saque." +
					" O valor supera o saldo e o cheque especial");
		}

	}

	protected boolean podeSacarComSaldo(double valorSaque){
		return valorSaque <= saldo;
	}

	protected void sacarSaldo(double valorSaque){
		saldo -= valorSaque;
	}

	protected boolean podeSacarComChequeEspecial(double valorSaque){
		return valorSaque <= saldo+limiteChequeEspecial;
	}

	protected void sacarChequeEspecial(double valorSaque){
		limiteChequeEspecial -= (valorSaque - saldo);
		saldo -= saldo;
	}

	@Override
	public void depositar(double valorDeposito) {
		if (valorDeposito <= 0){
			throw new IllegalArgumentException("O deposito nao pode ser zero ou negativo");
		}
		saldo += valorDeposito;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		try {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}catch (Exception e){
			throw new IllegalArgumentException("Nao foi possivel realizar a operacao" +
					" com o valor inserido");
		}

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNomeCliente(){
		return cliente.getNome();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Conta conta)) return false;
		return getNumero() == conta.getNumero();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumero());
	}

	@Override
	public String toString() {
		return "Conta{" +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo +
				", cliente=" + cliente.getNome() +
				'}';
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
