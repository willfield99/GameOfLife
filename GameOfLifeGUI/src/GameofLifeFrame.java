
/*4/16/19
 * 
 * The GameofLifeFrame class creates the frame that contains the GameofLifeBoard it uses instances of Button Panel, MoverThread,
 * and GameofLifePanel to display the application
 * 
 * William Field
 */

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class GameofLifeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String file_name;// file read in by the board
	private ButtonPanel buttons;// the play/pause buttons
	private MoverThread mover;// moverthread used to run the different generations
	private GameofLifePanel boardpanel;// the panel on which the board is displayed

	static {
		file_name = "board.txt";
	}

	public GameofLifeFrame(int x, int y, int width, int height) throws FileNotFoundException {// Creates the frame
		super();
		GameofLifeBoard board;// board used by the panel
		Thread thread;// Thread that runs mover
		board = new GameofLifeBoard(file_name);
		boardpanel = new GameofLifePanel(board);
		mover = new MoverThread(board, boardpanel);// moverthread takes in the board and the boardpanel
		buttons = new ButtonPanel(mover);// buttons takes in the moverthread to modify whether it runs

		thread = new Thread(mover);// thread of type mover
		thread.start();// starting the thread

		add(boardpanel, BorderLayout.CENTER);// adding boardpanel to the center of the window
		add(buttons, BorderLayout.SOUTH);// adding the buttons to the south of the window

		setSize(width, height);// Size mutator
		setLocation(x, y);// Location mutator

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}