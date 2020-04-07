package university;

import java.util.ArrayList;
import java.util.List;

public class Studente {

	private List<Esame> esami;
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
		esami = new ArrayList<Esame>();
	}

	public double getMediaBonus() {
		if (getSizeCorsi() == 0 || getSizeEsami() == 0) {
			return -1;
		} else {
			return mediaEsami() + ((getSizeEsami() / getSizeCorsi()) * 10);
		}
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getMatricola() {
		return matricola;
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

	public boolean isEnrolled(Corso corso) {
		return corsi.contains(corso);
	}

	public void addEsame(Corso c, Studente s, int voto) {
		esami.add(new Esame(c, s, voto));
	}

	public int getSizeEsami() {
		return esami.size();
	}

	public double mediaEsami() {
		double media = 0;

		for (Esame e : esami) {
			media += e.getVoto();
		}

		return media / esami.size();

	}

}
