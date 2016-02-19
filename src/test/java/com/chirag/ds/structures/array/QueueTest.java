package com.chirag.ds.structures.array;

import com.chirag.ds.exceptions.QueueEmptyException;
import com.chirag.ds.exceptions.QueueFullException;
import com.chirag.ds.structures.array.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<Integer> intQueue = new Queue<Integer>(4);
		
		try {
			intQueue.add(1);
			intQueue.add(2);
			intQueue.add(3);
			intQueue.add(4);
			intQueue.add(5);
			System.out.println(intQueue.remove());
		} catch(QueueFullException ex) {
			ex.printStackTrace();
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}

	}

}
