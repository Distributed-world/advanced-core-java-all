package com.ps.proxy.one;

//implementor
public interface LinkedList<T> {
	void addFirst(T element);
	void add(T element);

	T removeFirst();

	void addLast(T element);

	T removeLast();

	int getSize();
}
