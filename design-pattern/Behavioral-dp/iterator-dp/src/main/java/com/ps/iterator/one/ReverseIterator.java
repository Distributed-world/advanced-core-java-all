package com.ps.iterator.one;

public interface ReverseIterator<T> extends Iterator<T> {
	boolean hasPrevious();
	T previous();
}
