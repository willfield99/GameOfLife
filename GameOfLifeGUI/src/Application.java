
/*4/16/19
 * 
 * The application class creates a game of life frame to display the board on
 * 
 * William Field
 */

import java.io.FileNotFoundException;

public class Application {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		GameofLifeFrame frame;// frame of the picture

		try {// try block
			frame = new GameofLifeFrame(500, 100, 1019, 894);// the frame

		} catch (FileNotFoundException caught) {// catch block
			System.err.println("Couldnt find the file.");
		}
	}

}
