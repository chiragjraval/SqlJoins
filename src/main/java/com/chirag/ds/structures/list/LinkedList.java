package com.chirag.ds.structures.list;

import com.chirag.ds.comparison.ComparisonHelper;
import com.chirag.ds.comparison.ComparisonType;
import com.chirag.ds.structures.list.model.Node;

/**
 * This class represents LinkedList Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class LinkedList<T> {

	private Node<T> head;
	
	
	/**
	 * This method initializes a LinkedList with null Header 
	 */
	public LinkedList() {
		this.head = null; 
	}
	
	/**
	 * This method initializes a LinkedList with Header containing passed object 
	 * @param obj Initial header object
	 */
	public LinkedList(T obj) {
		this.head = new Node<T>(obj);
	}
	
	/**
	 * This method initializes a LinkedList with passed node as header
	 * @param node Node obj to set as Header
	 */
	public LinkedList(Node<T> node) {
		this.head = node;
	}
	
	
	/**
	 * @param obj Data obj to be added as Node
	 * @return true/false status for add operation 
	 */
	public boolean add(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return add(node);
	}
	
	/**
	 * @param node Object to be added as Node
	 * @return true/false status for add operation 
	 */
	public boolean add(Node<T> node)
	{	
		if(head==null)
		{
			head = node;
			return true;
		}
		else
		{
			Node<T> temp = head;
			while(temp.getNext()!=null) temp = temp.getNext();
			temp.setNext(node);
			return true;
		}
	}
	
	/**
	 * This method is used to remove first node that matches passed data object 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for remove operation 
	 */
	public boolean remove(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return remove(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Node to be removed from list
	 * @return true/false status for remove operation 
	 */
	public boolean remove(Node<T> node)
	{	
		return remove(node, ComparisonType.NODE);
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Object to be removed from list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for remove operation
	 */
	private boolean remove(Node<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else if(ComparisonHelper.compare(head, node, comType))
		{
			head = head.getNext();
			return true;
		}
		else
		{
			Node<T> temp = head;
			while(temp.getNext()!= null)
			{
				if(ComparisonHelper.compare(temp.getNext(), node, comType))
				{
					temp.setNext(temp.getNext().getNext());
					return true;
				}
				else
					temp = temp.getNext();
			}
		}
		
		return false;
	}
	
	
	/**
	 * This method is used to verify that list contains Node with passed data obj 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for existence status 
	 */
	public boolean contains(T obj)
	{
		Node<T> node = new Node<T>(obj);
		return contains(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @return true/false status for existence status 
	 */
	public boolean contains(Node<T> node)
	{	
		return contains(node, ComparisonType.NODE);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for existence status
	 */
	private boolean contains(Node<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else
		{
			Node<T> temp = head;
			while(temp!=null)
			{
				if(ComparisonHelper.compare(temp, node, comType))
					return true;
				else
					temp = temp.getNext();
			}
		}
		
		return false;
	}
}
