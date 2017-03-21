package TicTacToeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Control implements ActionListener {
	
	
	private Model _model;
	
	public Control(Model inModel){
		_model = inModel;
	}

	public void actionPerformed(ActionEvent a) {
		
		JButton temp = (JButton) a.getSource();
		
		//temp.setText("X");
		
		System.out.println(temp);
		
		if(_model.isItUsersTurn()){
			temp.setText("X");
			_model.isAiTurn();
			temp.setEnabled(false);
		}else{
			temp.setText("O");
			_model.isUserTurn();
			temp.setEnabled(false);
		}
		
	}
}
