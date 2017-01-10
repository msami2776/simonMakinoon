package simonMakinoon;

import gui.GUIApplication;

public class SimonGameMakinoon extends GUIApplication {

	public SimonGameMakinoon(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenMakinoon sgms = new SimonScreenMakinoon(getWidth(), 
				getHeight());
		setScreen(sgms); 

	}

	public static void main(String[] args) {
		SimonGameMakinoon sgmg = new SimonGameMakinoon(800, 500);
		Thread game = new Thread(sgmg); 
		game.start();

	}

}
