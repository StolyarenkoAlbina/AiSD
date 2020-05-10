//var 6 | DKrishen
import java.util.ArrayList;

//	 < class Vertex >
//
//	класс Вершин графа, хранящий
//	данные о размере конверта/открытки
//	данные о всех смежных вершинах и
//	информацию, была ли использованна 
//	эта вершина в обходе (применяю в медоде 
//	task для определения максимального
//	паросочетания)
//

public class Vertex{
	public char label;
	public Size size;
	public ArrayList<Vertex> adjList;
	public boolean used;

	public Vertex(char lab, double hight, double width){
		label = lab;
		size = new Size(hight, width);
		adjList = new ArrayList<Vertex>();
		used = false;
	}
}
