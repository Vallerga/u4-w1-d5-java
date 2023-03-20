package player_multimediale;

public class Immagine extends Elemento_Multimediale  {	
	int luminosità;
	
	public Immagine(String nomeFile, int lum) {
		super(nomeFile);
		setLuminosità(lum);
		System.out.println("cosa carica? " + super.titolo + " + "+ luminosità);
		System.out.println("esecuzione file:");
		show(super.titolo);
	}
	
	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
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
	
	void show (String tit) {
		controlloLuminosità(luminosità, super.titolo);
		System.out.println(super.titolo);
		
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
}
