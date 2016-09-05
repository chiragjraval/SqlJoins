package com.chirag.sj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.chirag.js.exceptions.JoinMethodNotFoundException;
import com.chirag.js.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.annotations.JoinMethod;
import com.chirag.sj.implementation.BasicInnerJoiner;
import com.chirag.sj.implementation.BasicLeftOuterJoiner;
import com.chirag.sj.interfaces.Selector;

public class JoinerUtil
{
	private static final BasicInnerJoiner innerJoiner = new BasicInnerJoiner();
	private static final BasicLeftOuterJoiner leftOuterJoiner = new BasicLeftOuterJoiner();
	
	public static <E, V, T> List<T> Join(List<E> list1, List<V> list2, JoinerType joinerType, Selector<E, V, T> selector) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		if(JoinerType.INNER_JOIN.equals(joinerType))
			return innerJoiner.join(list1, list2, selector);
		else if(JoinerType.LEFT_OUTER_JOIN.equals(joinerType))
			return leftOuterJoiner.join(list1, list2, selector);
		else
			return null;
	}
	
	public static Class<?> getListGenericType(List<?> list)
	{
		return list.iterator().next().getClass();
	}
	
	public  static Method getClassJoinMethod(Class<?> class1, Class<?> joinClass)
	{
		for (Method method : class1.getMethods())
		{
		 	JoinMethod joinMethodAnnotation = method.getAnnotation(JoinMethod.class);
		 	if(joinMethodAnnotation!=null && joinClass.equals(joinMethodAnnotation.joinClass()))
		 		return method;
		}
		return null;
	}
}
