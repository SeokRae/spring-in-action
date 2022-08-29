package com.example.serialize.json.domain;

import lombok.Getter;
import lombok.ToString;

import static com.example.serialize.json.domain.AgeValidator.rangeCondition;

@ToString
public class Age {
	
	private static final int LOWER = 0;
	private static final int HIGHER = 150;
	@Getter
	private final AgeValidator value;
	static final Age EMPTY = new Age(AgeValidator.empty);
	
	Age(AgeValidator value) {
		this.value = value;
	}
	
	static Age optional(int age) {
		return new Age(
			AgeValidator.createOrEmpty(rangeCondition(LOWER, HIGHER), age)
		);
	}
}