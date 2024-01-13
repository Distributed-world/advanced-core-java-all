package com.ps.factorymethod;

import com.ps.factorymethod.message.JSONMessage;
import com.ps.factorymethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new JSONMessage();
	}

	
}
