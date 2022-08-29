package com.example.serialize.json.domain;

import lombok.ToString;

import java.util.function.Predicate;

/**
 * 특정 값에 대한 range를 Validation 처리하는 클래스
 */
@ToString
final class AgeValidator {
	
	private final int value;
	static final int ZERO = 0;
	static final AgeValidator empty = new AgeValidator(ZERO);
	
	AgeValidator(int value) {
		this.value = value;
	}
	
	static AgeValidator createOrEmpty(Predicate<Integer> range, int value) {
		if (!range.test(value)) {
			return empty;
		}
		return new AgeValidator(value);
	}
	
	static Predicate<Integer> lowerRange(final int lower) {
		return (c) -> lower <= c;
	}
	
	static Predicate<Integer> higherRange(final int higher) {
		return (c) -> higher >= c;
	}
	
	
	static Predicate<Integer> rangeCondition(final int lower, final int higher) {
		return lowerRange(lower).and(higherRange(higher));
	}
	
	public int getAge() {
		return value;
	}
}