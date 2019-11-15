module com.hello.client {
	  //javac --module-path mlib -d output com.hello.client/src.main.java/module-info.java com.hello.client/src.main.java/com/hello/client/HelloWorldClient.java
	  //jar -c -f mlib/com.hello.client.jar --main-class=com/hello/client/HelloWorldClient -C output .
	  //java --module-path mlib -m com.hello.client  ==> java --module-path mlib --module com.hello.client
	  //	  jdeps --module-path mlib --module com.hello.client
	  //
	  requires com.hello;
}
