
public class Giocatore {

	private int num;
	
	public Giocatore(){
		this.num = 1;
	}
	
	public void switchGiocatore(){
		this.num = 3 - this.num;
	}
	
	public int get(){
		return this.num;
	}
}
