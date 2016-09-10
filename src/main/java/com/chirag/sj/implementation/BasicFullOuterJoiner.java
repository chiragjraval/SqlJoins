package com.chirag.sj.implementation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.interfaces.Joiner;
import com.chirag.sj.interfaces.Selector;

public class BasicFullOuterJoiner implements Joiner
{
	private BasicLeftOuterJoiner leftOuterJoiner = new BasicLeftOuterJoiner();
	private BasicRightOuterJoiner rightOuterJoiner = new BasicRightOuterJoiner();
	
	@Override
	public <E, V, T> List<T> join(List<E> list1, List<V> list2, Selector<E, V, T> selector) throws JoinMethodNotFoundException, JoinMethodNotMatchingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		List<T> leftOuterJoinResult = leftOuterJoiner.join(list1, list2, selector);
		List<T> rightOuterJoinResult = rightOuterJoiner.join(list1, list2, selector);
		
		Set<T> fullOuterJoinSet = new HashSet<T>();
		fullOuterJoinSet.addAll(leftOuterJoinResult);
		fullOuterJoinSet.addAll(rightOuterJoinResult);
		
		return new ArrayList<T>(fullOuterJoinSet);
	}
}
