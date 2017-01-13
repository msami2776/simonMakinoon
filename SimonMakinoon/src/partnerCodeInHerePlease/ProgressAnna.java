package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;
import simonMakinoon.ProgressInterfaceMakinoon;

public class ProgressAnna extends Component implements ProgressInterfaceMakinoon {

	private String round;
	private String sequence;
	private boolean gameOver;

	public ProgressAnna() {
		super(60,60,100,50);
	}

	@Override
	public void setRound(int roundNumber) {
		// TODO Auto-generated method stub
		round = "Round "+roundNumber;
		update();
	}

	@Override
	public void setSequenceLength(int size) {
		// TODO Auto-generated method stub
		sequence = "Win Streak: "+size;
		update();
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver){
			g.setColor(Color.blue);
			g.fillRect(0, 0, 100, 50);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (100 - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (100 - fm.stringWidth(sequence))/2, 40);

		}else{
			g.setColor(Color.green);
			g.fillRect(0, 0, 100, 50);
			g.setColor(Color.black);
			g.drawRect(0, 0, 100-1, 50-1);
			if(round !=null && sequence != null){

				g.drawString(round, (100 - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (100 - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

}
