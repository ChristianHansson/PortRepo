import java.awt.Color;
import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingComposite;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.model.Rect;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Model {
	private FileHandler filehandler = new FileHandler();

	public boolean isNewApp = true;
	public boolean getIsNewApp(){
		return this.isNewApp;
	}
	public void setIsNewApp(boolean in){
		this.isNewApp = in;
	}
	
	public void getLastDrawing(){
		if(getIsNewApp()){
			filehandler.getLastFileIfExists(this);
		}
	}
	public boolean isSaved = true;
	public void setIsSaved(boolean in){
		this.isSaved = in;
		System.out.println(getIsSaved());
	}
	public boolean getIsSaved(){
		return this.isSaved;
	}
	public Circle circle;
	public Circle setCircle(int x1, int y1, int w, int h, int width, Color lineColor, Color area){
		return new Circle(getUtil(), x1, y1, w, h, width, lineColor, area);
	}
	public Line line;
	public Line setLine(int x1, int y1, int x2, int y2, int width, Color color){
		return new Line(getUtil(), x1, y1, x2, y2, width, color);
	}
	public Rect rect;
	public Rect setRect(int x1, int y1, int w, int h, int width, Color lineColor, Color area){
		return new Rect(getUtil(), x1, y1, w, h, width, lineColor, area);
	}
	public DrawingContainer dc = new DrawingContainer();
	public DrawingContainer getContainer(){
		return dc;
	}
	public DrawingUtil da = new DrawingUtil();
	public DrawingUtil getUtil(){
		return da;
	}
	public void createCircle(int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		dc.add(setCircle(x1, y1, w, h, width, lineColor, area));
	}
	public void removeLastTempLine(){
		DrawingComposite e = dc.getV().lastElement();
		dc.remove(e);
	}
	public void removeLastDrawnFigure(){	
		DrawingComposite e = dc.getV().lastElement();
		dc.remove(e);
		setIsSaved(false);
	}
	public void createTempLine(int x1, int y1, int x2, int y2, int width, Color color){	
		dc.add(setLine(x1, y1, x2, y2, width, color));
	}
	public void createLine(int x1, int y1, int x2, int y2, int width, Color color){
		dc.add(setLine(x1, y1, x2, y2, width, color));
	}
	public void createRect(int x1, int y1, int w, int h, int width, Color lineColor, Color area){
		dc.add(setRect(x1, y1, w, h, width, lineColor, area));
		
	}
	public int convertColorToInt(Color inColor){
		return inColor.getRGB();
	}
	public Color convertIntToColor(int i){
		return new Color(i, true);
	}
	public void openImgFromFile(String path){
		try {
			resetModel();
			filehandler.getFileContent(path, this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveImgToFile(String path) {
		try {
			filehandler.saveImgToFile(path, dc.getV());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Color userSelectedColor;
	public void setUserColor(Color inColor) {
		userSelectedColor = inColor;
	}
	public Color getUserSelectedColor(){
		return (userSelectedColor != null) ? userSelectedColor : Color.BLUE;
	}
	public Color userSelectedFillColor;
	public void setUserFillcolor(Color inColor) {
		userSelectedFillColor = inColor;
	}
	public Color getUserSelectedFillColor(){
		return (userSelectedFillColor != null) ? userSelectedFillColor : Color.CYAN;
	}
	public void resetModel(){
		setIsSaved(true);
		dc.getV().clear();
	}
}
