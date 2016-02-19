package com.chirag.ds.structures.tree.util;

import com.chirag.ds.structures.tree.Tree;
import com.chirag.ds.structures.tree.model.TreeNode;

/**
 * @author Chirag
 *
 */
public class TreeUtils
{
	static class BooleanRef
	{
		public boolean value;
		
		public BooleanRef(boolean value)
		{
			this.value = value;
		}
	}
	
	static class IntegerRef
	{
		public int value;
		
		public IntegerRef(int value)
		{
			this.value = value;
		}
	}
	
	
	
	/**
	 * @param tree
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isBinarySearchTreeInOrder(Tree<T> tree)
	{
		TreeNode<T> prev=new TreeNode<T>();
		return isBinarySearchTreeInOrderUtil(tree.getRoot(), prev);
	}
	
	private static <T extends Comparable<T>> boolean isBinarySearchTreeInOrderUtil(TreeNode<T> root, TreeNode<T> prev)
	{
		if(root==null)
			return true;
	
		if(!isBinarySearchTreeInOrderUtil(root.getLeft(), prev))
			return false;
		
		if(prev.getData()!=null && root.getData().compareTo(prev.getData())<=0)
			return false;
		
		prev.setData(root.getData());
		
		return isBinarySearchTreeInOrderUtil(root.getRight(), prev);
	}
	
	/**
	 * @param root
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isBinarySearchTree(Tree<T> tree)
	{
		TreeNode<T> min=new TreeNode<T>(), max=new TreeNode<T>();
		populteMinMaxNode(tree.getRoot(), min, max);
		return isBinarySearchTreeUtil(tree.getRoot(), min, max); 
	}
	
	private static <T extends Comparable<T>> boolean isBinarySearchTreeUtil(TreeNode<T> root, TreeNode<T> min, TreeNode<T> max)
	{
		if(root==null)
			return true;
		
		if(root.getData().compareTo(min.getData())<0 || root.getData().compareTo(max.getData())>0)
			return false;
		
		return isBinarySearchTreeUtil(root.getLeft(), min, root) && isBinarySearchTreeUtil(root.getRight(), root, max);
	}
	
	private static <T extends Comparable<T>> void populteMinMaxNode(TreeNode<T> root, TreeNode<T> min, TreeNode<T> max)
	{
		if(root==null)
			return;
		
		if(min.getData()==null) {
			min.setData(root.getData());
		}
		else if(root.getData().compareTo(min.getData())<0)
			min.setData(root.getData());
		
		if(max.getData()==null) {
			max.setData(root.getData());
		}
		else if(root.getData().compareTo(max.getData())>0)
			max.setData(root.getData());
		
		populteMinMaxNode(root.getLeft(), min, max);
		populteMinMaxNode(root.getRight(), min, max);
	}
	
	

	/**
	 * @param tree
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static <T extends Comparable<T>> TreeNode<T> findLCA(Tree<T> tree, T data1, T data2)
	{
		BooleanRef v1 = new BooleanRef(false);
		BooleanRef v2 = new BooleanRef(false);
		TreeNode<T> lca = findLCAUtil(tree.getRoot(), data1, data2, v1, v2);
		
		if( (v1.value && v2.value) 
				|| (v1.value && checkIfNodeExist(lca, data2))
				|| (v2.value && checkIfNodeExist(lca, data1)))
			return lca;
		
		return null;
	}
	
	private static <T extends Comparable<T>> TreeNode<T> findLCAUtil(TreeNode<T> root, T data1, T data2, BooleanRef v1, BooleanRef v2)
	{
		if(root==null)
			return null;
		
		if(root.getData().equals(data1)) {
			v1.value = true;
			return root;
		}
		else if(root.getData().equals(data2)) {
			v2.value = true;
			return root;
		}
		
		TreeNode<T> leftLca = findLCAUtil(root.getLeft(), data1, data2, v1, v2);
		TreeNode<T> rigttLca = findLCAUtil(root.getRight(), data1, data2, v1, v2);
		
		if(leftLca!=null && rigttLca!=null)
			return root;
		else
			return (leftLca!=null) ? leftLca : rigttLca;
	}
	
	private static <T extends Comparable<T>> Boolean checkIfNodeExist(TreeNode<T> node, T data)
	{
		if(node==null)
			return false;
		
		if(node.getData().equals(data))
			return true;
		
		return checkIfNodeExist(node.getLeft(), data) || checkIfNodeExist(node.getRight(), data);
	}
	
	
	
	
	/**
	 * @param tree
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static <T extends Comparable<T>> int findShortestDistBetweenNodes(Tree<T> tree, TreeNode<T> node1, TreeNode<T> node2)
	{
		IntegerRef d1 = new IntegerRef(-1);
		IntegerRef d2 = new IntegerRef(-1);
		int level = 0;
		
		int dist = findShortestDistBetweenNodesUtil(tree.getRoot(), node1, node2, d1, d2, level);
		
		if(d1.value!=-1 && d2.value!=-1)
			return dist;
		
		if(d1.value!=-1)
			return findLevel(node1, node2, level);
		if(d2.value!=-1)
			return findLevel(node2, node1, level);
		
		return -1;
	}
	
	private static <T extends Comparable<T>> int findLevel(TreeNode<T> root, TreeNode<T> node, int level)
	{
		if(root==null)
			return -1;
		
		if(root.equals(node))
			return level;
		
		int d = findLevel(root.getLeft(), node, level+1);
		return d!=-1 ? d : findLevel(root.getRight(), node, level+1);
	}
	
	private static <T extends Comparable<T>> int findShortestDistBetweenNodesUtil(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2, 
			IntegerRef d1, IntegerRef d2, int level)
	{
		if(root==null) {
			return -1;
		}
		
		if(root.equals(node1)) {
			d1.value = level;
			return d1.value;
		}
		if(root.equals(node2)) {
			d2.value = level;
			return d2.value;
		}
		
		int lsVal = findShortestDistBetweenNodesUtil(root.getLeft(), node1, node2, d1, d2, level+1);
		int rsVal = findShortestDistBetweenNodesUtil(root.getRight(), node1, node2, d1, d2, level+1);
		
		if(lsVal!=-1 && rsVal!=-1)
		{
			return lsVal+rsVal-(level<<1);
		}
		
		return (lsVal!=-1) ? lsVal : rsVal;
	}
	
	
	
	
	/**
	 * @param node
	 * @param curLevel
	 * @param keyLevel
	 * @return
	 */
	private static <T extends Number> Number findSumOfAllAtLevel(TreeNode<T> node, int curLevel, int keyLevel)
	{
		if(node==null)
			return 0;
		
		if(curLevel==keyLevel)
			return node.getData();
		
		return findSumOfAllAtLevel(node.getLeft(), curLevel+1, keyLevel).doubleValue()
				+ findSumOfAllAtLevel(node.getRight(), curLevel+1, keyLevel).doubleValue();
	}
	
