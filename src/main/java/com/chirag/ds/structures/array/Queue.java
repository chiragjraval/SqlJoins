/**
 * 
 */
package com.chirag.ds.structures.array;

import com.chirag.ds.exceptions.QueueEmptyException;
import com.chirag.ds.exceptions.QueueFullException;

/**
 * This class represents Queue Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class Queue<T> {

	private Object[] arrayQueue;
	private int front, rear;
	private int queueSize;
	
	
	/**
	 * @param queueSize
	 */
	@SuppressWarnings("unchecked")
	public Queue(int queueSize)
	{
		super();
		this.arrayQueue = (T[]) new Object[queueSize];
		this.front = -1;
		this.rear = -1;
		this.queueSize = queueSize;
	}
	
	/**
	 * @param obj Data obj to be added to Queue
	 */
	public void add(T obj) throws QueueFullException
	{
		if(front!=-1 && rear!=-1 && front==rear)
		{
			throw new QueueFullException();
		}
		else
		{
			if(front==-1 && rear==-1)
				front = rear = 0;
			
			arrayQueue[front] = obj;
			front = (front+1)%queueSize;
		}
	}
	
	/**
	 * @return Data obj in Queue
	 */
	@SuppressWarnings("unchecked")
	public T remove() throws QueueEmptyException
	{
		T obj = null;
		
		if(rear==front && front==-1 && rear==-1)
		{
			obj = (T) arrayQueue[rear];
			arrayQueue[rear] = null;
			rear = (rear+1)%queueSize;
			
			if(rear==front)
				rear = front = -1;
		}
		else
		{
			throw new QueueEmptyException();
		}
		
		return obj;
	}
}
