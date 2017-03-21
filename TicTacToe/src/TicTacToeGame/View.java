package TicTacToeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame implements Observer{
	
	private JPanel panelCenter, panelTop, panelBottom, gameBoard;
	private JLabel gameTurn;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private ArrayList<JButton> test = new ArrayList<JButton>();
	private Control _control;
	public View(Control inControl){
		//setStructure(this);
		_control = inControl;
		
		setVisible(true);
		setSize(400,500);
		this.setLayout(new BorderLayout());
		panelTop = new JPanel();
		panelTop.setBackground(Color.red);
		add(panelTop, BorderLayout.NORTH);
		
		panelCenter = new JPanel();
		
		
		add(panelCenter, BorderLayout.CENTER);
		gameBoard = new JPanel();
		GridLayout grid = new GridLayout(3,3);
		gameBoard.setLayout(grid);
		gameBoard.setBackground(Color.blue);
		panelCenter.add(gameBoard, grid);
		
		
		for(int i = 0; i < 8; i++){
			JButton n1 = new JButton("n1");
			test.add(n1);
		}
		for(int q = 0; q < 8; q++){
			gameBoard.add(test.get(q));
		}
		
		
		
		
		
		
		
		
		//setButtons(gameBoard);
		
		//pack();
		
		
		
		/*GridBagLayout gb = new GridBagLayout();
		GridBagConstraints g = new GridBagConstraints();

		this.setLayout(gb);
		this.setVisible(true);
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.RED);
		panelCenter.setPreferredSize(new Dimension(200,200));
		g.gridx = 0;
		g.gridy = 1;
		this.add(panelCenter, g);
		
		for(int i = 0; i < 9; i++){
			b = new JButton("-");
			b.setPreferredSize(new Dimension(50,50));
			b.addActionListener(_control);
			panelCenter.add(b);
		}
		
		panelTop = new JPanel();
		panelTop.setBackground(Color.GRAY);
		panelTop.setPreferredSize(new Dimension(200,30));
		g.gridx = 0;
		g.gridy = 0;		
		this.add(panelTop, g);
		gameTurn = new JLabel();
		gameTurn.setText("Användarens tur");
		panelTop.add(gameTurn);
		panelBottom = new JPanel();
		panelBottom.setBackground(Color.YELLOW);
		panelBottom.setPreferredSize(new Dimension(200,30));
		g.gridx = 0;
		g.gridy = 2;
		this.add(panelBottom, g);
		JTextField te = new JTextField();
		te.setSize(20,20);
		panelBottom.add(te);
		this.pack();*/
		
	}
	public void setButtons(JPanel board){
		b1 = new JButton("-");
		b1.setPreferredSize(new Dimension(50,50));
		b1.addActionListener(_control);
		b2 = new JButton("-");
		b2.setPreferredSize(new Dimension(50,50));
		b2.addActionListener(_control);
		b3 = new JButton("-");
		b3.setPreferredSize(new Dimension(50,50));
		b4 = new JButton("-");
		b4.setPreferredSize(new Dimension(50,50));
		b5 = new JButton("-");
		b5.setPreferredSize(new Dimension(50,50));
		b6 = new JButton("-");
		b6.setPreferredSize(new Dimension(50,50));
		b7 = new JButton("-");
		b7.setPreferredSize(new Dimension(50,50));
		b8 = new JButton("-");
		b8.setPreferredSize(new Dimension(50,50));
		b9 = new JButton("-");
		b9.setPreferredSize(new Dimension(50,50));
		board.add(b1);
		board.add(b2);
		board.add(b3);
		board.add(b4);
		board.add(b5);
		board.add(b6);
		board.add(b7);
		board.add(b8);
		board.add(b9);
		
	}
	
	public void setStructure(JFrame frame){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
		frame.add(panelTop, BorderLayout.NORTH);
		panelBottom = new JPanel();
		panelBottom.setBackground(Color.WHITE);
		frame.add(panelBottom, BorderLayout.SOUTH);
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(3,3));
		panelCenter.setBackground(Color.GRAY);
		panelCenter.setPreferredSize(new Dimension(300,200));
		frame.add(panelCenter, BorderLayout.CENTER);
		setButtons(panelCenter);
		frame.pack();
	}
	
	public void update(Observable o, Object arg) {
		
	}
}
