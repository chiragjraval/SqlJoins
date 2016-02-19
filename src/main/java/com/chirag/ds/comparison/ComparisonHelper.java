package com.chirag.ds.comparison;

import com.chirag.ds.model.BaseNode;

public class ComparisonHelper {

	public static <T> boolean compare(BaseNode<T> node1, BaseNode<T> node2, ComparisonType comType)
	{
		if(node1==null || node2==null)
			return false;
		
		if (ComparisonType.NODE.equals(comType))
		{
			return node1.equals(node2);
		}
		else if (ComparisonType.DATA.equals(comType))
		{
			if(node1.getData()!=null && node2.getData()!=null)
				return node1.getData().equals(node2.getData());
			else
				return false;
		}
		else
		{
			return false;
		}
	}
	
}
