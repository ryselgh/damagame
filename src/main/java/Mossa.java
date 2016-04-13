
public class Mossa {
	
	private static final int DIM_COLON = 8;
	private Scacchiera scacchiera;
	public Giocatore giocatore = new Giocatore();
	private boolean mangiato = false;
	
	public Mossa(){
		
	}

	public Scacchiera getScacchiera() {
		return scacchiera;
	}

	public void setScacchiera(Scacchiera scacchiera) {
		this.scacchiera = scacchiera;
	}

	public boolean isMangiato() {
		return mangiato;
	}

	public void setMangiato(boolean mangiato) {
		this.mangiato = mangiato;
	}
	
	public boolean puoMuoversi(Scacchiera scacchiera, Casella casella){ //Calcola se la pedina selezionata ha almeno una mossa possibile a disposizione
		if(casella.isFree()==true)
			return false;
		else{
			if(casella.getPezzo().isDama()==true && (casella.getPezzo().getColore()==Colore.BIANCO && giocatore.get()==1 || casella.getPezzo().getColore()==Colore.NERO && giocatore.get()==2)){
				if(casella.getX()+1<DIM_COLON && casella.getY()+1<DIM_COLON && scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==true ||
				casella.getX()-1>=0 && casella.getY()+1<DIM_COLON && scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==true)
					return true;
				if(casella.getX()+2<DIM_COLON && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()+2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()+1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()-2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()+1).getPezzo().getColore())
					return true;
				else if(casella.getX()+1<DIM_COLON && casella.getY()-1>=0 && scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==true ||
				casella.getX()-1>=0 && casella.getY()-1>=0 && scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==true)
					return true;
				if(casella.getX()+2<DIM_COLON && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()+2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()-1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()-2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()-1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(casella.getPezzo().getColore()==Colore.BIANCO && giocatore.get()==1){
				if(casella.getX()+1<DIM_COLON && casella.getY()+1<DIM_COLON && scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==true ||
				casella.getX()-1>=0 && casella.getY()+1<DIM_COLON && scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==true)
					return true;
				if(casella.getX()+2<DIM_COLON && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()+2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()+1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()-2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()+1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(casella.getPezzo().getColore()==Colore.NERO && giocatore.get()==2){
				if(casella.getX()+1<DIM_COLON && casella.getY()-1>=0 && scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==true ||
				casella.getX()-1>=0 && casella.getY()-1>=0 && scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==true)
					return true;
				if(casella.getX()+2<DIM_COLON && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()+2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()-1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()-2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()-1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			return false;
		}
	}
	
		public boolean puoMangiareAncora(Scacchiera scacchiera, Casella casella){
		if(this.isMangiato() && casella.isFree()==false){
			if(casella.getPezzo().isDama()==true && (casella.getPezzo().getColore()==Colore.BIANCO && giocatore.get()==1 || casella.getPezzo().getColore()==Colore.NERO && giocatore.get()==2)){
				if(casella.getX()+2<DIM_COLON && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()+2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()+1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()-2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()+1).getPezzo().getColore())
					return true;
				if(casella.getX()+2<DIM_COLON && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()+2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()-1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()-2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()-1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(casella.getPezzo().getColore()==Colore.BIANCO && giocatore.get()==1){
				if(casella.getX()+2<DIM_COLON && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()+2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()+1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()+2<DIM_COLON && scacchiera.getCasella(casella.getX()-2, casella.getY()+2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()+1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()+1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(casella.getPezzo().getColore()==Colore.NERO && giocatore.get()==2){
				if(casella.getX()+2<DIM_COLON && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()+2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()+1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()+1, casella.getY()-1).getPezzo().getColore() ||
				casella.getX()-2>=0 && casella.getY()-2>=0 && scacchiera.getCasella(casella.getX()-2, casella.getY()-2).isFree()==true &&
				scacchiera.getCasella(casella.getX()-1, casella.getY()-1).isFree()==false &&
				casella.getPezzo().getColore()!=scacchiera.getCasella(casella.getX()-1, casella.getY()-1).getPezzo().getColore())
					return true;
				else
					return false;
			}
			return false;
		}else
			return false;
	}
	
	public boolean puoMuoversiVerso(Scacchiera scacchiera, Casella c_inizio, Casella c_fine){
		if(c_inizio.isFree()==true) //Se voglio muovere da una casella vuota
			return false;
		else if(c_inizio.equals(c_fine))//Se voglio muovermi sulla stessa posizione
			return false;
		else if(c_fine.isFree()==true){ //Se voglio muovermi in una posizione libera
			if(c_inizio.getPezzo().isDama()==true){ //Se sono Dama
				//Verso il BASSO (Sezione 1)
				if((c_fine.getX()==c_inizio.getX()+1 || c_fine.getX()==c_inizio.getX()-1) && c_fine.getY()==c_inizio.getY()+1) //Mossa diagonale DX/SX
					return true;
				else if(c_fine.getX()==c_inizio.getX()+2 && c_fine.getY()==c_inizio.getY()+2 && //Mangio una pedina avversaria
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).getPezzo().getColore()!=c_inizio.getPezzo().getColore() ||
						c_fine.getX()==c_inizio.getX()-2 && c_fine.getY()==c_inizio.getY()+2 &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).getPezzo().getColore()!=c_inizio.getPezzo().getColore())
					return true;
				//Verso l'ALTO (Sezione 2)
				else if((c_fine.getX()==c_inizio.getX()+1 || c_fine.getX()==c_inizio.getX()-1) && c_fine.getY()==c_inizio.getY()-1)//Mossa diagonale DX/SX
					return true;
				else if(c_fine.getX()==c_inizio.getX()+2 && c_fine.getY()==c_inizio.getY()-2 && //Mangio una pedina avversaria
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).getPezzo().getColore()!=c_inizio.getPezzo().getColore() ||
						c_fine.getX()==c_inizio.getX()-2 && c_fine.getY()==c_inizio.getY()-2 &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).getPezzo().getColore()!=c_inizio.getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(c_inizio.getPezzo().getColore()==Colore.BIANCO){ //Se sono BIANCO (Vedi Sezione 1)
				if((c_fine.getX()==c_inizio.getX()+1 || c_fine.getX()==c_inizio.getX()-1) && c_fine.getY()==c_inizio.getY()+1)
					return true;
				else if(c_fine.getX()==c_inizio.getX()+2 && c_fine.getY()==c_inizio.getY()+2 &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).getPezzo().getColore()!=c_inizio.getPezzo().getColore() ||
						c_fine.getX()==c_inizio.getX()-2 && c_fine.getY()==c_inizio.getY()+2 &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).getPezzo().getColore()!=c_inizio.getPezzo().getColore())
					return true;
				else
					return false;
			}
			if(c_inizio.getPezzo().getColore()==Colore.NERO){ //Se sono NERO (Vedi Sezione 2)
				if((c_fine.getX()==c_inizio.getX()+1 || c_fine.getX()==c_inizio.getX()-1) && c_fine.getY()==c_inizio.getY()-1)
					return true;
				else if(c_fine.getX()==c_inizio.getX()+2 && c_fine.getY()==c_inizio.getY()-2 &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).getPezzo().getColore()!=c_inizio.getPezzo().getColore() ||
						c_fine.getX()==c_inizio.getX()-2 && c_fine.getY()==c_inizio.getY()-2 &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).isFree()==false &&
						scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).getPezzo().getColore()!=c_inizio.getPezzo().getColore())
					return true;
				else
					return false;
			}
			return false;
		}
		else
			return false;
	}
	
	public Scacchiera muovi(Scacchiera scacchiera, Casella c_inizio, Casella c_fine){

		if(c_fine.getY()-c_inizio.getY()==2){ //BIANCO mangia NERO?
			c_fine.setPezzo(c_inizio.getPezzo());
			c_fine.getPezzo().setPosto(c_fine);
			c_fine.setFree(false);
			c_inizio.setPezzo(null);
			c_inizio.setFree(true);
			if(c_fine.getX()-c_inizio.getX()>0){ //Destra
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).setFree(true);
			}else{ //Sinistra
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).setFree(true);
			}
			if(isMangiato()==false)
				setMangiato(true);
		}else if(c_fine.getY()-c_inizio.getY()==-2){ //NERO mangia BIANCO?
			c_fine.setPezzo(c_inizio.getPezzo());
			c_fine.getPezzo().setPosto(c_fine);
			c_fine.setFree(false);
			c_inizio.setPezzo(null);
			c_inizio.setFree(true);
			if(c_fine.getX()-c_inizio.getX()>0){ //Destra
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).setFree(true);
			}else{ //Sinistra
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).setFree(true);
			}
			if(isMangiato()==false)
				setMangiato(true);
		}else{ //Mi muovo di una casella
			c_fine.setPezzo(c_inizio.getPezzo());
			c_fine.getPezzo().setPosto(c_fine);
			c_fine.setFree(false);
			c_inizio.setPezzo(null);
			c_inizio.setFree(true);
		}
		
		return scacchiera;
	}
	
	public Scacchiera mangia(Scacchiera scacchiera, Casella c_inizio, Casella c_fine){
		if(c_fine.getY()-c_inizio.getY()==2){ //BIANCO mangia NERO?
			c_fine.setPezzo(c_inizio.getPezzo());
			c_fine.getPezzo().setPosto(c_fine);
			c_fine.setFree(false);
			c_inizio.setPezzo(null);
			c_inizio.setFree(true);
			if(c_fine.getX()-c_inizio.getX()>0){ //Destra
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()+1).setFree(true);
			}else{ //Sinistra
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()+1).setFree(true);
			}
			if(isMangiato()==false)
				setMangiato(true);
		}else if(c_fine.getY()-c_inizio.getY()==-2){ //NERO mangia BIANCO?
			c_fine.setPezzo(c_inizio.getPezzo());
			c_fine.getPezzo().setPosto(c_fine);
			c_fine.setFree(false);
			c_inizio.setPezzo(null);
			c_inizio.setFree(true);
			if(c_fine.getX()-c_inizio.getX()>0){ //Destra
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()+1, c_inizio.getY()-1).setFree(true);
			}else{ //Sinistra
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).setPezzo(null);
				scacchiera.getCasella(c_inizio.getX()-1, c_inizio.getY()-1).setFree(true);
			}
			if(isMangiato()==false)
				setMangiato(true);
		}
		
		return scacchiera;
	}
	
	public boolean vuoleMangiare(Scacchiera scacchiera, Casella c_inizio, Casella c_fine){
		if(c_fine.getY()-c_inizio.getY()==2 || c_fine.getY()-c_inizio.getY()==-2)
			return true;
		else
			return false;
	}
	
}
