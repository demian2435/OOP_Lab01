package university;

public class Esame {

	private Corso corso;
	private Studente studente;
	private int voto;

	public Esame(Corso corso, Studente studente, int voto) {
		this.corso = corso;
		this.studente = studente;
		this.voto = voto;
	}

	public Corso getCorso() {
		return corso;
	}

	public Studente getStudente() {
		return studente;
	}

	public int getVoto() {
		return voto;
	}

}
