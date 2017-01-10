package simonMakinoon;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceMakinoon extends Clickable{


	void highlight();

	void setColor(Color color);

	void setX();

	void setY();

	void setAction(Action action);

	void dim();

	
	
}
