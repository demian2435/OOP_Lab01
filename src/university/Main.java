package university;

public class Main {

	// https://oop.polito.it/svn/OOPLabs/master/OOP_LAB_University/Requisiti.html

	public static void main(String[] args) {

		String universityName = "Politecnico di Torino";

		UniversityExt poli = new UniversityExt(universityName);

		poli.setRector("Guido", "Saracco");

		System.out.println("Rector of " + poli.getName() + " : " + poli.getRector()); // Guido Saracco

		int s1 = poli.enroll("Mario", "Rossi");
		int s2 = poli.enroll("Giuseppe", "Verdi");
		int s3 = poli.enroll("Michele", "Bianchi");
		int s4 = poli.enroll("Claudia", "Persiani");
		int s5 = poli.enroll("Federica", "Marinelli");
		int s6 = poli.enroll("Loretta", "Malori");
		int s7 = poli.enroll("Peppino", "Cavalli");

		System.out.println("Enrolled students " + s1 + ", " + s2); // 10000, 10001
		System.out.println("s1 = " + poli.student(s1)); // 10000 Mario Rossi

		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		int bio = poli.activate("Biologia I", "Federica Persiani");

		System.out.println("Activated courses " + macro + " and " + oop);// 10 and 11
		poli.register(s1, macro);
		poli.register(s1, bio);
		poli.register(s2, macro);
		poli.register(s2, oop);
		poli.register(s4, bio);
		poli.register(s4, macro);
		poli.register(s5, bio);
		poli.register(s6, macro);
		poli.register(s6, bio);
		poli.register(s6, oop);
		poli.register(s7, macro);

		System.out.println(poli.listAttendees(macro));
		// 10000 Mario Rossi
		// 10001 Giuseppe Verdi

		System.out.println(poli.studyPlan(s2));
		// 10,Macro Economics,Paul Krugman
		// 11,Object Oriented Programming,Marco Torchiano

		poli.exam(s1, macro, 27);
		poli.exam(s2, macro, 28);
		poli.exam(s2, oop, 19);
		poli.exam(s4, macro, 27);
		poli.exam(s5, bio, 30);
		poli.exam(s6, macro, 26);
		poli.exam(s6, oop, 22);
		poli.exam(s6, bio, 19);
		poli.exam(s7, macro, 27);
		System.out.println(poli.studentAvg(s1));
		System.out.println(poli.studentAvg(s2));
		System.out.println(poli.studentAvg(s3));

		System.out.println(poli.courseAvg(oop));
		System.out.println(poli.courseAvg(macro));
		System.out.println(poli.courseAvg(bio));

		System.out.println("+++\n" + poli.topThreeStudents());
		poli.exam(s1, bio, 30);
		System.out.println("+++ Dopo Mario 30\n" + poli.topThreeStudents());

	}

}
