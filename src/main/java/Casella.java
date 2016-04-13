
public class Casella {
	private int x;
	private int y;
	private boolean free;
	private Colore colore;
	private Pezzo pezzo;
	
	public Casella(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setFree(true);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int[] getXY(){
		int[] xy = new int[2];
		xy[0]=this.x;
		xy[1]=this.y;
		return xy;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public Pezzo getPezzo() {
		return pezzo;
	}

	public void setPezzo(Pezzo pezzo) {
		this.pezzo = pezzo;
	}
	
	public boolean isDama(){
		return this.pezzo.isDama();
	}
	
	public void setDama(boolean dama){
		this.pezzo.setDama(dama);
	}

}
