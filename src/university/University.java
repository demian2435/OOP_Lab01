package university;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class University {

	protected Logger log;

	protected String ateneo;
	protected Rettore rettore;
	protected static int matricola = 10000;
	protected static final int MAXSTUDENTI = 1000;
	protected List<Studente> studenti;
	protected static int codiceCorso = 10;
	protected static final int MAXCORSI = 50;
	protected List<Corso> corsi;

	public University(String ateneo) {
		this.ateneo = ateneo;
		studenti = new ArrayList<Studente>();
		corsi = new ArrayList<Corso>();

		log = Logger.getLogger("LOG");
	}

	public String getName() {
		return ateneo;
	}

	public void setRector(String nome, String cognome) {
		rettore = new Rettore(nome, cognome);

		log.log(Level.INFO, "Add to " + ateneo + " new Rector " + nome + " " + cognome);
	}

	public String getRector() {
		return rettore.toString();
	}

	public int enroll(String nome, String cognome) {
		if (studenti.size() >= MAXSTUDENTI) {
			return -1;
		}
		studenti.add(new Studente(nome, cognome, matricola));

		log.log(Level.INFO, "New student enrolled: " + matricola + ", " + nome + " " + cognome);

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

		log.log(Level.INFO, "New course activated: " + codiceCorso + ", " + corso + " " + nomeDocente);

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

		log.log(Level.INFO, "Student " + matricolaStudente + " signed up for course " + codiceCorso);

	}

	public String listAttendees(int codiceCorso) {
		return corsi.get(codiceCorso - 10).stampaStudenti();
	}

	public String studyPlan(int matricola) {
		return studenti.get(matricola - 10000).stampaCorsi();
	}

}
