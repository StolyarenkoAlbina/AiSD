//var 6 | DKrishen

//	 < class Size >
//
//	класс размеров хранит
//	информацию о длинне и
//	и ширине открыток и 
//	конвертов 
//	(hight всегда >= width)
//

public class Size{
	double width;
	double hight;

	Size(double hight, double width){	
		if(hight > width){
			this.width = width;
			this.hight = hight;
		}
		else {
			this.width = hight;
			this.hight = width;
		}
	}
}
