package com.chirag.sj.interfaces;

public interface Selector<E,V,T>
{
	public T select(E obj1, V obj2);
}
