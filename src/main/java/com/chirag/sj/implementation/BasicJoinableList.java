package com.chirag.sj.implementation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.interfaces.JoinableList;
import com.chirag.sj.interfaces.Selector;

public class BasicJoinableList<E> implements JoinableList<E>
{
	private static final BasicInnerJoiner innerJoiner = new BasicInnerJoiner();
	private static final BasicLeftOuterJoiner leftOuterJoiner = new BasicLeftOuterJoiner();
	
	private List<E> data = null;
	
	public BasicJoinableList(List<E> data) {
		this.data = data;
	}
	
	@Override
	public List<E> getData() {
		return this.data;
	}
	
	@Override
	public <V, T> JoinableList<T> innerJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = innerJoiner.join(this.data, joinList.getData(), selector);
		return new BasicJoinableList<T>(result);
	}

	@Override
	public <V, T> JoinableList<T> leftOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = leftOuterJoiner.join(this.data, joinList.getData(), selector);
		return new BasicJoinableList<T>(result);
	}
}
