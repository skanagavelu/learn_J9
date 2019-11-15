package com.hello.client;

import com.hello.HelloWorld;

public class HelloWorldClient {
	public static void main(String arg[]) {
		HelloWorld hello = new HelloWorld();
//		System.out.println(hello.var);
		System.out.println(hello.sayHelloWorld());
	}

	public static class HelloWorldSub extends HelloWorld {
		public String sayHelloWorld() {
			return "Hello World!" + var;
		}
	}
}
