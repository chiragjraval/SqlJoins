package com.chirag.js.exceptions;

public class JoinMethodNotMatchingException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5440402830733572734L;

	/**
	 * Default Constructor
	 */
	public JoinMethodNotMatchingException()
	{
		super("Join Method not matching");
	}
	
	/**
	 * @param c1 Class 1 type
	 * @param c2 Class 2 type
	 */
	public JoinMethodNotMatchingException(Class<?> c1, Class<?> c2)
	{
		super("Join Method not matching for " + c1.getName() + " and " + c2.getName());
	}
	
}
