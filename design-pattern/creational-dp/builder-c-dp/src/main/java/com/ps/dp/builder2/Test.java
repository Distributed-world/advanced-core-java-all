/**
 * 
 */
package com.ps.dp.builder2;

/**
 * @author premp
 *
 */
public record Test(int a, int b, int c, String str) {
	private Test(TestBuilder builder) {
		this(builder.a, builder.b, builder.c, builder.str);
	}

	private static class TestBuilder {
		int a;
		int b;
		int c;
		String str;
	}
}
