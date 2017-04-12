package com.akkademy.messages;

import java.io.Serializable;

public class GetRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767732664993915814L;
	
	public final String key;

	public GetRequest(String key) {
		this.key = key;
	}
}