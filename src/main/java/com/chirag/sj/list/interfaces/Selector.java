package com.chirag.sj.list.interfaces;

public interface Selector<E,V,T>
{
	public T select(E obj1, V obj2);
}
