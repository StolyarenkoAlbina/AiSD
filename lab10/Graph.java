//var 6 | DKrishen
import java.util.ArrayList;

//	 < class Graph >
//	
//	автор задачи (Котов)
//	рекомендовал решать
//	её через двудольный граф,
//	поэтому я храню граф в памяти
//	в виде двух листов, каждый из
//	которых представляет собой одну
//	из долей графа. (а не в виде
//	матрицы смежности, как обычно 
//	делают при реализации графов)
//	



public class Graph{
	
	//	Одна доля графа - открытки
	//	вторая - конверты

	private ArrayList<Vertex> envelopesList;
	private ArrayList<Vertex> postcardsList;

	public Graph(){
		envelopesList = new ArrayList<Vertex>();
		postcardsList = new ArrayList<Vertex>();
	}

	//	 < базовые методы >
	//	
	//	методы addEnvelope() и
	//	addPostcard() добавляют
	//	в граф вершины в соответсвующие
	//	доли. метод findEnvelope()
	//	проверяет, есть ли в графе 
	//	вершина с таким именем и если да
	//	то возвращает её, если нет - 
	//	возвращает нулевую.
	//	

	void addEnvelope(char lab, double hight, double width){ //	добавить конверт
		envelopesList.add(new Vertex(lab, hight, width));
	}
	void addPostcard(char lab, double hight, double width){ //	добавить открытку
		postcardsList.add(new Vertex(lab, hight, width));
	}
	Vertex findEnvelope(char lab){	//	найти конверт
		for(int i = 0; i < envelopesList.size(); i++){
			if (envelopesList.get(i).label == lab) return envelopesList.get(i);
		}
		return new Vertex('0', 0, 0);
	}

	//	 < создание рёбер >
	//	
	//	метод createEdges() создаёт
	//	рёбра между вершинами разных
	//	долей графа в том случае, если
	//	открытка помещается в конверт
	//	
	//	для проверки на это вначале мы
	//	проверяем, вмещается ли открытка
	//	линейно, если нет, то делаем поворот
	//
	//	Без алхимии и лёгкой магии
	//	сложно объяснить, как работает 
	//	данная формула, поэтому прикреплю
	//	фото с илюстрированным доказательством
	//	всей тригонометрии, а пока что держите
	//	моего друга кролика:
	//	
	//	  +		  x				*		  
	//				(\ /)	*			*
	//		*		(*•*)		  +		 
	//			x	(")(")			*	
	//	< я кролик по имени Шон и я говорю мяу >
	//

	void createEdges(){
		for(int i = 0; i < envelopesList.size(); i++)
			envelopesList.get(i).adjList = new ArrayList<Vertex>();
		for(int i = 0; i < postcardsList.size(); i++)
			postcardsList.get(i).adjList = new ArrayList<Vertex>();

		for(int i = 0; i < envelopesList.size(); i++)
			for(int j = 0; j < postcardsList.size(); j++){
				double diag = Math.sqrt(postcardsList.get(j).size.width*postcardsList.get(j).size.width +
							  postcardsList.get(j).size.hight*postcardsList.get(j).size.hight);
				double k = envelopesList.get(i).size.hight / diag;
				if ((postcardsList.get(j).size.width <= envelopesList.get(i).size.width &&
					 postcardsList.get(j).size.hight <= envelopesList.get(i).size.hight) || (
					 postcardsList.get(j).size.width * k + Math.sqrt(postcardsList.get(j).size.hight *
					 postcardsList.get(j).size.hight - k*diag*k*diag)
					 <= envelopesList.get(i).size.width)){
						envelopesList.get(i).adjList.add(postcardsList.get(j));
						postcardsList.get(j).adjList.add(envelopesList.get(i));
				}
			}
	}

	//	 < вывод данных >
	//	
	//	методы printEdges() и 
	//	printVertex() выводят
	//	в консоль данные о
	//	вершинах каждой из долей
	//	и информацию о том,
	//	какие вершины между
	//	собой смежны
	//	

	void printEdges(){
		System.out.print("\tEdges:\n\t");
		for(int i = 0; i < postcardsList.size(); i ++)
			for(int j = 0; j < postcardsList.get(i).adjList.size(); j++)
				System.out.print(postcardsList.get(i).label + "-" + postcardsList.get(i).adjList.get(j).label + " ");
	
		System.out.println();
	}
	void printVertex(){
		System.out.print("\tEnvelopes:\n\t");
		for(int i = 0; i < envelopesList.size(); i++)
			System.out.print(envelopesList.get(i).label + " ");
		System.out.println();
		
		System.out.print("\tpostcards:\n\t");
		for(int i = 0; i < postcardsList.size(); i++)
			System.out.print(postcardsList.get(i).label + " ");
		System.out.println();
	}

	//	 < нахождение максимального паросочетания >
	//	
	//	Котов (автор задачи) 
	//	рекомендовал находить 
	//	максимальное паросочетание
	//	с помощью алгоритма Куна, 
	//	но так как я существо ленивое
	//	для того,что бы разбирать чей-то
	//	алгоритм - я написал свой.
	//	
	//	Мы выбираем первую открытку 
	//	и вкладываем её в первый конверт,
	//	в который она помещает (с вершиной
	//	которога смежна вершина открытки),
	//	и вычёркиваем этот конверт из свободных.
	//	далее повторяем операцию для второй 
	//	открытки. 
	//	
	//	Если у какой-либо открытки нет смежных
	//	вершин, то мы возвращаемся на уровень
	//	выше (к предыдущей открытке) и меняем
	//	для неё конверт. Если у нас не будет 
	//	комбинации, при которой все открытки
	//	можно разложить по конвертам, то
	//	возвращаем false, в ином случае 
	//	возвращаем true
	//	

	boolean task(int i){
		boolean temp = false;
		ArrayList<Integer> tempIndex = new ArrayList<Integer>();

		for(int j = 0; j < postcardsList.get(i).adjList.size(); j++){
			if(!findEnvelope(postcardsList.get(i).adjList.get(j).label).used){
				if(i == postcardsList.size() - 1) return true;
				else {

					for(int k = 0; k < envelopesList.size();k++){
						if (envelopesList.get(k).label == postcardsList.get(i).adjList.get(j).label) {
							tempIndex.add(k);
							envelopesList.get(k).used = true;
						}
					}
					temp = task(i+1);
				}
			}
			if(temp == true) return true;
			else 
				for(int k = 0; k < tempIndex.size(); k++)
					envelopesList.get(tempIndex.get(k)).used = false;
		}
		return temp;
	}
}
