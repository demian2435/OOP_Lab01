package university;

public class Main {
	
	// https://oop.polito.it/svn/OOPLabs/master/OOP_LAB_University/Requisiti.html

	public static void main(String[] args) {
		University u = new University("Tor Vergata");
		
		u.enroll("Damiano", "Malori");
		u.enroll("Federica", "Persiani");
		u.activate("OOP", "Mario Rossi");
		u.activate("HTC", "Marco Verdi");
		u.activate("Numeri Simpatici", "Gianni Sperti");
		
		System.out.println("* Studente 10001");
		System.out.println(u.student(10001));
		System.out.println("* Corso 10");
		System.out.println(u.course(10));
		
		u.register(10000, 10);
		u.register(10001, 10);
		u.register(10000, 11);
		u.register(10000, 12);

		System.out.println("* Studenti iscitti al corso 10");
		System.out.println(u.listAttendees(10));
		
		System.out.println("* Corsi a cui è iscitto lo studente 10000");
		System.out.println(u.studyPlan(10000));
	}

}
