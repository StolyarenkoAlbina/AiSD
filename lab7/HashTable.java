//var 6 | DKrishen

class HashTable {
	private String[] hashArray;
	private int arraySize;

	public HashTable() {
		arraySize = hashFunc("zz" + 1);
		hashArray = new String[arraySize];
	}
	public static int hashFunc(String key){
		return Integer.parseInt(key, 36);
	}
	public void print(){
		for(int i = 0; i < arraySize; i++)
			if(hashArray[i] != null)
				System.out.print(hashArray[i] + " ");
		System.out.println();
	}
	public void insert(String item){
		int index = hashFunc(item);

		while(hashArray[index] != null){
			index++;
			index %= arraySize;
		}
		hashArray[index] = item;
	}
	public int find(String key){
		int index = hashFunc(key);
		while(hashArray[index] != null){
			if(hashArray[index].equals(key))
				return index;
			index++;
			index %= arraySize;
		}
		return -1;
	}
}
