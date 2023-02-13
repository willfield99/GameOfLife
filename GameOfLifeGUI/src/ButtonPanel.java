
/*4/16/2019
 * 
 * The ButtonPanel class creates the panel that contains the play and pause buttons for the board GUI 
 * 
 * William Field
 */
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel(MoverThread mover) {// ButtonPanel creates the appropriate actions and links them to new JButtons
											// on the panel

		Action playaction;// declaring playaction
		Action pauseaction;// declaring pauseaction
		JPanel buttons;// panel containing the buttons

		playaction = new PlayAction(mover);// initializing
		pauseaction = new PauseAction(mover);
		buttons = new JPanel();

		add(buttons, BorderLayout.SOUTH);// adding buttons to BorderLayout.SOUTH
		buttons.add(new JButton(playaction));// adding both playaction and pauseaction to buttons
		buttons.add(new JButton(pauseaction));
	}

}
