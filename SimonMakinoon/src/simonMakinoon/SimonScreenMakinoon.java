package simonMakinoon;

import java.awt.Color;

import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import partnerCodeInHerePlease.ButtonAnna;
import partnerCodeInHerePlease.MoveAnna;
import partnerCodeInHerePlease.ProgressAnna;
	
public class SimonScreenMakinoon extends ClickableScreen 
				implements Runnable {

	private TextLabel label;
    private double timeLeft;
	private ButtonInterfaceMakinoon[] button; 
	private ProgressInterfaceMakinoon progress; 
	private ArrayList<MoveInterfaceMakinoon> sequence;
	 
	private int roundNumber;
	private boolean acceptingInput;
	
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenMakinoon(int width, int height) {
		
		super(width, height);
		roundNumber = 0; 
		Thread app = new Thread(this);
		
		app.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> lst) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceMakinoon>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		lst.add(progress);
		lst.add(label);

	}

	private ProgressInterfaceMakinoon getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return new ProgressAnna();
	}

	private void addButtons() {
		 int numberOfButtons = 4 ; 
		 Color[] colorsArray = {Color.BLACK, Color.YELLOW, 
				 Color.RED,Color.BLUE};
		 button = new ButtonInterfaceMakinoon[numberOfButtons];
		 
		for (int i = 0; i < colorsArray.length; i++){ 
			button[i] = getAButton();
			final ButtonInterfaceMakinoon b = getAButton();
		
			button[i].setColor(colorsArray[i]);
			button[i].setX();
			button[i].setY();
			button[i].setAction(new Action(){

				public void act(){
					 if(acceptingInput){
						 Thread blink = new Thread(new Runnable(){

							 public void run(){
								 b.highlight(); 
								 try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 b.dim();
								 
							 }

						});
						 blink.start();
						 if(b == sequence.get(sequenceIndex).getButton()){
		                      sequenceIndex++;
		                  }else{
		                      gameOver();
		                      return;
		                  }
		                  if(sequenceIndex == sequence.size()){
		                      Thread nextRound = new Thread(SimonScreenMakinoon.this);
		                      nextRound.start();
		                  }
					 }
				}

				});
		}
		
		
	}

	protected void gameOver() {
		progress.gameOver();
		
	}

	private void setY(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setX(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setColor(Color black) {
		
		
	}

	private ButtonInterfaceMakinoon getAButton() {
		// TODO Auto-generated method stub
		return new ButtonAnna();
	}

	private MoveInterfaceMakinoon randomMove() {
		ButtonInterfaceMakinoon b = null;
		

		int rand = (int) (Math.random()* button.length); 
		if( rand != lastSelectedButton){
			b = button[rand]; 
			
		}
		//code that randomly selects a ButtonInterfaceX
		return getMove(b);
	}

	private MoveInterfaceMakinoon getMove(ButtonInterfaceMakinoon b) {
		// TODO Auto-generated method stub
		return new MoveAnna(b);
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
		
	}

	private void nextRound() {
      acceptingInput = false;
      
      roundNumber++;
      
      sequence.add(randomMove());
      
      progress.setRound(roundNumber);
      
      progress.setSequenceLength(sequence.size());
      
      changeText("Simon's turn!");
      
      label.setText("");
      
      playSequence();
      
      changeText("Your turn!!!");
      
      label.setText("");
      
      acceptingInput = true;
      
      sequenceIndex = 0;
		
	}

	private void playSequence() {
		ButtonInterfaceMakinoon b = null;
		for(MoveInterfaceMakinoon s: sequence){
			if(b!=null){
              b.dim();
          }
          b = s.getButton();
          b.highlight();
          try {
              Thread.sleep(800);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      b.dim();
     
	}

	private void changeText(String string) {
		
		try{
          label.setText(string);
          Thread.sleep(800);
		}catch(Exception e){
          e.printStackTrace();
		}
		
	}

}
