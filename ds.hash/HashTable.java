package ds.hash;

public class HashTable {
	Integer[] table;
	int c1, c2, c3;
	int marker = -1; // special marker for deletion
	
	public HashTable(int n) {
		// fill your code
		table = new Integer[n];
	}

	public void Create(int c1, int c2, int c3){
		// fill your code
		if( c1==0 && c2==0 && c3 == 0 )	//not allowed
			return;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	
	private int hash(Integer key) {
		return key%1009;
	}
	
	private int p(Integer k, Integer i) {
		return c1*i*i+c2*i+c3;
	}
	
	public void Insert(Integer key){
		// fill your code
		int home=0;
		int finalPos = home = hash(key);
		for(int i=1;table[finalPos] != null && table[finalPos] != -1;i++) {
			finalPos = (home + p(key,i)) % table.length;
			if(table[finalPos] != null && table[finalPos].compareTo(key)==0) {
				System.out.println("Duplicate keys are not allowed for insertion.");
				return;
			}
		}
		table[finalPos] = key;
		System.out.println("INSERT: "+key+" / "+"INDEX: "+finalPos);
	}

	public void Delete(Integer key){
		// fill your code
		int home = 0;
		int finalPos = home = hash(key);
		boolean foundit = false;
		for(int i=1;table[finalPos]!=null;i++) {	//if it's null, then it means that you should end your search.
			if(table[finalPos].compareTo(key)==0) {
				foundit = true;
				break;
			}
			finalPos = (home + p(key,i)) % table.length;
		}
		if(foundit) {
			table[finalPos] = marker;
			System.out.println("DELETE: "+key+" / "+"INDEX: "+finalPos);
		}
		else {
			System.out.println("Failed to find "+key+".");
		}
	}
	
	public void Search(Integer key){
		int home = 0;
		int finalPos = home = hash(key);
		boolean foundit = false;
		for(int i=1;table[finalPos]!=null;i++) {	//if it's null, then it means that you should end your search.
			//System.out.println("for "+key+" finalPos is "+finalPos);
			if(table[finalPos].compareTo(key)==0) {
				foundit = true;
				break;
			}
			finalPos = (home + p(key,i)) % table.length;
		}
		if(foundit) {
			System.out.println("SEARCH: "+key+" / "+"INDEX: "+finalPos);
		}
		else {
			System.out.println("Failed to find "+key+".");
		}
	}
}
