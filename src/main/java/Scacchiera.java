
public class Scacchiera {
	
	private final static int DIM_COLON = 8; 
	private Casella[][] casella = new Casella[DIM_COLON][DIM_COLON];
	
	public Scacchiera(){
		inizializza();
	}
	
	private void inizializza(){
		//Generazione caselle
		for(int col=0;col<DIM_COLON;col++){
			for(int rig=0;rig<DIM_COLON;rig++){
				casella[col][rig] = new Casella(col, rig);
				if(col%2==0){
					if(rig%2==0){
						casella[col][rig].setColore(Colore.NERO);
					}
					else{
						casella[col][rig].setColore(Colore.BIANCO);
					}
				}
				else{
					if(rig%2==0){
						casella[col][rig].setColore(Colore.BIANCO);
					}
					else{
						casella[col][rig].setColore(Colore.NERO);
					}
				}
			}
		}
		//Posizionamento pezzi
		//////BIANCHI
		for(int col=0;col<DIM_COLON;col++){
			for(int rig=0;rig<3;rig++){
				if(col%2==0){
					if(rig%2==0){
						casella[col][rig].setFree(false);
						casella[col][rig].setPezzo(new Pezzo(Colore.BIANCO));
						casella[col][rig].getPezzo().setPosto(casella[col][rig]);
					}
				}
				else{
					if(rig%2!=0){
						casella[col][rig].setFree(false);
						casella[col][rig].setPezzo(new Pezzo(Colore.BIANCO));
						casella[col][rig].getPezzo().setPosto(casella[col][rig]);
					}
				}
			}
		}
		//////NERI
		for(int col=0;col<DIM_COLON;col++){
			for(int rig=5;rig<DIM_COLON;rig++){
				if(col%2==0){
					if(rig%2==0){
						casella[col][rig].setFree(false);
						casella[col][rig].setPezzo(new Pezzo(Colore.NERO));
						casella[col][rig].getPezzo().setPosto(casella[col][rig]);
					}
				}
				else{
					if(rig%2!=0){
						casella[col][rig].setFree(false);
						casella[col][rig].setPezzo(new Pezzo(Colore.NERO));
						casella[col][rig].getPezzo().setPosto(casella[col][rig]);
					}
				}
			}
		}
	} //End of inizializza
	
	public void printScacchiera(){
		for(int rig=0;rig<DIM_COLON;rig++){
			for(int col=0;col<DIM_COLON;col++){
				if(casella[col][rig].isFree()){
					if(casella[col][rig].getColore()==Colore.NERO)
						System.out.print("[_]"); //Casella NERA
					else
						System.out.print("[ ]"); //Casella BIANCA
				}else{
					if(casella[col][rig].getPezzo().getColore()==Colore.BIANCO)
						System.out.print("[B]"); //Pezzo BIANCO
					else if(casella[col][rig].getPezzo().getColore()==Colore.NERO)
						System.out.print("[N]"); //Pezzo NERO
				}
			}
			System.out.println("");
		}
	}
	
	public Casella getCasella(int x, int y){
		return casella[x][y];
	}
	
	public void checkDama(){
		int rig = 0;
		for(int col=0;col<DIM_COLON;col=col+2)
			if(casella[col][rig].isFree()==false)
				if(casella[col][rig].getPezzo().getColore()==Colore.NERO)
					casella[col][rig].getPezzo().setDama(true);
		rig = 7;
		for(int col=1;col<DIM_COLON;col=col+2)
			if(casella[col][rig].isFree()==false)
				if(casella[col][rig].getPezzo().getColore()==Colore.BIANCO)
					casella[col][rig].getPezzo().setDama(true);
	}
	
	public Scacchiera clona(){
		Scacchiera scacchiera_copia = new Scacchiera();
		for(int col=0;col<DIM_COLON;col++){
			for(int rig=0;rig<DIM_COLON;rig++){
				if(this.getCasella(col, rig).isFree())
					scacchiera_copia.getCasella(col, rig).setFree(true);
				else
					scacchiera_copia.getCasella(col, rig).setPezzo(this.getCasella(col, rig).getPezzo());
				scacchiera_copia.getCasella(col, rig).setColore(this.getCasella(col, rig).getColore());
			}
		}
		return scacchiera_copia;
	}
	
}