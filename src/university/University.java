package university;

import java.util.ArrayList;
import java.util.List;

public class University {

	private String ateneo;
	private Rettore rettore;
	private static int matricola = 10000;
	private static final int MAXSTUDENTI = 1000;
	private List<Studente> studenti;
	private static int codiceCorso = 10;
	private static final int MAXCORSI = 50;
	private List<Corso> corsi;

	public University(String ateneo) {
		this.ateneo = ateneo;
		studenti = new ArrayList<Studente>();
		corsi = new ArrayList<Corso>();
	}

	public String getName() {
		return ateneo;
	}

	public void setRector(String nome, String cognome) {
		rettore = new Rettore(nome, cognome);
	}

	public String getRector() {
		return rettore.toString();
	}

	public int enroll(String nome, String cognome) {
		if (studenti.size() >= MAXSTUDENTI) {
			return -1;
		}
		studenti.add(new Studente(nome, cognome, matricola));
		return matricola++;
	}

	public String student(int matricola) {
		return studenti.get(matricola - 10000).toString();
	}

	public int activate(String corso, String nomeDocente) {
		if (corsi.size() >= MAXCORSI) {
			return -1;
		}
		corsi.add(new Corso(corso, nomeDocente, codiceCorso));
		return codiceCorso++;
	}

	public String course(int codiceCorso) {
		return corsi.get(codiceCorso - 10).toString();
	}

	public void register(int matricolaStudente, int codiceCorso) {
		Studente s = studenti.get(matricolaStudente - 10000);
		Corso c = corsi.get(codiceCorso - 10);

		if (s.canRegister() && c.canRegister()) {
			s.addCorso(c);
			c.addStudente(s);
		}
	}

	public String listAttendees(int codiceCorso) {
		return corsi.get(codiceCorso - 10).stampaStudenti();
	}

	public String studyPlan(int matricola) {
		return studenti.get(matricola - 10000).stampaCorsi();
	}

}
