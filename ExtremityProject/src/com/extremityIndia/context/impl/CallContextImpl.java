package com.extremityIndia.context.impl;

import com.extremityIndia.context.CallContext;
import com.extremityIndia.context.Context;

import java.util.HashMap;



/**
 * @author Kunal Sonu
 *
 */
public class CallContextImpl implements CallContext {
	
	private static HashMap<String, Context> contextCollection = new HashMap<String, Context>();
	
	
	/**
	 * Default Constructor
	 */
	public CallContextImpl(){
	
	}
	
	/**
	 * @see CallContext#setContext(Context)
	 */
	public void setContext(Context keyValue) {
		String keyName = Thread.currentThread().getName();
		contextCollection.put(keyName, keyValue);
	}

	/**
	 * @see CallContext#getContext()
	 */
	public Context getContext() {
		String keyName = Thread.currentThread().getName();
		return (Context) contextCollection.get(keyName);
	}



}
