package de.haw_landshut.gschied.seel;

/**Hauptprogramm zur Universitaetsverwaltung.
 * Enthaelt einige Testfaelle.
 * Aufruf erfolgt mit dem Case-Label als Kommandozeilenargumentz.b.
 * java Main success oder java Main dean
 * Die jeweiligen Methoden, die dabei aufgerufen werden, enthalten in Kommentar
 * was der Auruf der Methode liefern sollte.
 *
 * @author Prof. Dr. Christian Seel
 * @author Gudrun Schiedermeier
 */
public class Main {

	public static void main(String[] args) {

		switch(args[0]) {
			case "success":
				success();
				break;
			case "null":
				failNullRef();
				break;
			case "dean":
				failDoubleDean();
				break;
			case "same":
				successSameDean();
				break;
			case "nomore":
				successNoMoreDean();
				break;
			case "other":
				successNoMoreOtherDean();
				break;
			case "add":
				failAmbiguousElement();
				break;
			case "singleton":
				failDoubleManagement();
				break;
			default:
				System.err.println("invalid key");
				break;
		}
	}

	/**Zum Testen der Universitaetsverwaltung.
	 * Positive Faelle: Erwartete Ausgabe
		 All People:
		 Juergen Wunderbar: Am Lurzenhof 1, 1.1.1970, Dr.Ing, true
		 Christian Seelig: Am Lurzenhof 42, 1.1.1980, Dr. rer. oec., false
		 Gudrun Schiederleitner: Nassau Bahamas 12, 32.13.1960, Dr. mult. hc., false
		 Max Mustermann: Privatweg 4, 1.1.1990, M12345, Informatik
		 Maria Musterfrau: Privatweg 4, 29.2.1902, M98746, Informatik

		 All Professors:
		 Juergen Wunderbar: Am Lurzenhof 1, 1.1.1970, Dr.Ing, true
		 Christian Seelig: Am Lurzenhof 42, 1.1.1980, Dr. rer. oec., false
		 Gudrun Schiederleitner: Nassau Bahamas 12, 32.13.1960, Dr. mult. hc., false

		 All Students:
		 Max Mustermann: Privatweg 4, 1.1.1990, M12345, Informatik
		 Maria Musterfrau: Privatweg 4, 29.2.1902, M98746, Informatik

		 All Rooms:
		 400, true, Am Lurzenhof 1, HS013
		 150, false, Schoenaustrasse 10, SH001
		 Juergen Wunderbar, 24.0, Am Lurzenhof1, IF4711
		 */
	private static void success() {
		UniversityManagement hawLandshut = new UniversityManagement(5, 4);

		Professor wunderlich = new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");

		hawLandshut.addPerson(wunderlich);
		hawLandshut.addPerson(new Professor("Dr. rer. oec.", false, "Christian Seelig", "Am Lurzenhof 42", "1.1.1980"));
		hawLandshut.addPerson(new Professor("Dr. mult. hc.", false, "Gudrun Schiederleitner", "Nassau Bahamas 12", "32.13.1960"));

		hawLandshut.addPerson(new Student("M12345", "Informatik", "Max Mustermann", "Privatweg 4", "1.1.1990"));
		hawLandshut.addPerson(new Student("M98746", "Informatik", "Maria Musterfrau", "Privatweg 4", "29.2.1902"));

		System.out.println("All People:");
		hawLandshut.printAllPeople();
		System.out.println("\nAll Professors:");
		hawLandshut.printAllProfessor();
		System.out.println("\nAll Students:");
		hawLandshut.printAllStudents();

		hawLandshut.addRoom(new LectureTheater(400, true, "Am Lurzenhof 1", "HS013"));
		hawLandshut.addRoom(new LectureTheater(150, false, "Schoenaustrasse 10", "SH001"));
		hawLandshut.addRoom(new Office(wunderlich, 24, "Am Lurzenhof1", "IF4711"));

		System.out.println("\nAll Rooms:");
		hawLandshut.printAllRooms();

	}

	/**Test auf NullPointer, Geburtsdatum fuer Professor ist null.
	 * Erwartete Ausgabe:
	 * Exception in thread "main" java.lang.NullPointerException
	 */
	private static void failNullRef() {
		new Professor("Dr. mult. hc.", false, "Gudrun Schiederleitner", "Nassau Bahamas 12", null);
	}

	/**Test auf doppelten Dean: Weiterer Professor soll als Dean gesetzt werden.
	 * Erwartete Ausgabe:
	 * Exception in thread "main" java.lang.IllegalStateException: ambiguous dean
	 */
	private static void failDoubleDean() {
		new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");
		new Professor("Dr. rer. oec.", true, "Christian Seelig", "Am Lurzenhof 42", "1.1.1980");
	}

	/**Test auf doppelten Dean: Professor der schon Dean ist, bleibt Dean, kein weiterer Professor ist Dean.
	 * Erwartete Ausgabe: true
	 */
	private static void successNoMoreOtherDean() {
		Professor wunderbar = new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");
		Professor seelig = new Professor("Dr. rer. oec.", false, "Christian Seelig", "Am Lurzenhof 42", "1.1.1980");
		seelig.setDean(false);
		System.out.println(wunderbar.isDean());

	}

	/**Test auf doppelten Dean: Professor, der schon Dean ist, bleibt Dean.
	 * Erwartete Ausgabe: true.
	 */
	private static void successSameDean() {
		Professor wunderbar = new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");
		wunderbar.setDean(true);
		System.out.println(wunderbar.isDean());
	}

	/**Absetzung eines Deans.
	 * Ewartete Ausgabe: false.
	 */
	private static void successNoMoreDean() {
		Professor wunderbar = new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");
		wunderbar.setDean(false);
		System.out.println(wunderbar.isDean());
	}

	/**Test auf Einfuegen eines bereits enthaltenen Elements im Personen-Array.
	 * Erwartete Ausgabe:
	 * Exception in thread "main" java.lang.IllegalArgumentException: person already added: Juergen Wunderbar: Am Lurzenhof 1, 1.1.1970, Dr. Ing., true
	 */
	private static void failAmbiguousElement() {
		UniversityManagement hawLandshut = new UniversityManagement(5, 4);

		Professor wunderlich = new Professor("Dr. Ing.", true, "Juergen Wunderbar", "Am Lurzenhof 1", "1.1.1970");

		hawLandshut.addPerson(wunderlich);
		hawLandshut.addPerson(wunderlich);
	}

	/**Test auf ein Universitaetsverwaltung: es darf keine zweite geben.
	 * Erwartete Ausgabe:
	 * Exception in thread "main" java.lang.IllegalStateException: only one object permitted
	 */
	private static void failDoubleManagement() {
		new UniversityManagement(5, 4);
		new UniversityManagement(5, 4);

	}

}

