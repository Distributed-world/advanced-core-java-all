package org.server.web.http;

import java.net.InetSocketAddress;

class ServerConfiguration {
	private static ServerConfiguration serverConfigurationInstance;
	private final InetSocketAddress serverAddress;
	private final String greetMessage;

	public ServerConfiguration(Integer port, String msg) {
		this.greetMessage = msg;
		this.serverAddress = new InetSocketAddress(port);
		if (serverConfigurationInstance == null)
			serverConfigurationInstance = this;
	}

	public static ServerConfiguration getInstance() {
		return serverConfigurationInstance;
	}

	public String getGreetMessage() {
		return greetMessage;
	}

	public InetSocketAddress getServerAddress() {
		return serverAddress;
	}
}
