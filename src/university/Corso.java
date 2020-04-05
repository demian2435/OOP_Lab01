package university;

import java.util.ArrayList;
import java.util.List;

public class Corso {
	private String corso;
	private String nomeDocente;
	private int codiceCorso;
	private List<Studente> studenti;

	public Corso(String corso, String nomeDocente, int codiceCorso) {
		this.corso = corso;
		this.nomeDocente = nomeDocente;
		this.codiceCorso = codiceCorso;
		studenti = new ArrayList<Studente>();
	}

	public int getSizeStudenti() {
		return studenti.size();
	}

	public void addStudente(Studente s) {
		studenti.add(s);
	}

	@Override
	public String toString() {
		return codiceCorso + ", " + corso + ", " + nomeDocente;
	}

	public String stampaStudenti() {
		String result = "";

		for (Studente s : studenti) {
			result += s.toString() + "\n";
		}
		return result;
	}

}