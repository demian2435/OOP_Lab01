package university;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce gli oggetti corso
 * @author D2435
 *
 */
public class Corso {

	private List<Esame> esami;
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
		esami = new ArrayList<Esame>();
	}

	/**
	 * Restituisce il nome del corso sotto forma di Stringa
	 * @return String contenente il nome del corso
	 */
	public String getNomeCorso() {
		return corso;
	}

	/**
	 * Restituisce il numero di studenti iscritti a questo corso
	 * @return int pari al numero di studenti iscritti
	 */
	public int getSizeStudenti() {
		return studenti.size();
	}

	/**
	 * Iscrive uno studente al corso selezionato
	 * @param s Oggetto della classe Studente
	 */
	public void addStudente(Studente s) {
		studenti.add(s);
	}

	@Override
	public String toString() {
		return codiceCorso + "," + corso + "," + nomeDocente;
	}

	/**
	 * Restituisce uno String elaborato contenente tutti gli studenti
	 * @return String degli studenti iscritti al corso
	 */
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

	/**
	 * Controlla che non sia stato superato il tetto massimo di iscritti al corso
	 * @return True o False
	 */
	public boolean canRegister() {
		return studenti.size() < MAXSTUDENTI;
	}

	/**
	 * Aggiunge alla lista interna gli studenti che hanno sostenuto un esame
	 * @param c Oggetto Corso
	 * @param s Oggetto Studente
	 * @param voto int pari al voto preso all'esame
	 */
	public void addEsame(Corso c, Studente s, int voto) {
		esami.add(new Esame(c, s, voto));
	}

	/**
	 * Ritorna il numero di easmi dati in questo corso
	 * @return int totale esami sostenuti in questo corso
	 */
	public int getSizeEsami() {
		return esami.size();
	}

	/**
	 * Ritorna la media degli esami sostenuti in questo corso
	 * @return int La media degli esami di questo corso
	 */
	public double mediaEsami() {
		double media = 0;

		for (Esame e : esami) {
			media += e.getVoto();
		}

		return media / esami.size();

	}

}
