package com.chirag.sj.implementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.interfaces.Joiner;
import com.chirag.sj.interfaces.Selector;
import com.chirag.sj.util.JoinerUtil;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class BasicInnerJoiner implements Joiner
{
	@Override
	public <E, V, T> List<T> join(List<E> list1, List<V> list2, Selector<E, V, T> selector) throws JoinMethodNotFoundException, JoinMethodNotMatchingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		if(list1==null || list1.isEmpty() || list2==null || list2.isEmpty() || selector==null)
			throw new NullPointerException();
		
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
		
		List<T> result = new ArrayList<T>(list1.size());
		Multimap<Object, V> list2Map = HashMultimap.create();
		
		for (V list2Obj : list2) {
			Object key = c2JoinMethod.invoke(list2Obj);
			if(key != null){
				list2Map.put(c2JoinMethod.invoke(list2Obj), list2Obj);
			}
		}
		
		for (E list1Obj : list1)
		{
			Object list1ObjKey = c1JoinMethod.invoke(list1Obj);
			Collection<V> list2Obj = list2Map.get(list1ObjKey);
			if(list2Obj == null || list2Obj.isEmpty()) result.add(selector.select(list1Obj, null));
			else for(V v:list2Obj) result.add(selector.select(list1Obj, v));
		}
		
		return result;
	}
	
	
}