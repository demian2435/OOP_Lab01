package university;

public class Rettore {
	private String nome;
	private String cognome;

	public Rettore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return nome + " " + cognome;
	}

}
