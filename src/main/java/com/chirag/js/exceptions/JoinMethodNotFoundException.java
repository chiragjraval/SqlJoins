package com.chirag.js.exceptions;

public class JoinMethodNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1551443650470409536L;

	/**
	 * Default Constructor
	 */
	public JoinMethodNotFoundException()
	{
		super("Join Method not found");
	}
	
	/**
	 * @param c1 Class in which Join Method should exist
	 * @param c2 Class for which Join Method should exist in c1
	 */
	public JoinMethodNotFoundException(Class<?> c1, Class<?> c2)
	{
		super("Join Method not found for " + c2.getName() + " in Class " + c1.getName());
	}
}
