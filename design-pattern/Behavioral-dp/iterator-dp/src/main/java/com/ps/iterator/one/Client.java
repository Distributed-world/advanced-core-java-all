package com.ps.iterator.one;

public class Client {

	public static void main(String[] args) {
		Iterator<ThemeColor> iThemeColor = ThemeColor.getIterator();
		while(iThemeColor.hasNext()) {
			System.out.println(iThemeColor.next());
		}

	}

}
