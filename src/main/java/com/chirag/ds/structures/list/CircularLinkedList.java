package com.chirag.ds.structures.list;

import com.chirag.ds.comparison.ComparisonHelper;
import com.chirag.ds.comparison.ComparisonType;
import com.chirag.ds.structures.list.model.TwoWayNode;

/**
 * This class represents CircularLinkedList Data Structure.
 * @param <T> Type of Data object
 * @author Chirag
 */
public class CircularLinkedList<T> {

	private TwoWayNode<T> head;
	
	
	/**
	 * This method initializes a CircularLinkedList with null Header 
	 */
	public CircularLinkedList() {
		this.head = null; 
	}
	
	/**
	 * This method initializes a CircularLinkedList with Header containing passed object 
	 * @param obj Initial header object
	 */
	public CircularLinkedList(T obj) {
		this.head = new TwoWayNode<T>(obj);
	}
	
	/**
	 * This method initializes a CircularLinkedList with passed node as header.<br/>
	 * This method will change next and prev pointer of the node and will set them to header.
	 * @param node Node obj to set as Header
	 */
	public CircularLinkedList(TwoWayNode<T> node) {
		this.head = node;
		this.head.setNext(head);
		this.head.setPrev(head);
	}
	
	
	/**
	 * @param obj Data obj to be added as Node
	 * @return true/false status for add operation 
	 */
	public boolean add(T obj)
	{
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return add(node);
	}
	
	/**
	 * @param node Object to be added as Node
	 * @return true/false status for add operation 
	 */
	public boolean add(TwoWayNode<T> node)
	{	
		if(head==null)
		{
			head = node;
			head.setNext(head);
			head.setPrev(head);
			return true;
		}
		else
		{
			TwoWayNode<T> temp = head;
			while(temp.getNext()!=head) temp = temp.getNext();
			
			node.setPrev(temp);
			node.setNext(head);
			head.setPrev(node);
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
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return remove(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Node to be removed from list
	 * @return true/false status for remove operation 
	 */
	public boolean remove(TwoWayNode<T> node)
	{	
		return remove(node, ComparisonType.NODE);
	}
	
	/**
	 * This method is used to remove node from list
	 * @param node Object to be removed from list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for remove operation
	 */
	private boolean remove(TwoWayNode<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else if(ComparisonHelper.compare(head, node, comType))
		{
			if(head.getNext()==head && head.getPrev()==head)
				head = null;
			else
			{
				head.getNext().setPrev(head.getPrev());
				head.getPrev().setNext(head.getNext());
				head = head.getNext();
			}
			
			return true;
		}
		else
		{
			TwoWayNode<T> temp = head;
			while(temp.getNext()!= null)
			{
				if(ComparisonHelper.compare(temp.getNext(), node, comType))
				{
					TwoWayNode<T> foundNode = temp.getNext();
					temp.setNext(foundNode.getNext());
					foundNode.getNext().setPrev(temp);
					return true;
				}
				else
					temp = temp.getNext();
			}
			
			return false;
		}
		
		
	}
	
	
	/**
	 * This method is used to verify that list contains Node with passed data obj 
	 * @param obj Data obj to be removed from list
	 * @return true/false status for existence status 
	 */
	public boolean contains(T obj)
	{
		TwoWayNode<T> node = new TwoWayNode<T>(obj);
		return contains(node, ComparisonType.DATA);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @return true/false status for existence status 
	 */
	public boolean contains(TwoWayNode<T> node)
	{	
		return contains(node, ComparisonType.NODE);
	}
	
	/**
	 * This method is used to verify that list contains passed Node
	 * @param node Node to be verify against list
	 * @param comType Value to indicate how comparison need to be done
	 * @return true/false status for existence status
	 */
	private boolean contains(TwoWayNode<T> node, ComparisonType comType)
	{
		if(head==null)
			return false;
		else
		{
			if(ComparisonHelper.compare(head, node, comType))
				return true;
			
			TwoWayNode<T> temp = head.getNext();
			while(temp!=head)
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
