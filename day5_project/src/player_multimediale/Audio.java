package player_multimediale;

public class Audio extends Elemento_Multimediale {
	private int volume;
	private int durata;

	public Audio(String nomeFile, int durataFile, int volumeFile) {
		super(nomeFile);
		setDurata(durataFile);
		setVolume(volumeFile);
		System.out.println("esecuzione file:");
		play(volume, durata, super.titolo);
	}

	public void play(int volumeIstanza, int durataIstanza, String titoloFile) {		
		controlloVolume(volume, super.titolo);
		for (int i = 0; i < this.durata; i++) {
			System.out.println(super.titolo);
		}
	}
	
	public void setDurata(int dur) {
		this.durata = dur;
	}

	public void setVolume(int vol) {
		this.volume = vol;
	}
	
	void controlloVolume(int vol, String tit) {
		if (0 < vol) {
			for (int i = 0; i < vol; i++) {
				alzaVolume(tit);
			}
		} else if (0 > vol) {
			for (int i = 0; i < vol; i--) {
				abbassaVolume(tit);
			}
		}

	}
	
	void alzaVolume(String titolo) {
		super.titolo += "!";
	}

	void abbassaVolume(String titolo) {
		String shortedArr[] = new String[titolo.length() - 1];
		String singChar[] = titolo.split("");
		String standard = "!";
		if (singChar[titolo.length() - 1].equals(standard)) {
			for (int i = 0; i < singChar.length - 1; i++) {
				shortedArr[i] = singChar[i];
			}
			titolo = String.join("", shortedArr);			
		} else {
			titolo = String.join("", singChar);
		}
		super.titolo = titolo;
	}
}
