package com.easeljs.html5.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client side stub for the RPC service.
 */
public interface GreetingServiceAsync {
	void greetServer(String name, AsyncCallback<String> callback);
}
