import java.awt.Color;

import Interfaces.IStringInterface;
import se.kau.isgc08.lab4.model.DrawingContainer;

public class Controller implements IStringInterface{

	private MainView mv;
	public Model m;
	public Controller(){
		m = new Model();
		mv = new MainView(this);
		isNewApp();
		mv.runUi();
	}
	public DrawingContainer getContainer(){
		return m.getContainer();
	}
	public void addCircle(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		m.createCircle(x1,y1,w,h,width,lineColor,area);
	}
	public void addLine(int x1, int y1, int x2, int y2, int width, Color color){
		m.createLine(x1, y1, x2, y2, width, color);
	}
	public void addRect(int x1, int y1, int w, int h, int width, Color lineColor, Color area){
		m.createRect(x1, y1, w, h, width, lineColor, area);
	}
	public void saveImageTofile(String path) {
		if(path != null){			
			m.saveImgToFile(path);		
		}
	}
	public void openImageFromFile(String path) {
		if(path != null){
			m.openImgFromFile(path);
			mv.updateUi(USER_OPENS_FILE);
		}
	}
	public void setUserColor(Color inColor) {
		m.setUserColor(inColor);
		mv.updateUi(USER_SELECTED_COLOR);
	}
	public Color getUserColor() {
		return m.getUserSelectedColor();
	}
	public void setUserFillcolor(Color inColor){
		m.setUserFillcolor(inColor);
		mv.updateUi(USER_SELECTED_FILL_COLOR);
	}
	public Color getUserFillColor(){
		return m.getUserSelectedFillColor();
	}
	public void createTempLine(int x1, int y1, int x2, int y2, int width, Color color) {
		m.createTempLine(x1, y1, x2, y2, width, color);
	}
	public void removeLastTempLine() {
		m.removeLastTempLine();
	}
	public void setIsSaved(boolean b) {
		m.setIsSaved(b);
	}
	public boolean getIsSaved(){
		return m.getIsSaved();
	}
	public void exitApplication(){
		if(m.getIsSaved()){
			System.exit(1);
		}else{
			mv.askUserToSave(USER_EXIT_ASK_TO_SAVE);
		}
	}
	public void isNewApp(){
		if(m.getIsNewApp()){
			m.getLastDrawing();
			m.setIsNewApp(false);
		}
	}
	public void closeCurrentOpenImg() {
		if(m.getIsSaved() != true){
			mv.askUserToSave(USER_CLOSES_FILE_ASK_TO_SAVE);
		}else{
			resetModel();
			mv.updateUi(USER_CLOSES_FILE);
		}
	}
	public void regretLastFigure(){
		m.removeLastDrawnFigure();
	}
	public void resetModel(){
		m.resetModel();
		mv.updateUi(USER_CLOSES_FILE);
	}
	public static void main(String [] args){
		new Controller();
	}
}
