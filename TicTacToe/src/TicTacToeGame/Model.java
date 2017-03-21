package TicTacToeGame;

import java.util.Observable;

public class Model extends Observable {
	
	private boolean userTurn = true;
	
	public String[] combos;
	
	public void isUserTurn(){
		userTurn = true;
		setChanged();
		notifyObservers();
	}
	
	public void isAiTurn(){
		userTurn = false;
		setChanged();
		notifyObservers();
	}
	
	public boolean isItUsersTurn(){
		return userTurn;
	}
}
