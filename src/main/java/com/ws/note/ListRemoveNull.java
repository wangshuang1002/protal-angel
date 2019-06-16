package com.ws.note;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveNull {
	
	public static void main(String[] args) {  
	    List<Integer> arrays = new ArrayList<Integer>();  
	    arrays.add(2);  
	    arrays.add(null);  
	    arrays.add(456);  
	    arrays.add(null);  
	    arrays.add(789);  
	    List<Integer> nullArr = new ArrayList<Integer>();  
	    nullArr.add(null);  
	    arrays.removeAll(nullArr);  
	    System.out.println(arrays);  
	} 

}
