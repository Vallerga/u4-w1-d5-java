package player_multimediale;

public class Audio_prova extends Elemento_Multimediale {
	private int volume = 1;
	private int durata = 1;
	private String file;

	// controlla nome
	// controlla la durata
	// aggiunge un punto esclamativo ad ogni aumento di volume
	// riproduce un file ( cioè lo stampa)
	// ripete la stampa per il numero di durata

	public Audio_prova(String nomeFile, int durataAudio, int volumeFile) {
		super(nomeFile);
		setDurata(durataAudio); // controllo durata
		controllovolume(volumeFile, nomeFile); // aggiungo punti esclamativi
		stampaAudio(); // riproduco file
		System.out.println("sono eseguito: " + file + volume + durata);
	}

	public void play(int volumeIstanza, int durataIstanza, String titoloFile) {
		// setVolume(volumeIstanza); // controllo volume

		for (int i = 0; i < this.durata; i++) {
			System.out.println(file);
		}
	}

	void controllovolume(int vol, String tit) {
		if (this.volume < vol) {
			for (int i = this.volume; i == vol; i++) {
				alzaVolume(tit);
			}
		} else if (vol > this.volume) {
			for (int i = this.volume; i == vol; i--) {
				abbassaVolume(tit);
			}
		}

	}

	protected void alzaVolume(String titolo) {
		this.file = titolo + "!";
	}

	protected void abbassaVolume(String titolo) {
		String shortedArr[] = new String[titolo.length() - 1];
		String singChar[] = titolo.split("");
		String standard = "!";
		// System.out.println("cosa c'è nell'ultima posizione? ");
		// System.out.println(singChar[titolo.length() - 1]);
		// System.out.println(singChar[titolo.length() - 1].equals(standard));
		if (singChar[titolo.length() - 1].equals(standard)) {
			for (int i = 0; i < singChar.length - 1; i++) {
				shortedArr[i] = singChar[i];
				// shortedArr.join(singChar[i]);
				// System.out.println(singChar[i]);
			}
			titolo = String.join("", shortedArr);
			// System.out.println("volume abassato!");
		} else {
			// System.out.println("volume non abbassabile, non entra nell'if");
			titolo = String.join("", singChar);
		}
		// System.out.print("fine ciclo: ");
		// System.out.println(titolo);
		this.file = titolo;
	}

	/*
	 * not implemented function
	 
	protected String abbassaVolume(String titolo) {
		String shortedArr = "";
		String glue;
		String singChar[] = titolo.split("");
		if (singChar[singChar.length - 1] != "!")
			for (int i = 0; i < singChar.length - 2; i++) {
				shortedArr.concat(singChar[i]);
			}
		return titolo = shortedArr;
	}*/

	public void setDurata(int dur) {
		this.durata = dur;
	}

	public void setVolume(int vol) {
		this.volume = vol;
	}

	public void setFile(String nome) {
		this.file = nome;
	}

	private void stampaAudio() {
		for (int i = 0; i < this.durata; i++) {
			System.out.println(file);
		}
	}
}
