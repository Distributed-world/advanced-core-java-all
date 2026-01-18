package com.ps.proxy.one;

public class SinglyLinkedList<T> implements LinkedList<T> {
	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	private int size;
	private Node<T> top;
	private Node<T> last;

	@Override
	public void addFirst(T element) {
		if (top == null) {
			last = top = new Node<T>(element, null);
		} else {
			top = new Node<T>(element, top);
		}
		size++;
	}

	@Override
	public T removeFirst() {
		if (top == null)
			return null;
		Node<T> tmp = top;
		top = top.next;
		tmp.next = null;
		size--;
		return tmp.data;
	}

	@Override
	public void addLast(T element) {
		if (last == null) {
			last = top = new Node<T>(element, null);
		} else {
			last.next = new Node<T>(element, null);
			last = last.next;
		}
		size++;

	}

	@Override
	public T removeLast() {
		if (last == null)
			return null;

		Node<T> tmp = top;
		while (tmp.next != last) {
			tmp = tmp.next;
		}
		tmp.next = null;
		T t = last.data;
		last = tmp;
		size--;
		return t;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [size=" + size + ", top=" + top + ", last=" + last + "]";
	}

	public static void main(String... args) {
		SinglyLinkedList<Integer> isll = new SinglyLinkedList<>();
		isll.addFirst(1);
		System.out.println(isll);
		isll.addLast(3);
		System.out.println(isll);
		isll.removeLast();
		System.out.println(isll);
		
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}
}
