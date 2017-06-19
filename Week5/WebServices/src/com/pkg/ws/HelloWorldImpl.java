package com.pkg.ws;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.pkg.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString() {
		return "Hello World JAX-WS";
	}
}