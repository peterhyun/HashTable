package ds.test;

import java.io.StringReader;
import java.util.Scanner;

import ds.hash.HashTable;

public class Main {
	static int TableSize = 1009;
	private static final int ERROR = -1;
	private static final int CREATE = 0;
	private static final int INSERT = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		HashTable hashtable = new HashTable(TableSize);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			Integer key;
			int c1, c2, c3;
			
			switch(getCommandNum(cmd)){
			case CREATE:
				c1 = i_scanner.nextInt();
				c2 = i_scanner.nextInt();
				c3 = i_scanner.nextInt();
				// fill your code
				hashtable.Create(c1, c2, c3);
				break;
			case INSERT:
				key = (Integer)i_scanner.nextInt();
				// fill your code
				hashtable.Insert(key);
				break;
			case DELETE:
				key = (Integer)i_scanner.nextInt();
				// fill your code
				hashtable.Delete(key);
				break;
				
			case SEARCH:
				key = (Integer)i_scanner.nextInt();
				// fill your code
				hashtable.Search(key);
				break;
			}
			
			i_scanner.close();
		}
		
		scanner.close();
	}
	
	private static int getCommandNum(String cmd){
		if(cmd.equals("create"))
			return CREATE;
		else if(cmd.equals("insert"))
			return INSERT;
		else if(cmd.equals("delete"))
			return DELETE;
		else if(cmd.equals("search"))
			return SEARCH;
		else
			return ERROR;
	}

}
