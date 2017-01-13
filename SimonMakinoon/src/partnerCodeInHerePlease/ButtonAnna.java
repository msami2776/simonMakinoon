package partnerCodeInHerePlease;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;
import simonMakinoon.ButtonInterfaceMakinoon;

public class ButtonAnna extends Component implements ButtonInterfaceMakinoon {

	private Action action;
	private Color displayColor;
	private boolean highlight;
	private Color c;
	private String name;
	private static final int w = 50;
	private static final int h = 50;

	public ButtonAnna() {
		super(0,0,w,h);
		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		action.act();
	}

	@Override
	public boolean isHovered(int i, int j) {
		// TODO Auto-generated method stub
		double distance = Math.sqrt(Math.pow(i-(getX()+w/2), 2) + Math.pow(j-(getY()+h/2), 2));
		return distance < w/2;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		if(c != null) displayColor = c;
		highlight = true;
		update();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.c = color;
		displayColor = c;
		update();
	}

	@Override
	public void setX() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub
		this.action = action;
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		displayColor = Color.black;
		highlight = false;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null){ 
			g.setColor(displayColor);
		}
		else{ 
			g.setColor(Color.gray);
		}
		g.fillOval(0, 0, w, h);
		g.setColor(Color.black);
		g.drawOval(0, 0, w-1, h-1);
		if(highlight){
			g.setColor(Color.white);
			Polygon p = new Polygon();
			
			int s = (int)(5/8.0 * w);
			int t = (int)(1.0/5*h)+4;
			p.addPoint(s-4, t-4);
			p.addPoint(s+7, t-2);
			p.addPoint(s+10, t);
			p.addPoint(s+14, t+10);
			p.addPoint(s+12, t+14);
			p.addPoint(s+8, t+3);
			g.fill(p);
		}
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

}
