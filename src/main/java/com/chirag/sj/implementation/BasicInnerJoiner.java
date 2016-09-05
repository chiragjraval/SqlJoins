package com.chirag.sj.implementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;
import com.chirag.sj.interfaces.Joiner;
import com.chirag.sj.interfaces.Selector;
import com.chirag.sj.util.JoinerUtil;

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
		
		HashMap<Object, V> list2Map = new HashMap<Object, V>();
		for (V list2Obj : list2) list2Map.put(c2JoinMethod.invoke(list2Obj), list2Obj);
		
		List<T> result = new ArrayList<T>(list1.size()<list2.size() ? list1.size() : list2.size());
		
		for (E list1Obj : list1)
		{
			Object list1ObjKey = c1JoinMethod.invoke(list1Obj);
			
			if(list2Map.containsKey(list1ObjKey))
			{
				V list2Obj = list2Map.get(list1ObjKey);
				result.add(selector.select(list1Obj, list2Obj));
			}
		}
		
		return result;
	}
	
	
}
