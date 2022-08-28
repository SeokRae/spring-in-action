package com.example.serialize.json.elements;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@RequiredArgsConstructor
public final class DefaultFields<T> {
	private final List<T> fields;
	
	public boolean is(T... args) {
		return fields.equals(List.of(args));
	}
	
	public static <T> DefaultFields<T> defaultFields(T... fields) {
		return new DefaultFields<>(List.of(fields));
	}
}