	public static <T extends Number> Number findSumOfAllAtLevel(TreeNode<T> node, int level)
	{
		if(level<1)
			return -1;
		else
			return findSumOfAllAtLevel(node, 1, level);
	}
	
	
	
	
	/**
	 * @param root
	 * @param maxHeight
	 * @return
	 */
	private static <T extends Comparable<T>> int findDiameterOfTreeUtil(TreeNode<T> root, IntegerRef maxHeight)
	{
		IntegerRef lsMaxHeight = new IntegerRef(0), rsMaxHeight = new IntegerRef(0);
		int lsDiameter = 0 , rsDiameter = 0;
		
		if(root==null)
		{
			maxHeight.value = 0;
			return 0;
		}
		
		lsDiameter = findDiameterOfTreeUtil(root.getLeft(), lsMaxHeight);
		rsDiameter = findDiameterOfTreeUtil(root.getLeft(), rsMaxHeight);
		
		maxHeight.value = Math.max(lsMaxHeight.value, rsMaxHeight.value) + 1;
		
		return Math.max(lsMaxHeight.value + rsMaxHeight.value + 1, Math.max(lsDiameter, rsDiameter));
	}
	
	public static <T extends Comparable<T>> int findDiameterOfTree(Tree<T> tree)
	{
		if(tree==null)
			return 0;
		
		IntegerRef maxHeight = new IntegerRef(0);
		return findDiameterOfTreeUtil(tree.getRoot(), maxHeight);
	}
}
