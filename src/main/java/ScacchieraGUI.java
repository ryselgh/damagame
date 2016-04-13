import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScacchieraGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2118625125695705272L;
	private static final int DIM_COLON = 8;
	public JFrame frame;
	private static JButton[][] btn = new JButton[DIM_COLON][DIM_COLON];
	private Scacchiera scacchiera = new Scacchiera();
	private Mossa mossa = new Mossa();
	private static Casella casellaClicked;
	private static JButton buttonClicked;
	private static int count = 0;
	private Icon whiteFree = new ImageIcon("src/main/resources/white_free.png");
	private Icon blackFree = new ImageIcon("src/main/resources/black_free.png");
	private Icon whitePezzo = new ImageIcon("src/main/resources/black_white.png");
	private Icon blackPezzo = new ImageIcon("src/main/resources/black_black.png");
	private Icon whitePezzoSel = new ImageIcon("src/main/resources/black_white_sel.png");
	private Icon blackPezzoSel = new ImageIcon("src/main/resources/black_black_sel.png");
	private Icon whiteDama = new ImageIcon("src/main/resources/black_white_dama.png");
	private Icon blackDama = new ImageIcon("src/main/resources/black_black_dama.png");
	private Icon whiteDamaSel = new ImageIcon("src/main/resources/black_white_dama_sel.png");
	private Icon blackDamaSel = new ImageIcon("src/main/resources/black_black_dama_sel.png");
	

	
	public ScacchieraGUI() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 829);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Inizializzo scacchiera di bottoni
		for(int col = 0; col<DIM_COLON;col++){
			for(int rig=0; rig<DIM_COLON;rig++){
				btn[col][rig] = new JButton("");
				btn[col][rig].setBounds(col*100, rig*100, 100, 100);
				frame.getContentPane().add(btn[col][rig]);
				btn[col][rig].addActionListener(this);
				
				//Alternanza nero/bianco (background)
				if(col%2==0){
					if(rig%2==0){
						btn[col][rig].setIcon(blackFree);
					}
					else{
						btn[col][rig].setIcon(whiteFree);
					}
				}
				else{
					if(rig%2==0){
						btn[col][rig].setIcon(whiteFree);
					}
					else{
						btn[col][rig].setIcon(blackFree);
					}
				}
				//End of Alternanza Nero/Bianco
				btn[col][rig].setForeground(Color.WHITE); //Testo dei pulsanti = BIANCO
				if(scacchiera.getCasella(col, rig).isFree()==false){
					if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.BIANCO)
						btn[col][rig].setIcon(whitePezzo); //Pezzo BIANCO
					else if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.NERO)
						btn[col][rig].setIcon(blackPezzo); //Pezzo NERO
				}
			}
		}
	}//End of initialize()
	
	private void updateBtn(){
		for(int col=0;col<DIM_COLON;col++){
			for(int rig=0;rig<DIM_COLON;rig++){
				if(scacchiera.getCasella(col, rig).isFree()==true && scacchiera.getCasella(col, rig).getColore()==Colore.NERO)
					btn[col][rig].setIcon(blackFree);
				else if(scacchiera.getCasella(col, rig).isFree()==true && scacchiera.getCasella(col, rig).getColore()==Colore.BIANCO)
					btn[col][rig].setIcon(whiteFree);
				else if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.BIANCO && scacchiera.getCasella(col, rig).getPezzo().isDama()==true)
					btn[col][rig].setIcon(whiteDama);
				else if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.NERO && scacchiera.getCasella(col, rig).getPezzo().isDama()==true)
					btn[col][rig].setIcon(blackDama);
				else if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.BIANCO)
					btn[col][rig].setIcon(whitePezzo);
				else if(scacchiera.getCasella(col, rig).getPezzo().getColore()==Colore.NERO)
					btn[col][rig].setIcon(blackPezzo);
			}
		}
		if(mossa.isMangiato()==true){
			if(buttonClicked.getIcon()==whitePezzo)
				buttonClicked.setIcon(whitePezzoSel);
			else if(buttonClicked.getIcon()==blackPezzo)
				buttonClicked.setIcon(blackPezzoSel);
			else if(buttonClicked.getIcon()==whiteDama)
				buttonClicked.setIcon(whiteDamaSel);
			else if(buttonClicked.getIcon()==blackDama)
				buttonClicked.setIcon(blackDamaSel);
		}	
	}
	
	public void actionPerformed(ActionEvent e1) {
		if(count == 0){ //Selezione della pedina da muovere
			if(e1.getSource() instanceof JButton){
				int col = (((JButton) e1.getSource()).getBounds().x)/100;
				int rig = (((JButton)e1.getSource()).getBounds().y)/100;
				casellaClicked = scacchiera.getCasella(col, rig);
				buttonClicked = ((JButton) e1.getSource());
				if(mossa.puoMuoversi(scacchiera, casellaClicked)){
					if(((JButton) e1.getSource()).getIcon()==whitePezzo)
						((JButton) e1.getSource()).setIcon(whitePezzoSel);
					else if(((JButton) e1.getSource()).getIcon()==blackPezzo)
						((JButton) e1.getSource()).setIcon(blackPezzoSel);
					else if(((JButton) e1.getSource()).getIcon()==whiteDama)
						((JButton) e1.getSource()).setIcon(whiteDamaSel);
					else if(((JButton) e1.getSource()).getIcon()==blackDama)
						((JButton) e1.getSource()).setIcon(blackDamaSel);
					count++;
				}
			}
		}
		else if(e1.getSource() instanceof JButton){ //count > 0; Selezione della mossa
			int col = (((JButton) e1.getSource()).getBounds().x)/100;
			int rig = (((JButton)e1.getSource()).getBounds().y)/100;
			if(mossa.puoMuoversiVerso(scacchiera, casellaClicked, scacchiera.getCasella(col, rig))){ //Se la pedina selezionata può effettuare la mossa in posizione (col,rig)
				if(mossa.isMangiato()){ //Se nel suo turno ha già mangiato una pedina
					if(mossa.vuoleMangiare(scacchiera, casellaClicked, scacchiera.getCasella(col, rig))==true){ //Analisi di fattibilità
						scacchiera = mossa.mangia(scacchiera, casellaClicked, scacchiera.getCasella(col, rig)); //casellaClicked = la casella dov'era prima di mangiare (adesso vuota)
						casellaClicked = scacchiera.getCasella(col, rig); //casellaClicked = la casella dove si trova attualmente la pedina che ha fatto la doppia mangiata
					}
				}else{
					scacchiera = mossa.muovi(scacchiera, casellaClicked, scacchiera.getCasella(col, rig));
					casellaClicked = scacchiera.getCasella(col, rig);
				}
				scacchiera.checkDama();
				if(mossa.puoMangiareAncora(scacchiera, casellaClicked)==true){ 
					buttonClicked = btn[casellaClicked.getX()][casellaClicked.getY()];
					count++;
				}else{
					mossa.giocatore.switchGiocatore();
					mossa.setMangiato(false);
					buttonClicked.setIcon(blackFree);
					count=0;
				}
			}else{
				if(mossa.puoMangiareAncora(scacchiera, casellaClicked)==false)
					count=0;
			}
			updateBtn();
			System.out.println("");
			System.out.println("");
			scacchiera.printScacchiera();
		}
	}
	
}
