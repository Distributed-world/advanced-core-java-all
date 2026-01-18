package com.ps.proxy.one;
//abstraction
public interface FifoCollection<T> {
	void offer(T element);
	T poll();

}
