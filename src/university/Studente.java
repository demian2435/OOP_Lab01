package university;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private String nome;
	private String cognome;
	private int matricola;
	private List<Corso> corsi;

	public Studente(String nome, String cognome, int matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		corsi = new ArrayList<Corso>();
	}

	public int getSizeCorsi() {
		return corsi.size();
	}

	public void addCorso(Corso c) {
		corsi.add(c);
	}

	@Override
	public String toString() {
		return matricola + " " + nome + " " + cognome;
	}

	public String stampaCorsi() {
		String result = "";

		for (Corso c : corsi) {
			result += c.toString() + "\n";
		}
		return result;
	}

}
