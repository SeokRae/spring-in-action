package com.example.serialize.json.domain;

import com.example.serialize.json.elements.DefaultFields;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@ToString
public class NickName {
	private static final String EMPTY = "";
	private static final DefaultFields<String> defaultFields = DefaultFields.defaultFields(EMPTY);
	@Getter
	private final String value;
	static final NickName EMPTY_NICKNAME = new NickName(EMPTY);
	
	public NickName(String value) {
		this.value = value;
	}
	
	static String getOrEmpty(String name) {
		return Optional.ofNullable(name)
			.orElse(EMPTY);
	}
	
	static NickName createOrEmpty(String name) {
		if (defaultFields.is(name)) {
			return EMPTY_NICKNAME;
		}
		return new NickName(name);
	}
}
