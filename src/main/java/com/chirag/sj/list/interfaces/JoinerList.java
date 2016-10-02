package com.chirag.sj.list.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.chirag.sj.exceptions.JoinMethodNotFoundException;
import com.chirag.sj.exceptions.JoinMethodNotMatchingException;

public interface JoinerList
{
	<E,V,T> List<T> join(List<E> list1, List<V> list2, Selector<E, V, T> selector) throws JoinMethodNotFoundException, JoinMethodNotMatchingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
