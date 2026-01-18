package com.ps.decorator.one;

import java.util.Base64;

import org.apache.commons.text.StringEscapeUtils;

public class Base64EncodedMessage implements Message {
	private Message msg;
	public Base64EncodedMessage(Message msg) {
		this.msg = msg;
	}
	@SuppressWarnings("deprecation")
	@Override
	public String getContent() {
		 
		return Base64.getEncoder().encodeToString(msg.getContent().getBytes());
	}

}
