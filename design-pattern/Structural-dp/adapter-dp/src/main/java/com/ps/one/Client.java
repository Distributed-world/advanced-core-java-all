package com.ps.one;

public class Client {

	public static void main(String[] args) {
		new TargerAdapter( ()->System.out.print("Method to be execute from Adaptee")).todo();
	}

}
