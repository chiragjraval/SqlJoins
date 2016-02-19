package com.chirag.ds.structures.array;

import com.chirag.ds.exceptions.StackEmptyException;
import com.chirag.ds.exceptions.StackFullException;
import com.chirag.ds.structures.array.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<Integer>(2);
		
		try {
			intStack.push(1);
			intStack.push(2);
			System.out.println(intStack.pop());
			System.out.println(intStack.pop());
			System.out.println(intStack.pop());
		} catch(StackFullException ex) {
			ex.printStackTrace();
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
