package com.extremityIndia.context;


/**
 * Interface to manage call context per user request. 
 *  
 * @author: Kunal Sonu
 * 
 */
public interface CallContext {
	
	/**
	 * Set the call context to be used in subsequent method calls.
	 *  
	 * @param ctx	call context
	 */
	void setContext(Context ctx);
	
	
	/**
	 * Get the context bound to the current thread.
	 * 
	 * @return  call context
	 */
	Context getContext(); 


}
