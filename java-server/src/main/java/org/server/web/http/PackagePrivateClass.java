package org.server.web.http;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PackagePrivateClass {
	public Object createClassInstance(Constructor<?> packagePrivateClass, Object... objects)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		packagePrivateClass.setAccessible(true);
		return packagePrivateClass.newInstance(objects);
	}

}
