package org.server.web.http;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App {
	public static void initConfiguration() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<ServerConfiguration> constructor = ServerConfiguration.class.getDeclaredConstructor(Integer.class,
				String.class);
		constructor.setAccessible(true);
		constructor.newInstance(8080, "Hello World!");
	}

	public static void main(String... strings) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		App.initConfiguration();
		new WebServer().startServer();
	}
}
