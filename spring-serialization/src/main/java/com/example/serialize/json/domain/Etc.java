package com.example.serialize.json.domain;

import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.example.serialize.json.domain.EtcValue.intValue;
import static com.example.serialize.json.domain.EtcValue.strValue;

@ToString
final class Etc implements Iterable<String> {
	private final Map<String, EtcValue> value;
	
	Etc() {
		this.value = new HashMap<>();
	}
	
	static Etc etc() {
		return new Etc();
	}
	
	Etc put(String key, int value) {
		this.value.put(key, intValue(value));
		return this;
	}
	
	Etc put(String key, String value) {
		this.value.put(key, strValue(value));
		return this;
	}
	
	int getOrDefault(String key, int defaultValue) {
		return value.getOrDefault(key, intValue(defaultValue))
			.getInt();
	}
	
	String getOrDefault(String key, String defaultValue) {
		return value.getOrDefault(key, strValue(defaultValue))
			.getString();
	}
	
	@Override
	public Iterator<String> iterator() {
		return value.keySet().iterator();
	}
}
