package university;

import java.util.ArrayList;
import java.util.List;

public class Corso {
	private String corso;
	private String nomeDocente;
	private int codiceCorso;
	private List<Studente> studenti;
	private static final int MAXSTUDENTI = 100;

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
		return codiceCorso + "," + corso + "," + nomeDocente;
	}

	public String stampaStudenti() {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < studenti.size(); i++) {
			result.append(studenti.get(i));
			if (i < studenti.size() - 1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	public boolean canRegister() {
		return studenti.size() < MAXSTUDENTI;
	}

}
