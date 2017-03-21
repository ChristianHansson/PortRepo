package TicTacToeGame;

public class Main {
	public static void main (String[] args){
		Model _model = new Model();
		Control _control = new Control(_model);
		View _view = new View(_control);
		_model.addObserver(_view);
	}
}
