package com.ps.decorator.one;

public class Client {

	public static void main(String[] args) {
		Message msg = new TextMessage("Hello World this is <b>Bold</b>");
		System.out.println(msg.getContent());
		Message decorator = new HTMLEncodedMessage(msg);
		System.out.println(decorator.getContent());
		
		decorator = new Base64EncodedMessage(msg);
		System.out.println(decorator.getContent());

	}

}
