package com.example.serialize.json.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static com.example.serialize.json.domain.AgeValidator.rangeCondition;

@ToString
public class Age {
	
	private static final int LOWER = 0;
	private static final int HIGHER = 150;
	
	private final AgeValidator value;
	
	Age(AgeValidator value) {
		this.value = value;
	}
	
	static Age optional(int age) {
		return new Age(
			AgeValidator.createOrEmpty(rangeCondition(LOWER, HIGHER), age)
		);
	}
	
	public int value() {
		return value.getAge();
	}
}