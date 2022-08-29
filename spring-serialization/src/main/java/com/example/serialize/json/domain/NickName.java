package com.example.serialize.json.domain;

import com.example.serialize.json.elements.DefaultFields;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@ToString
public class NickName {
	private final String value;
	
	private static final String EMPTY = "";
	
	private static final NickName EMPTY_NICKNAME = new NickName(EMPTY);
	
	private static final DefaultFields<String> defaultFields = DefaultFields.defaultFields(EMPTY);
	
	public NickName(String value) {
		this.value = value;
	}
	
	static String getOrEmpty(String name) {
		return Optional.ofNullable(name)
			.orElse(EMPTY);
	}
	
	static NickName createOrEmpty(String name) {
		if(defaultFields.is(name)) {
			return EMPTY_NICKNAME;
		}
		return new NickName(name);
	}
}
