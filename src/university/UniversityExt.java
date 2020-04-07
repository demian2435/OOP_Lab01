package university;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class UniversityExt extends University {

	public UniversityExt(String ateneo) {
		super(ateneo);
	}

	public void exam(int matricola, int corso, int voto) {
		Studente s = studenti.get(matricola - 10000);
		Corso c = corsi.get(corso - 10);

		if (!s.isEnrolled(c)) {
			return;
		}
		if (voto < 0 || voto > 30) {
			return;
		}

		s.addEsame(c, s, voto);
		c.addEsame(c, s, voto);

		log.log(Level.INFO, "Student " + matricola + " took an exam in course " + corso + " with grade " + voto);
	}

	public String studentAvg(int matricola) {
		Studente s = studenti.get(matricola - 10000);

		if (s.getSizeEsami() > 0) {
			return "Student " + matricola + " : " + s.mediaEsami();
		} else {
			return "Student " + matricola + " hasn't taken any exams";
		}

	}

	public String courseAvg(int corso) {
		Corso c = corsi.get(corso - 10);

		if (c.getSizeEsami() > 0) {
			return "The average for the course " + c.getNomeCorso() + " is: " + c.mediaEsami();
		} else {
			return "No student has taken the exam in " + c.getNomeCorso();
		}

	}

	public String topThreeStudents() {
		if (studenti.size() == 0) {
			return "No Students";
		}

		List<Studente> perMedia = new ArrayList<Studente>(studenti);
		perMedia.sort((s1, s2) -> {
			double risultato = s2.getMediaBonus() - s1.getMediaBonus();
			if (risultato == 0) {
				risultato = s2.getSizeEsami() - s1.getSizeEsami();
			}
			if (risultato == 0) {
				risultato = s2.getSizeCorsi() - s1.getSizeCorsi();
			}
			if (risultato == 0) {
				risultato = s2.getMatricola() + s1.getMatricola();
			}

			return (int) risultato;
		});

		int stampaMax = 3;

		if (studenti.size() == 1) {
			stampaMax = 1;
		}
		if (studenti.size() == 2) {
			stampaMax = 2;
		}

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < stampaMax; i++) {
			Studente s = perMedia.get(i);
			result.append(s.getNome() + " " + s.getCognome() + " : " + s.getMediaBonus());
			if (i < 2) {
				result.append("\n");
			}
		}

		return result.toString();
	}

}
