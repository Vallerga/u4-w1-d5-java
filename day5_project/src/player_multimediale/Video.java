package player_multimediale;

public class Video extends Elemento_Multimediale {
	private int volume;
	private int durata;
	private int luminosità;

	public Video(String nomeFile, int durataFile, int volumeFile, int lum) {
		super(nomeFile);
		setDurata(durataFile);
		setVolume(volumeFile);
		setLuminosità(lum);
		System.out.println("esecuzione file:");
		play(volume, durata, super.titolo, luminosità);
	}

	void play(int volumeIstanza, int durataIstanza, String titoloFile, int lum) {
		controlloVolume(volume, super.titolo);
		controlloLuminosità(luminosità, super.titolo);
		for (int i = 0; i < this.durata; i++) {
			System.out.println(super.titolo);
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

	void alzaLuminosità(String titolo) {
		super.titolo += "*";
	}
	void abbassaLuminosità(String titolo) {
		String shortedArr[] = new String[titolo.length() - 1];
		String singChar[] = titolo.split("");
		String standard = "*";
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

	void controlloLuminosità(int lum, String tit) {
		if (0 < lum) {
			for (int i = 0; i < lum; i++) {
				alzaLuminosità(tit);
			}
		} else if (0 > lum) {
			for (int i = 0; i > lum; i--) {
				abbassaLuminosità(tit);
			}
		}
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

	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}

	public void setDurata(int dur) {
		this.durata = dur;
	}

	public void setVolume(int vol) {
		this.volume = vol;
	}

}
