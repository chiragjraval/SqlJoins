package com.chirag.sj.list.implementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.list.interfaces.JoinerList;
import com.chirag.sj.list.interfaces.Selector;
import com.chirag.sj.util.JoinerUtil;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class BasicRightOuterJoinerList implements JoinerList
{
	@Override
	public <E, V, T> List<T> join(List<E> list1, List<V> list2, Selector<E, V, T> selector) throws JoinMethodNotFoundException, JoinMethodNotMatchingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		if(list1==null || list1.isEmpty() || selector==null)
			throw new NullPointerException();
		
		List<T> result = new ArrayList<T>(list1.size());
		
		if(list2==null || list2.isEmpty())
		{
			for (E list1Obj : list1)
				result.add(selector.select(list1Obj, null));
			
			return result;
		}
		
		Class<?> class1 = JoinerUtil.getListGenericType(list1);
		Class<?> class2 = JoinerUtil.getListGenericType(list2);
		
		Method c1JoinMethod = JoinerUtil.getClassJoinMethod(class1, class2);
		Method c2JoinMethod = JoinerUtil.getClassJoinMethod(class2, class1);
		
		if(c1JoinMethod==null)
			throw new JoinMethodNotFoundException(class1, class2);
		if(c2JoinMethod==null)
			throw new JoinMethodNotFoundException(class2, class1);
		
		if(!c1JoinMethod.getReturnType().equals(c2JoinMethod.getReturnType()))
			throw new JoinMethodNotMatchingException(class1, class2);
		
		Multimap<Object, E> list1Map = HashMultimap.create();
		
		for (E list1Obj : list1) {
			Object key = c1JoinMethod.invoke(list1Obj);
			if(key != null){
				list1Map.put(c1JoinMethod.invoke(list1Obj), list1Obj);
			}
		}
		
		for (V list2Obj : list2)
		{
			Object list2ObjKey = c2JoinMethod.invoke(list2Obj);
			Collection<E> list1Obj = list1Map.get(list2ObjKey);
			if(list1Obj == null || list1Obj.isEmpty()) result.add(selector.select(null, list2Obj));
			else for(E e:list1Obj) result.add(selector.select(e, list2Obj));
		}
		
		return result;
	}
}
