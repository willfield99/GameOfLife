
/*4/16/19
 * 
 * The action that handles when the play button is pressed. It plays the mover thread
 * 
 * William Field
 */
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class PlayAction extends AbstractAction {

	private MoverThread mover;// moverthread used by playaction

	public PlayAction(MoverThread mover) {// constructor
		this.mover = mover;
		this.putValue(NAME, "Play");// naming the action play
	}

	@Override
	public void actionPerformed(ActionEvent e) {// action performed when called
		// TODO Auto-generated method stub
		mover.play();//playing the MoverThread

	}
}
