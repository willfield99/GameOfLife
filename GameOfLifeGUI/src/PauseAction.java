
/*4/16/19
 * 
 * The action that handles when the pause button is pressed. It pauses the mover thread
 * 
 * William Field
 */
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class PauseAction extends AbstractAction {

	private MoverThread mover;// moverthread used by the action

	public PauseAction(MoverThread mover) {// constructor
		this.mover = mover;
		this.putValue(NAME, "Pause");// naming the action pause
	}

	@Override
	public void actionPerformed(ActionEvent e) {// action performed when called
		// TODO Auto-generated method stub
		mover.pause();//pausing the MoverThread

	}
}
