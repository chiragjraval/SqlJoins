package com.chirag.ds.exceptions;

/**
 * This class represents exception which occurs when Stack is empty and we try to get Data from it
 * @author Chirag 
 */
public class QueueEmptyException extends Exception {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 6674379288246116066L;

	/**
	 * Default Constructor
	 */
	public QueueEmptyException() {
		super("Queue Empty Exception");
	}

	/**
	 * @param message
	 */
	public QueueEmptyException(String message) {
		super("Queue Empty Exception :: " + message);
	}

}
