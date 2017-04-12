package com.akkademy.messages;

import java.io.Serializable;

public class KeyNotFoundException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3364116079295715802L;
	public final String key;

	public KeyNotFoundException(String key) {
		this.key = key;
	}
}