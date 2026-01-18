package com.ps.proxy.one;

public class Client {

	public static void main(String[] args) {
		FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
		collection.offer(1);
		collection.offer(2);
		collection.offer(3);
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
	}

}
