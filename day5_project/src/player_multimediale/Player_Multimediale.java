package player_multimediale;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Player_Multimediale {
	static Scanner Scanner = new Scanner(System.in);
	private static int luminosità;
	private static int volume;
	private static int durata;
	private static String titolo;

	public static void main(String args[]) {

		String tipo;
		int z = 0;
		Elemento_Multimediale[] database = new Elemento_Multimediale[5];
		System.out.println("");
		System.out.println("Grazie per aver scelto il nostro Player Multimediale!");
		System.out.println("");
		while (z < 5) {
			System.out.println("Digita la tipologia del prossimo file è un: AUDIO, VIDEO o IMMAGINE?");
			tipo = prendiTipo();
			System.out.println("Tipologia selezionata: " + tipo);
			System.out.println("");
			settaTitolo(titolo);

			if (tipo.equals("AUDIO")) { // controllo se AUDIO
				settaVolumeDurata(durata, volume);
				Audio file = new Audio(titolo, durata, volume);
				database[z] = file;
				;
			} else if (tipo.equals("IMMAGINE")) { // controllo se IMMAGINE
				settaLuminosità(luminosità);
				Immagine file = new Immagine(titolo, luminosità);
				database[z] = file;

			} else if (tipo.equals("VIDEO")) { // controllo se IMMAGINE
				settaVolumeDurata(durata, volume);
				settaLuminosità(luminosità);
				Video file = new Video(titolo, durata, volume, luminosità);
				database[z] = file;
			}

			z++;
		}
		int h = 1;
		while (h == 1) {
			System.out.println("Vuoi rieseguire un file specifico? Y or N");
			String res = Player_Multimediale.Scanner.nextLine().toUpperCase();
			if (res.equals("Y")) {
				System.out.println("Selezione quale file digitare indicando il numero: 1, 2, 3, 4, 5");
				h = 1;
				int indice = eseguiDaDatabase();
				if (database[indice] instanceof Audio) {
					Audio A = (Audio) database[indice];
					A.play(A.volume, A.durata, A.titolo);
				} else if (database[indice] instanceof Immagine) {
					Immagine A = (Immagine) database[indice];
					A.show(A.titolo);
				}
				if (database[indice] instanceof Video) {
					Video A = (Video) database[indice];
					A.play(A.volume, A.durata, A.titolo, A.luminosità);
				}
			} else if (res.equals("N")) {
				System.out.println("Grazie per aver partecipato");
				h = 0;

			} else {
				System.out.println("Carattare non valido! Devi indicare con Y o N, ridigata la risposta");
				h = 1;
			}
		}
		System.out.println("");
		System.out.println("Il programma è finito, arrivederci");

		// String fileTipo = Scanner.nextLine().toUpperCase();
		// prendiTipo(Scanner.nextLine().toUpperCase());
		// Audio_prova file1 = new Audio_prova("Concerto Mozart", 5, 4);

	}

	public static int eseguiDaDatabase() {
		int Check = 0;
		while (Check == 0) {
			String buffer = Player_Multimediale.Scanner.nextLine().toUpperCase();
			switch (buffer) {
			case "1":
				Check = 1;
				return 0;
			case "2":
				Check = 1;
				return 1;
			case "3":
				Check = 1;
				return 2;
			case "4":
				Check = 1;
				return 3;
			case "5":
				Check = 1;
				return 4;
			default:
				System.out.println("Devi digitare un numero da 1 a 5, ridigita: ");
				break;
			}
		}
		System.out.println("ERRORE");
		return 0;
	}

	public static String prendiTipo() {
		int Check = 0;
		while (Check == 0) {
			String buffer = Player_Multimediale.Scanner.nextLine().toUpperCase();
			switch (buffer) {
			case "AUDIO":
				Check = 1;
				return "AUDIO";
			// return Tipologia.AUDIO;
			case "VIDEO":
				Check = 1;
				return "VIDEO";
			// return Tipologia.VIDEO;
			case "IMMAGINE":
				Check = 1;
				return "IMMAGINE";
			// return Tipologia.IMMAGINE;
			default:
				System.out.println("tipologia file non supportata, ripetere inserimento: ");
				break;
			}
		}
		return "ERRORE";
	}

	public static int prendiInt() {
		int Check = 0;
		int buffer = 1;
		while (Check == 0) {
			try {
				buffer = Player_Multimediale.Scanner.nextInt(); // carica buffer
				Player_Multimediale.Scanner.nextLine(); // scarica scanner
				Check = 1; // esci dal while

			} catch (InputMismatchException e) {
				System.out.println("Il numero non è un intero! Ridigitare il numero");
				System.out.println("");
				Player_Multimediale.Scanner.nextLine(); // scarica scanner di sicurezza
				Check = 0; // riattiva il while se l'utente non digita correttamente
			}
		}
		return buffer;
	}

	public static String prendiString() {
		int Check = 0;
		String buffer = "prova";
		while (Check == 0) {
			try {
				buffer = Player_Multimediale.Scanner.nextLine(); // carica buffer
				Check = 1; // esci dal while

			} catch (InputMismatchException e) {
				System.out.println("Il numero non è un intero! Ridigitare il numero");
				System.out.println("");
				Player_Multimediale.Scanner.nextLine(); // scarica scanner di sicurezza
				Check = 0; // riattiva il while se l'utente non digita correttamente
			}
		}
		return buffer;
	}

	public static void settaLuminosità(int lum) {
		System.out.println("Digita la luminosità: ");
		luminosità = prendiInt(); // cattura luminosità
		System.out.println("Il luminosità sarà: " + luminosità);
		System.out.println("");
	}

	public static void settaVolumeDurata(int dur, int vol) {

		System.out.println("Digita la durata: ");
		durata = prendiInt(); // cattura durata
		System.out.println("La durata è di: " + durata);
		System.out.println("");

		System.out.println("Digita il volume: ");
		volume = prendiInt(); // cattura volume
		System.out.println("Il volume sarà: " + volume);
		System.out.println("");
	}

	public static void settaTitolo(String titoloFile) {
		System.out.println("Digita il nome del file: ");
		titolo = prendiString(); // cattura nome
		System.out.println("Il file si chiamerà sarà: " + titolo);
		System.out.println("");
	}
}
