import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta){
		contas.add(conta);
	}

	public void removerConta(int numero){
		Conta contaRemover = contas.stream().filter(c -> c.getNumero() == numero).findFirst().orElse(null);
		contas.remove(contaRemover);
	}

	public void listarContasPorNumero(){
		List<Conta> contasPorNumero = contas.stream().sorted(Comparator.comparing(Conta::getNumero)).toList();
		System.out.println("<<< CONTAS ORDENADAS POR NUMERO >>>");
		contasPorNumero.forEach(System.out::println);
	}

	public void listarContasPorNome(){
		List<Conta> contasPorNome = contas.stream().sorted(Comparator.comparing(Conta::getNomeCliente)).toList();
		System.out.println("<<< CONTAS ORDENADAS POR NOME >>>");
		contasPorNome.forEach(System.out::println);
	}


}
