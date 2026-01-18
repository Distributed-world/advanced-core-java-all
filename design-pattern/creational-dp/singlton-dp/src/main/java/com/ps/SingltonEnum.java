package com.ps;

public enum SingltonEnum {
	INSTANCE;
	@Override
	  public String toString() {
	    return getDeclaringClass().getCanonicalName() + "@" + hashCode();
	  }
}
