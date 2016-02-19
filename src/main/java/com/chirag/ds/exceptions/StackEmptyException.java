package com.chirag.ds.exceptions;

/**
 * This class represents exception which occurs when Stack is empty and we try to get Data from it
 * @author Chirag 
 */
public class StackEmptyException extends Exception {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 6674379288246116066L;

	/**
	 * Default Constructor
	 */
	public StackEmptyException() {
		super("Stack Empty Exception");
	}

	/**
	 * @param message
	 */
	public StackEmptyException(String message) {
		super("Stack Empty Exception :: " + message);
	}

}
