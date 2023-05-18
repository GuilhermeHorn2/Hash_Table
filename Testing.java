package misc;

import java.util.ArrayList;
import java.util.Scanner;


public class main_misc2 {
	
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
	   Hash_Table<String,Integer> h = new Hash_Table<>();
	   h.add("a", 1);
	   h.add("a", 2);
	   h.check_data("a");
	   int x = h.get_data("a", 1);
	   System.out.println();
	   System.out.println(x);
	   x = h.get_data("a");
	   System.out.println(x);
	
	}	
	
	} 
	
