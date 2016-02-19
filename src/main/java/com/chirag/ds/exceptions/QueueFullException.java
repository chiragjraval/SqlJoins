package com.chirag.ds.exceptions;

/**
 * This class represents exception which occurs when Stack is full and we try to add Data to it
 * @author Chirag 
 */
public class QueueFullException extends Exception {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 6674379288246116066L;

	/**
	 * Default Constructor
	 */
	public QueueFullException() {
		super("Queue Full Exception");
	}

	/**
	 * @param message
	 */
	public QueueFullException(String message) {
		super("Queue Full Exception :: " + message);
	}

}
