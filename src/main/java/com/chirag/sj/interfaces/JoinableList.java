package com.chirag.sj.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.chirag.js.exceptions.JoinMethodNotFoundException;
import com.chirag.js.exceptions.JoinMethodNotMatchingException;

public interface JoinableList<E>
{
	/**
	 * @return Data setup into Joinable List
	 */
	public List<E> getData();
	
	/**
	 * This method is used to perform Inner Join with other List 
	 * @param joinList List to join of type V
	 * @param selector Selector from E,V into T
	 * @return Joins List of type E with list of type V and returns list of resultant type T
	 */
	public <V,T> JoinableList<T> innerJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException;
	
	/**
	 * This method is used to perform Left Outer Join with other List 
	 * @param joinList List to join of type V
	 * @param selector Selector from E,V into T
	 * @return Joins List of type E with list of type V and returns list of resultant type T
	 */
	public <V,T> JoinableList<T> leftOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException;
}
