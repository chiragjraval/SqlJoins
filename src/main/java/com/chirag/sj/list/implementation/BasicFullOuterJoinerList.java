package com.chirag.sj.list.implementation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.list.interfaces.JoinerList;
import com.chirag.sj.list.interfaces.Selector;

public class BasicFullOuterJoinerList implements JoinerList
{
	private BasicLeftOuterJoinerList leftOuterJoiner = new BasicLeftOuterJoinerList();
	private BasicRightOuterJoinerList rightOuterJoiner = new BasicRightOuterJoinerList();
	
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
