package university;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private String nome;
	private String cognome;
	private int matricola;
	private List<Corso> corsi;
	private static final int MAXCORSI = 25;

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
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < corsi.size(); i++) {
			result.append(corsi.get(i));
			if (i < corsi.size() - 1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	public boolean canRegister() {
		return corsi.size() < MAXCORSI;
	}

}
