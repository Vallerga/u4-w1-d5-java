package player_multimediale;

public class Elemento_Multimediale {
	String titolo;
	
	public Elemento_Multimediale(String nomeFile) {
		setFile(nomeFile);
	}
	
	public void setFile(String nome) {
		this.titolo = nome;
	}	
}
