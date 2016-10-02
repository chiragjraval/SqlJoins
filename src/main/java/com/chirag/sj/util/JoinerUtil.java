package com.chirag.sj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import com.chirag.sj.annotations.JoinMethod;
import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.list.implementation.BasicFullOuterJoinerList;
import com.chirag.sj.list.implementation.BasicInnerJoinerList;
import com.chirag.sj.list.implementation.BasicLeftOuterJoinerList;
import com.chirag.sj.list.implementation.BasicRightOuterJoinerList;
import com.chirag.sj.list.interfaces.Selector;

public class JoinerUtil
{
	private static final BasicInnerJoinerList innerJoiner = new BasicInnerJoinerList();
	private static final BasicLeftOuterJoinerList leftOuterJoiner = new BasicLeftOuterJoinerList();
	private static final BasicRightOuterJoinerList rightOuterJoiner = new BasicRightOuterJoinerList();
	private static final BasicFullOuterJoinerList fullOuterJoiner = new BasicFullOuterJoinerList();
	
	public static <E, V, T> List<T> join(List<E> list1, List<V> list2, JoinType joinType, Selector<E, V, T> selector, Class<T> targetClass) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, JoinMethodNotFoundException, JoinMethodNotMatchingException
	{
		if(JoinType.INNER_JOIN.equals(joinType))
			return innerJoiner.join(list1, list2, selector);
		else if(JoinType.LEFT_OUTER_JOIN.equals(joinType))
			return leftOuterJoiner.join(list1, list2, selector);
		else if(JoinType.RIGHT_OUTER_JOIN.equals(joinType))
			return rightOuterJoiner.join(list1, list2, selector);
		else if(JoinType.FULL_OUTER_JOIN.equals(joinType))
			return fullOuterJoiner.join(list1, list2, selector);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <E> Class<E> getListGenericType(Collection<E> data)
	{
		if(data!=null && !data.isEmpty())
			return (Class<E>)data.iterator().next().getClass();
		else
			return null;
	}
	
	public static Method getClassJoinMethod(Class<?> class1, Class<?> joinClass)
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
