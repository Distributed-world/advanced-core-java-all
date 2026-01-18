package com.ps.decorator.one;

import org.apache.commons.text.StringEscapeUtils;

public class HTMLEncodedMessage implements Message {
	private Message msg;
	public HTMLEncodedMessage(Message msg) {
		this.msg = msg;
	}
	@SuppressWarnings("deprecation")
	@Override
	public String getContent() {
		 
		return StringEscapeUtils.escapeHtml4(msg.getContent());
	}

}
