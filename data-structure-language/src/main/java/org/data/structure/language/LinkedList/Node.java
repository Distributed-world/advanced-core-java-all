package org.data.structure.language.LinkedList;
public class Node<T> {
	T value;
	Node<T> next;
	Node<T> prev;

	Node(T t) {
		this.value = t;
	}

	public String getValue() {
		return value.toString();
	}
}