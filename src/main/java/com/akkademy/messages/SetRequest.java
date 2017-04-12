package com.akkademy.messages;

public class SetRequest implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2211224161876737948L;
	private final String key;
	private final Object value;

	public SetRequest(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}
}
