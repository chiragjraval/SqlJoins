package com.chirag.sj.list.implementation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.list.interfaces.JoinableList;
import com.chirag.sj.list.interfaces.Selector;

public class BasicJoinableList<E> extends ArrayList<E> implements JoinableList<E>
{
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -8608685281766384341L;
	
	private static final BasicInnerJoinerList innerJoiner = new BasicInnerJoinerList();
	private static final BasicLeftOuterJoinerList leftOuterJoiner = new BasicLeftOuterJoinerList();
	private static final BasicRightOuterJoinerList rightOuterJoiner = new BasicRightOuterJoinerList();
	private static final BasicFullOuterJoinerList fullOuterJoiner = new BasicFullOuterJoinerList();
		
	public BasicJoinableList(List<E> data) {
		super(data);
	}
	
	@Override
	public <V, T> JoinableList<T> innerJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = innerJoiner.join(this, joinList, selector);
		return new BasicJoinableList<T>(result);
	}

	@Override
	public <V, T> JoinableList<T> leftOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = leftOuterJoiner.join(this, joinList, selector);
		return new BasicJoinableList<T>(result);
	}

	@Override
	public <V, T> JoinableList<T> rightOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = rightOuterJoiner.join(this, joinList, selector);
		return new BasicJoinableList<T>(result);
	}

	@Override
	public <V, T> JoinableList<T> fullOuterJoin(JoinableList<V> joinList, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		List<T> result = fullOuterJoiner.join(this, joinList, selector);
		return new BasicJoinableList<T>(result);
	}
}
