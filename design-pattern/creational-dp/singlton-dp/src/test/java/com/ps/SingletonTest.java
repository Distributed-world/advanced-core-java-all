package com.ps;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public abstract class SingletonTest<S> {
	private final Supplier<S> singletonInstanceMethod;

	public SingletonTest(final Supplier<S> singletonInstanceMethod) {
		this.singletonInstanceMethod = singletonInstanceMethod;
	}

	@Test
	void testMultipleCallsReturnTheSameObjectInSameThread() {
		var instance1 = this.singletonInstanceMethod.get();
		var instance2 = this.singletonInstanceMethod.get();
		var instance3 = this.singletonInstanceMethod.get();
		assertSame(instance1, instance2);
		assertSame(instance1, instance3);
		assertSame(instance2, instance3);
	}
	
	@Test
	  void testMultipleCallsReturnTheSameObjectInDifferentThreads() throws Exception {
	    assertTimeout(ofMillis(10000), () -> {
	      // Create 10000 tasks and inside each callable instantiate the singleton class
	      final var tasks = IntStream.range(0, 10000)
	          .<Callable<S>>mapToObj(i -> this.singletonInstanceMethod::get)
	          .collect(Collectors.toCollection(ArrayList::new));

	      final var executorService = Executors.newFixedThreadPool(8);
	      final var results = executorService.invokeAll(tasks);

	      final var expectedInstance = this.singletonInstanceMethod.get();
	      for (var res : results) {
	        final var instance = res.get();
	        assertNotNull(instance);
	        assertSame(expectedInstance, instance);
	      }

	      executorService.shutdown();
	    });

	  }
}
