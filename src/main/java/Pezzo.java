
public class Pezzo {
	
	private Colore colore;
	private boolean dama;
	private Casella posto;
	
	public Pezzo(Colore colore){
		this.setColore(colore);
		this.setDama(false);
	}

	public boolean isDama() {
		return dama;
	}

	public void setDama(boolean dama) {
		this.dama = dama;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public Casella getPosto() {
		return posto;
	}

	public void setPosto(Casella posto) {
		this.posto = posto;
	}
	
}
