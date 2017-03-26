import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import Interfaces.IStringInterface;
import se.kau.isgc08.lab4.view.DrawingPanel;

public class MainView extends JFrame implements IStringInterface{
/**
 * TODO: Fix automatic push of JAR-file so that its included to final lab turn-in.
 * */
	private Controller c;
	private DrawingPanel dp;
	private Color userColor, userFillColor;
	private JPanel wrapper,p, settings;
	private JButton b, userColorBtn, userFillColorBtn;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem items [];
	private BorderLayout l;
	/*Determine what figure to draw*/
	private String choice = "initial";
	
	public int circle_height, circle_width;
	public JTextField circle_height_field, circle_width_field, rect_height_field, 
	rect_width_field, rect_line_width, line_line_width;
	public Color maincolor;
	/*Listeners for MainView*/
	public ToolbarListener tbl;
	public PanelListener pl;
	
	public JFileChooser chooser;
	
	public MainView(Controller controller) {
		this.c = controller;
	}
	public Controller getController(){
		return this.c;
	}
	public void runUi() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				getController().exitApplication();
			}
		});
		l = new BorderLayout();
		tbl = new ToolbarListener();
		this.setJMenuBar(createMenuBar());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setSize(dimen());
		this.setLayout(l);
		
		wrapper = new JPanel(new GridLayout(2, 0));
		this.add(wrapper, l.NORTH);
		
		p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(Color.RED);
		wrapper.add(p);
		
		p.add(setToolbar());
		
		dp = new DrawingPanel(getController().getContainer());
		dp.setBackground(Color.WHITE);
		pl = new PanelListener();
		dp.addMouseListener(pl);
		dp.addMouseMotionListener(pl);
		
		this.add(dp, l.CENTER);
		dp.repaint();
	}
	public void askUserToSave(String what){
		if(what.equals(USER_EXIT_ASK_TO_SAVE)){			
			int i = JOptionPane.showConfirmDialog(this, "spara?", "spara", JOptionPane.YES_NO_CANCEL_OPTION);
			if(i == JOptionPane.YES_OPTION){
				showSaveFileDialog(what);
			}else if(i == JOptionPane.NO_OPTION){
				getController().setIsSaved(true);
				getController().exitApplication();
			}
		}else if(what.equals(USER_PRESSES_SAVE_CHOICE)){
			showSaveFileDialog(what);
		}else if(what.equals(USER_PRESSES_OPEN_CHOICE)){
			if(getController().getIsSaved()){
				showOpenFileDialog(what);
			}else{
				int i = JOptionPane.showConfirmDialog(this, "spara?", "spara", JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == JOptionPane.YES_OPTION){
					showSaveFileDialog(what);
				}else if(i == JOptionPane.NO_OPTION){
					showOpenFileDialog(NO_SAVE_OPEN_IMG);
				}
			}
		}else if(what.equals(USER_CLOSES_FILE_ASK_TO_SAVE)){
			int i = JOptionPane.showConfirmDialog(this, "Spara nuvarande fil?", "spara", JOptionPane.YES_NO_CANCEL_OPTION);
			if(i == JOptionPane.YES_OPTION){
				showSaveFileDialog(USER_CLOSES_FILE_ASK_TO_SAVE);
			}else if(i == JOptionPane.NO_OPTION){
				getController().resetModel();
			}
		}
	}
	public void showOpenFileDialog(String what){
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter ff =new FileNameExtensionFilter("text files", "txt");
		chooser.setFileFilter(ff);
		int s = chooser.showOpenDialog(this);
		switch(s){
		case JFileChooser.APPROVE_OPTION:
			File f = chooser.getSelectedFile();
			getController().openImageFromFile(f.getAbsolutePath());
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		}
		chooser = null;
	}
	public void showSaveFileDialog(String w){
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter ff =new FileNameExtensionFilter("text files", "txt");
		chooser.setFileFilter(ff);
		int s = chooser.showOpenDialog(this);
		switch(s){
		case JFileChooser.APPROVE_OPTION:
			File f = chooser.getSelectedFile();
			if(f.exists()){
				int res = JOptionPane.showConfirmDialog(this, OVERRIDE_SAVE_FILE);
				if(res == JOptionPane.YES_OPTION){
					getController().saveImageTofile(f.getAbsolutePath());
					getController().setIsSaved(true);
					if(w.equals(USER_EXIT_ASK_TO_SAVE)){						
						getController().exitApplication();
					}
					if(w.equals(USER_CLOSES_FILE_ASK_TO_SAVE)){
						getController().resetModel();
					}
				}
			}else{
				getController().saveImageTofile(f.getAbsolutePath());
				getController().setIsSaved(true);
				if(w.equals(USER_EXIT_ASK_TO_SAVE)){						
					getController().exitApplication();
				}
				if(w.equals(USER_CLOSES_FILE_ASK_TO_SAVE)){
					getController().resetModel();
				}
			}
			if(w.equals(USER_PRESSES_OPEN_CHOICE)){
				showOpenFileDialog(null);
			}
			break;
		case JFileChooser.CANCEL_OPTION:
			
			break;
			default: 
				break;
		}
		chooser = null;
	}
	private JMenuBar createMenuBar(){
		menubar = new JMenuBar();
		menu = new JMenu(MENU_CHOICE_ALTERNATIVE);
		menubar.add(menu);
		getAlternativeItems(menu);
		menu = new JMenu(MENU_CHOICE_FILE);
		menubar.add(menu);
		getFileAlternativeItems(menu);
		return (menubar != null) ? menubar : null;
	}
	private void getAlternativeItems(JMenu m){
		String menuText[] = {MENU_NEW,MENU_OPEN,MENU_CLOSE,MENU_SAVE,MENU_EXIT_APP};
		items = new JMenuItem[menuText.length];
		for (int i = 0; i < items.length; i++) {
			if(i == 3 || i == 4){
				m.addSeparator();
			}
			String label = menuText[i];
			items[i] = new JMenuItem(label);
			items[i].addActionListener(tbl);
			m.add(items[i]);
		}
	}
	private void getFileAlternativeItems(JMenu m){
		String menuText[] = {MENU_REGRET};
		items = new JMenuItem[menuText.length];
		for (int i = 0; i < items.length; i++) {
			if(i == 3 || i == 4){
				m.addSeparator();
			}
			String label = menuText[i];
			items[i] = new JMenuItem(label);
			items[i].addActionListener(tbl);
			m.add(items[i]);
		}
	}
	public void updateUi(String in) {
		switch(in){
		case USER_SELECTED_COLOR:
			userColor = getController().getUserColor();
			userColorBtn.setBackground(userColor);
			break;
		case USER_SELECTED_FILL_COLOR:
			userFillColor = getController().getUserFillColor();
			userFillColorBtn.setBackground(userFillColor);
			break;
		case USER_CLOSES_FILE:
			this.repaint();
			this.revalidate();
			break;
		case USER_OPENS_FILE:
			this.repaint();
			this.revalidate();
			break;
		case USER_REGRETS_LAST_FIGURE:
			getController().regretLastFigure();
			this.repaint();
			this.revalidate();
			break;
			default:
				break;
		}
	}
	private void setMiscSettings(String in){
		if(settings != null){
			wrapper.remove(settings);
			settings = null;
			this.revalidate();
		}
		if(settings == null){
			choice = in;
			settings = new JPanel(new FlowLayout(FlowLayout.LEFT));
			settings.setBackground(Color.GREEN);
			JToolBar toolBar = new JToolBar("bb");
			switch(in){
			case VIEW_USER_SELECTED_CIRCLE:
				toolBar.add(new JLabel(CIRCLE_STRING));
				toolBar.addSeparator();
				toolBar.add(new JLabel(HEIGHT_STRING));
				toolBar.addSeparator();
				circle_height_field = new JTextField(10);
				circle_height_field.setName(HEIGHT_STRING);
				toolBar.add(circle_height_field);
				toolBar.addSeparator(); 
				toolBar.add(new JLabel(WIDTH_STRING));
				toolBar.addSeparator();
				circle_width_field = new JTextField(10);
				circle_width_field.setName(WIDTH_STRING);
				toolBar.add(circle_width_field);
				toolBar.addSeparator(); 
				break;
			case VIEW_USER_SELECTED_LINE:
				toolBar.add(new JLabel(LINE_STRING));
				toolBar.addSeparator();
				toolBar.add(new JLabel("Tjocklek"));
				toolBar.addSeparator();
				line_line_width = new JTextField(10);
				line_line_width.setName(LINE_WIDTH);
				toolBar.add(line_line_width);
				toolBar.addSeparator(); 
				break;
			case VIEW_USER_SELECTED_RECT:
				toolBar.add(new JLabel(RECT_STRING));
				toolBar.addSeparator();
				toolBar.add(new JLabel(HEIGHT_STRING));
				toolBar.addSeparator();
				rect_height_field = new JTextField(10);
				rect_height_field.setName(HEIGHT_STRING);
				toolBar.add(rect_height_field);
				toolBar.addSeparator();
				toolBar.add(new JLabel(WIDTH_STRING));
				toolBar.addSeparator();
				rect_width_field = new JTextField(10);
				rect_width_field.setName(WIDTH_STRING);
				toolBar.add(rect_width_field);
				toolBar.addSeparator();
				toolBar.add(new JLabel(LINE_WIDTH));
				toolBar.addSeparator();
				rect_line_width = new JTextField(10);
				rect_line_width.setName(LINE_WIDTH);
				toolBar.add(rect_line_width);
				toolBar.addSeparator();
				break;
				default:
					break;
			}
			JButton close = new JButton(CLOSE_MISC);
			close.addActionListener(new ToolbarListener());
			toolBar.add(close);
			settings.add(toolBar);
			wrapper.add(settings);
			this.revalidate();
		}
		
	}
	public void closeMiscSettings(){
		wrapper.remove(settings);
		this.revalidate();
		this.repaint();
	}
	private JToolBar setToolbar(){
		JToolBar toolbar = new JToolBar("aa");
		btnFactory(toolbar);
		return toolbar;
	}
	private void btnFactory(JToolBar in){
		b = new JButton(CIRCLE_STRING);
		b.addActionListener(tbl);
		b.setFocusPainted(false);
		in.add(b);
		
		b = new JButton(LINE_STRING);
		b.addActionListener(tbl);
		b.setFocusPainted(false);
		in.add(b);
		
		b = new JButton(RECT_STRING);
		b.addActionListener(tbl);
		b.setFocusPainted(false);
		in.add(b);
		
		in.addSeparator();
		
		userColorBtn = new JButton(COLOR_STRING);
		userColorBtn.setFocusPainted(false);
		userColorBtn.addActionListener(tbl);
		userColorBtn.setBackground((userColor != null) ? userColor : null);
		in.add(userColorBtn);
		
		userFillColorBtn = new JButton(COLOR_FILL_STRING);
		userFillColorBtn.setFocusPainted(false);
		userFillColorBtn.addActionListener(tbl);
		userFillColorBtn.setBackground((userFillColor != null) ? userFillColor : null);
		in.add(userFillColorBtn);
		
	}	
	private Dimension dimen(){
		return new Dimension(900, 900);
	}
	private void addLineItem(int x1, int y1, int x2, int y2){
		try{
			validateAndDrawLine(choice, x1, y1, x2, y2);
		}catch(Exception e){
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage()+EMPTY_OR_NOT_ACCURATE);
		}
		
	}
	private boolean validateAndDrawLine(String f, int x1, int y1, int x2, int y2) throws Exception{
		if(f.equals(VIEW_USER_SELECTED_LINE)){
			if(!validateInt(line_line_width.getText().toString())){
				throw new Exception(LINE_WIDTH);
			}else{
				getController().addLine(
						x1, 
						y1, 
						x2, 
						y2, 
						Integer.parseInt(line_line_width.getText().toString()), 
						getController().getUserColor());
				dp.repaint();
				revalidate();
				return true;
			}
		}else{
			return false;
		}
	}
	/**
	 * method that attempts to draw a Circle and a Rect
	 * @param x = x-cordinates
	 * @param y = y-cordinates
	 * */
	private void addItem(int x, int y) {
		if(choice == null){
			JOptionPane.showMessageDialog(getContentPane(), USER_CHOOSE_FIGURE_TO_DRAW);
		} else
			try {
				validateAndDraw(choice, x, y);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(getContentPane(), e.getMessage()+EMPTY_OR_NOT_ACCURATE);
			}
	}
	/**
	 * Method called from addItem() that draws either a Circle or a Rect.
	 * Method validates the required input fields.
	 * @param f = choice ; what figure to draw
	 * @param x = x-cordinate on screen where to draw
	 * @param y = y-cordinate on screen where to draw
	 * */
	private boolean validateAndDraw(String f, int x, int y) throws Exception{
		if(f.equals(VIEW_USER_SELECTED_CIRCLE)){
			if(!validateInt(circle_height_field.getText().toString())){
				throw new Exception(HEIGHT_STRING);
			}
			if(!validateInt(circle_width_field.getText().toString())){
				throw new Exception(WIDTH_STRING);
			}
			else{
				getController().addCircle(
						x, 
						y, 
						Integer.parseInt(circle_width_field.getText().toString()),
						Integer.parseInt(circle_height_field.getText().toString()), 
						10, 
						getController().getUserColor(), 
						getController().getUserFillColor());
				getController().setIsSaved(false);
				this.repaint();
				this.revalidate();
				return true;
			}
			
		}
		if(f.equals(VIEW_USER_SELECTED_RECT)){
			if(!validateInt(rect_height_field.getText().toString())){
				throw new Exception(HEIGHT_STRING);
			}
			if(!validateInt(rect_width_field.getText().toString())){
				throw new Exception(WIDTH_STRING);
			}
			if(!validateInt(rect_line_width.getText().toString())){
				throw new Exception(LINE_WIDTH);
			}
			else{
				getController().addRect(
						x, 
						y, 
						Integer.parseInt(rect_width_field.getText().toString()), 
						Integer.parseInt(rect_height_field.getText().toString()), 
						Integer.parseInt(rect_line_width.getText().toString()), 
						getController().getUserColor(), 
						getController().getUserFillColor());
				getController().setIsSaved(false);
				this.repaint();
				this.revalidate();
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * Validation method. 
	 * @param String
	 * @return true if String = int ; false if String != int
	 * */
	private boolean validateInt(String in){
		try {
			int n = Integer.parseInt(in);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * Method that is called from DrawingPanel listener class. to validate when user is drawing a Line.
	 * */
	public boolean validateLineWidth(){
		try {
			int i = Integer.parseInt(line_line_width.getText().toString());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getContentPane(), LINE_WIDTH+EMPTY_OR_NOT_ACCURATE);
			return false;
		}
	}
	/**
	 * Button and menu listener class. This class only responds to buttons in the toolbar and the menu.
	 * New and Close are redundant - But often a standard for programs like this, left it there for that reason.
	 * */
 	class ToolbarListener implements ActionListener, IStringInterface{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			switch(s){
			case COLOR_STRING:
				getController().setUserColor(JColorChooser.showDialog(getContentPane(), "Välj färg", null));
				break;
			case COLOR_FILL_STRING:
				getController().setUserFillcolor(JColorChooser.showDialog(getContentPane(), "Välj färg", null));
				break;
			case CIRCLE_STRING:
				setMiscSettings(VIEW_USER_SELECTED_CIRCLE);
				break;
			case LINE_STRING:
				setMiscSettings(VIEW_USER_SELECTED_LINE);
				break;
			case RECT_STRING:
				setMiscSettings(VIEW_USER_SELECTED_RECT);
				break;
			case CLOSE_MISC:
				closeMiscSettings();
				break;
			case MENU_EXIT_APP:
				getController().exitApplication();
			case MENU_SAVE:
				askUserToSave(USER_PRESSES_SAVE_CHOICE);
				break;
			case MENU_OPEN:
				askUserToSave(USER_PRESSES_OPEN_CHOICE);
				break;
			case MENU_CLOSE:
				getController().closeCurrentOpenImg();
				break;
			case MENU_REGRET:
				updateUi(USER_REGRETS_LAST_FIGURE);
				break;
			case MENU_NEW:
				getController().closeCurrentOpenImg();
				break;
				default:
					break;
			}
		}
	}
 	/**
 	 * Listener class ; Both "click" class and a mousemotion class. This class only responds to the DrawingPanel object.
 	 * */
	class PanelListener implements MouseListener, MouseMotionListener{

		int initX, initY, endX, endY;
		public PanelListener() {
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			if(choice.equals(VIEW_USER_SELECTED_LINE)){
				if (validateLineWidth()) {					
					getController().removeLastTempLine();
					getController().createTempLine(initX, initY, e.getX(), e.getY(), 
							Integer.parseInt(line_line_width.getText().toString()), getController().getUserColor());
					dp.repaint();
					revalidate();
				}
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(choice.equals(VIEW_USER_SELECTED_CIRCLE)){
				addItem(e.getX(), e.getY());
			}
			else if(choice.equals(VIEW_USER_SELECTED_RECT)){
				addItem(e.getX(), e.getY());
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(choice.equals(VIEW_USER_SELECTED_LINE)){
				if(validateLineWidth()){					
					getController().setIsSaved(false);
					initX = e.getX();
					initY = e.getY();
					getController().createTempLine(initX, initY, e.getX(), e.getY(), 
							Integer.parseInt(line_line_width.getText().toString()), getController().getUserColor());
				}
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(choice.equals(VIEW_USER_SELECTED_LINE)){
				if (validateLineWidth()) {					
					dp.repaint();
					revalidate();
					getController().removeLastTempLine();
					addLineItem(initX, initY, e.getX(), e.getY());
				}
			}
		}	
	}
}
