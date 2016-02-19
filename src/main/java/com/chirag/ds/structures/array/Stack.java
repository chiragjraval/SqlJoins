package com.chirag.ds.structures.array;

import com.chirag.ds.exceptions.StackEmptyException;
import com.chirag.ds.exceptions.StackFullException;

/**
 * This class represents Stack Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class Stack<T> {

	private Object[] arrayStack;
	private int top = 0;
	private int stackDepth;
	
	/**
	 * @param stackDepth Initial depth of Stack
	 */
	@SuppressWarnings("unchecked")
	public Stack(int stackDepth)
	{
		super();
		this.arrayStack = (T[]) new Object[stackDepth];
		this.top = 0;
		this.stackDepth = stackDepth;
	}
	
	
	/**
	 * @param obj Data obj to be added to Stack
	 */
	public void push(T obj) throws StackFullException
	{
		if(top==stackDepth)
		{
			throw new StackFullException();
		}
		else
		{
			arrayStack[top] = obj;
			top++;
		}
	}
	
	
	/**
	 * @return Data obj at top of Stack
	 */
	@SuppressWarnings("unchecked")
	public T pop() throws StackEmptyException
	{
		T obj = null;
		
		if(top==0)
		{
			throw new StackEmptyException();
		}
		else
		{
			top--;
			obj = (T) arrayStack[top];
			arrayStack[top] = null;
		}
		
		return obj;
	}
}
