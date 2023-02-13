/*4/16/19
 * 
 * The MoverThread class creates a runnable that can be used by a thread to run new generations of the game of life board. It also
 * contains play and pause methods
 * 
 * William Field
 */
public class MoverThread implements java.lang.Runnable {

	private GameofLifeBoard board;// board to create generations of
	private javax.swing.JPanel panel;// panel the board is displayed on
	private boolean running;// whether the thread is currently running
	private static int sleep_time;// how long to sleep in between generations

	static {
		sleep_time = 150;//sleep time is 350 millis
	}

	public MoverThread(GameofLifeBoard board, javax.swing.JPanel panel) {// constructor for moverthread
		this.board = board;
		this.panel = panel;
	}

	public void pause() {// pauses the thread
		running = false;
	}

	public void play() {// plays the thread
		running = true;
	}

	@Override
	public void run() {// run method

		try {
			while (true) {// runs while running is true
				if (running) {
					
					board.nextGeneration();// create a new generation
					panel.repaint();// repaint the board
				}
				Thread.sleep(sleep_time);// sleep for sleep_time milliseconds
			}
		} catch (InterruptedException caught) {// catch block
			System.out.println("Board stopped.");
		}

	}

}
