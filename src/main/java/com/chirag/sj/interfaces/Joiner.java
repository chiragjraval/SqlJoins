package com.chirag.sj.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.chirag.js.exceptions.JoinMethodNotFoundException;
import com.chirag.js.exceptions.JoinMethodNotMatchingException;

public interface Joiner
{
	public <E,V,T> List<T> join(List<E> list1, List<V> list2, Selector<E, V, T> selector) throws JoinMethodNotFoundException, JoinMethodNotMatchingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
