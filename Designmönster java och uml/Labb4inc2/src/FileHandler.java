import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import se.kau.isgc08.lab4.model.DrawingComposite;
import se.kau.isgc08.lab4.model.DrawingContainer;

public class FileHandler implements Serializable{
	
	private final String indexPath = System.getProperty("user.home")+"\\lastfile";
	
	private String lastFile = null;
	private BufferedWriter bw;
	private BufferedReader br;
	public FileHandler() {}
	public void saveLastFileName(String path){
		try {
			bw = new BufferedWriter(new FileWriter(createIfNoFile(indexPath)));
			bw.write(path);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getLastFileIfExists(Model m){
		try{
			if(indexFileExist()){				
				br = new BufferedReader(new FileReader(indexPath+".txt"));
				String i;
				while((i = br.readLine()) != null){
					if(i.contains(".txt")){						
						lastFile = i;
					}else{
						lastFile = i+".txt";
					}
				}
				br.close();
				br = new BufferedReader(new FileReader(lastFile));
				String ii;
				while((ii = br.readLine()) != null){
					String delims = "[:]";
					String it[] = ii.split(delims);
					switch(it[0]){
					case "Line":
						m.createLine(conToInt(it[1]),conToInt(it[2]),conToInt(it[3]),conToInt(it[4]),conToInt(it[5]),
								new Color(Integer.valueOf(it[6]))
								);
						break;
					case "Circle":
						m.createCircle(conToInt(it[1]),conToInt(it[2]),conToInt(it[3]),conToInt(it[4]),conToInt(it[5]), 
								new Color(Integer.valueOf(it[6])), 
								new Color(Integer.valueOf(it[7])));
						break;
					case "Rect":
						m.createRect(conToInt(it[1]),conToInt(it[2]),conToInt(it[3]),conToInt(it[4]),conToInt(it[5]), 
								new Color(Integer.valueOf(it[6])), 
								new Color(Integer.valueOf(it[7])));
						break;
					}
				}
			}else{
				System.out.println("file doesnt exist");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private boolean indexFileExist(){
		File f = new File(indexPath+".txt");
		if(f.exists()){
			return true;
		}else{
			return false;
		}
	}
	
	private int conToInt(String in){
		return Integer.parseInt(in);
	}
	public void getFileContent(String path, Model m) throws Exception{
		try {
			br = new BufferedReader(new FileReader(path));
			String i;
			while((i = br.readLine()) != null){
				String delims = "[:]";
				String it[] = i.split(delims);
				switch(it[0]){
				case "Line":
					m.createLine(
							conToInt(it[1]), 
							conToInt(it[2]), 
							conToInt(it[3]), 
							conToInt(it[4]), 
							conToInt(it[5]),
							new Color(Integer.valueOf(it[6]))
							);
					break;
				case "Circle":
					m.createCircle(
							conToInt(it[1]), 
							conToInt(it[2]), 
							conToInt(it[3]), 
							conToInt(it[4]), 
							conToInt(it[5]), 
							new Color(Integer.valueOf(it[6])), 
							new Color(Integer.valueOf(it[7])));
					break;
				case "Rect":
					m.createRect(
							conToInt(it[1]), 
							conToInt(it[2]), 
							conToInt(it[3]), 
							conToInt(it[4]), 
							conToInt(it[5]), 
							new Color(Integer.valueOf(it[6])), 
							new Color(Integer.valueOf(it[7])));
					break;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveImgToFile(String path,Vector<DrawingComposite> p) throws Exception{
		bw = new BufferedWriter(new FileWriter(createIfNoFile(path)));
		DrawingComposite t;
		Enumeration<DrawingComposite> e=p.elements();
		while(e.hasMoreElements()) {
			t= e.nextElement();
			switch(t.getClass().getSimpleName()){
			case "Line":
				String printLine =
				t.getClass().getSimpleName()+":"+
						t.getX1()+":"+
						t.getY1() +":"+ 
						t.getWidth()+":"+ 
						t.getHeight()+":"+
						t.getLineWidth()+":"+
						t.getLineColor().getRGB()+
						System.getProperty("line.separator");
				bw.write(printLine);
				break;
			case "Circle":
				String printCircle = 
					t.getClass().getSimpleName()+":"+
						t.getX1()+":"+
						t.getY1()+":"+
						t.getWidth()+":"+
						t.getHeight()+":"+
						t.getLineWidth()+":"+
						t.getLineColor().getRGB()+":"+
						t.getAreaColor().getRGB()+
						System.getProperty("line.separator");
				bw.write(printCircle);
				break;
			case "Rect":
				String printRect = 
					t.getClass().getSimpleName()+":"+
					t.getX1()+":"+
					t.getY1()+":"+
					t.getWidth()+":"+
					t.getHeight()+":"+
					t.getLineWidth()+":"+
					t.getLineColor().getRGB()+":"+
					t.getAreaColor().getRGB()+
					System.getProperty("line.separator")
				;
				bw.write(printRect);
				break;
				default: break;
			}
		}
		bw.close();
		saveLastFileName(path);
	}
	private File createIfNoFile(String path){
		File f = new File(path);
		File s = null;
		if(f.exists()){
			return f;
		}else{
			try{
				f.delete();
				s = new File(path+".txt");
				s.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
			return s;
		}
	}
}
