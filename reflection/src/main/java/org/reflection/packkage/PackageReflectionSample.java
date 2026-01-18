package org.reflection.packkage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PackageReflectionSample {

	public PackageReflectionSample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, URISyntaxException, IOException {
		 initialize("org.reflection","org");
		System.out.println(PackageReflectionSample.class.getResource("/"));
	}

	public static void initialize(String... packageNames)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, URISyntaxException, IOException {
		List<Class<?>> classList = getAllClasses(packageNames);
		for (Class<?> clazz : classList) {
			if (!clazz.isAnnotationPresent(InitializerClass.class)) {
				continue;
			}
			List<Method> listOfMethods = getAllInitializingMethods(clazz);
			Object instance = clazz.getDeclaredConstructor().newInstance();
			for (Method method : listOfMethods) {
				method.invoke(instance);
			}
		}
	}

	private static List<Class<?>> getAllClasses(String... packageNames)
			throws URISyntaxException, ClassNotFoundException, IOException {
		List<Class<?>> classList = new ArrayList<>();
		for (String packageName : packageNames) {
			String packageRelativePath = packageName.replace('.', '/');
			URI packageURI = PackageReflectionSample.class.getResource("/").toURI();
			if (packageURI.getScheme().equals("file")) {
				Path packageFullPath = Paths.get(packageURI);
				classList.addAll(getAllClasses(packageFullPath, packageName));
			} else if (packageURI.getScheme().equals("jar")) {
				FileSystem fileSystem = FileSystems.newFileSystem(packageURI, Collections.EMPTY_MAP);
				Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
				classList.addAll(getAllClasses(packageFullPathInJar, packageName));
				fileSystem.close();
			}
		}
		return classList;
	}

	private static List<Class<?>> getAllClasses(Path packagePath, String packageName)
			throws IOException, ClassNotFoundException {
		if (!Files.exists(packagePath))
			return Collections.EMPTY_LIST;
		List<Path> files = Files.list(packagePath).filter(Files::isRegularFile).collect(Collectors.toList());
		List<Class<?>> classList = new ArrayList<>();
		for (Path filePath : files) {
			String fileName = filePath.getFileName().toString();
			if (fileName.endsWith(".class")) {
				String classFullName = packageName + "." + fileName.replaceFirst("\\.class", "");
				Class<?> clazz = Class.forName(classFullName);
				classList.add(clazz);
			}
		}

		return classList;
	}

	private static List<Method> getAllInitializingMethods(Class<?> clazz) {
		List<Method> methodList = new ArrayList<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(InitializerMethod.class)) {
				methodList.add(method);
			}
		}
		return methodList;
	}
}
