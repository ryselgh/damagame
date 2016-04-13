
public class Main {

	private static Scacchiera scacchiera = new Scacchiera();

	public static void main(String[] args) {
		
		scacchiera.printScacchiera();

		try {
			MainMenuGUI menu = new MainMenuGUI();
			menu.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
