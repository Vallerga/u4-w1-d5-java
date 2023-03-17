package player_multimediale;

public class Audio extends Elemento_Multimediale {
	private int volume = 1;
	private int durata = 1;
	private String file;
	
	Audio(String nomeFile, int durataAudio, int volumeFile, Tipologia tipo) {
		setDurata(durataAudio); // controllo durata
	}

	
	// riproduce un file ( cioè lo stampa)
	// controlla la durata
	// ripete la stampa per il numero di durata
	// controlla volume
	// aggiunge un punto esclamativo ad ogni aumento di volume
	
	public void play(int volumeIstanza, int durataIstanza, String titoloFile) {
		// setVolume(volumeIstanza); // controllo volume
		
		controllovolume(volumeIstanza, titoloFile); // aggiungo punti esclamativi
		for (int i = 0; i < this.durata; i++) {
			System.out.println(file);
		}
	}

	void controllovolume(int vol, String tit) {
		if (this.volume < vol ) {
			for (int i = this.volume; i < vol; i++) {
				alzaVolume(tit);
			}
		} 
		/*else if (par <= this.volume) {
			for (int i = 0; i > par; i--) {abbassaVolume(tit);}}*/
	}

	protected void alzaVolume(String titolo) {
		this.file = titolo + "!";
	}

	/* not implemented function
	 * protected String abbassaVolume(String titolo) {
		String singChar[] = titolo.split("");
		if (singChar[singChar.length-1] != "!")
			for(int i = 0; i < singChar.length-2; i++) {
		titolo = singChar;
		}
		return titolo; 
	}*/
	
	public void setDurata (int dur) {
		this.durata = dur;
	}
	
	public void setVolume (int vol) {
		this.volume = vol;
	}
	
	public void setFile (String nome) {
		this.file = nome;
	}
	
	private void stampaAudio() {
		for (int i = 0; i < this.durata; i++) {
			System.out.println(file);
		}
	}
}
