package org.data.structure.language.LinkedList;
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int length;

	public LinkedList(T t) {
		this.head = this.tail = new Node<>(t);
		length = 1;
	}

	public void append(T t) {
		Node<T> nNode = new Node<>(t);
		if (length != 0) {
			this.tail.next = nNode;
			this.tail = nNode;
		} else {
			this.head = this.tail = nNode;
		}
		length++;
	}

	public void prepend(T t) {
		Node<T> nNode = new Node<T>(t);
		if (length != 0) {
			nNode.next = head;
			this.head = nNode;
		} else {
			this.head = this.tail = nNode;
		}
		length++;
	}

	public void removeLast() {
		if (length != 0) {
			Node<T> prev = head;
			Node<T> tmp = head;
			while (tmp.next != null) {
				prev = tmp;
				tmp = prev.next;
			}
			tail = prev;
			tail.next = null;
			length--;
		}
	}

	public void removeFirst() {
		if (length != 0) {
			Node<T> node = this.head;
			this.head = head.next;
			node.next = null;
			length--;
			if (length == 0) {
				this.tail = null;
			}
		}
	}

	public Node<T> get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node<T> tNode = this.head;
		for (int i = 0; i < length; i++) {
			tNode = tNode.next;
		}
		return tNode;
	}

	public boolean set(int index, T value) {
		Node<T> tNode = get(index);
		if (tNode != null) {
			tNode.value = value;
			return true;
		}
		return false;
	}

	public boolean insert(int index, T value) {
		if (index < 0 || index > length)
			return false;
		if (index == 0) {
			this.prepend(value);
			return true;
		}
		if (index == length) {
			this.append(value);
			return true;
		}
		Node<T> nNode = new Node<T>(value);
		Node<T> tNode = get(index - 1);
		nNode.next = tNode.next;
		tNode.next = nNode;
		length++;
		return true;
	}

	public Node<T> remove(int index) {
		if (index < 0 || index >= length)
			return null;
		Node<T> tNode = get(index - 1);
		Node<T> iNode = tNode.next;
		tNode.next = iNode.next;
		iNode.next = null;
		length--;
		return iNode;
	}

	public void reverse() {
		Node<T> cursor = head;
		Node<T> after = cursor.next; 
		Node<T> before = null;
		head = tail;
		tail = cursor;
		for (int i = 0; i < length; i++) {
			after = cursor.next;
			cursor.next = before;
			before = cursor;
			cursor = after;
		}
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void printHead() {
		System.out.println("Head:- " + head.getValue());
	}

	public void printTail() {
		System.out.println("Tail:- " + tail.getValue());
	}

	public void printLength() {
		System.out.println("Length:- " + length);
	}

	public void printList() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.getValue()+" ");
			temp = temp.next;
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		LinkedList<Integer> intLinkedList = new LinkedList<Integer>(22);
		intLinkedList.prepend(61);
		intLinkedList.append(1);
		intLinkedList.append(5);
		intLinkedList.append(50);
		intLinkedList.append(55);
		intLinkedList.printList();
		intLinkedList.reverse();
		intLinkedList.printList();
	}

}
