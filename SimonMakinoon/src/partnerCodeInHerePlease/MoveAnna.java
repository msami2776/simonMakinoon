package partnerCodeInHerePlease;

import java.awt.Graphics2D;

import gui.components.Component;
import simonMakinoon.ButtonInterfaceMakinoon;
import simonMakinoon.MoveInterfaceMakinoon;

public class MoveAnna implements MoveInterfaceMakinoon {

	private ButtonInterfaceMakinoon y; 
	
	public void MoveAnna(ButtonInterfaceMakinoon y){
		this.y = y; 
	}
	@Override
	public ButtonInterfaceMakinoon getButton() {
		// TODO Auto-generated method stub
		return y; 
	}

	
}
