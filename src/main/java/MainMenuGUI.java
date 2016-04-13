import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuGUI {

	public JFrame frame;

	public MainMenuGUI() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("src/main/resources/main_menu.png")));
		
		JButton button = new JButton(new ImageIcon("src/main/resources/new_game_btn.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ScacchieraGUI window = new ScacchieraGUI();
					window.frame.setVisible(true);
				} catch (Exception excp) {
					excp.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setBounds(180, 267, 285, 100);
		frame.getContentPane().add(button);
	}
}
