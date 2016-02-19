package com.chirag.ds.exceptions;

/**
 * This class represents exception which occurs when Stack is full and we try to add Data to it
 * @author Chirag 
 */
public class StackFullException extends Exception {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 6674379288246116066L;

	/**
	 * Default Constructor
	 */
	public StackFullException() {
		super("Stack Full Exception");
	}

	/**
	 * @param message
	 */
	public StackFullException(String message) {
		super("Stack Full Exception :: " + message);
	}

}
