package com.chirag.sj.list.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;

public interface JoinableList<E> extends List<E>
{	
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
	
	/**
	 * This method is used to perform Right Outer Join with other List 
	 * @param joinList List to join of type V
	 * @param selector Selector from E,V into T
	 * @return Joins List of type E with list of type V and returns list of resultant type T
	 */
	public <V,T> JoinableList<T> rightOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException;
	
	/**
	 * This method is used to perform Full Outer Join with other List 
	 * @param joinList List to join of type V
	 * @param selector Selector from E,V into T
	 * @return Joins List of type E with list of type V and returns list of resultant type T
	 */
	public <V,T> JoinableList<T> fullOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException;
}
